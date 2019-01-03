<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="pl.spiascik.ug.store.domain.Chocolate" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

    <jsp:useBean id="chocolates" class="pl.spiascik.ug.store.service.ChocolateService" scope="application" />

    <%

        int id = chocolates.getAllChocolates().size();
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price").replace(",","."));
        String productionDate = request.getParameter("productionDate");
        boolean isWhite = false;
        if (request.getParameter("isWhite") != null)
            isWhite = true;
        boolean isBlack = false;
        if (request.getParameter("isBlack") != null)
            isBlack = true;

        Chocolate newCloth = new Chocolate(id,name,productionDate,price,isWhite,isBlack);

        chocolates.addChocolate(newCloth);
    %>

    <p>Dodano: <% out.print(newCloth.getName()); %> </p>
    <p>
        <a href="index.jsp">Wróć na stronę sklepu</a>
    </p>
</body>
</html>