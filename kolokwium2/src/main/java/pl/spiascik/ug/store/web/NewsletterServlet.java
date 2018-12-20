package pl.spiascik.ug.store.web;

import pl.spiascik.ug.store.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addNewsletter")
public class NewsletterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        ShopService basket;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("formName").equals("addToBasket")) {

            if (!session.isNew()) {
                basket = (ShopService) session.getAttribute("basket");
                basket.addToBasket(Integer.parseInt(request.getParameter("id")));
                session.setAttribute("basket", basket);
            }

            try {
                out.println("<!DOCTYPE html><html><head>");
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style></head><body>");
                out.println("<h3>Dodano produkt do koszyka</h3><br/>");
                out.println("<p><a href='/zad03/'>Wróć na stronę główną</a></p>");
                out.println("</body></html>");
            } finally {
                out.close();
            }
        }

        if (request.getParameter("formName").equals("removeFromBasket")) {

            if (!session.isNew()) {
                basket = (ShopService) session.getAttribute("basket");
                basket.removeFromBasket(Integer.parseInt(request.getParameter("id")));
                session.setAttribute("basket", basket);
            }

            try {
                out.println("<!DOCTYPE html><html><head>");
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style></head><body>");
                out.println("<h3>Usunięto produkt z koszyka</h3><br/>");
                out.println("<p><a href='/zad03/'>Wróć na stronę główną</a></p>");
                out.println("</body></html>");
            } finally {
                out.close();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(true);

        ShopService basket = new ShopService();

        if (!session.isNew()) {
            basket = (ShopService) session.getAttribute("basket");
        }
        session.setAttribute("basket", basket);

    }
}
