<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
		<title>METER �N�e��</title>	
		<jsp:include page='\WEB-INF\jsp\frame.jsp'/>
	</head>
	<body>
		<header>
		  <h2><c:if test="${loginUser != null}">${loginUser.getName()},</c:if>�w����{METER��${����}�ӳ�</h2>
		  <c:if test="${loginUser == null}"><a href='login'>�Ѧ��n�J�b��</a></c:if>
		  <jsp:include page='WEB-INF\jsp\logout.jsp'/>
		</header>
		<section>
		  <jsp:include page="WEB-INF\jsp\frame-nav.jsp"/>	  
		  <article>
			�ڥu�O�N�e��QQ
		  </article>
		</section>
	</body>
</html>