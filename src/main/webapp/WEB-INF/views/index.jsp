<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>User Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="açıklama" />
    <meta name="keywords" content="arama kelimeleri" />
    <meta name="author" content="Enes Tuncay" />



    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="index/favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="index/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="index/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="index/css/bootstrap.css">

    <link rel="stylesheet" href="index/css/style.css">


    <!-- Modernizr JS -->
    <script src="index/js/modernizr-2.6.2.min.js"></script>

</head>
<body>
<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Kapat</span></span></a>
    <div class="fh5co-bio">
        <figure>
            <img src="index/images/person1.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
        </figure>
        <h2>${user.customerId}</h2>
        <p>Please select an option below</p>
        <ul class="fh5co-social">
            <li><a href="process">Make any Process</a></li>
            <br><br>
            <li><a href="logout">Logout</a></li>
            <br><br>
            <li><a href="deleteUser">Delete User</a></li>
        </ul>
    </div>

</div>
<!-- END #fh5co-offcanvas -->
<header id="fh5co-header">

    <div class="container-fluid">

        <div class="row">
            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="index.html">Welcome ${user.customerId}</a></h1>
            </div>
        </div>
    </div>
</header>
<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry"></div>
</div>

<!-- jQuery -->
<script src="index/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="index/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="index/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="index/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="index/js/main.js"></script>

</body>
</html>

