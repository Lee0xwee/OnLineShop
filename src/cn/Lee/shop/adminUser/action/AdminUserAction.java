package cn.Lee.shop.adminUser.action;

import cn.Lee.shop.adminUser.domain.AdminUser;
import cn.Lee.shop.adminUser.service.AdminUserService;
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


@Controller("adminUserAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {


    @Autowired
    private AdminUserService adminUserService;

    private AdminUser adminUser = new AdminUser();

    @Override
    public AdminUser getModel() {
        return adminUser;
    }

    @Action(value = "adminUser_login", results = {@Result(name = "loginFail", location = "/admin/index.jsp"),
            @Result(name = "loginSuccess", location = "/admin/home.jsp")})
    public String login() {


        AdminUser exsitAdminUser = adminUserService.login(adminUser);
        if (exsitAdminUser == null) {

            this.addActionError("登录失败：用户名或密码错误！");
            return "loginFail";

        } else {

            ServletActionContext.getRequest().getSession().setAttribute("adminUser", exsitAdminUser);
            return "loginSuccess";

        }

    }


}
