<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>�լd���G</title>
<jsp:include page='frame.jsp'/>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<article>
			�ݨ��լd���G<br>
			<br>
			<c:forEach var="questionsAns" items="${questionsAns}">
				���D${questionsAns[0]}�G${questionsAns[1]}<br>
			</c:forEach>
			<br>
			<a href="orders">�����T</a>
			<a href="home">����</a>
		</article>
	</td></tr>
	
</table>