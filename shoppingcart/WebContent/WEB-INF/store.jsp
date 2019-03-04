<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>${login.getName()}儲值介面</title>
</head>
<body>
	<form action='userstore' method='post'>
		儲值金額：　<input type=text name=storemoney placeholder='請輸入金額'>
		<input type=submit value='儲值'>
	</form>
</body>
</html>