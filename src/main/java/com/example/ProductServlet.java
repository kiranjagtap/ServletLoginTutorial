package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {


    public void init(ServletConfig config) throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> mensProductsList = new ArrayList<>();
        mensProductsList.add("Shirts");
        mensProductsList.add("Jeans");
        mensProductsList.add("T-Shirts");
        mensProductsList.add("Regular Shirts");

        String user = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            user = cookie.getValue();
        }

        request.setAttribute("username", user);
        request.setAttribute("mensProductList", mensProductsList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
        requestDispatcher.forward(request,response);

    }

}
