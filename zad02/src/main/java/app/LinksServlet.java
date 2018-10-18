package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/menu")
public class LinksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(httpServletRequest, httpServletResponse);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>" +
                "<h4>Links</h4>" +
                "<p><a href='about'>About</a></p>" +
                "<p><a href='date'>Date</a></p>" +
                "</body></html>");

    }
}
