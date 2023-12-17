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
    <form action="RegisterServlet" method="post"> <!-- action is gonna used url-pattern -->
        <table>
            <tr>
                <td>Enter Name: </td>
                <td><input type="text" name="user_name" placeholder="Enter Here.."></td>
            </tr>
            <tr>
                <td>Enter Email: </td>
                <td><input type="email" name="user_email" placeholder="Enter here.."></td>
            </tr>
            <tr>
                <td>Enter Age: </td>
                <td><input type="number" name="user_age" placeholder="Enter Here.."></td>
            </tr>
            <tr>
                <td>Select Course</td>
                <td>
                    <select name="user_course">
                        <option value="Java">Java</option>
                        <option value="CPP">CPP</option>
                        <option value="Python">Python</option>
                    </select>
                </td>
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