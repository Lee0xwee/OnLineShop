package cn.Lee.shop.iterceptor;

import cn.Lee.shop.adminUser.domain.AdminUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;



//后台权拦截器，拦截action中方法
public class PrivilegeInterceptor extends MethodFilterInterceptor {

    public String doIntercept(ActionInvocation actionInvocation) throws Exception {


        AdminUser adminUser = (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("adminUser");
        if (adminUser == null) {

            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addActionMessage("亲，您还没有登录,没有权限访问.请先去登录！");
            return "fail";

        } else {

            return actionInvocation.invoke();

        }

    }
}
