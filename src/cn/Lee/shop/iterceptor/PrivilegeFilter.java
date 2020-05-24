/*
 * Created on 2005-7-5
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cn.Lee.shop.iterceptor;

import cn.Lee.shop.adminUser.domain.AdminUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//后台权限过滤器，过滤后台页面
public class PrivilegeFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {


        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;

        AdminUser adminUser = (AdminUser) hrequest.getSession().getAttribute("adminUser");
        /*System.out.println("执行拉。。。");*/
        if (adminUser != null) {

            /*System.out.println("执行啦");*/
            chain.doFilter(hrequest, hresponse);

        } else {

            hrequest.getRequestDispatcher("/admin/index.jsp").forward(hrequest, hresponse);
//            hresponse.sendRedirect("/admin/index.jsp");

        }


    }


    public void destroy() {}

}
