package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sayHello")
public class HelloServlet extends HttpServlet {
    // date - aktualna data
    //about = tresc html o mnie
    // linki do stron

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(httpServletRequest, httpServletResponse);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body><h4>Hello World!</h4></body></html>");

    }
}
