<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	getFruit();
	$("#submit").on("click", function(){
		patchFruit();
	})
});
function getFruit(){
	$.ajax({
		url: "/web/api/fruits/"+${fruitId},
		method: "get",
		success: function(fruit){
			$("#name").val(fruit.name)
		},
		error: function(err){
			console.log(err);
		}
	})
}

function patchFruit(){
	var data = {
		name: $("#name").val()
	};
	$.ajax({
		url: "/web/api/fruits/"+${fruitId},
		method: "patch",
		data: JSON.stringify(data),
		contentType : 'application/json',
		success: function(){
			location.href = "/web/fruits";
		},
		error: function(err){
			console.log(err);
		}
	})
}
</script>
</head>
<body>
<h1>Fruit 작성</h1>
이름: <input type="text" id="name" name="name">
<br>
<button id="submit">등록</button>
</body>
</html>