<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${login != null}">
	<button type="button" onclick="alert('�n�X�o');location.href='logout'">�ڭn�n�X</button>
</c:if>
