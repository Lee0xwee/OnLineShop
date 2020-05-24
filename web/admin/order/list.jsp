<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">

        function deliver_goods(oid) {

            window.location.href = "${pageContext.request.contextPath}/adminOrder_updateState.action?oid=" + oid;

        }

        function showDetail(oid) {


            var $but = $("#but" + oid);
            var $div = $("#div" + oid);
            if ($but.val() == "订单详情") {

                $.post("${pageContext.request.contextPath}/adminOrder_findOrderItem.action",
                    {"oid": oid, "time": new Date().getTime()}, function (obj) {

                        $div.html(obj)

                    });

                $but.val("关闭");

            } else {

                $div.html("");
                $but.val("订单详情");

            }
        }

    </script>
</HEAD>
<body>
<br>
<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
        <TBODY>
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3">
                <strong>订单列表</strong>
            </TD>
        </tr>

        <tr>
            <td class="ta_01" align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr
                            style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

                        <td align="center" width="10%">
                            序号
                        </td>
                        <td align="center" width="10%">
                            订单编号
                        </td>
                        <td align="center" width="10%">
                            订单金额
                        </td>
                        <td align="center" width="10%">
                            收货人
                        </td>
                        <td align="center" width="10%">
                            订单状态
                        </td>
                        <td align="center" width="50%">
                            订单详情
                        </td>
                    </tr>
                    <s:iterator var="o" value="pageBean.list" status="status">
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#F5FAFE';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="18%">
                                <s:property value="#status.count"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:property value="#o.oid"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:property value="#o.total"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:property value="#o.name"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:if test="#o.state==1">
                                    <font style="color: red">未付款</font>
                                </s:if>
                                <s:if test="#o.state==2">
                                    <input type="button" style="width: 50px;height: 25px"
                                           onclick="deliver_goods(<s:property value="#o.oid"/>)"
                                           value="发货"/>
                                </s:if>
                                <s:if test="#o.state==3">
                                    <font style="color: blue"> 等待确认收货</font>
                                </s:if>
                                <s:if test="#o.state==4">
                                    <font style="color: green">订单完成</font>
                                </s:if>

                            </td>
                            <td align="center" style="HEIGHT: 22px">
                                <input style="width: 80px;height: 25px" type="button" value="订单详情"
                                       id="but<s:property value="#o.oid"/>"
                                       onclick="showDetail(<s:property value="#o.oid"/>)"/>

                            </td>
                        <tr>
                            <td colspan="6">
                                <div id="div<s:property value="#o.oid"/>">

                                </div>
                            </td>

                        </tr>

                        </tr>
                    </s:iterator>
                </table>
            </td>
        </tr>
        <tr align="center">
            <td colspan="7">
                <div class="pagination">
                <span>第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
                共${pageBean.totalCount}条记录&nbsp;&nbsp;&nbsp;</span>
                    <s:if test="pageBean.pageNumber!=1">
                        <a href="${pageContext.request.contextPath }/adminOrder_findAll.action?pageNumber=1"
                           class="firstPage">&nbsp;</a>
                        <a href="${pageContext.request.contextPath }/adminOrder_findAll.action?pageNumber=${pageBean.pageNumber-1}"
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
                                <a href="${pageContext.request.contextPath }/adminOrder_findAll.action?&pageNumber=${i} ">
                                        ${i }
                                </a>
                            </c:when>
                            <c:otherwise><span class="currentPage">${i}</span></c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <s:if test="pageBean.pageNumber!=pageBean.totalPage">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath }/adminOrder_findAll.action?pageNumber=${pageBean.pageNumber+1}">&nbsp;</a>

                        <a class="lastPage"
                           href="${pageContext.request.contextPath }/adminOrder_findAll.action?pageNumber=${pageBean.totalPage}">&nbsp;</a>
                    </s:if>
                    <s:else>
                        <span class="nextPage">&nbsp;</span>
                        <span class="lastPage">&nbsp;</span>
                    </s:else>
                </div>
            </td>
        </tr>
        </TBODY>
    </table>
</form>
</body>
</HTML>

