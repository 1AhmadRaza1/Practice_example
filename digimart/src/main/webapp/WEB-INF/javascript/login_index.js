$(document).ready(function(){
	
	alert("page load example ");
	

	
	$("#login_admin").click(function(){
		alert("button click ..")
		getDetail();
		var adminEmail=$("#admin_email").val();
		var adminPassword=$("#admin_password").val();
		alert(adminEmail+"  "+adminPassword)
		 var adminEntity={"admin_id":1,"admin_name":"b","admin_mobile":"c","admin_email":adminEmail,
		"admin_password":adminPassword}
		
		function getDetail(){
			alert("call function")
			$.ajax({
				type:"POST",
				contentType:"application/json",
				dataType : "json",
				url:"admin-detail",
				data:JSON.stringify(adminEntity),
				success:function(responseText){
					alert(responseText)
					//var jsonData=JSON.stringify(responseText);
					//alert(jsonData.adminEmail)
				}
			});
	}	
		

	});
	
	
});
	
		


