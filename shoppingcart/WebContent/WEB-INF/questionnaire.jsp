<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�ݨ��լd</title>
</head>
<body>
	<form action="questionnaire" method='post'>
		${i+1}:${quest}�@<br>
		<input type='radio' name='question${i}' value='good'>���N<br>
		<input type='radio' name='question${i}' value='soso'>���q<br>
		<input type='radio' name='question${i}' value='bad'>�����N<br>
		<input type='submit' value='�U�@�D' >
	</form>
</body>
</html>