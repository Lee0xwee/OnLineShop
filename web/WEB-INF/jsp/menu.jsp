<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>

<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <s:if test="#session.sessionUser == null">
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|
                </li>
            </s:if>
            <s:else>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <s:property value="#session.sessionUser.name"/> |
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${pageContext.request.contextPath}/order_list.action?&pageNumber=1">我的订单</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${pageContext.request.contextPath}/user_exit.action">退出</a>|
                </li>
            </s:else>
            <li>
                <a>会员中心</a>
                |
            </li>
            <li>
                <a>购物指南</a>
                |
            </li>
            <li>
                <a>关于我们</a>

            </li>
        </ul>
    </div>
    <div class="cart">
        <a href="${pageContext.request.contextPath}/cart_toCartPage.action">购物车</a>
    </div>
    <div class="phone">
        客服热线:
        <strong>96008/53277764</strong>
    </div>
</div>
<div class="span24">
    <ul class="mainNav">
        <li><a href="${pageContext.request.contextPath}/index.action">首页</a> |</li>
        <s:iterator value="#session.cList" var="c">
            <li>
                <a href="${pageContext.request.contextPath}/category_findByCid.action?cid=<s:property value="#c.cid"/>&pageNumber=1">
                    <s:property value="#c.cname"/>
                </a>
                |
            </li>
        </s:iterator>
    </ul>
</div>

</div>