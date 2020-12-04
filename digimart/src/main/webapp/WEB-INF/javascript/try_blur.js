$(document).ready(function(){
	alert("on load j")
	//call_getSupplierdetail();
	var count = 1;
	$("#addproduct").click(function() {
    	var addrows = '<tr><td>' + count + '</td><td><select id="product_' + count + '"></select></td><td><input type="text" id="qty_' + count + '" name="qty_' + count + '" /></td>';
   		$("#addRow").append(addrows);

    	$('#qty_' + count).blur(function() {
      		alert("cal  bulur on each text box ");
    	});
    	count = count + 1;
	});
});