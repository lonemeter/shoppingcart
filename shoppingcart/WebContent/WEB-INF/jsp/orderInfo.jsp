<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�q���T</title>
</head>
<body>
	<a href="orders">�����T</a>
	<a href="home">����</a>
	<br>
	<br>
	<table border='1'>
		<tr>
			<th align="center" colspan="4">�q��s��:${orderID}</th>
		</tr>
		<tr>
			<th>����</th>
			<th>�W��</th>
			<th>����</th>
			<th>�Ϥ�</th>
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