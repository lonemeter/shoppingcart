<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER購物場</title>
		<jsp:include page='frame.jsp'/>
	</head>
<body>
	<header>
		  <h2>歡迎光臨METER購物車</h2>
	</header>
	<section>
		  <nav>
		    <ul>
		      <li><a href="home">首頁</a></li>
		      <li><a href="home?page=1">補品</a></li>
		      <li><a href="home?page=2">防具</a></li>
		      <li><a href="home?page=3">武器</a></li>
		      <li><a href="home?page=4">購物車</a></li>
		    </ul>
		  </nav>	  
		  <article>
			<c:forEach var="goods" items="${goods}">
				<img src="${goods.photo}"><br>${goods.name}　價格:${goods.price}　<button type='button' onclick='alert("移除購物車");location.href="sessiontest?sell=t&ses=${goods.engname}"'>移除購物車</button><br>
			</c:forEach>		
			<br><br>總共金額：${sum}　<button type='button' onclick='alert("付款： ${sum}元， 成功！");location.href="sessiontest?clc=t"'>去結帳</button><br>
		  </article>
		</section>
</body>
</html>