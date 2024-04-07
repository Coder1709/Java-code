package com.nucleus.controller.p4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/display")
public class DisplayCookiesServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Display Cookies</title>");
        out.println("</head>");
        out.println("<body>");

        // Get the cookies from the request
        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length > 0) {
            out.println("<h2>All Cookies:</h2>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Name</th><th>Value</th></tr>");

            for (Cookie cookie : cookies) {
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No Cookie</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
