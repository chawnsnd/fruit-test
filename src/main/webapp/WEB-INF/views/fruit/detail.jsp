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
})
function getFruit(){
	$.ajax({
		url: "/web/api/fruits/"+${fruitId},
		method: "get",
		success: function(fruit){
			html = "<div>"+fruit.name+"</div>";
			$("#output").html(html);
		},
		error: function(err){
			console.log(err);
		}
	})
}
function deleteFruit(){
	$.ajax({
		url: "/web/api/fruits/"+${fruitId},
		method: "delete",
		success: function(fruit){
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
<h1>Fruit 상세</h1>
<div id="output"></div>
<a href="/web/fruits/">과일 목록</a>
<a href="/web/fruits/${fruitId}/edit">과일 수정</a>
<a href="#" onclick="deleteFruit()">과일 삭제</a>
</body>
</html>