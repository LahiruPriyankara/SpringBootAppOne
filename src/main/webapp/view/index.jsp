<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello ${value}</h2>

	<br>

	<form action="http://localhost:8080/student/addStudent" method="get">
		Name : <input type="text" name="name" /> <br><br>
		Age :  <input type="text" name="age" /> <br><br>
		Grade : <input type="text" name="grade" /><br><br>
		
		<input type="submit" value="Send"> 
	</form>
	<br>
	Student ${sudent}
	<br>
	Name : ${sudent.name}  Age : ${sudent.age}  Grade : ${sudent.grade}  
	<br>
	All Students ${sudents}
	
	<br><br>
	<form action="http://localhost:8080/student/getStudent" method="get">
		ID : <input type="text" name="id" />		
		<input type="submit" value="GetStudent"> 
	</form>
	<br><br>
	Student Found  ${foundSudent}
	
	<br><br>
	<form action="http://localhost:8080/student/getStudents" method="get">
		Name : <input type="text" name="name" /> <br><br>
		Age :  <input type="text" name="id" /> <br><br>			
		Getting All Student : <input type="submit" value="GetStudent"> 
	</form>
	<br><br>
	FindByName Found  ${findByName}<br><br>
	FindByAgeGraterThan Found  ${findByAgeGreaterThan}<br><br>
	FindByAgeGreaterThan Found  ${findByAgeAndName}<br><br>
</body>
</html>