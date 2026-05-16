package com.example.servlet;

import com.example.dao.UserDao;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao=new UserDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        User user = userDao.login(phone, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("admin".equals(user.getRole())) {
                response.sendRedirect("adminHome.jsp");
            } else {
                response.sendRedirect("userHome.jsp");
            }

        } else {
            request.setAttribute("msg", "手机号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }
}
