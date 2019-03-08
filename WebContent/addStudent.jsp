<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>AddStudent</title>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<style>
/* config.css */

/* helpers/align.css */

.align {
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
      -ms-flex-direction: column;
          flex-direction: column;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
}

/* helpers/grid.css */

.grid {
  margin-left: auto;
  margin-right: auto;
  max-width: 320px;
  max-width: 20rem;
  width: 90%;
}

/* helpers/hidden.css */

.hidden {
  border: 0;
  clip: rect(0 0 0 0);
  height: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
  width: 1px;
}

/* helpers/icon.css */

.icons {
  display: none;
}

.icon {
  display: inline-block;
  fill: #606468;
  font-size: 16px;
  font-size: 1rem;
  height: 1em;
  vertical-align: middle;
  width: 1em;
}

/* layout/base.css */

* {
  -webkit-box-sizing: inherit;
          box-sizing: inherit;
}

html {
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  font-size: 100%;
  height: 100%;
}

body {
  background-color: #2c3338;
  color: blue;
  font-family: 'Open Sans', sans-serif;
  font-size: 14px;
  font-size: 0.875rem;
  font-weight: 400;
  height: 100%;
  line-height: 1.5;
  margin: 0;
  min-height: 100vh;
}

/* modules/anchor.css */

a {
  color: #007bff;
  outline: 0;
  text-decoration: none;
}

a:focus,
a:hover {
  text-decoration: underline;
}

/* modules/form.css */

input {
  background-image: none;
  border: 0;
  color: inherit;
  font: inherit;
  margin: 0;
  outline: 0;
  padding: 0;
  -webkit-transition: background-color 0.3s;
  transition: background-color 0.3s;
}

input[type='submit'] {
  cursor: pointer;
}

.form {
  margin: -14px;
  margin: -0.875rem;
}

.form input[type='number'],
.form input[type='text'],
.form input[type='submit'] {
  width: 100%;
}

.form__field {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  margin: 14px;
  margin: 0.875rem;
}

.form__input {
  -webkit-box-flex: 1;
      -ms-flex: 1;
          flex: 1;
}

/* modules/login.css */

.login {
  color: #eee;
}

.login label,
.login input[type='text'],
.login input[type='number'],
.login input[type='password'],
.login input[type='email'],
.login input[type='submit'] {
  border-radius: 0.25rem;
  padding: 16px;
  padding: 1rem;
}

.login label {
  background-color: #363b41;
  border-bottom-right-radius: 0;
  border-top-right-radius: 0;
  padding-left: 20px;
  padding-left: 1.25rem;
  padding-right: 20px;
  padding-right: 1.25rem;
}

.login input[type='password'],
.login input[type='number'],
.login input[type='text'],
.login input[type='email'] {
  background-color: #3b4148;
  border-bottom-left-radius: 0;
  border-top-left-radius: 0;
}

.login input[type='password']:focus,
.login input[type='password']:hover,
.login input[type='number']:focus,
.login input[type='number']:hover
.login input[type='text']:focus,
.login input[type='text']:hover
.login input[type='email']:focus,
.login input[type='email']:hover {
  background-color: #434a52;
}

.login input[type='submit'] {
  background-color: #0000ff;
  color: #eee;
  font-weight: 700;
  text-transform: uppercase;
}

.login input[type='submit']:focus,
.login input[type='submit']:hover {
  background-color: #0000f0;
}

/* modules/text.css */

p {
  margin-bottom: 24px;
  margin-bottom: 1.5rem;
  margin-top: 24px;
  margin-top: 1.5rem;
}

.text--center {
  text-align: center;
}
</style>
<title>insertPage</title>
</head>
<body class="text-center">
	<form method=post action="AddServlet" class="form-signin">
		<div>
			<h3>Roll</h3>
			<input type="number" name="roll" min=1 max=9999999 required>
		</div>
		<br>
		<div>
			<h3>Attedance</h3>
			<input type="number" step=0.01 name="attendance" min=1 max=100 required>
		</div>
		<br>

		<div>
			<h3>CGPA</h3>
			<input type="number" step=0.01 name="cgpa"min=1 max=10 required>
		</div>

		<div>
			<h3>Batch</h3>
			<input type="number" name="batch" min=1998 max=2019 required>
		</div>
		<br>
		<div>
			<h3>Department</h3>
			<select name="dept">
				<c:forEach var="dept" items="${DEPARTMENT}">
					<option value="${dept.dept_id}">${dept.name}</option>
				</c:forEach>
			</select>
		</div>
		<br>
		<div>
			<h3>Name</h3>
			<input type="text" name="name" required>
		</div>
		<div>
			<h3>Gender</h3>
			<input type="text" name="gender" required>
		</div>
		<br>


		<div>
			<h3>Mail</h3>
			<label for="inputEmail" class="sr-only"></label> <input type="email"
				name="mail" required required placeholder="Enter valid email Id">
		</div>
		<br>
		<div>
			<h3>Password</h3>
			<label for="inputPassword" class="sr-only"></label> <input
				type="password" name="password" required>
		</div>
		<br>

		<div>
			<button type="submit" class="btn btn-primary btn-lg">ADD</button>
			<br> <a href="admin.html">Home</a>
		</div>

		<div align="right">
			<a href="Home.jsp">Logout</a>
		</div>
	</form>
</body>
</html>