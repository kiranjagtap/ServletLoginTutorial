package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("user");
        Cookie cookie1 = new Cookie("username", username);

        if (null != username) {
            request.setAttribute("username", username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("category.jsp");
            response.addCookie(cookie1);
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid User, please login again");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }


    }


}
