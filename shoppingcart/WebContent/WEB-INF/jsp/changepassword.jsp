<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<style>
a {text-decoration:none;}
</style>
<title>修改密碼</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<h3>請登入帳號</h3>
		<form action="ChangePassword" method="post">
			舊的密碼:<input type="password" name="oldpassword"><br>
			新的密碼:<input type="password" name="newpassword1"><br>
			密碼確認:<input type="password" name="newpassword2"><br>
			<input type="submit" value="確認修改"><a href="Home">不要修改</a>
		</form>
	</td></tr>
</table>