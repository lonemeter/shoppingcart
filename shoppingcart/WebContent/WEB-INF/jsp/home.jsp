<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<style>
		a {text-decoration:none;}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER 購物場</title>	
		<jsp:include page='frame.jsp'/>
	</head>
	<body>
		<header>
		  <h2><c:if test="${loginUser != null}">${loginUser.getName()},</c:if>歡迎光臨METER的${分類}商場</h2>
		  <c:if test="${loginUser == null}"><a href='login'>由此登入帳號</a></c:if>
		  <jsp:include page='/WEB-INF/jsp/logout.jsp'/>
		</header>
		<section>
		  <jsp:include page="/WEB-INF/jsp/frame-nav.jsp"/>	  
		  <article>
			<script>
		  		function button(a){
		  				 $.ajax({ 
		  	               type:"get",  //傳值方式有分 post & get
		  	               url:"shoppingCartManagement?product="+a,
		  	               async:false
			  	         })
			  	          alert("加入購物車");
		  		}  		
			</script>
			<form action="home" method="get">
			<c:if test="${param.page!=null && param.page!=shoppingcart}">
				<input type='hidden' name='page' value='${param.page}'>
			</c:if>
				<input type="text" name="serch" placeholder="想找甚麼">
				<input type="submit" value="收尋"><br><br>
			</form>
			<c:forEach var="goods" items="${goods}">
						<img src='${goods.getPhoto()}'><br>${goods.getName()}　價格:${goods.getPrice()}　<c:if test='${loginUser!=null}'><button type='button' onclick="button('${goods.getEngname()}')">加入購物車</button></c:if><br>
			</c:forEach>
		  </article>
		</section>
	</body>
</html>