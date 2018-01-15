<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
    EmpService empSvc = new EmpService();
    List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html >
<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
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
			<td><h3>所有員工資料 - ListAllEmp.jsp</h3>
			          <a href="<%=request.getContextPath()%>/form.jsp">回輸入頁</a></td></tr>
	</table>
	
	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<c:forEach var="empVO" items="${list}" begin="0" end="${list.size()}">
			<tr align='center' valign='middle' ${(empVO.eid==param["empVO.eid"]) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
				<td>${empVO.eid}</td>
				<td>${empVO.ename}</td>	
	
				<td>
				  <s:form action="getOne" namespace="/myNamespace"  method="getOne">
				     <s:submit value="修改" />
				        <input type="hidden" name="empVO.eid" value="${empVO.eid}">
<%-- 				        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
	<%-- 			        <input type="hidden" name="whichPage"	value="<%=\\whichPage%>">               <!--送出當前是第幾頁給Controller--> --%>
				     </s:form>
				</td>
				<td>
				  <s:form action="myAction_delete" namespace="/myNamespace"  >
				     <s:submit value="刪除" />
				        <input type="hidden" name="empVO.eid" value="${empVO.eid}">
<%-- 				        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
	<%-- 			        <input type="hidden" name="whichPage"	value="\\<%=whichPage%>">               <!--送出當前是第幾頁給Controller--> --%>
				  </s:form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



</html>
