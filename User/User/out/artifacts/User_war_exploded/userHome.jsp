<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>用户主页</title>
</head>
<body>

<h2>用户主页</h2>

<p>欢迎你：<%= user.getName() %></p>
<p>手机号：<%= user.getPhone() %></p>
<p>性别：<%= user.getGender() %></p>

<a href="updateUser.jsp">修改个人信息</a>

<p style="color:red">${msg}</p>

</body>
</html>