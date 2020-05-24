<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>传智商城</title>
    <link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/css/product.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">

        $(function () {

            $("#addCart").click(function () {

                $("#cartForm").submit();

            })
            var count = 1;
            $("#increase").click(function () {

                count = count + 1;
                $("#count").val(count);

                /* //方式二
                var count = $("#count");
                 $(count).get(0).value = parseInt($(count).get(0).value) + 1;*/


            })

            $("#decrease").click(function () {
                if (count > 1) {

                    count = count - 1;
                    $("#count").val(count);

                } else {

                    count = 1;
                    $("#count").val(count);


                }
            })

        })

    </script>
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
<div class="container productContent">
    <div class="span6">
        <div class="hotProductCategory">
            <s:iterator value="#session.cList" var="c">
                <dl>
                    <dt>
                        <a href="${pageContext.request.contextPath}/category_findByCid.action?cid=<s:property value="#c.cid"/>&pageNumber=1">
                            <s:property value="#c.cname"/> </a>
                    </dt>
                    <s:iterator var="cs" value="#c.categorySecondSet">
                        <dd>
                            <a href="${pageContext.request.contextPath}/category_findByCsid.action?csid=<s:property value="#cs.csid"/>&pageNumber=1"/>
                            <s:property value="#cs.csname"/>
                            </a>
                        </dd>
                    </s:iterator>
                </dl>
            </s:iterator>
        </div>


    </div>
    <div class="span18 last">

        <div class="productImage">
            <a title="" style="outline-style: none; text-decoration: none;" id="zoom"
               href="http://image/r_renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
                <div class="zoomPad"><img style="opacity: 1;" title="" class="medium"
                                          src="${pageContext.request.contextPath}/${model.image}">
                    <div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
                         class="zoomPup"></div>
                    <div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
                         class="zoomWindow">
                        <div style="width: 368px;" class="zoomWrapper">
                            <div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div>
                            <div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img
                                    src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg"
                                    style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;">
                            </div>
                        </div>
                    </div>
                    <div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">
                        Loading zoom
                    </div>
                </div>
            </a>

        </div>
        <div class="name">${model.pname}</div>
        <div class="sn">
            <div>编号：751</div>
        </div>
        <div class="info">
            <dl>
                <dt>商城价:</dt>
                <dd>
                    <strong>￥：${model.shop_price}元/份</strong>
                    参 考 价：
                    <del>￥${model.market_price}元/份</del>
                </dd>
            </dl>
            <dl>
                <dt>促销:</dt>
                <dd>
                    <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时折扣</a>
                </dd>
            </dl>
            <dl>
                <dt></dt>
                <dd>
                    <span>    </span>
                </dd>
            </dl>
        </div>
        <form id="cartForm" action="${pageContext.request.contextPath}/cart_addCart.action" method="post">
            <input type="hidden" name="pid" value="${model.pid}">
            <div class="action">

                <dl class="quantity">
                    <dt>购买数量:</dt>
                    <dd>
                        <input id="count" name="count" value="1" maxlength="4" onpaste="return false;" type="text">
                        <div>
                            <a href="#" id="increase" class="increase">&nbsp;</a>
                            <a href="#" id="decrease" class="decrease">&nbsp;</a>
                            <%--<span id="increase" class="increase">&nbsp;</span>
                            <span id="decrease" class="decrease">&nbsp;</span>--%>
                        </div>
                    </dd>
                    <dd>
                        件
                    </dd>
                </dl>
                <div class="buy">
                    <input id="addCart" class="addCart" value="加入购物车" type="button">

                </div>
            </div>

        </form>
        <div id="bar" class="bar">
            <ul>
                <li id="introductionTab">
                    <a href="#introduction">商品介绍</a>
                </li>

            </ul>
        </div>

        <div id="introduction" name="introduction" class="introduction">
            <div class="title">
                <strong>${model.pdesc}</strong>
            </div>
            <div style="text-align: center">
                <img src="${pageContext.request.contextPath}/${model.image}">
            </div>
        </div>


    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="${pageContext.request.contextPath }/image/r_renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势"
                 height="52" width="950">
        </div>
    </div>
    <div class="span24">
        <ul class="bottomNav">
            <li>
                <a href="#">关于我们</a>
                |
            </li>
            <li>
                <a href="#">联系我们</a>
                |
            </li>
            <li>
                <a href="#">诚聘英才</a>
                |
            </li>
            <li>
                <a href="#">法律声明</a>
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
                <a>SHOP++官网</a>
                |
            </li>
            <li>
                <a>SHOP++论坛</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
    </div>
</div>
</body>
</html>