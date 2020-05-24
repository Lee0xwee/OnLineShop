package cn.Lee.shop.category.action;


import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.category.service.CategoryService;
import cn.Lee.shop.product.domain.Product;
import cn.Lee.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("categoryAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {


    @Autowired
    private CategoryService categoryService;
    private PageBean<Product> pageBean;
    private Integer csid;
    private List<CategorySecond> csList;
    private Integer pageNumber = 1;
    private Integer pageSize = 12;


    private Category category = new Category();

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getCsid() {
        return csid;
    }

    public List<CategorySecond> getCsList() {
        return csList;
    }

    @Override
    public Category getModel() {
        return category;
    }


    @Action(value = "category_findByCid", results = {@Result(name = "findByCid", location = "/WEB-INF/jsp/productList.jsp")})
    public String findByCid() throws Exception {

        System.out.println(category.getCid());

        pageBean = categoryService.findByPageCid(category.getCid(), pageNumber, pageSize);
        return "findByCid";
    }

    @Action(value = "category_findByCsid", results = {@Result(name = "findByCsid", location = "/WEB-INF/jsp/productList.jsp")})
    public String findByCsid() throws Exception {


        pageBean = categoryService.findByCsid(csid, pageNumber, pageSize);

        ActionContext.getContext().getSession().put("csList", csList);
        return "findByCsid";
    }


}
