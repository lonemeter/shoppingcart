<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>調查結果</title>
<jsp:include page='frame.jsp'/>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<article>
			問卷調查結果<br>
			<br>
			<c:forEach var="questionsAns" items="${questionsAns}">
				問題${questionsAns[0]}：${questionsAns[1]}<br>
			</c:forEach>
			<br>
			<a href="home">繼續購物</a>
		</article>
	</td></tr>
</table>