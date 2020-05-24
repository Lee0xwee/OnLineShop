package cn.Lee.shop.user.action;


import cn.Lee.shop.user.domain.User;
import cn.Lee.shop.user.service.UserService;
import cn.Lee.shop.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userAdminAction")
@Scope("prototype")
@ParentPackage("shop")

public class AdminUserAction extends ActionSupport implements ModelDriven<User> {

    @Autowired
    private UserService userService;
    private PageBean<User> pageBean;
    private Integer pageNumber = 1;
    private Integer pageSize = 10;

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    public PageBean<User> getPageBean() {
        return pageBean;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Action(value = "userAdmin_findAll", results = {@Result(name = "findAll", location = "/admin/user/list.jsp")})
    public String findAll() {

        pageBean = userService.findPageAll(pageNumber, pageSize);
        return "findAll";
    }

    @Action(value = "userAdmin_edit", results = {@Result(name = "edit", location = "/admin/user/edit.jsp")})
    public String edit() {


        user = userService.findByUid(user.getUid());
        return "edit";
    }

    @Action(value = "userAdmin_update", results = {@Result(name = "updateC", type = "redirectAction", location = "userAdmin_findAll")})
    public String update() {

        userService.update(user);
        return "updateC";
    }


    @Action(value = "userAdmin_delete", results = {@Result(name = "deleteC", type = "redirectAction", location = "userAdmin_findAll")})
    public String delete() {


        userService.delete(user.getUid());
        return "deleteC";

    }


}
