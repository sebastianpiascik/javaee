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

<jsp:useBean id="newslettersList" class="pl.spiascik.ug.store.service.NewsletterService" scope="session" />

<%
//    newslettersList.removeNewsletter(Integer.parseInt(request.getParameter("id")));
    newslettersList.removeNewsletter(Integer.parseInt(request.getParameter("id")));
%>

<p>Usunięto newsletter</p>
<p><a href='allnewsletters.jsp'>Zobacz listę newsletterów</a></p>
</p>
</body>
</html>