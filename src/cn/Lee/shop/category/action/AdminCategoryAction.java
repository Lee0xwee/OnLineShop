package cn.Lee.shop.category.action;

import cn.Lee.shop.category.domain.Category;
import cn.Lee.shop.category.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("adminCategoryAction")
@Scope("prototype")
@ParentPackage("shop")
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {


    @Autowired
    private CategoryService categoryService;

    private List<Category> cList;


    private Category category = new Category();

    @Override
    public Category getModel() {
        return category;
    }


    public List<Category> getCList() {
        return cList;
    }

    @Action(value = "adminCategory_toAddPage", results = {@Result(name = "toAddPage", location = "/admin/category/add.jsp")})
    public String toAddPage() {

        return "toAddPage";
    }

    @Action(value = "adminCategory_findAll", results = {@Result(name = "findAll", location = "/admin/category/list.jsp")})
    public String findAll() {

        cList = categoryService.findAll();

        return "findAll";
    }

    @Action(value = "adminCategory_save", results = {@Result(name = "saveC", type = "redirectAction", location = "adminCategory_findAll")})
    public String save() {

        categoryService.saveC(category);
        return "saveC";
    }


    @Action(value = "adminCategory_edit", results = {@Result(name = "edit", location = "/admin/category/edit.jsp")})
    public String edit() {

        category = categoryService.findByUid(category.getCid());
        return "edit";
    }

    @Action(value = "adminCategory_update", results = {@Result(name = "updateC", type = "redirectAction", location = "adminCategory_findAll")})
    public String update() {

        categoryService.updateC(category);
        return "updateC";
    }

    @Action(value = "adminCategory_delete", results = {@Result(name = "deleteC", type = "redirectAction", location = "adminCategory_findAll")})
    public String delete() {

        categoryService.deleteC(category.getCid());
        return "deleteC";
    }
}
