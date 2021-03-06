<%@ taglib prefix="th" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account | Al Sat</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/account.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Serif:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
</head>
<body>
<%@include file="header.jsp"%>

<div class="account-page">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <img class="account-img" src="/img/account.jpg">
            </div>
            <div class="col-2">
                <div class="form-container" id="FormContainer">
                    <div class="form-btn">
                        <span onclick="loginToggle()">Login</span>
                        <span onclick="registerToggle()">Register</span>
                        <hr id="Indicator">
                    </div>

                    <form id="LoginForm">
                        <input type="text" placeholder="username">
                        <input type="password" placeholder="Password">
                        <button type="submit" class="btn">Login</button>
                        <a href="#">Forget password?</a>
                    </form>

                    <form id="RegisterForm">
                        <input type="text" placeholder="Name">
                        <input type="text" placeholder="Surname">
                        <input type="email" placeholder="Email">
                        <input type="text" placeholder="Phone number">
                        <input type="text" placeholder="City">
                        <input type="password" placeholder="Password">
                        <button type="submit" class="btn">Register</button>
                     </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>

<script src="js/Account.js"></script>