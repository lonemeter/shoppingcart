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
		<title>METER�ʪ���</title>
		<jsp:include page='frame.jsp'/>
	</head>
<body>
	<header>
		  <h2><c:if test="${loginUser != null}">${loginUser.getName()},</c:if>�w����{METER�ʪ���</h2>
		  <c:if test="${loginUser == null}"><a href='Login'>�Ѧ��n�J�b��</a></c:if>
		  <jsp:include page='/WEB-INF/jsp/logout.jsp'/>
	</header>
	<section>
		  <jsp:include page="/WEB-INF/jsp/frame-nav.jsp"/>
		  <article>
			<c:forEach var="goods" items="${goods}">
				<img src="${goods.getPhoto()}"><br>${goods.getName()}�@����:${goods.getPrice()}�@<button type='button' onclick='alert("�����ʪ���");location.href="ShoppingCartManagement?remove=t&product=${goods.getEngname()}"'>�����ʪ���</button><br>
			</c:forEach>		
			<br><br>
			<c:if test="${loginUser != null}">
				�z���{���G${loginUser.getMoney()}�@<br>
				<c:choose>
					<c:when test="${sum==0}">
						�`�@���B�G${sum}�@<button type='button' onclick='alert("����ܰӫ~")'>�h���b</button><br>
					</c:when>
					<c:otherwise>
						<c:if test="${sum > loginUser.getMoney()}">
							�`�@���B�@�G${sum}�@�l�B����<button type='button' onclick='location.href="Store"'>���x��</button><br>
						</c:if>
						<c:if test="${sum <= loginUser.getMoney()}">
							�`�@���B�@�G${sum}�@<button type='button' onclick='alert("�I�ڡG ${sum}���A ���\�I");location.href="Consume"'>�h���b</button><br>
						</c:if>
						
					</c:otherwise>
				</c:choose>
				
			</c:if>
			<c:if test="${loginUser == null}">���n�J</c:if>
		  </article>
		</section>
</body>
</html>