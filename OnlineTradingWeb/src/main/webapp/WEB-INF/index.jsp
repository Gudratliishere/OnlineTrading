<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Al Sat | Free advertisement</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Serif:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
</head>
<body>
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
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="${pageContext.request.contextPath}/account">Account</a></li>
                </ul>
            </nav>
            <label class="menu-icon" onclick="menutoggle()">Menu</label>
        </div>

        <div class="row">
            <div class="col-2">
                <h1>Add your product to sale!</h1>
                <p>Just with one click, you can share your product and sale
                    it in one minute.</p>
                <a href="" class="btn">Create now! &#8594;</a>
            </div>
            <div class="col-2">
                <img class="add-product-img" src="/img/add_product.jpg">
            </div>
        </div>
    </div>
</div>

<div class="categories">
    <div class="small-container">
        <div class="row">
            <div class="col-3">
                <label>col 3</label>
            </div>
            <div class="col-3">
                <label>col 3</label>
            </div>
            <div class="col-3">
                <label>col 3</label>
            </div>
        </div>
    </div>
</div>

<div class="small-container">
    <h2 class="title">Featured Products</h2>
    <div class="row">
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
    </div>
</div>

<div class="offer">
    <div class="small-container">
        <div class="row">
            <div class="col-2">
                <label>Exclusive</label>
            </div>
            <div class="col-2">
                <p>Exclusively available on store!</p>
                <h1>Smart band 4</h1>
                <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur at eligendi, quibusdam quis
                    rerum sunt
                    tempora veritatis? Dolore ducimus explicabo illum, inventore modi odio omnis quasi sequi, sit soluta
                    vitae.</small>
                <a href="#" class="btn">Buy Now &#8594;</a>
            </div>
        </div>
    </div>
</div>

<div class="small-container">
    <h2 class="title">Latest Products</h2>
    <div class="row">
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
        <div class="col-4">
            <label>Col 4</label>
            <h4>Red printed T-shirt</h4>
            <div class="rating">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p>$50.00</p>
        </div>
    </div>
</div>

<div class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col-1">
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

<script src="js/Index.js"></script>