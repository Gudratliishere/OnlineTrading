<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Products | Al Sat</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/product.css">
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

<div class="small-container single-product">
    <div class="row">
        <div class="col-2">
            <label>image</label>

            <div class="small-img-row">
                <div class="small-img-col">
                    <label>small image</label>
                </div>
                <div class="small-img-col">
                    <label>small image</label>
                </div>
                <div class="small-img-col">
                    <label>small image</label>
                </div>
            </div>
        </div>
        <div class="col-2">
            <p>Home / T-Shirt</p>
            <h1>T shirt description</h1>
            <h4>$50.00</h4>
            <select>
                <option>Select Size</option>
                <option>XXL</option>
                <option>XL</option>
            </select>

            <h3>Product Details <i class="fa fa-indent"></i></h3>
            <br>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci, beatae commodi doloremque
                doloribus ducimus esse fugiat nulla quam
                reprehenderit. At incidunt nostrum numquam reiciendis voluptas? Aliquam fugiat modi optio quo?</p>
        </div>
    </div>
</div>

<div class="small-container">
    <div class="row row-2">
         <h2>Related Products</h2>
        <p>View more</p>
    </div>
</div>

<div class="small-container">
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