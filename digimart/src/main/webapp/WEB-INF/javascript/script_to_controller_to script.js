$(document).ready(function(){
	$("#sales").click(function(){
		alert("hello")
		var script_to_controller = {"name":$("#name").val()};
		$.ajax({
			type:"post",
			data:JSON.stringify(script_to_controller),             
			dataType: "json",         
            contentType: 'application/json',
			url:"script-controller-passed",
            success:function(responseText){
				alert(responseText)
				var data=JSON.parse(responseText);
				alert(data)
			}
		});
		
	});
});