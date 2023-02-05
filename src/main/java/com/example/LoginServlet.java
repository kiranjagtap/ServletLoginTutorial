package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username!=null && username.equals("dummy")){
            if(password!=null && password.equals("dummy")){
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                out.println("Welcome "+username +" to dfirst Servlet login Tutorial");
                out.println("</body>");
                out.println("</html>");

            }
            else{
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
                out.println("<b> Invalid credentials, Please try again</b>");
                out.println("</body>");
                out.println("</html>");

            }
        }

    }
}
