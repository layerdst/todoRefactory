<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>할일등록</header>
	<section>
		<form action="">
			<label for="todo_input">어떤일인가요?</label> 
			<input type="text" id="todo_input" />
			 
			<label for="todo_who">누가 할일인가요?</label> 
			<input type="text" id="todo_who" />
			
			<label for="todo_who">어떤일인가요?</label>
			<input type="text" id="todo_who" />
			
			<p> 우선순위를 선택하세요 </p>
			<div>
				<input type="radio" id="one" name="priority" value="1">
				<label for="one">1</label>
			</div>

			<div>
				<input type="radio" id="two" name="priority" value="2"> 
				<label for="two">2</label>
			</div>

			<div>
				<input type="radio" id="three" name="priority" value="3"> 
				<label for="three">3</label>
			</div>

			<button type="submit"> 전송 </button>
		</form>
	</section>

</body>
</html>