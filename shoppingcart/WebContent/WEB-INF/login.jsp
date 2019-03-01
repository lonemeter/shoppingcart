<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<style>
a {text-decoration:none;}
</style>
<title>登入帳號</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<h3>請登入帳號</h3>
		<form action="login" method="post">
			帳號:<input type="text" name="name"><br>
			密碼:<input type="password" name="password"><br>
			<input type="submit" value="登入">
		</form>
		<a href='home'>不登入直接遊覽</a>
		<button type="button" onclick="location.href='accountdb'">註冊帳號</button>
	</td></tr>
</table>