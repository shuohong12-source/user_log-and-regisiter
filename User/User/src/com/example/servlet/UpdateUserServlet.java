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

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User oldUser = (User) session.getAttribute("user");

        if (oldUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        oldUser.setName(name);
        oldUser.setPassword(password);
        oldUser.setGender(gender);

        boolean flag = userDao.updateUser(oldUser);

        if (flag) {
            session.setAttribute("user", oldUser);
            request.setAttribute("msg", "修改成功");
        } else {
            request.setAttribute("msg", "修改失败");
        }

        request.getRequestDispatcher("userHome.jsp").forward(request, response);
    }
}