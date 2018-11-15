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
<ul>
    <%
        for (Newsletter n : newslettersList.getNewsletters()) {
            String subject1 = "";
            String subject2 = "";
            if (n.isSubject1())
                subject1 = " - temat 1";
            if (n.isSubject2())
                subject2 = " - temat 2";
    %>
    <li>
        <%
            out.println("Newsletter:" + n.getName() + subject1 + subject2 + "<br/>Data od: " + n.getDateFrom() + "<br/>" +
                    "Data do: " + n.getDateTo() + "");
        %>
    </li>
    <form action='removeNewsletter.jsp' method='post'>
        <input type='hidden' name='formName' value='addToBasket'/>
        <input type='text' name='id' value='<% out.print(n.getId()); %>' hidden/>
        <button type='submit'>Usuń newsletter</button>
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
