package com.nucleus.controller.p2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/middleman")
public class MiddleMan extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Middle man Service got called");
        resp.setContentType("text/html");

       //allowing access if there ia a valid session
       if(req.getSession() != null){
           resp.getWriter().println("Valid User");
           resp.getWriter().println("<h3> Hi do the Checkout </h3> <br>");
           resp.getWriter().println("<form action=\"LogoutServlet\" method=\"post\">\n" + "<br> " +"<input type=\"submit\" value=\"Logout\" >" + "</form>");

       }

       if(req.getSession() ==null){
           System.out.println("no Active session in middle Man");
           resp.sendRedirect("question2.html");
       }
    }
}
