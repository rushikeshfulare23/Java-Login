<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
        body {
            background-image: url("img/back.png");
            background-size: cover; /* or use "contain" depending on the desired effect */
            background-position: center; /* to center the image */
            background-repeat: no-repeat; 
        }
        form {
            width: 400px;
            height: 400;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 30px;
            height: auto;
        }
        select {
            width: 30px;
            height: auto;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">My Website</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>
            </ul>
        </div>
        <%@ include file="top.html" %>
    </nav>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
            <div style="background-color: #87CEEB; padding: 20px; border-radius: 20px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);width: 95%; max-width: 450px;">
                <form action="Register" method="post">
                    <h1 class="text-center">User Registration</h1>
                   <div class="form-group">
    <label for="txtName">Enter Name:</label>
    <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Enter your name" style="width: 100%; height: 40px;">
</div>
<div class="form-group">
    <label for="txtEmail">Enter Email:</label>
    <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="Enter your Email" style="width: 100%; height: 40px;">
</div>
                    <div class="form-group">
                        <label for="txtGender">Select Gender:</label>
                        <select class="form-control" id="txtGender" name="txtGender">
                             <option value="None">~None~</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                            
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtCity">Select City:</label>
                        <select class="form-control" id="txtCity" name="txtCity">
                            <option value="None">~None~</option>
                            <option value="Chh.SambhajiNagr">Chh.SambhajiNagr</option>
                            <option value="Pune">Pune</option>
                            <option value="Mumbai">Mumbai</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtPassword">Enter Password:</label>
                        <input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Enter your password" style="width: 100%; height: 40px;">
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                    <a href="login.jsp" class="btn btn-primary">Login</a>
                    <a href="register.jsp" class="btn btn-secondary ml-2">Cancel</a>
                </form>
            </div>
            </div>
        </div>
    </div>
    <%@ include file="bottom.html" %>
    <!-- Add Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoJtKh7z7lGz7fuP4F8nfdFvAOA6Gg/z6Y5J6XqqyGXYM2ntX5" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>