package cn.Lee.shop.user.action;

import cn.Lee.shop.user.domain.User;
import cn.Lee.shop.user.service.UserService;
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

import javax.servlet.http.HttpServletResponse;


@Controller("userAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    @Autowired
    private UserService userService;

    //模型驱动封装获取表单数据
    private User user = new User();

    //获取表单数据
    private String checkCode;

    @Override
    public User getModel() {
        return user;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }


    @Action(value = "user_registPage", results = {@Result(name = "registPage", location = "/WEB-INF/jsp/regist.jsp")})
    public String registPage() {
        return "registPage";
    }

    @Action(value = "user_loginPage", results = {@Result(name = "loginPage", location = "/WEB-INF/jsp/login.jsp")})
    public String loginPage() {

        return "loginPage";
    }

    @Action(value = "user_exit", results = {@Result(name = "exit", type = "redirectAction", location = "index")})
    public String exit() {

        ServletActionContext.getRequest().getSession().invalidate();
        return "exit";
    }

    @Action(value = "user_checkUser")
    public String checkUser() throws Exception {


        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(user.getUsername());

        User exsitUser1 = userService.findByUserName(user.getUsername());
        User exsitUser2 = userService.findByEmail(user.getEmail());

        if (exsitUser1 != null) {

            response.getWriter().print("<font color='red'>用户名已存在！</font>");

        }
        if (exsitUser2 != null) {

            response.getWriter().print("<font color='red'>邮箱已存在！</font>");
        }
        return NONE;

    }

    @Action(value = "user_regist", results = {@Result(name = "msg", location = "/WEB-INF/jsp/msg.jsp"), @Result(name = "registFail", location = "/WEB-INF/jsp/regist.jsp")})
    public String regist() throws Exception {

        String vCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
        if (!checkCode.equalsIgnoreCase(vCode)) {

            this.addActionError("验证码错误");
            return "registFail";

        }

        userService.regist(user);
        this.addActionMessage("注册成功，请前往邮箱激活！");
        return "msg";

    }

    @Action(value = "user_active", results = {@Result(name = "active", location = "/WEB-INF/jsp/msg.jsp")})
    public String active() {

        /*HttpServletRequest request = ServletActionContext.getRequest();
        String code = request.getParameter("code");*/

        User exsitUser = userService.active(user.getCode());

        if (exsitUser == null) {

            this.addActionMessage("激活失败，验证码无效！");

        } else {

            exsitUser.setState(1);
            exsitUser.setCode(null);
            userService.updateState(exsitUser);
            this.addActionMessage("激活成功，请登录！");
        }

        return "active";
    }

    @Action(value = "user_login", results = {@Result(name = "loginSuccess", type = "redirectAction", location = "index"), @Result(name = "loginFail", location = "/WEB-INF/jsp/login.jsp")})
    public String login() {

        User exsitUser = userService.findByUser(user);
        String vCode = (String) ServletActionContext.getRequest().getSession().getAttribute("vCode");
        if (!checkCode.equalsIgnoreCase(vCode)) {

            this.addActionError("验证码错误");
            return "loginFail";
        }

        if (exsitUser == null) {

            this.addActionMessage("登录失败：用户名或密码错误！");
            return "loginFail";

        } else {

            ServletActionContext.getRequest()
                    .getSession().setAttribute("sessionUser", exsitUser);
            return "loginSuccess";

        }

    }

}
