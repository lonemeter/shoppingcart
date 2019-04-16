<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${loginUser != null}">
	<button type="button" onclick="alert('登出囉');location.href='logout'">我要登出</button>
	<a href = "changePassword"><font size="4">修改密碼</font></a>
</c:if>
