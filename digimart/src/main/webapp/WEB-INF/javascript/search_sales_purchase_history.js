$(document).ready(function(){
	
	$("#sales_history").show();
	$('#purchase_history').hide();
	
	var searchHistory;
	getCustomerDetails();
	getSupplierDetails();
	
	$("#sales").click(function(){	
		searchHistory = {"customerName":$("#customerName").val(),
			"supplierName":$("#supplierName").val(),
			"toDate":$("#toDate").val(),
			"fromDate":$("#fromDate").val(), 
			"mobileNumber":$("#mobileNumber").val()
		};
		$.ajax({
			type:"post",
			data:JSON.stringify(searchHistory),             
			dataType: "json",         
            contentType: 'application/json',
			url:"get-sales-history",
            success:function(responseText){
				alert(responseText)
				var data=JSON.parse(responseText);
				alert(data)
			}
		
		});
		
	});
	
	$('#sales_link').click(function (){
		$("#sales_history").show();
		$('#purchase_history').hide();
	});
	
	$('#purchase_link').click(function (){
		$('#purchase_history').show();
		$('#sales_history').hide();
	});
	
	function getCustomerDetails(){
		$.ajax({
			type:"get",
			contentType:"application/json",
			url:"get-customer-name",
			success:function(responseText){
				var data=JSON.parse(responseText);
				$.each(data,function(index,value1){
					$("#customerName").append("<option value="+value1.customer_name+">"+value1.customer_name+"</option>");
				});
			}
		});
			
	}
	
	function getSupplierDetails(){
		$.ajax({
			type:"get",
			contentType:"application/json",
			url:"get-supplier-name",
			success:function(responseText){
				var data=JSON.parse(responseText);
				$.each(data,function(index,value1){
					$("#supplierName").append("<option value="+value1.suplier_name+">"+value1.suplier_name+"</option>");
				});
			}
		});
	}
	
	
});