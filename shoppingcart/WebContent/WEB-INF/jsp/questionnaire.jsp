<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<title>�ݨ��լd</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<form action="Questionnaire" method='post'>
			${questionNumber+1}:${quest}�@<br>
			<input type='radio' name='question${questionNumber}' value='good'>���N<br>
			<input type='radio' name='question${questionNumber}' value='soso'>���q<br>
			<input type='radio' name='question${questionNumber}' value='bad'>�����N<br>
			<input type='submit' value='�U�@�D' >
		</form>
	</td></tr>
</table>