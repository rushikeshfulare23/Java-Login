<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Dashboard</title>
	<!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	 <style>
    body{
    background-image: url("img/back.png");
    background-size: cover; /* or use "contain" depending on the desired effect */
    background-position: center; /* to center the image */
    background-repeat: no-repeat; 
    }
   .dashboard-container {
      max-width: 800px;
      margin: 40px auto;
      padding: 20px;
      background-color: #f9f9f9;
      border: 1px solid #ddd;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
   .dashboard-header {
      background-color: #87CEEB;
      padding: 10px;
      border-bottom: 1px solid #ddd;
    }
   .dashboard-header h2 {
      color: #333;
      margin-top: 0;
    }
   .dashboard-content {
      padding: 20px;
    }
   .dashboard-content ul {
      list-style: none;
      padding: 0;
      margin: 0;
    }
   .dashboard-content li {
      margin-bottom: 10px;
    }
   .dashboard-content a {
      color: #337ab7;
      text-decoration: none;
    }
   .dashboard-content a:hover {
      color: #23527c;
      text-decoration: underline;
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
                    <a class="nav-link" href="index.jsp">Register</a>
                </li>
            </ul>
        </div>
<%@ include file="top.html" %>
    </nav>
	<div class="dashboard-container">
		<div class="dashboard-header">
			<h2>Welcome to Your Dashboard!</h2>
		</div>
		<div class="dashboard-content">
			<h3>Account Information</h3>
			<ul>
				<li><strong>username:</strong> ${username}</li>
				<li><strong>Email:</strong> ${email}</li>
				<li><strong>Gender:</strong> ${gender}</li>
				<li><strong>City:</strong> ${city}</li>
			</ul>
			<h3>Actions</h3>
			<ul>
				<li><a href="editprofile.jsp">Edit Profile</a></li>
				<li><a href="changepassword.jsp">Change Password</a></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</div>
	</div>
	 <!-- Add Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoJtKh7z7lGz7fuP4F8nfdFvAOA6Gg/z6Y5J6XqqyGXYM2ntX5" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  <%@ include file="bottom.html" %>
</body>
</html>