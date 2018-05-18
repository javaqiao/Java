<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.qrsx.entity.JspUser" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./cs/userlist.css" />
<title>用户列表</title>
</head>
<body>
<!--header -->
<div class="header">
<h4>在线人数:</h4>
<h1><%=request.getSession().getAttribute("onlineUser")%></h1>


</div>
<!--left -->
<div class="left"></div>
<!--content -->
<div class="content">
<!--放置数据列表  -->
<table  class="gridtable">
<tr>
	<th>ID</th>
	<th>用户名</th>
	<th>密码</th>
	<th>性别</th>
	<th>身份证</th>
	<th>年龄</th>
</tr>

<!--循环读取数据  -->
 <%
List<JspUser> userlist=new ArrayList<JspUser>();
userlist=(List<JspUser>)request.getAttribute("userlist");
for(JspUser user:userlist)
{
%>
<tr>
<td><%=user.getId()%></td>
<td><%=user.getName()%></td>
<td><%=user.getPwd()%></td>
<td><%=user.getSex()%></td>
<td><%=user.getIdentity()%></td>
<td><%=user.getAge()%></td>
</tr>
<%
}
%> 

<div></div>

<!--JSTL读取数据 -->
<c:forEach var="user2"  items="${userlist}">
<tr>
<td>${user2.id}</td>
</tr>
</c:forEach>


</table>

</div>
<!--footer -->
<div class="footer"></div>
</body>
</html>