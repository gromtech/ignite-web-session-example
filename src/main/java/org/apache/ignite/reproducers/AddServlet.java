package org.apache.ignite.reproducers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        HttpSession session = request.getSession(true);

        String[] uri = request.getRequestURI().split("/");

        if (uri.length > 3) {
            session.setAttribute(uri[2], uri[3]);

            response.getWriter().printf("<div>Added attribute [key=%s, value=%s]</div>\n", uri[2], uri[3]);
        }
        else
            response.getWriter().println("<div>Unable to set attribute. Please try /add/1/one</div>");
    }
}