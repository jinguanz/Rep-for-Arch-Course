<%-- 
    Document   : PlaceOrder
    Created on : 16 Oct, 2012, 11:14:40 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place an order</title>
        <script type="text/javascript" src="Document.js"></script>
    </head>
    <body>

        <a href = "Home.jsp">Home</a>&nbsp;
        <a href="Logout.jsp">LogOut</a>
    <center><h1 >ACME Bicycle</h1></center>
    <form name="form1" action="ReviewOrder.jsp" method="post">

        <table align="center">
            <tr>
                <th colspan="2" align="center">Credit/Debit Card Information</th>
            </tr>

            <tr>
                <td>Card No.</td>
                <td><input type="text" name="cardno" maxlength="16" size="16"></td>
            </tr>


            <tr>
                <td>Card Expiration(mm-yy)</td>
                <td>
                    <select name="month">
                        <option value="D">1</option>
                        <option value="D">2</option>
                        <option value="D">3</option>
                        <option value="D">4</option>
                        <option value="D">5</option>
                        <option value="D">6</option><option value="D">7</option>
                        <option value="D">8</option>
                        <option value="D">9</option>
                        <option value="D">10</option>
                        <option value="D">11</option><option value="D">12</option>



                    </select>
                </td>
                <td><select name="year">
                        <option value="D">2012</option>
                        <option value="D">2013</option>
                        <option value="D">2014</option>
                        <option value="D">2015</option><option value="D">2016</option>
                        <option value="D">2017</option>
                        <option value="D">2018</option>
                </td>
            </tr>

            <tr>
                <td>CVV No.</td>
                <td><input type="text" name="cvv" maxlength="3" size="4"></td>
            </tr>
            <tr>
                
                <td><input type="Submit" name="sub" value="Submit" onclick="return fnCheckCardData()">
                    <INPUT TYPE=Reset NAME="cmdReset" VALUE="Reset">
                </td>
            </tr>
        </table>
    </form>
    <br><br><br><br><br>

</body>

</html>
