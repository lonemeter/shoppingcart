<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>成交購物紀錄</title>
</head>
<body>
	<a href="home">首頁</a>
	<table border='1'>
		<tr>
			<th>訂單編號</th>
			<th>購物者</th>
			<th>訂單資訊</th>
		</tr>
		<c:forEach var="orders" items="${orders}">
			<tr>
		 		<td>${orders.getOrderID()}</td>
	 			<td>${orders.getUserName()}</td>
	 			<td><a href="orderInfo?orderID=${orders.getOrderID()}">查看訂單</a></td>
			</tr>
	
			
		</c:forEach>
	
	</table>
</body>
</html>