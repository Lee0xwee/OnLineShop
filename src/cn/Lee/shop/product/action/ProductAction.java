package cn.Lee.shop.product.action;


import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.product.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("productAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class ProductAction extends ActionSupport implements ModelDriven<Product> {


    @Autowired
    private ProductService productService;


    private Product product = new Product();

    @Override
    public Product getModel() {
        return product;
    }


    @Action(value = "product_findByPid", results = {@Result(name = "findByPid", location = "/WEB-INF/jsp/products.jsp")})
    public String findByPid() throws Exception {


        product = productService.findProduct(product.getPid());
        return "findByPid";
    }
}
