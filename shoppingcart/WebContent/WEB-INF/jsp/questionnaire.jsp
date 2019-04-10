<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<title>問卷調查</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<form action="Questionnaire" method='post'>
			${questionNumber+1}:${quest}　<br>
			<input type='radio' name='question${questionNumber}' value='good'>滿意<br>
			<input type='radio' name='question${questionNumber}' value='soso'>普通<br>
			<input type='radio' name='question${questionNumber}' value='bad'>不滿意<br>
			<input type='submit' value='下一題' >
		</form>
	</td></tr>
</table>