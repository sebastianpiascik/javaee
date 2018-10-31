package pl.spiascik.ug.store.web;

import pl.spiascik.ug.store.domain.Cloth;
import pl.spiascik.ug.store.service.ClothService;
import pl.spiascik.ug.store.service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(request.getParameter("formName").equals("addToBasket")){
            ShopService.addToBasket(Integer.parseInt(request.getParameter("id")));

            try {
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style>");
                out.println("<body>");
                out.println("<h3>Dodano produkt do koszyka</h3>");
                out.println("<br/>");
                out.println("<p><a href='/zad03/'>Wróć na stronę główną</a></p>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }

        if(request.getParameter("formName").equals("removeFromBasket")){
            ShopService.removeFromBasket(Integer.parseInt(request.getParameter("id")));

            try {
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style>");
                out.println("<body>");
                out.println("<h3>Usunięto produkt z koszyka</h3>");
                out.println("<br/>");
                out.println("<p><a href='/zad03/'>Wróć na stronę główną</a></p>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style>");
            out.println("<body>");
            out.println("<h2>Sklep z ubraniami</h2><hr/>");
            if (ClothService.getAllClothes().size() > 0) {
                out.println("<h3>Wszystkie produkty:</h3>");
                out.println("<ul>");
                for (Cloth cloth : ClothService.getAllClothes()) {
                    String waterproof = "";
                    if (cloth.isWaterproof())
                        waterproof = " - wodoodporność";
                    out.println("<li>Produkt: " + cloth.getName() + waterproof +
                            "<br/>Cena: " + cloth.getPrice() + "zł" +
                            "<br/>Data dodania: <i>" + cloth.getProductionDate() + "</i></li>");
                    out.println("<form action='' method='post'>" +
                            "<input type='hidden' name='formName' value='addToBasket' />" +
                            "<input type='text' name='id' value='"+ cloth.getId() +"' hidden />" +
                            "<button type='submit'>Dodaj do koszyka</button><br/><br/>" +
                            "</form>");
                }
                out.println("</ul>");
            } else{
                out.println("<p>Brak produktów w sklepie</p>");
            }
            out.println("<p><a href='/zad03/form'>Dodaj produkt</a></p>");
            if (ClothService.getAllClothes().size() > 0) {
                out.println("<h3>Produkty w koszyku:</h3>");
                out.println("<ul>");
                for (Cloth cloth : ShopService.getBasket()) {
                    String waterproof = "";
                    if (cloth.isWaterproof())
                        waterproof = " - wodoodporność";
                    out.println("<li>Produkt: " + cloth.getName() + waterproof +
                            "<br/>Cena: " + cloth.getPrice() + "zł" +
                            "<br/>Data dodania: <i>" + cloth.getProductionDate() + "</i></li>");
                    out.println("<form action='' method='post'>" +
                            "<input type='hidden' name='formName' value='removeFromBasket' />" +
                            "<input type='text' name='id' value='"+ cloth.getId() +"' hidden />" +
                            "<button type='submit'>Usuń z koszyka</button><br/><br/>" +
                            "</form>");
                }
                out.println("</ul>");
            } else{
                out.println("<p>Brak produktów w koszyku</p>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    public void init() throws ServletException {

        getServletContext().setAttribute("shop_storage", new ShopService());


    }
}
