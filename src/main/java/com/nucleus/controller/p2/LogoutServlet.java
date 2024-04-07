package com.nucleus.controller.p2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method called");


        //invalidate the session
        HttpSession session = req.getSession(false);
        System.out.println("User =" + session.getAttribute("email"));
        if(session != null){
            //if session exit invalidate it
            session.invalidate();
        }
        resp.sendRedirect("question2.html");
    }
}
