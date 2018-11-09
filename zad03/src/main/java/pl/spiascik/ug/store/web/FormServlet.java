package pl.spiascik.ug.store.web;

import pl.spiascik.ug.store.domain.Cloth;
import pl.spiascik.ug.store.service.ClothService;
import pl.spiascik.ug.store.service.ShopService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price").replace(",","."));

        java.sql.Date productionDate=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(request.getParameter("productionDate") != null && !request.getParameter("productionDate").equals("")){
            try {
                Date pDate = simpleDateFormat.parse(request.getParameter("productionDate"));
                productionDate = new java.sql.Date(pDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        boolean isWaterproof = false;
        if (request.getParameter("isWaterproof") != null)
            isWaterproof = true;


        Cloth newCloth = new Cloth(name,productionDate,price,isWaterproof);

        ClothService clothes = (ClothService) getServletContext().getAttribute("products");
        clothes.addCloth(newCloth);
        getServletContext().setAttribute("products",clothes);

        Cloth newClothContent = clothes.getCloth(ClothService.clothes.size()-1);

        try {
            out.println("<!DOCTYPE html><html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style></head><body>");
            out.println("<h3>Dodano produkt - " + newClothContent.getName() + "</h3><br/>");
            out.println("<p><a href='/zad03/'>Wróć na stronę główną</a></p>");
            out.println("<p><a href='/zad03/form'>Dodaj następny produkt</a></p>");
            out.println("</body></html>");
        } finally {
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<!DOCTYPE html><html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<style>*{font-family:cursive;color:#454545;}body{margin:20px 2em;}</style></head>");
            out.println("<body><h1>Formularz</h1>");
            out.println("<form action='form' method='post'>" +
                    "<fieldset><label for='name'>Nazwa: </label><input type='text' name='name' /><br/><br/>" +
                    "<label for='productionDate'>Data produkcji: </label><input type='date' name='productionDate' /><br/><br/>" +
                    "<label for='price'>Cena: </label><input type='text' name='price' /><br/><br/>" +
                    "<label for='isWaterproof'>Wodoodporność: </label><input type='checkbox' name='isWaterproof' /><br/><br/>" +
                    "<button type='submit'>Dodaj produkt</button></fieldset>" +
                    "</form>");
            out.println("<p><a href='/zad03/'>Wróc do sklepu</a></p></body></html>");
        } finally {
            out.close();
        }
    }
}

