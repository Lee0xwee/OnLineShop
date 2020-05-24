<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>传智商城</title>
    <link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
    <div class="span5">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/index.action">
                <img src="${pageContext.request.contextPath}/image/r_renleipic_01/logo.gif" alt="传智播客"/>
            </a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障"
                 title="正品保障"/>
        </div>
    </div>

    <%@ include file="menu.jsp" %>

</div>

<div class="container index">

    <div class="span24">
        <div id="hotProduct" class="hotProduct clearfix">
            <div class="title">
                <strong>热门商品</strong>
                <!-- <a  target="_blank"></a> -->
            </div>
            <ul class="tab">
                <li class="current">
                    <a href="蔬菜分类.htm?tagIds=1" target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
            </ul>
            <!-- 					<div class="hotProductAd">
                        <img src="${pageContext.request.contextPath }/image/a.jpg" width="260" height="343" alt="热门商品" title="热门商品">
            </div> -->
            <ul class="tabContent" style="display: block;">
                <s:iterator var="product" value="hotList">
                    <li>
                        <a target="_blank"
                           href="${pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#product.pid"/>"><img
                                src="${pageContext.request.contextPath }/<s:property value="#product.image"/> "
                                data-original="http://storage.shopxx.net/demo-image/3.0/201301/0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg"
                                style="display: block;"></a>
                    </li>

                </s:iterator>

            </ul>
        </div>
    </div>
    <div class="span24">
        <div id="newProduct" class="newProduct clearfix">
            <div class="title">
                <strong>最新商品</strong>
                <a target="_blank"></a>
            </div>
            <ul class="tab">
                <li class="current">
                    <a href="蔬菜分类.htm?tagIds=2" target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
                <li>
                    <a target="_blank"></a>
                </li>
            </ul>
            <!-- 					<div class="newProductAd">
                                                <img src="${pageContext.request.contextPath }/image/q.jpg" width="260" height="343" alt="最新商品" title="最新商品">
                                    </div>
                                     -->
            <ul class="tabContent" style="display: block;">
                <s:iterator var="product" value="newList">
                    <li>
                        <a target="_blank"
                           href="${pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#product.pid"/>">
                            <img
                                    src="${pageContext.request.contextPath }/<s:property value="#product.image"/>"
                                    data-original="http://storage.shopxx.net/demo-image/3.0/201301/4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg"
                                    style="display: block;"></a>
                    </li>
                </s:iterator>
            </ul>

        </div>
    </div>
    <div class="span24">
        <div class="friendLink">
            <dl>
                <dt>新手指南</dt>
                <dd>
                    <a target="_blank">支付方式</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">配送方式</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">售后服务</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">购物帮助</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">蔬菜卡</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">礼品卡</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">银联卡</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">亿家卡</a>
                    |
                </dd>

                <dd class="more">
                    <a>更多</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="${pageContext.request.contextPath }/image/footer.jpg" width="950" height="52" alt="我们的优势"
                 title="我们的优势">
        </div>
    </div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a>关于我们</a>
                |
            </li>
            <li>
                <a>联系我们</a>
                |
            </li>
            <li>
                <a>招贤纳士</a>
                |
            </li>
            <li>
                <a>法律声明</a>
                |
            </li>
            <li>
                <a>友情链接</a>
                |
            </li>
            <li>
                <a target="_blank">支付方式</a>
                |
            </li>
            <li>
                <a target="_blank">配送方式</a>
                |
            </li>
            <li>
                <a>服务声明</a>
                |
            </li>
            <li>
                <a>广告声明</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
    </div>
</div>
</body>
</html>
