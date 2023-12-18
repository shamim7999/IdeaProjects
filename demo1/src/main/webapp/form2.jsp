<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            width: 40%;
            border: 1px solid black;
            margin: auto;
            padding: 20px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>My Form</h1>
    <form action="registerpersonservlet" method="post"> <!-- action is gonna used url-pattern -->
        <table>
            <tr>
                <td>Enter Email: </td>
                <td><input type="email" name="user_email" placeholder="Enter here.."></td>
            </tr>
            <tr>
                <td>Enter Password: </td>
                <td><input type="password" name="user_password" placeholder="Enter here.."></td>
            </tr>
            <tr>
                <td>Confirm Password: </td>
                <td><input type="password" name="user_confirm_password" placeholder="Enter here.."></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Register</button>
                    <button type="reset">Reset</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>