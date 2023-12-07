

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <style>
        body {
            background: linear-gradient(to right, #FFD700, #FFA500); /* Change gradient colors as needed */
            color: #ffffff; /* Text color on the gradient background */
        }

        .navbar {
            background-color: #343a40; /* Navbar background color */
        }

        .navbar-dark .navbar-nav .nav-link {
            color: #ffffff; /* Navbar link color */
        }

        .navbar-dark .navbar-toggler-icon {
            background-color: #ffffff; /* Navbar toggler color */
        }

        .welcome-container {
            text-align: center;
            padding: 100px 0;
        }

        .welcome-message {
            font-size: 36px;
            font-weight: bold;
        }
        .navbar {
	    background-color: #343a40; /* Navbar background color */
	    padding-top: 15px; /* Customize the top padding to adjust the height */
	    padding-bottom: 15px; /* Customize the bottom padding to adjust the height */
}
        
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">BILL MAX</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="registration.jsp">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container welcome-container">
    <div class="welcome-message">
        <p>😉👋🙋‍♀️</p>
        <h1>WELCOME, <%= session.getAttribute("user") %>! Your Login was successful, Thank you !!!</h1>
        <p>Explore and discover what we have to offer.</p>
    </div>
</div>

<!-- Bootstrap JS (optional, if you need Bootstrap JavaScript features) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
