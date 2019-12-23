<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/19/2019
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Convert from ${dollar} to VND</h1>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td> USD </td>
                <td><label>
                    <input type="text" name="usd">
                </label></td>
            </tr>
        </table>
        <input type="submit" value="Convert">
    </fieldset>
</form>
<h1> Result: ${usd} USD = ${vnd} VND</h1>
</body>
</html>
