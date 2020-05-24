<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>传智商城</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">


        function pay(oid) {

            window.location.href = "${pageContext.request.contextPath}/order_toOrderPage.action?oid=" + oid;

        }

        function ack(oid) {

            window.location.href = "${pageContext.request.contextPath}/order_ackOrder.action?oid=" + oid;

        }



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

<div class="container cart">

    <div class="span24">

        <div class="step step1" style="text-align:left;margin: 20px;color: green">
            <h1>我的订单</h1>
        </div>

        <table>
            <tbody>
            <s:iterator value="pageBean.list" var="order">
                <tr>
                    <th colspan="5" style="font-size: 18px">
                        <font style="font-weight: bolder;color: black">订单编号：</font><s:property value="#order.oid"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <font style="font-weight: bolder;color: black">订单状态：</font>
                        <s:if test="#order.state==1">
                            <input class="button_ok" type="button" style="width: 80px;height: 30px" onclick="pay(<s:property value="#order.oid"/>)"
                                   value="未付款"/>
                        </s:if>
                        <s:if test="#order.state==2">
                            <font style="color: red">已付款,等待发货</font>
                        </s:if>
                        <s:if test="#order.state==3">
                            <input class="button_ok" type="button" style="width: 80px;height: 30px" onclick="ack(<s:property value="#order.oid"/>)"
                                   value="确认收货"/>
                        </s:if>
                        <s:if test="#order.state==4">
                            <font style="color: green">交易完成</font>

                        </s:if>
                    </th>
                </tr>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>

                </tr>

                <s:iterator value="#order.orderItemSet" var="orderItem">
                    <tr>
                        <td width="60">
                            <input type="hidden" name="id" value="22">
                            <img src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/> ">
                        </td>
                        <td>
                            <s:property value="#orderItem.product.pname"/>
                        </td>
                        <td>
                            ￥<s:property value="#orderItem.product.shop_price"/>
                        </td>
                        <td class="quantity" width="60">
                            <s:property value="#orderItem.count"/>
                        </td>
                        <td width="140">
                            <span class="subtotal">￥<s:property value="#orderItem.subtotal"/></span>
                        </td>

                    </tr>
                </s:iterator>
                <tr>
                    <th style="text-align: right;padding-right: 40px;font-weight: bolder;color: red;font-size: 18px"
                        colspan="5">
                        总计：￥<s:property value="#order.total"/></th>
                </tr>
            </s:iterator>
            </tbody>
        </table>

        <div class="pagination">
            <span>第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
                共${pageBean.totalCount}条记录&nbsp;&nbsp;&nbsp;</span>
            <s:if test="pageBean.pageNumber!=1">
                <a href="${pageContext.request.contextPath }/order_list.action?pageNumber=1"
                   class="firstPage">&nbsp;</a>
                <a href="${pageContext.request.contextPath }/order_list.action?pageNumber=${pageBean.pageNumber-1}"
                   class="previousPage">&nbsp;</a>
            </s:if>
            <s:else>
                <span class="firstPage">&nbsp;</span>
                <span class=" previousPage">&nbsp;</span>
            </s:else>

            <%--页码切换形式
            页码列表，最多显示4个页码！当前页在5位置上，例如：1 2 (3) 4
             --%>
            <c:choose>
                <c:when test="${pageBean.totalPage <= 4 }">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pageBean.totalPage }"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${pageBean.pageNumber-1 }"/>
                    <c:set var="end" value="${pageBean.pageNumber+2 }"/>
                    <c:choose>
                        <c:when test="${begin < 1 }">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="4"/>
                        </c:when>
                        <c:when test="${end > pageBean.totalPage }">
                            <c:set var="begin" value="${pageBean.totalPage-3 }"/>
                            <c:set var="end" value="${pageBean.totalPage }"/>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:choose>
                    <c:when test="${i != pageBean.pageNumber}">
                        <a href="${pageContext.request.contextPath }/order_list.action?&pageNumber=${i} ">
                                ${i }
                        </a>
                    </c:when>
                    <c:otherwise><span class="currentPage">${i}</span></c:otherwise>
                </c:choose>
            </c:forEach>


            <s:if test="pageBean.pageNumber!=pageBean.totalPage">
                <a class="nextPage"
                   href="${pageContext.request.contextPath }/order_list.action?pageNumber=${pageBean.pageNumber+1}">&nbsp;</a>

                <a class="lastPage"
                   href="${pageContext.request.contextPath }/order_list.action?pageNumber=${pageBean.totalPage}">&nbsp;</a>
            </s:if>
            <s:else>
                <span class="nextPage">&nbsp;</span>
                <span class="lastPage">&nbsp;</span>
            </s:else>

        </div>

    </div>

</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="image\r_renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
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
