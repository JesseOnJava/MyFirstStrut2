<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- �����ĥ� JSTL �P EL ���� --%>

<%
    EmpService empSvc = new EmpService();
    List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html >
<html>
<head>
<title>�Ҧ����u��� - listAllEmp.jsp</title>
<s:head theme="xhtml"  /><!-- �w�] -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


</head>
<body bgcolor='white'>

<div class="container">
  <div class="jumbotron">
    <h1>Welcome</h1>
    <h2>Angular & Bootstrap Demo</h2>
  </div>


	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCCC' align='center' valign='middle' height='20'>
			<td><h3>�Ҧ����u��� - ListAllEmp.jsp</h3>
			          <a href="<%=request.getContextPath()%>/form.jsp">�^��J��</a></td></tr>
	</table>
	
	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>���u�s��</th>
			<th>���u�m�W</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
		<c:forEach var="empVO" items="${list}" begin="0" end="${list.size()}">
			<tr align='center' valign='middle' ${(empVO.eid==param["empVO.eid"]) ? 'bgcolor=#CCCCFF':''}><!--�N�ק諸���@���[�J����Ӥw-->
				<td>${empVO.eid}</td>
				<td>${empVO.ename}</td>	
	
				<td>
				  <s:form action="getOne" namespace="/myNamespace"  method="getOne">
				     <s:submit value="�ק�" />
				        <input type="hidden" name="empVO.eid" value="${empVO.eid}">
<%-- 				        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller--> --%>
	<%-- 			        <input type="hidden" name="whichPage"	value="<%=\\whichPage%>">               <!--�e�X��e�O�ĴX����Controller--> --%>
				     </s:form>
				</td>
				<td>
				  <s:form action="myAction_delete" namespace="/myNamespace"  >
				     <s:submit value="�R��" />
				        <input type="hidden" name="empVO.eid" value="${empVO.eid}">
<%-- 				        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller--> --%>
	<%-- 			        <input type="hidden" name="whichPage"	value="\\<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller--> --%>
				  </s:form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<br>�����������|:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



</html>
