<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shop application - Add product</title>

    <style>
        * { font-family: cursive; color: #454545; }
        body { margin: 20px 2em; }
    </style>
</head>
<body>

    <h2>Formularz dodawania czekolad</h2>
    <form action="addProduct.jsp" method='post'>
        <fieldset>
            <label for='name'>Nazwa: </label>
            <input type='text' id="name" name='name' /><br/><br/>
            <label for='productionDate'>Data produkcji: </label>
            <input type='date' id="productionDate" name='productionDate'/><br/><br/>
            <label for='price'>Cena: </label>
            <input type='text' id="price" name='price' /><br/><br/>
            <label for="isWhite">Biała: </label>
            <input type='checkbox' id="isWhite" name="isWhite" /><br/><br/>
            <button type='submit'>Dodaj produkt</button>
        </fieldset>
    </form>

</body>
</html>