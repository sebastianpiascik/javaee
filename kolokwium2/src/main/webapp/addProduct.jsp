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
    <%--<jsp:useBean id="cloth" class="pl.spiascik.ug.store.domain.Chocolate" scope="session" />--%>

    <%--<jsp:setProperty name="cloth" property="*" />--%>

    <jsp:useBean id="chocolates" class="pl.spiascik.ug.store.service.ChocolateService" scope="application" />

    <%

        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price").replace(",","."));
        String productionDate = request.getParameter("productionDate");

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

        boolean isWhite = false;
        if (request.getParameter("isWhite") != null)
            isWhite = true;

        Chocolate newCloth = new Chocolate(name,productionDate,price,isWhite);

        chocolates.addChocolate(newCloth);
    %>

    <p>Dodano: <% out.print(newCloth.getName()); %> </p>
    <p>
        <a href="index.jsp">Wróć na stronę sklepu</a>
    </p>
</body>
</html>