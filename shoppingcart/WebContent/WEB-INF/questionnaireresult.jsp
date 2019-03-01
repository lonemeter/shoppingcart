<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>調查結果</title>
<jsp:include page='frame.jsp'/>
</head>
<body>

	<article>
		問卷調查結果<br>
		<br>
		問題一:${question0}<br>
		問題二:${question1}<br>
		問題三:${question2}<br>
		<br>
		<a href="home">繼續購物</a>
	</article>

</body>
</html>