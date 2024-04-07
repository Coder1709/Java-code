package com.nucleus.controller.p3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/keepmesignin")
public class CookieHandler extends HttpServlet {
    private HashMap<String, String> userCredentials;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the HashMap and store some sample user credentials
        userCredentials = new HashMap<>();
        userCredentials.put("user1@example.com", "password1");
        userCredentials.put("user2@example.com", "password2");
        // Add more users as needed
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean keepMeSignedIn = "on".equals(req.getParameter("keepMeSignedIn"));


        // Check if the user is already authenticated via cookie
        Cookie[] cookies = req.getCookies();
        boolean authenticated = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("email") && email.equalsIgnoreCase(cookie.getValue()) && cookie.getName().equalsIgnoreCase("password") && password.equalsIgnoreCase(cookie.getValue())) {
                    authenticated = true;
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        // If not authenticated via cookie, proceed with username/password authentication
        if (authenticated || (email.equals(email) && password.equals(password))) {
            HttpSession session = req.getSession();
            session.setAttribute("username", email);

            // If "Keep me signed in" option is checked, create a new cookie with extended expiration time
            if (keepMeSignedIn) {
                // Delete the existing password cookie (if any)
                Cookie[] existingCookies = req.getCookies();
                if (existingCookies != null) {
                    for (Cookie existingCookie : existingCookies) {
                        if (existingCookie.getName().equals("password")) {
                            existingCookie.setMaxAge(0);
                            resp.addCookie(existingCookie);
                            break;
                        }
                    }
                }





                    if (keepMeSignedIn) {
                        // Create a cookie with the user's email
                        Cookie emailCookie = new Cookie("email", email);
                        Cookie passwordCookie = new Cookie("password", password);
                        emailCookie.setMaxAge(30 * 24 * 60);
                        passwordCookie.setMaxAge(30 * 24 * 60);
                        resp.addCookie(emailCookie);
                        resp.addCookie(passwordCookie);
                    }

                    resp.sendRedirect("home.html"); // Redirect to the home page
                } else {
                    resp.sendRedirect("login.jsp?error=1"); // Redirect to the login page with an error parameter
                }
            }



        }
    }



