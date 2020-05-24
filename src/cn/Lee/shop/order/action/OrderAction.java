package cn.Lee.shop.order.action;

import cn.Lee.shop.cart.domain.Cart;
import cn.Lee.shop.cart.domain.CartItem;
import cn.Lee.shop.order.domain.Order;
import cn.Lee.shop.order.domain.OrderItem;
import cn.Lee.shop.order.service.OrderService;
import cn.Lee.shop.user.domain.User;
import cn.Lee.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller("orderAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

    @Autowired
    private OrderService orderService;
    private PageBean<Order> pageBean;
    private String pd_FrpId;
    private Integer pageNumber = 1;
    private Integer pageSize = 5;

    private Order order = new Order();

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPd_FrpId(String pd_FrpId) {
        this.pd_FrpId = pd_FrpId;
    }

    public PageBean<Order> getPageBean() {

        return pageBean;
    }

    @Override
    public Order getModel() {
        return order;
    }

    @Action(value = "order_save", results = {@Result(name = "saveC", location = "/WEB-INF/jsp/order.jsp"),
            @Result(name = "msg", location = "/WEB-INF/jsp/msg.jsp")})
    public String toOrderPage() {

        order.setOrdertime(new Date());
        order.setState(1);  //1:未付款，2：已付款未发货，3：已发货未收货，4：交易完成
        Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
        if (cart == null) {

            this.addActionMessage("亲，您还没有购物，请先去购物！");
            return "msg";

        }
        order.setTotal(cart.getTotal());
        for (CartItem cartItem : cart.getCartItems()) {

            OrderItem orderItem = new OrderItem();
            orderItem.setCount(cartItem.getCount());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            order.getOrderItemSet().add(orderItem);
        }

        //设置所属用户
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("sessionUser");

        order.setUser(user);
        orderService.save(order);
        cart.clearCart();
        return "saveC";
    }

    @Action(value = "order_list", results = {@Result(name = "list", location = "/WEB-INF/jsp/orderList.jsp")})
    public String list() {


        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("sessionUser");
        pageBean = orderService.findByUid(user.getUid(), pageNumber, pageSize);
        return "list";
    }

    @Action(value = "order_toOrderPage", results = {@Result(name = "toOrderPage", location = "/WEB-INF/jsp/order.jsp"),})
    public String findByOid() {

        order = orderService.findByOid(order.getOid());
        return "toOrderPage";
    }

    @Action(value = "order_ackOrder", results = {@Result(name = "ackOrder", type = "redirectAction", location = "order_list"),})
    public String ackOrder() {

        Order currOrder = orderService.findByOid(order.getOid());
        currOrder.setState(4);
        orderService.update(currOrder);
        return "ackOrder";
    }

    @Action(value = "order_payOrder", results = {@Result(name = "payOrder", location = "/WEB-INF/jsp/msg.jsp"),})
    public String payOrder() throws Exception {


        Order currOrder = orderService.findByOid(order.getOid());
        currOrder.setName(order.getName());
        currOrder.setPhone(order.getPhone());
        currOrder.setAddr(order.getAddr());
        currOrder.setState(2);
        orderService.update(currOrder);

        this.addActionMessage("订单付款成功：订单编号：" + currOrder.getOid() + " 付款金额: ￥" + currOrder.getTotal());
        return "payOrder";



       /* // 付款需要的参数:
        String p0_Cmd = "Buy"; // 业务类型:
        String p1_MerId = "10001126856";// 商户编号:
        String p2_Order = order.getOid().toString();// 订单编号:
        String p3_Amt = "0.01"; // 付款金额:
        String p4_Cur = "CNY"; // 交易币种:
        String p5_Pid = ""; // 商品名称:
        String p6_Pcat = ""; // 商品种类:
        String p7_Pdesc = ""; // 商品描述:
        String p8_Url = "http://127.0.0.1:8080/order_callBack.action"; // 商户接收支付成功数据的地址:
        String p9_SAF = ""; // 送货地址:
        String pa_MP = ""; // 商户扩展信息:
        String pd_FrpId = this.pd_FrpId;// 支付通道编码:
        String pr_NeedResponse = "1"; // 应答机制:
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue); // hmac
        // 向易宝发送请求:
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        // 重定向:向易宝出发:
        ServletActionContext.getResponse().sendRedirect(sb.toString());

        return NONE;*/


    }


}
