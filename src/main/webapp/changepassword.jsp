<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
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
        input[type="password"] {
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
                    <form action="ChangePasswordServlet" method="post">
                        <h1 class="text-center">Change Password</h1>
                        <div class="form-group">
                            <label for="currentPassword">Current Password:</label>
                            <input type="password" class="form-control" id="currentPassword" name="currentPassword" placeholder="Enter your current password" style="width: 100%; height: 40px;">
                        </div>
                        <div class="form-group">
                            <label for="newPassword">New Password:</label>
                            <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter your new password" style="width: 100%; height: 40px;">
                        </div>
                        <div class="form-group">
                            <label for="confirmNewPassword">Confirm New Password:</label>
                            <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword" placeholder="Confirm your new password" style="width: 100%; height: 40px;">
                        </div>
                        <button type="submit" class="btn btn-primary">Change Password</button>
                    </form>
                    <% if (request.getAttribute("error") != null) { %>
                        <p style="color: red;"><%= request.getAttribute("error") %></p>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="bottom.html" %>
    <!-- Add Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoJtKh7z7lGz7fuP4F8nfdFvAOA6Gg/z6Y5J6XqqyGXYM2ntX5" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap