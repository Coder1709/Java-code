package com.nucleus.controller.p1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String emailId = "admin@gmail.com";
    private final String password = "P@ssword";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method called");

        String email = req.getParameter("email");
        String userpassword = req.getParameter("password");
        System.out.println(email);
        System.out.println(password);

        if(emailId.equalsIgnoreCase(email) && password.equalsIgnoreCase(userpassword)){
            HttpSession session = req.getSession();
            session.setAttribute("user", "Arpit");


            Cookie userName = new Cookie("user", email);
            userName.setMaxAge(30*60);
            resp.addCookie(userName);
            resp.sendRedirect("servletHandler");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out= resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }





    }
}
