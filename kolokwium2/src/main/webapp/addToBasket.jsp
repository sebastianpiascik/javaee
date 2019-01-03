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

<jsp:useBean id="basket" class="pl.spiascik.ug.store.service.ShopService" scope="session" />

<%
    basket.addToBasket(Integer.parseInt(request.getParameter("id")));
%>

<p>Dodano produkt do koszyka</p>
<p>
    <a href="index.jsp">Wróć na stronę sklepu</a>
</p>
</body>
</html>