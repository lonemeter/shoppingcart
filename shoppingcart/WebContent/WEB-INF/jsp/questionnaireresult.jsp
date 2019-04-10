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
			問題一:${question0}<br>
			問題二:${question1}<br>
			問題三:${question2}<br>
			<br>
			<a href="Home">繼續購物</a>
		</article>
	</td></tr>
</table>