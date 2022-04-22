<%--
  Created by IntelliJ IDEA.
  User: Dunay Gudratli
  Date: 22.4.2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="css/header.css">
<div class="header">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/">Al Sat</a>
            </div>
            <nav>
                <ul id="MenuItems">
                    <li><a href="${pageContext.request.contextPath}/index">Home</a></li>
                    <li><a href="#">Category</a></li>
                    <li><a href="${pageContext.request.contextPath}/about">About us</a></li>
                    <li><a href="${pageContext.request.contextPath}/account">Account</a></li>
                </ul>
            </nav>
            <label class="menu-icon" onclick="menutoggle()">Menu</label>
        </div>
    </div>
</div>
<script src="js/Header.js"></script>