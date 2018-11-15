<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="pl.spiascik.ug.store.domain.Cloth" %>
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
    <%--<jsp:useBean id="cloth" class="pl.spiascik.ug.store.domain.Cloth" scope="session" />--%>

    <%--<jsp:setProperty name="cloth" property="*" />--%>

    <jsp:useBean id="clothes" class="pl.spiascik.ug.store.service.ClothService" scope="application" />

    <%

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

        clothes.addCloth(newCloth);
    %>

    <p>Dodano: <% out.print(newCloth.getName()); %> </p>
    <p>
        <a href="index.jsp">Wróć na stronę sklepu</a>
    </p>
</body>
</html>