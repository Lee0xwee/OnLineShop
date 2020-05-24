<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>传智商城</title>
    <link href="${pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/css/product.css" rel="stylesheet" type="text/css">
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
<div class="container productList">
    <div class="span6">
        <div class="hotProductCategory">

            <s:iterator value="#session.cList" var="c">
                <dl>
                    <dt>
                        <a href="${pageContext.request.contextPath}/category_findByCid.action?cid=<s:property value="#c.cid"/>&pageNumber=1">
                            <s:property value="#c.cname"/>
                        </a>
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

        <form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm"
              method="post">

            <div id="result" class="result table clearfix">
                <ul>
                    <s:iterator value="pageBean.list" var="p">
                        <li>
                            <a href="${pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#p.pid"/>">
                                <img src="${pageContext.request.contextPath}/<s:property value="#p.image"/> "
                                     width="170"
                                     height="170" style="display: inline-block;">

                                <span style='color:green'>
											 <s:property value="#p.pname"/>
											</span>

                                <span class="price">
												商城价： ￥<s:property value="#p.shop_price"/> /份
											</span>

                            </a>
                        </li>
                    </s:iterator>
                </ul>
            </div>
            <div class="pagination">
                <span>第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
                    共${pageBean.totalCount}条记录&nbsp;&nbsp;&nbsp;</span>
                <s:if test="model.cid !=null">
                    <s:if test="pageBean.pageNumber!=1">
                        <a href="${pageContext.request.contextPath }/category_findByCid.action?cid=${model.cid}&pageNumber=1"
                           class="firstPage">&nbsp;</a>
                        <a href="${pageContext.request.contextPath }/category_findByCid.action?cid=${model.cid}&pageNumber=${pageBean.pageNumber-1}"
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
                                <a href="${pageContext.request.contextPath }/category_findByCid.action?cid=${model.cid}&pageNumber=${i} ">
                                        ${i }
                                </a>
                            </c:when>
                            <c:otherwise><span class="currentPage">${i}</span></c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <s:if test="pageBean.pageNumber!=pageBean.totalPage">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath }/category_findByCid.action?cid=${model.cid}&pageNumber=${pageBean.pageNumber+1}">&nbsp;</a>

                        <a class="lastPage"
                           href="${pageContext.request.contextPath }/category_findByCid.action?cid=${model.cid}&pageNumber=${pageBean.totalPage}">&nbsp;</a>
                    </s:if>
                    <s:else>
                        <span class="nextPage">&nbsp;</span>
                        <span class="lastPage">&nbsp;</span>
                    </s:else>
                </s:if>
                <s:if test="csid!=null">

                    <s:if test="pageBean.pageNumber!=1">
                        <a href="${pageContext.request.contextPath }/category_findByCsid.action?csid=${csid}&pageNumber=1"
                           class="firstPage">&nbsp;</a>
                        <a href="${pageContext.request.contextPath }/category_findByCsid.action?csid=${csid}&pageNumber=${pageBean.pageNumber-1}"
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
                                <a href="${pageContext.request.contextPath }/category_findByCsid.action?csid=${csid}&pageNumber=${i} ">
                                        ${i }
                                </a>
                            </c:when>
                            <c:otherwise><span class="currentPage">${i}</span></c:otherwise>
                        </c:choose>
                    </c:forEach>


                    <s:if test="pageBean.pageNumber!=pageBean.totalPage">
                        <a class="nextPage"
                           href="${pageContext.request.contextPath }/category_findByCsid.action?csid=${csid}&pageNumber=${pageBean.pageNumber+1}">&nbsp;</a>

                        <a class="lastPage"
                           href="${pageContext.request.contextPath }/category_findByCsid.action?csid=${csid}&pageNumber=${pageBean.totalPage}">&nbsp;</a>
                    </s:if>
                    <s:else>
                        <span class="nextPage">&nbsp;</span>
                        <span class="lastPage">&nbsp;</span>
                    </s:else>
                </s:if>
            </div>
        </form>
    </div>
</div>
<div class="container footer">
    <div class="span24">
        <div class="footerAd">
            <img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势"
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
                <a>诚聘英才</a>
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
                <a>官网</a>
                |
            </li>
            <li>
                <a>论坛</a>

            </li>
        </ul>
    </div>
    <div class="span24">
        <div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
    </div>
</div>
</body>
</html>