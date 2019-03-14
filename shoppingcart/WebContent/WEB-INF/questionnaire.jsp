<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<title>問卷調查</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<form action="questionnaire" method='post'>
			${i+1}:${quest}　<br>
			<input type='radio' name='question${i}' value='good'>滿意<br>
			<input type='radio' name='question${i}' value='soso'>普通<br>
			<input type='radio' name='question${i}' value='bad'>不滿意<br>
			<input type='submit' value='下一題' >
		</form>
	</td></tr>
</table>