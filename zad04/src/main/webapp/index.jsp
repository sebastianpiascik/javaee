<%@ page import="pl.spiascik.ug.store.service.ShopService" %>
<%@ page import="pl.spiascik.ug.store.domain.Cloth" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

    <% if(session.getAttribute( "rodo" ) == null){ %>
        <% String rodoCheck = request.getParameter("rodo"); %>
        <% if (rodoCheck == null) { %>
            <jsp:forward page="rodoForm.jsp"/>
        <% } else{
            session.setAttribute("rodo",true);
        } %>
    <% } %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shop application</title>
    <style>
        * { font-family: cursive; color: #454545; }
        body { margin: 20px 2em; }
    </style>
</head>
<body>

    <jsp:useBean id="basket" class="pl.spiascik.ug.store.service.ShopService" scope="session" />
    <jsp:useBean id="clothes" class="pl.spiascik.ug.store.service.ClothService" scope="application" />


    <h2>Sklep z ubraniami</h2>

    <%
        if (clothes.getAllClothes().size() > 0) {
    %>


        <h3>Wszystkie produkty:</h3>
        <ul>
            <%
                for (Cloth c : clothes.getAllClothes()) {
                    String waterproof = "";
                    if (c.isWaterproof())
                        waterproof = " - wodoodporność";
            %>

            <li>
                <%
                    out.println("Produkt:" + c.getName() + waterproof + "<br/>Cena: " + c.getPrice() + "zł<br/>" +
                            "Data dodania: <i>" + c.getProductionDate() + "</i>");
                %>
            </li>
            <form action='addToBasket.jsp' method='post'>
                <input type='hidden' name='formName' value='addToBasket'/>
                <input type='text' name='id' value='<% out.print(c.getId()); %>' hidden/>
                <button type='submit'>Dodaj do koszyka</button>
                <br/><br/>
            </form>
            <% } %>
        </ul>
    <% }
        else{
            out.println("<p>Brak produktów w sklepie</p>");
        }
    %>

    <p><a href='addProductForm.jsp'>Dodaj produkt</a></p>

    <% if (basket.getBasket().size() > 0) { %>
        <h3>Produkty w koszyku:</h3>
        <ul>
            <%
                for (Cloth c : basket.getBasket()) {
                    String waterproof = "";
                    if (c.isWaterproof())
                        waterproof = " - wodoodporność";
            %>
            <li>
                <%
                    out.println("Produkt:" + c.getName() + waterproof + "<br/>Cena: " + c.getPrice() + "zł<br/>" +
                            "Data dodania: <i>" + c.getProductionDate() + "</i>");
                %>
            </li>
            <form action='removeFromBasket.jsp' method='post'>
                <input type='hidden' name='formName' value='addToBasket'/>
                <input type='text' name='id' value='<% out.print(c.getId()); %>' hidden/>
                <button type='submit'>Usuń z koszyka</button>
                <br/><br/>
            </form>
            <% } %>
        </ul>
    <% }
        else {
            out.println("<p>Brak produktów w koszyku</p>");
        }
    %>


</body>
</html>
