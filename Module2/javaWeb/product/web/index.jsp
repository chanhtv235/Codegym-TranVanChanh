<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/16/2019
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/calculate">
    <h2>Product Discount Calculator</h2>
    <table>
      <tr>
        <td>
          Product Description:
        </td>
        <td>
          <input type="text" id="product" name="product">
        </td>
      </tr>
      <tr>
        <td>
          List Price:
        </td>
        <td>
          <input type="text" id="price" name="price">
        </td>
      </tr>
      <tr>
        <td>
          Discount Percent::
        </td>
        <td>
          <input type="text" id="discout" name="discout">
        </td>
      </tr>
    </table>
    <input type="submit" value="calculate discout">
  </form>
  </body>
</html>
