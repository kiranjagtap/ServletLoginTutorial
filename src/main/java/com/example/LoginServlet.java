package com.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private ServletConfig config;
    private String jdbcUrl = null;
    private String dbDriver = null;
    private String adminPath = null;
    private ServletContext servletContext= null;

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet config initialized");
        this.config = config;
        this.init();
    }

    public void init() throws ServletException {
        System.out.println("Init called");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post method called");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        jdbcUrl = config.getInitParameter("jdbc-url");
        dbDriver = config.getInitParameter("dbdriver");

        System.out.println("Init Param::JDBC URL  -"+jdbcUrl);
        System.out.println("Init Param::JDBC Driver  -"+dbDriver);


        servletContext = request.getServletContext();
        adminPath = servletContext.getInitParameter("adminPath");

        System.out.println("CONTEXT Param::adminPath  -"+adminPath);


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
