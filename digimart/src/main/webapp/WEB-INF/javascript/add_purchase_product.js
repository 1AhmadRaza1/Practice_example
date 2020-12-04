$(document).ready(function(){
	alert("on load j")
	call_getSupplierdetail();
	var count=1;
	var selectProduct_id="";
	//var product_qty="";
	var c;
	var q;
	var p_name;
	var add_purchase=true;
	var jsonRequestString;
	var responseValue=0;
	var getlastItemId=false;
	var addProductbtn=false;
	var data;
	$("#addproduct").click(function(){
			var addProduct="<tr><td colspan='2'>"+count+"&nbsp;&nbsp;&nbsp;<select id='product"+count+"' name='product"+count+"'><option value='-1'>-- Select Product Name --</option></select></td><td><input type='text' id='quantity"+count+"' name='quantity"+count+"'></td></tr>";
			selectProduct_id="product"+count;
			$("#addRow").append(addProduct);
			if(add_purchase==true){
				call_addpurchaseProduct();
				alert(add_purchase)
			}
			call_get_lastPurchase_id();
			call_getProductDeatail();
			if(addProductbtn==true){
				call_addProductItemMaster();
			}
			if(getlastItemId==true){
				call_purchase_product_item_master_history();
			}
			addProductbtn=true;
			count=count+1;
	});
	
	function call_addpurchaseProduct(){
			alert("ist time execute else parts ")
			jsonRequestString={"suplier_detail_id":$("#suplier_detail_id").val(),"purchaseDate":$("#purchaseDate").val()};
		$.ajax({
			type:"post",
			data:JSON.stringify(jsonRequestString),
			contentType:"application/json",
			dataType:"json",
			url:"add-new-purchase",
			success:function(responseText){
				alert(responseText)
			}
		});
		add_purchase=false;
	}
	
	function call_get_lastPurchase_id(){
		$.ajax({
			type:"get",
			url:"get-last-purchase-id",
			success:function(responseText){
				alert(responseText)
				responseValue=JSON.parse(responseText);
				$.each(responseValue,function(index,value1){
					$("#last_purchase_id").val(value1.purchase_master_id);
				});
			}
		});
	}
	
	function call_getProductDeatail(){
		$.ajax({
			type:"get",
			contentType:"application/json",
			url:"get-list-product-name",
			success:function(responseText){
				//alert(responseText)
				responseValue=JSON.parse(responseText);
				$.each(responseValue,function(index,value1){
					$("#"+selectProduct_id).append("<option value="+value1.product_master_id+">"+value1.product_name+"</option>");
				});
			}
			
		});
	}
	
	function call_addProductItemMaster(){
		 c=count-1;
		 q="#quantity"+c;
		 p_name="#product"+c;
	 	 jsonRequestString={"purchase_master_id":$("#last_purchase_id").val(),"product_master_id":$(p_name).val(),"quantity":$(q).val()};
		 alert(jsonRequestString.product_master_id+"   "+jsonRequestString.purchase_master_id+"  "+jsonRequestString.quantity)
		 $.ajax({
			type:"post",
			data:JSON.stringify(jsonRequestString),
			contentType:"application/json",
			dataType:"json",
			url:"add-multiple-product",
			success:function(responseText){	
			}
		});	
		addProductbtn=false;
	}
		
	$("#updatePurchase").click(function(){
			call_addProductItemMaster();
	});
	
	function call_purchase_product_item_master_history(){
	alert("item master history .......")
		c=count-1;
		q="#quantity"+c;
		p_name="#product"+c;
		jsonRequestString={"purchase_master_id":$("#last_purchase_id").val(),
			"suplier_detail_id":$("#suplier_detail_id").val(),
			"product_master_id":$(p_name).val(),
			"purchase_item_master_id":$("#last_purchase_item_master_id").val(),
			"purchase_date":$("#purchaseDate").val(),
			"product_item_quantity":$(q).val()};
		alert(jsonRequestString.product_master_id+"   "+jsonRequestString.purchase_master_id+" "+jsonRequestString.purchase_item_master_id+" "+jsonRequestString.product_item_quantity+"  "+jsonRequestString.purchase_date)
		$.ajax({
			type:"post",
			data:JSON.stringify(jsonRequestString),
			contentType:"application/json",
			dataType:"json",
			url:"add-purchase-product-item-history",
			success:function(responseText){	
			}
		});
					
	}
	
	function call_getSupplierdetail(){
		$.ajax({
			type:"get",
			contentType:"application/json",
			url:"get-list-supplier-detail",
			success:function(responseText){
				responseValue=JSON.parse(responseText);
				$.each(responseValue,function(index,value1){
					$("#suplier_detail_id").append("<option value="+value1.suplier_detail_id+">"+value1.suplier_name+"</option>");
				});
			}
			
		});
	}

});