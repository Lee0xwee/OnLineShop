<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        <!--
        body {
            background-color: #FFFFFF;
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }

        body, td, th {
            color: #000000;
        }

        -->
    </style>
    <style>
        BODY {
            SCROLLBAR-FACE-COLOR: #cccccc;
            SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF;
            SCROLLBAR-SHADOW-COLOR: #ffffff;
            SCROLLBAR-3DLIGHT-COLOR: #cccccc;
            SCROLLBAR-ARROW-COLOR: #ffffff;
            SCROLLBAR-TRACK-COLOR: #ffffFF;
            SCROLLBAR-DARKSHADOW-COLOR: #cccccc;
        }
    </style>
</head>

<body>

<form name="Form1" method="post" action="name.aspx" id="Form1">

    <table width="100%" border="0" height="88" border="1"
           background="${pageContext.request.contextPath}/images/back1.JPG">
        <tr>
            <td colspan=4 class="ta_01" align="center" bgcolor="#afd1f3" style="height: 50px"><strong
                    style="font-size: 20px">系统首页</strong>
            </td>
        </tr>

        <tr>
            <td width="65%" height="84" align="center" valign="top">

            </td>
        </tr>
        <tr>
            <td height=2></td>
        </tr>

    </table>
    <div class="Style1" style="font-size: 50px;font-family: 隶书;
    margin-top: 60px;text-align: center;color: #d80000">欢迎<font
            style="font-family: 'Times New Roman'">${sessionScope.adminUser.username}</font>
    </div>
    <div class="Style1" style="font-size: 50px;font-family: 隶书;
    margin-top: 5px;text-align: center;color: #d80000">登录成功！
    </div>

</form>

</body>

</html>