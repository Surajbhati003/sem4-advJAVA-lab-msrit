<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>T-Shirt (Q6) Program</title>
</head>
<body>
<%--A generally more reliable method of passing information to a backend program is the POST method.
This method packages the information in exactly the same way as the GET method, but instead of sending it as a text string after a ? in the URL it sends it as a separate message. --%>
<form action="tdetails" method="post">
T-Shirt Accessories<input type="checkbox" name="access" value="Belt"/>Belt
<input type="checkbox" name="access" value="Cap"/>Cap
<input type="checkbox" name="access" value="Hair-Band"/>HairBand<br>
Tag-Line<input type="text" name="tagline" size="50"/><br>
T-Shirt Feature:<input type="radio" name="pocket" value="ChestPocket"/>ChestPocket
<input type="radio" name="pocket" value="NoChestPocket"/>No Chest Pocket<br>
T-Shirt Color:<select name="Tshirtcolor">
<option>Blue</option>
<option>Red</option>
<option>Green</option>
</select><br>
<input type="submit" value="Place Orders"/>
</form>
</body>
</html>