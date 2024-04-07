package com.nucleus.controller.p1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletHandler")

public class ServletHandler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method called");
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        String user = (String) session.getAttribute("user");
        PrintWriter out = resp.getWriter();
        out.println("Welcome " + user + " to the servlet handler<br>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Creation Time: " + session.getCreationTime() + "<br>");
        out.println("Last Accessed Time: " + session.getLastAccessedTime()  + "<br>");
        out.println("Max Inactive Interval: " + session.getMaxInactiveInterval() + "<br>");
        out.println("Is New: " + session.isNew() + "<br>");
        out.println("Session Timeout: " + session.getMaxInactiveInterval() + "<br>");
        out.println("Redirecting to google in 10 seconds" + "<br>");
        resp.setHeader("Refresh", "10; URL=http://www.google.com" );

    }
}
