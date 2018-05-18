<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String msg = (String)request.getAttribute("msg");
	if(msg == null){
		msg = "";
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<script type="text/javascript">
		function checkUser(){
			var userNo = document.getElementById("username").value;
			var vcode = document.getElementById("vcode").value;
			document.forms[0].submit();
		}
	</script> 
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
    <table align="center" class="login" cellspacing="1px" cellpadding="1px"  >
    		<tr> 
    			<td class="loginText">用户名</td>
    			<td><input type="text" id="username" name="username"/></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" id="pwd" name = "password"/></td>
    		</tr>   
    		<tr>
    			<td>角色</td>   
    			<td>
	    			<select id="role" name = "role">  
					  <option value ="1">系统管理员</option>  
					  <option value ="2">普通用户</option>  
					  <option value="3">国家主席</option>  
					  <option value="4">省委书记</option>  
					</select> 
				</td> 		
    			 
    		</tr>  
    		<tr>
    			<td>验证码：</td>
    			<td>
    				<input type="text" id="vcode" name = "vcode" size="8"/>
    				<img src="ValidateCodeServlet" title="看不清，点击换一张试试" onClick="this.src=this.src+'?'" >
    			</td>
    		</tr>                        
    		<tr>
    			<td colspan="2">
    				<a href="javascript:checkUser();" >
    					<img alt="" src="${pageContext.request.contextPath}/images/login_btn.jpg" align="right" width="80px;">
    				</a>
    			</td>
    			
    		</tr>
    		<tr>
    			<td colspan="2"><font color="red"><%=msg  %></font></td>
    		</tr>
    
    
    	
		
    	</table>
    	</form> 
    
</body>
</html>