package com.example.servlet;

import com.example.dao.UserDao;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        if (userDao.isPhoneExist(phone)) {
            request.setAttribute("msg", "该手机号已被注册");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setPhone(phone);
        user.setName(name);
        user.setPassword(password);
        user.setGender(gender);

        boolean flag = userDao.register(user);

        if (flag) {
            request.setAttribute("msg", "注册成功，请登录");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "注册失败");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}