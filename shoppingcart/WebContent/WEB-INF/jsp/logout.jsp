<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${loginUser != null}">
	<button type="button" onclick="alert('�n�X�o');location.href='logout'">�ڭn�n�X</button>
	<a href = "changePassword"><font size="4">�ק�K�X</font></a>
</c:if>
