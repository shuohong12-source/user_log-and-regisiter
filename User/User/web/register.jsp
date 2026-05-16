<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<h2>用户注册</h2>

<form action="register" method="post">
    手机号：<input type="text" name="phone"><br>
    姓名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>
    性别：
    <input type="radio" name="gender" value="男">男
    <input type="radio" name="gender" value="女">女
    <br>
    <input type="submit" value="注册">
</form>

<a href="login.jsp">已有账号？去登录</a>

<p style="color:red">${msg}</p>

</body>
</html>