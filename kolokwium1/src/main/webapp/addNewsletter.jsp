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

<%

    String name = request.getParameter("name");
    String dateFrom = request.getParameter("dateFrom");
    String dateTo = request.getParameter("dateTo");
    String frequency = request.getParameter("freq");
    boolean subject1 = false;
    boolean subject2 = false;

    if (request.getParameter("subject1") != null)
        subject1 = true;
    if (request.getParameter("subject2") != null)
        subject2 = true;



    Newsletter n = new Newsletter(name,dateFrom,dateTo,frequency,subject1,subject2);
    newslettersList.addNewNewsletters(n);
%>
<p>Dodano newsletter:  <% out.print(n.getName()); %></p>
</body>
</html>
