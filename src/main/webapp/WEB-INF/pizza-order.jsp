<%--
  Created by IntelliJ IDEA.
  User: kjorgeron0819
  Date: 7/15/22
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pizza Form</title>
</head>
<body>
<form action="pizza-order" method="post">
    <h1>ORDER YOUR PIZZA TODAY!</h1>
    <h3>Pizza Crust</h3>
    <label for="tossed">Hand Tossed</label>
    <input type="radio" name="tossed" id="tossed" value="hand-tossed">
    <br>
    <label for="thin">Thin Crust</label>
    <input type="radio" name="thin" id="thin" value="thin">
    <br>
    <h3>Pizza Sauce</h3>
    <label for="marinara">Marinara</label>
    <input type="radio" name="marinara" id="marinara" value="marinara">
    <br>
    <label for="pesto">Pesto</label>
    <input  name="pesto" id="pesto" type="radio" value="pesto">
    <br>
    <h3>Pizza Size</h3>
    <label for="12">12"</label>
    <input type="radio" name="12" id="12" value='12"'>
    <br>
    <label for="14">14"</label>
    <input type="radio" name="14" id="14" value='14"'>
    <br>
    <h3>Pizza Toppings</h3>
    <label for="extra-cheese">Extra Cheese</label>
    <input type="checkbox" name="extra-cheese" id="extra-cheese" value="extra-cheese">
    <br>
    <label for="peperoni">Peperoni</label>
    <input type="checkbox" name="peperoni" id="peperoni" value="peperoni">
    <br>
    <label for="pineapple">Pineapple</label>
    <input type="checkbox" name="pineapple" id="pineapple" value="pineapple">
    <br>
    <h3>Enter Your Address Below!</h3>
    <label for="address">Address:</label>
    <input type="text" name="address" id="address" value="${address}">
    <br>
    <button type="submit">Submit</button>
</form>
<% System.out.println();%>
</body>
</html>
