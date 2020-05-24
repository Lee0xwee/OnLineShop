<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>传智商城后台</title>
    <link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

    <script type="text/javascript">

        $(function () {

            $("#add").click(function () {

                window.location.href = "${pageContext.request.contextPath}/adminCategorySecond_toAddPage.action"

            });

        })
    </script>
</HEAD>
<body>
<br>
<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
    <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
        <TBODY>
        <tr>
            <td class="ta_01" align="center" bgColor="#afd1f3">
                <strong>二级分类列表</strong>
            </TD>
        </tr>
        <tr>
            <td class="ta_01" align="right">
                <button type="button" id="add" name="add" value="添加" class="button_add">
                    &#28155;&#21152;
                </button>

            </td>
        </tr>
        <tr>
            <td class="ta_01" align="center" bgColor="#f5fafe">
                <table cellspacing="0" cellpadding="1" rules="all"
                       bordercolor="gray" border="1" id="DataGrid1"
                       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                    <tr
                            style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

                        <td align="center" width="18%">
                            序号
                        </td>
                        <td align="center" width="17%">
                            二级分类名称
                        </td>
                        <td align="center" width="17%">
                            所属一级分类
                        </td>
                        <td width="7%" align="center">
                            编辑
                        </td>
                        <td width="7%" align="center">
                            删除
                        </td>
                    </tr>
                    <s:iterator var="cs" value="pageBean.list" status="status">
                        <tr onmouseover="this.style.backgroundColor = 'white'"
                            onmouseout="this.style.backgroundColor = '#F5FAFE';">
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="18%">
                                <s:property value="#status.count"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:property value="#cs.csname"/>
                            </td>
                            <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                                width="17%">
                                <s:property value="#cs.cid.cname"/>
                            </td>
                            <td align="center" style="HEIGHT: 22px">
                                <a href="${ pageContext.request.contextPath }/adminCategorySecond_edit.action?csid=<s:property value="#cs.csid"/>">
                                    <img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0"
                                         style="CURSOR: hand">
                                </a>
                            </td>

                            <td align="center" style="HEIGHT: 22px">
                                <a href="${ pageContext.request.contextPath }/adminCategorySecond_delete.action?csid=<s:property value="#cs.csid"/>">
                                    <img src="${pageContext.request.contextPath}/images/i_del.gif" width="16"
                                         height="16" border="0" style="CURSOR: hand">
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </td>

        </tr>
        <tr align="center">
            <td colspan="4">
                <div class="pagination">
                <span>第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
                共${pageBean.totalCount}条记录&nbsp;&nbsp;&nbsp;</span>
                    <s:if test="pageBean.pageNumber!=1">
                        <a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?pageNumber=1"
                           class="firstPage">&nbsp;</a>
                        <a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?pageNumber=${pageBean.pageNumber-1}"
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
                                <a href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?&pageNumber=${i} ">
                                        ${i }
                                </a>
                            </c:when>
                            <c:otherwise><span class="currentPage">${i}</span></c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <s:if test="pageBean.pageNumber!=pageBean.totalPage">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?pageNumber=${pageBean.pageNumber+1}">&nbsp;</a>

                        <a class="lastPage"
                           href="${pageContext.request.contextPath }/adminCategorySecond_findAll.action?pageNumber=${pageBean.totalPage}">&nbsp;</a>
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

