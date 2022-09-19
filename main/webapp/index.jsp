<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css?ver=2">
	<title>ToDoProject</title>
</head>
<body>

	<header>
		<div id="top_menu">
			<div>나의 해야할 일들</div>
			<div>
				<input type="button" value="새로운 TODO 등록" onclick = "location.href='/add'"/>
			</div>
		</div>
	</header>
	
	<section>
		<div id = "todo_table">
			<div class = "column" id = "todo">
				<div class = "todo"> TO DO	
				</div>
				
				<div class = "todo"> TO DO	
					<p class = "todo_title"> 타이틀 </p>
					<p>
						<span> 등록날짜 : ㅇㅇ 우선순위 : ㅇ </span>
						<span>
							<input class ="btn" id="test" type="button" value = "→"/>
						</span>
					</p>
				</div>
			</div>
			<div class = "column" id = "doing">
				<div class = "doing"> DOING
				</div>
				
				<div class = "doing"> TO DO	
					<p class = "todo_title"> 타이틀 </p>
					<p>
						<span> 등록날짜 : ㅇㅇ 우선순위 : ㅇ </span>
						<span>
							<input class ="btn" id="test" type="button" value = "→"/>
						</span>
					</p>
				</div>
			</div>
			<div class = "column" id = "done">
				<div class = "DONE"> DONE	
				</div>
				
				<div class = "DONE"> DONE
					<p class = "todo_title"> 타이틀 </p>
					<p>
						<span> 등록날짜 : ㅇㅇ 우선순위 : ㅇ </span>
						<span>
							<input class ="btn" id="test" type="button" value = "→"/>
						</span>
					</p>
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>
