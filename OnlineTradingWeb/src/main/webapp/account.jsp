<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account | Al Sat</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/account.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Serif:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
    <script src="js/Index.js"></script>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href="/">Al Sat</a>
            </div>
            <nav>
                <ul id="MenuItems">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Category</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Account</a></li>
                </ul>
            </nav>
            <label class="menu-icon" onclick="menutoggle()">Menu</label>
        </div>
    </div>
</div>

<div class="account-page">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <label>account image</label>
            </div>
            <div class="col-2">
                <div class="form-container">
                    <div class="form-btn">
                        <span>Login</span>
                        <span>Register</span>
                    </div>

                    <form>
                        <input type="text" placeholder="username">
                        <input type="password" placeholder="Password">
                        <button type="submit" class="btn">Login</button>
                        <a href="#">Forget password?</a>
                    </form>

                    <form>
                        <input type="text" placeholder="username">
                        <input type="email" placeholder="Email">
                        <input type="password" placeholder="Password">
                        <button type="submit" class="btn">Register</button>
                     </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col-1">
                <h3>Download our app</h3>
                <p>Download app for android and ios mobile phone.</p>
                <div class="app-logo">
                    <label>App logo</label>
                </div>
            </div>
            <div class="footer-col-2">
                <label>footer col 2</label>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A consequuntur earum esse est fugiat hic
                    incidunt nulla
                    praesentium sed tempora. Ad cumque impedit, nobis numquam praesentium recusandae sed soluta
                    unde.</p>
            </div>
            <div class="footer-col-3">
                <h3>Useful links</h3>
                <ul>
                    <li>Coupons</li>
                    <li>Blog Post</li>
                    <li>Return Policy</li>
                    <li>Join Affiliate</li>
                </ul>
            </div>
            <div class="footer-col-4">
                <h3>Follow us</h3>
                <ul>
                    <li>Facebook</li>
                    <li>Instagram</li>
                    <li>Twitter</li>
                    <li>YouTube</li>
                </ul>
            </div>
        </div>
        <hr>
        <p class="copyright">Copyright 2022 - Dunay Gudratli</p>
    </div>
</div>

</body>
</html>

