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
  <title>修改个人信息</title>
</head>
<body>

<h2>修改个人信息</h2>

<form action="updateUser" method="post">
  手机号：<input type="text" value="<%= user.getPhone() %>" readonly><br>
  姓名：<input type="text" name="name" value="<%= user.getName() %>"><br>
  密码：<input type="text" name="password" value="<%= user.getPassword() %>"><br>
  性别：
  <input type="radio" name="gender" value="男" <%= "男".equals(user.getGender()) ? "checked" : "" %>>男
  <input type="radio" name="gender" value="女" <%= "女".equals(user.getGender()) ? "checked" : "" %>>女
  <br>
  <input type="submit" value="修改">
</form>

</body>
</html>