<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.User" %>

<%
  List<User> list = (List<User>) request.getAttribute("list");
%>

<html>
<head>
  <title>用户列表</title>
</head>
<body>

<h2>所有用户信息</h2>

<table border="1" cellspacing="0" cellpadding="8">
  <tr>
    <th>ID</th>
    <th>手机号</th>
    <th>姓名</th>
    <th>密码</th>
    <th>性别</th>
    <th>操作</th>
  </tr>

  <%
    for (User user : list) {
  %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getPhone() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getPassword() %></td>
    <td><%= user.getGender() %></td>
    <td>
      <a href="deleteUser?id=<%= user.getId() %>" onclick="return confirm('确定删除该用户吗？')">删除</a>
    </td>
  </tr>
  <%
    }
  %>
</table>

<a href="adminHome.jsp">返回管理员主页</a>

</body>
</html>