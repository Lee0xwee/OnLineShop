package cn.Lee.shop.order.action;


import cn.Lee.shop.order.domain.Order;
import cn.Lee.shop.order.service.OrderService;
import cn.Lee.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("adminOrderAction")
@Scope("prototype")
@ParentPackage("shop")

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {

    @Autowired
    private OrderService orderService;
    private PageBean<Order> pageBean;
    private Integer pageNumber = 1;
    private Integer pageSize = 15;

    private Order order = new Order();

    @Override
    public Order getModel() {
        return order;
    }

    public PageBean<Order> getPageBean() {
        return pageBean;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }


    @Action(value = "adminOrder_findAll", results = {@Result(name = "findAll", location = "/admin/order/list.jsp")})
    public String findAll() {


        pageBean = orderService.findPageAll(pageNumber, pageSize);
        return "findAll";
    }


    @Action(value = "adminOrder_findOrderItem", results = {@Result(name = "findOrderItem", location = "/admin/order/orderItem.jsp")})
    public String findOrderItem() throws Exception {

        order = orderService.findByOid(order.getOid());
        return "findOrderItem";
    }

    @Action(value = "adminOrder_updateState", results = {@Result(name = "updateState", type = "redirectAction", location = "adminOrder_findAll")})
    public String updateState() {

        Order exsitorder = orderService.findByOid(order.getOid());
        exsitorder.setState(3);
        orderService.update(exsitorder);
        return "updateState";
    }


}
