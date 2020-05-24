<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>传智播客</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="divcontent" style="text-align: center">
    <div style="padding-top: 100px">
        <a href="${ pageContext.request.contextPath }/index.action"
           style="text-decoration:none"><font style="font-size: 24px">首页</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <a href="${ pageContext.request.contextPath }/user_registPage.action"
           style="text-decoration:none"><font style="font-size: 24px">注册</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <a href="${ pageContext.request.contextPath }/user_loginPage.action"
           style="text-decoration:none"><font style="font-size: 24px">登录</font></a>
    </div>
    <table width="850px" border="0" cellspacing="0" style="margin: 0 auto">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="90%" border="0" cellspacing="0" style="margin: 10px auto">
                    <tr>
                        <td style="width:98px"><img
                                src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128"
                                height="128"/>
                        </td>
                        <td style="padding-top:10px;width: 350px">
                            <font style="font-weight:bold; color:#FF0000;font-size: 30px">
                            <s:actionmessage/>
                            <s:actionerror/>
                        </font>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1></td>
        </tr>
    </table>
</div>
</body>
</html>