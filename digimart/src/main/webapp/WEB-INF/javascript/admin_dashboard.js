$(document).ready(function(){
	
	alert("page load example ");
	
		
	function getDetail(){
		alert("call function")
		$.ajax({
			type:"get",
			url:"dashboard-admin-list"
		});
	}	
});
	
		


