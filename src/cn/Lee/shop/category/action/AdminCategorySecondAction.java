package cn.Lee.shop.category.action;


import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.domain.CategorySecond;
import cn.Lee.shop.category.service.CategoryService;
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

import java.util.List;


@Controller("adminCategorySecondAcion")
@Scope("prototype")
@ParentPackage("shop")

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {

    @Autowired
    private CategoryService categoryService;
    private PageBean<CategorySecond> pageBean;
    private List<Category> cList;
    private Integer pageNumber = 1;
    private Integer pageSize = 10;

    private CategorySecond categorySecond = new CategorySecond();


    public PageBean<CategorySecond> getPageBean() {
        return pageBean;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public CategorySecond getModel() {
        return categorySecond;
    }

    public List<Category> getCList() {
        return cList;
    }

    @Action(value = "adminCategorySecond_findAll", results = {@Result(name = "findAll", location = "/admin/categorysecond/list.jsp")})
    public String findAll() {

        pageBean = categoryService.findPageAll(pageNumber, pageSize);
        return "findAll";
    }

    @Action(value = "adminCategorySecond_toAddPage", results = {@Result(name = "toAddPage", location = "/admin/categorysecond/add.jsp")})
    public String toAddPage() {


        cList = categoryService.findAll();
        return "toAddPage";
    }

    @Action(value = "adminCategorySecond_save", results = {@Result(name = "saveC", type = "redirectAction", location = "adminCategorySecond_findAll")})
    public String save() {


        categoryService.saveCs(categorySecond);
        return "saveC";
    }

    @Action(value = "adminCategorySecond_edit", results = {@Result(name = "edit", location = "/admin/categorysecond/edit.jsp")})
    public String edit() {

        cList = categoryService.findAll();
        categorySecond = categoryService.findByCsid(categorySecond.getCsid());
        return "edit";
    }

    @Action(value = "adminCategorySecond_update", results = {@Result(name = "updateCs", type = "redirectAction", location = "adminCategorySecond_findAll")})
    public String update() {


        categoryService.updateCs(categorySecond);
        return "updateCs";
    }


    @Action(value = "adminCategorySecond_delete", results = {@Result(name = "deleteCs", type = "redirectAction", location = "adminCategorySecond_findAll")})
    public String delete() {

        categoryService.deleteCs(categorySecond.getCsid());
        return "deleteCs";
    }




}
