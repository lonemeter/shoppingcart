<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.*,java.text.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>METER �ʪ���</title>	
		<jsp:include page='frame.jsp'/>
	</head>
	<body>
		<header>
		  <h2><c:if test="${login != null}">${login},</c:if>�w����{METER${����}�ӳ�</h2>
		  <c:if test="${login == null}"><a href='login'>�Ѧ��n�J</a></c:if>
		  <jsp:include page='logout.jsp'/>
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
			<script>
		  		function button(a){
		  				 $.ajax({ 
		  	               type:"get",  //�ǭȤ覡���� post & get
		  	               url:"sessiontest?ses="+a,
		  	               async:false
			  	         })
			  	          alert("�[�J�ʪ���");
		  		}  		
			</script>
			<c:forEach var="goods" items="${goods}">
						<img src='${goods.photo}'><br>${goods.name}�@����:${goods.price}�@<c:if test='${login!=null}'><button type='button' onclick="button('${goods.engname}')">�[�J�ʪ���</button></c:if><br>
			</c:forEach>
		  </article>
		</section>
	</body>
</html>