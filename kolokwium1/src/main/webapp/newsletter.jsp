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
    <label for="name">Imie</label>
    <input type="text" id="name" name="name"><br/>
    <label for="date_from">Data od</label>
    <input type="text" id="date_from" name="date_from"><br/>
    <label for="date_from">Data do</label>
    <input type="text" id="date_to" name="date_to"><br/>
    <p>Częstotliwość</p>
    <input type="radio" name="freq" value="codziennie" checked>Codziennie<br/>
    <input type="radio" name="freq" value="tygodniowo">Tygodniowo<br/>
    <input type="radio" name="freq" value="miesięcznie">Miesięcznie<br/><br/>
    <label for="subject1">Temat1</label>
    <input type="checkbox" id="subject1" name="subject1"><br/><br/>
    <label for="subject2">Temat2</label>
    <input type="checkbox" id="subject2" name="subject2"><br/><br/>
    <button type="submit">Akceptuj</button>
</form>
</body>
</html>
