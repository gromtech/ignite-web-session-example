package org.apache.ignite.reproducers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        HttpSession session = request.getSession(true);

        String[] uri = request.getRequestURI().split("/");

        if (uri.length > 2) {
            session.removeAttribute(uri[2]);

            response.getWriter().printf("<div>Removed attribute: %s</div>\n", uri[2]);
        }
        else
            response.getWriter().println("<div>Unable to set attribute. Please try /remove/1</div>");
    }
}