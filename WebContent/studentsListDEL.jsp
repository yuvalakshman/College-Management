<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
@
use postcss-cssnext ;
	/* config.css */ 

:root { -
	-baseColor: #606468;
}

/* helpers/align.css */
.align {
	align-items: center;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

/* helpers/grid.css */
:root { -
	-gridMaxWidth: 20rem; -
	-gridWidth: 90%;
}

.grid {
	margin-left: auto;
	margin-right: auto;
	max-width: var(- -gridMaxWidth);
	width: var(- -gridWidth);
}

/* helpers/hidden.css */
.hidden {
	border: 0;
	clip: rect(0, 0, 0, 0);
	height: 1px;
	margin: -1px;
	overflow: hidden;
	padding: 0;
	position: absolute;
	width: 1px;
}

/* helpers/icon.css */
:root { -
	-iconFill: var(- -baseColor);
}

.icons {
	display: none;
}

.icon {
	display: inline-block;
	fill: var(- -iconFill);
	font-size: 1rem;
	height: 1em;
	vertical-align: middle;
	width: 1em;
}

/* layout/base.css */
:root { -
	-htmlFontSize: 100%; -
	-bodyBackgroundColor: #2c3338; -
	-bodyColor: var(- -baseColor); -
	-bodyFontFamily: 'Open Sans'; -
	-bodyFontFamilyFallback: sans-serif; -
	-bodyFontSize: 0.875rem; -
	-bodyFontWeight: 400; -
	-bodyLineHeight: 1.5;
}

* {
	box-sizing: inherit;
}

html {
	box-sizing: border-box;
	font-size: var(- -htmlFontSize);
	height: 100%;
}

body {
	background-color: var(- -bodyBackgroundColor);
	color: white;
	font-family: var(- -bodyFontFamily), var(- -bodyFontFamilyFallback);
	font-size: var(- -bodyFontSize);
	font-weight: var(- -bodyFontWeight);
	height: 100%;
	line-height: var(- -bodyLineHeight);
	margin: 0;
	min-height: 100vh;
}

/* modules/anchor.css */
:root { -
	-anchorColor: #eee;
}

a {
	color: var(- -anchorColor);
	outline: 0;
	text-decoration: none;
}

a:focus, a:hover {
	text-decoration: underline;
}

/* modules/form.css */
:root { -
	-formFieldMargin: 0.875rem;
}

input {
	background-image: none;
	border: 0;
	color: inherit;
	font: inherit;
	margin: 0;
	outline: 0;
	padding: 0;
	transition: background-color 0.3s;
}

input[type='submit'] {
	cursor: pointer;
}

.form {
	margin: calc(var(- -formFieldMargin)* -1);
}

.form input[type='password'], .form input[type='text'], .form input[type='submit']
	{
	width: 100%;
}

.form__field {
	display: flex;
	margin: var(- -formFieldMargin);
}

.form__input {
	flex: 1;
}

/* modules/login.css */
:root { -
	-loginBorderRadus: 0.25rem; -
	-loginColor: #eee; -
	-loginInputBackgroundColor: #3b4148; -
	-loginInputHoverBackgroundColor: #434a52; -
	-loginLabelBackgroundColor: #363b41; -
	-loginSubmitBackgroundColor: RoyalBlue; -
	-loginSubmitColor: #eee; -
	-loginSubmitHoverBackgroundColor: RoyalBlue;
}

.login {
	color: var(- -loginColor);
}

.login label, .login input[type='text'], .login input[type='password'],
	.login input[type='submit'] {
	border-radius: var(- -loginBorderRadus);
	padding: 1rem;
}

.login label {
	background-color: var(- -loginLabelBackgroundColor);
	border-bottom-right-radius: 0;
	border-top-right-radius: 0;
	padding-left: 1.25rem;
	padding-right: 1.25rem;
}

.login input[type='password'], .login input[type='email'] {
	background-color: var(- -loginInputBackgroundColor);
	border-bottom-left-radius: 0;
	border-top-left-radius: 0;
}

.login input[type='password']:focus, .login input[type='password']:hover,
	.login input[type='email']:focus, .login input[type='email']:hover {
	background-color: var(- -loginInputHoverBackgroundColor);
}

.login input[type='submit'] {
	background-color: var(- -loginSubmitBackgroundColor);
	color: var(- -loginSubmitColor);
	cursor: pointer;
	font-weight: 700;
	text-transform: uppercase;
}

.login input[type='submit']:focus, .login input[type='submit']:hover {
	background-color: var(- -loginSubmitHoverBackgroundColor);
}

/* modules/text.css */
:root { -
	-paragraphMarginBottom: 1.5rem; -
	-paragraphMarginTop: 1.5rem;
}

p {
	margin-bottom: var(- -paragraphMarginBottom);
	margin-top: var(- -paragraphMarginTop);
}

.text--center {
	text-align: center;
}

.form {
	position: absolute;
	top: 30%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body class="align">
	<h3>List of Students</h3>
	<table align="center" border="1">
		<thead>
			<tr>
				<th>Roll</th>
				<th>Name</th>
				<th>mail</th>
				<th>Batch</th>
				<th>Attendance</th>
				<th>CGPA</th>
				<th>Department_name</th>
				<th>Department_hod</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="students" items="${STUDENTS}">
				<tr>

					<td>${students.roll}</td>
					<td>${students.name}</td>
					<td>${students.mail}</td>

					<td>${students.batch}</td>
					<td>${students.attendance}</td>
					<td>${students.cgpa}</td>
					<td>${students.department.name}</td>
					<td>${students.department.hod}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div align="center">
		<a href="deleteStudent.jsp">Remove more Students</a><br> <a
			href="admin.html">Home</a>
	</div>
	<div align="right">
		<a href="Home.jsp">Logout</a>
	</div>
</body>
</html>