<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table width="70%" style="text-align: center;margin: 0 auto">
    <s:iterator var="orderItem" value="model.orderItemSet">
        <tr>
            <td style="width: 100px">
                <img width="40" height="45" src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>">
            </td>
            <td style="width: 100px"><s:property value="#orderItem.product.pname"/></td>
            <td style="width: 100px"><s:property value="#orderItem.count"/>件</td>
            <td style="width: 100px">￥<s:property value="#orderItem.subtotal"/></td>
        </tr>
    </s:iterator>
</table>