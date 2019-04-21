<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>訂單資訊</title>
</head>
<body>
	<a href="orders">成交資訊</a>
	<a href="home">首頁</a>
	<br>
	<br>
	<table border='1'>
		<tr>
			<th align="center" colspan="4">訂單編號:${orderID}</th>
		</tr>
		<tr>
			<th>種類</th>
			<th>名稱</th>
			<th>價錢</th>
			<th>圖片</th>
		</tr>
		<c:forEach var="orderInfo" items="${orderInfo}">
			<tr>
		 		<td>${orderInfo.getCategory()}</td>
	 			<td>${orderInfo.getName()}</td>
	 			<td>${orderInfo.getPrice()}</td>
	 			<td><img src='${orderInfo.getPhoto()}'></td>	
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>