<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
a {text-decoration:none;}
</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER購物場</title>
		<jsp:include page='frame.jsp'/>
	</head>
<body>
	<header>
		  <h2><c:if test="${login != null}">${login.getName()},</c:if>歡迎光臨METER購物車</h2>
		  <c:if test="${login == null}"><a href='login'>由此登入帳號</a></c:if>
		  <jsp:include page='logout.jsp'/>
	</header>
	<section>
		  <jsp:include page="frame-nav.jsp"/>
		  <article>
			<c:forEach var="goods" items="${goods}">
				<img src="${goods.getPhoto()}"><br>${goods.getName()}　價格:${goods.getPrice()}　<button type='button' onclick='alert("移除購物車");location.href="sessiontest?sell=t&ses=${goods.getEngname()}"'>移除購物車</button><br>
			</c:forEach>		
			<br><br>
			<c:if test="${login != null}">
				您的現金：${login.getMoney()}　<br>
				<c:choose>
					<c:when test="${sum==0}">
						總共金額：${sum}　<button type='button' onclick='alert("未選擇商品")'>去結帳</button><br>
					</c:when>
					<c:otherwise>
						<c:if test="${sum>login.getMoney()}">
							總共金額　：${sum}　餘額不足<button type='button' onclick='location.href="storeservlet"'>請儲值</button><br>
						</c:if>
						<c:if test="${sum<=login.getMoney()}">
							總共金額　：${sum}　<button type='button' onclick='alert("付款： ${sum}元， 成功！");location.href="sessiontest?clc=t"'>去結帳</button><br>
						</c:if>
						
					</c:otherwise>
				</c:choose>
				
			</c:if>
			<c:if test="${login == null}">未登入</c:if>
		  </article>
		</section>
</body>
</html>