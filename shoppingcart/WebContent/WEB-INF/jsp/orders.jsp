<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�����ʪ�����</title>
</head>
<body>
	<a href="home">����</a>
	<table border='1'>
		<tr>
			<th>�q��s��</th>
			<th>�ʪ���</th>
			<th>�q���T</th>
		</tr>
		<c:forEach var="orders" items="${orders}">
			<tr>
		 		<td>${orders.getOrderID()}</td>
	 			<td>${orders.getUserName()}</td>
	 			<td><a href="orderInfo?orderID=${orders.getOrderID()}">�d�ݭq��</a></td>
			</tr>
	
			
		</c:forEach>
	
	</table>
</body>
</html>