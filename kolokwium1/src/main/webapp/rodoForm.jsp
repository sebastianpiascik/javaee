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
        <h2>Form:</h2>
                <form method="post" action="index.jsp">
                <label for="rodo">Rodo</label>
                <input type="checkbox" id="rodo" name="rodo" checked><br/>
                <label for="other">Inne</label>
                <input type="checkbox" id="other" name="other"><br/><br/>
                <span>
                <% if(session.getAttribute( "rodo" ) == null){ %>
                        <%-- <%= session.getAttribute( "rodo" ) %> --%>
                        Zaakceptuj RODO aby przejść dalej
                        </span><br/>
                 <% } %>
                <button type="submit">Akceptuj</button>
                </form>
    </body>
</html>
