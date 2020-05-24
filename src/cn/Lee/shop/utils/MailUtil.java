package cn.Lee.shop.utils;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

import javax.mail.MessagingException;
import javax.mail.Session;

public class MailUtil {

    public static void sendMail(String email, String code) throws Exception {


        /*String host = "smtp.163.com";//获取服务器主机
        String uname = "lee_0xwee";//获取用户名
        String pwd = "lw1641";//获取密码
        String from = "lee_0xwee@163.com";//获取发件人*/


        String host = "smtp.qq.com";//获取服务器主机
        String uname = "1641714570";//获取用户名
        String pwd = "ynyrzabvndmsdiae";//获取密码
        String from = "1641714570@qq.com";//获取发件人
        String to = email;//获取收件人
        String subject = "这是来自Lee官方商城的激活邮件";//获取主题
        String content = "<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://127.0.0.1:8080/user_active.action?code="
                + code + "'>http://127.0.0.1:8080/user_active.action?code=" + code + "</a></h3>";//获取邮件内容

        // content = MessageFormat.format(content, user.getCode());//替换{0}

        Session session = MailUtils.createSession(host, uname, pwd);//得到session
        Mail mail = new Mail(from, to, subject, content);//创建邮件对象
        try {

            cn.itcast.mail.MailUtils.send(session, mail);//发邮件！

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }

    }


}
