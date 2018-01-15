<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>show</title>

</head>
<body>

	<table border="1" cellspacing="0">
		<tr>
			<td>員工姓名</td><td>員工編號</td>
		</tr>
		<tr>
			<td><s:property value="ename"/></td><td><s:property value="eid"/></td>
		</tr>	
	</table>

</body>
</html>