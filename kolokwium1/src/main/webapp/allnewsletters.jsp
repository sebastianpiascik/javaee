<%@ page import="pl.spiascik.ug.store.domain.Newsletter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rodo form</title>
    <style>
        * { font-family: cursive; color: #454545; }
        body { margin: 20px 2em; }
        span {color:red}
    </style>
</head>
<body>

<jsp:useBean id="newslettersList" class="pl.spiascik.ug.store.service.NewsletterService" scope="session" />

<h2>Wszystkie newslettery:</h2>


<% if (newslettersList.getNewsletters().size() > 0) { %>
<h3>Produkty w koszyku:</h3>
<ul>
    <%
        for (Newsletter n : newslettersList.getNewsletters()) {
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
    out.println("<p>Brak newsletterów</p>");
}
%>

</body>
</html>
