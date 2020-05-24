package cn.Lee.shop.index.action;

import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.service.CategoryService;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.product.service.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class IndexAction extends ActionSupport {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    private List<Product> hotList;
    private List<Product> newList;

    public List<Product> getHotList() {
        return hotList;
    }

    public List<Product> getNewList() {
        return newList;
    }

    @Action(value = "index", results = {@Result(name = "index", location = "/WEB-INF/jsp/index.jsp")})
    public String execute() {

        List<Category> cList = categoryService.findAll();

        hotList = productService.findByHot();
        newList = productService.findByNew();

        ActionContext.getContext().getSession().put("cList", cList);

       /* //方式2
        ActionContext.getContext().getValueStack().set("hotList", hotList);*/

        return "index";
    }

}

