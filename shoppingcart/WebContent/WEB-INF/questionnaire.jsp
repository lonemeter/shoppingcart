<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<title>�ݨ��լd</title>
<table width="100%" height="100%">
	<tr><td align="center" valign="center">
		<form action="questionnaire" method='post'>
			${i+1}:${quest}�@<br>
			<input type='radio' name='question${i}' value='good'>���N<br>
			<input type='radio' name='question${i}' value='soso'>���q<br>
			<input type='radio' name='question${i}' value='bad'>�����N<br>
			<input type='submit' value='�U�@�D' >
		</form>
	</td></tr>
</table>