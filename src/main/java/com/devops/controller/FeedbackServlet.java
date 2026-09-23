package com.devops.controller;

import com.devops.service.FeedbackValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");

        response.setContentType("text/html;charset=UTF-8");
        if (!FeedbackValidator.isValid(name, email, feedback)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("<h2>Invalid feedback</h2><a href='index.html'>Go back</a>");
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<html><body style='font-family:Arial;padding:40px'>");
        response.getWriter().println("<h1>Thank you, " + escapeHtml(name) + "!</h1>");
        response.getWriter().println("<p>Your feedback was submitted successfully.</p>");
        response.getWriter().println("<a href='index.html'>Back to Home</a>");
        response.getWriter().println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value == null ? "" : value.replace("&", "&amp;")
                .replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
