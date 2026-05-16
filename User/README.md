# Servlet 用户管理系统（MVC模式）使用手册

## 1. 项目概述

本项目基于 Java Servlet、JSP、JDBC 和 MySQL 开发，采用 MVC 模式实现用户管理系统。支持普通用户注册、登录、修改资料，以及管理员查看和删除用户。

## 2. 功能模块

### 普通用户

- 注册（手机号唯一）
- 登录（手机号+密码）
- 修改姓名/密码/性别
- 退出登录

### 管理员

- 登录后台
- 查看所有用户
- 删除普通用户
- 退出登录

## 3. 技术架构

- Model: User.java
- View: JSP 页面
- Controller: Servlet
- DAO: UserDao 数据访问
- DB: MySQL

## 4. 环境要求

- JDK 8+
- Tomcat 9+
- MySQL 8+
- IDEA/Eclipse
- mysql-connector-j 驱动

## 5. 数据库配置

创建数据库：

```sql
CREATE DATABASE user_manage DEFAULT CHARACTER SET utf8mb4;
USE user_manage;
CREATE TABLE user (
 id INT PRIMARY KEY AUTO_INCREMENT,
 phone VARCHAR(20) UNIQUE NOT NULL,
 name VARCHAR(50),
 password VARCHAR(50),
 gender VARCHAR(10),
 role VARCHAR(20)
);
INSERT INTO user(phone,name,password,gender,role)
VALUES('admin','管理员','123456','男','admin');
```

## 6. 项目部署

1. 导入项目到 IDE
2. 配置 Tomcat
3. 导入数据库
4. 将 mysql 驱动放到 WEB-INF/lib
5. 修改 DBUtil.java 数据库账号密码
6. 启动 Tomcat
7. 打开 /login.jsp

## 7. 页面说明

- login.jsp 登录页
- register.jsp 注册页
- userHome.jsp 用户主页
- updateUser.jsp 修改资料
- adminHome.jsp 管理后台
- userList.jsp 用户列表

## 8. 项目结构

```text
src/com/example/
 model/
 dao/
 servlet/
 util/
WebContent/
 *.jsp
```

## 9. 常见问题

- 无法连接数据库：检查 DBUtil 和 jar 包
- 管理员登录失败：检查 role 字段读取
- 中文乱码：设置 UTF-8
- 页面404：检查 servlet 映射

## 10. 可扩展方向

- Filter 登录拦截
- 密码加密
- 分页查询
- 搜索用户
- Bootstrap 美化
- 文件上传

## 11. 总结

项目实现 MVC 分层、数据库持久化、权限控制，适合作为 Java Web 课程设计示例。
