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
	getFruits();
});

function getFruits(){
	$.ajax({
		url: "/web/api/fruits",
		method: "get",
		success: function(fruits){
			var html = "";
			$.each(fruits, function(index, fruit){
				html += "<div onclick='location.href=`/web/fruits/"+fruit.fruitId+"`'>"+fruit.name+"</div>";
			})
			$("#output").html(html);
		},
		error: function(err){
			console.log(err);
		}
	})
}
</script>
</head>
<body>
<h1>Fruit 리스트</h1>
<div id="output"></div>
<a href="/web/fruits/post">과일 등록</a>
</body>
</html>