<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER�ʪ���</title>
		<jsp:include page='frame.jsp'/>
	</head>
<body>
	<header>
		  <h2>�w����{METER�ʪ���</h2>
	</header>
	<section>
		  <nav>
		    <ul>
		      <li><a href="home">����</a></li>
		      <li><a href="home?page=1">�ɫ~</a></li>
		      <li><a href="home?page=2">����</a></li>
		      <li><a href="home?page=3">�Z��</a></li>
		      <li><a href="home?page=4">�ʪ���</a></li>
		    </ul>
		  </nav>	  
		  <article>
			<c:forEach var="goods" items="${goods}">
				<img src="${goods.photo}"><br>${goods.name}�@����:${goods.price}�@<button type='button' onclick='alert("�����ʪ���");location.href="sessiontest?sell=t&ses=${goods.engname}"'>�����ʪ���</button><br>
			</c:forEach>		
			<br><br>�`�@���B�G${sum}�@<button type='button' onclick='alert("�I�ڡG ${sum}���A ���\�I");location.href="sessiontest?clc=t"'>�h���b</button><br>
		  </article>
		</section>
</body>
</html>