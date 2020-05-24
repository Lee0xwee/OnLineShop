package cn.Lee.shop.cart.action;

import cn.Lee.shop.cart.domain.Cart;
import cn.Lee.shop.cart.domain.CartItem;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.product.service.ProductService;
import cn.Lee.shop.user.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class CartAction extends ActionSupport {

    private Integer pid;
    private int count;

    @Autowired
    private ProductService productService;


    //set方法用于获取jsp中的数据，get方法用于封装数据到jsp页面
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Action(value = "cart_toCartPage", results = {@Result(name = "toCartPage", location = "/WEB-INF/jsp/cart.jsp")})
    public String toCartPage() {


        return "toCartPage";

    }

    @Action(value = "cart_addCart", results = {@Result(name = "addCart", location = "/WEB-INF/jsp/cart.jsp"),
            @Result(name = "msg", location = "/WEB-INF/jsp/msg.jsp")})
    public String addCart() {


        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("sessionUser");
        if (user == null) {

            this.addActionMessage("亲，您还没有登录，请先去登录！");
            return "msg";

        }
        CartItem cartItem = new CartItem();
        Product product = productService.findProduct(pid);
        cartItem.setCount(count);
        cartItem.setProduct(product);
        Cart cart = getCart();
        cart.addCart(cartItem);
        return "addCart";

    }


    @Action(value = "cart_clearCart", results = {@Result(name = "clearCart", location = "/WEB-INF/jsp/cart.jsp")})
    public String clearCart() {

        getCart().clearCart();
        return "clearCart";

    }

    @Action(value = "cart_removeCart", results = {@Result(name = "removeCart", location = "/WEB-INF/jsp/cart.jsp")})
    public String removeCart() {


        getCart().removeCart(pid);
        return "removeCart";

    }

    private Cart getCart() {

        Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");

        if (cart == null) {

            cart = new Cart();
            ServletActionContext.getRequest().getSession().setAttribute("cart", cart);

        }

        return cart;

    }

}
