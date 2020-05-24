package cn.Lee.shop.user.action;

import cn.itcast.vcode.utils.VerifyCode;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
public class CheckImgAction extends ActionSupport {

    @Action(value = "checkImg")
    public String execute() throws Exception {

        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();//获取一次性验证码图片

        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();

        // 该方法必须在getImage()方法之后来调用
        VerifyCode.output(image, response.getOutputStream());//把图片写到指定流中

        // 把文本保存到session中，为LoginServlet验证做准备
        request.getSession().setAttribute("vCode", vc.getText());

        return NONE;
    }
}
