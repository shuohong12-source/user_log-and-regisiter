<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<h2>用户登录</h2>

<form action="login" method="post">
    手机号：<input type="text" name="phone"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

<a href="register.jsp">没有账号？去注册</a>

<p style="color:red">${msg}</p>

</body>
</html>