$(document).ready(function(){
	alert("on load")
	$('#example1').DataTable( {
		//"processing": true,
        "serverSide": true, 
		"lengthMenu": [3, 5, 10],
        "ajax": {            
			//"type": "POST",
            "url": "list-stock-dataTable",
			"dataType":"json"
        },
        "columns": [
        	{ "data": "suplier_name"},
            { "data": "product_name"},
            { "data": "product_company_name"},
            { "data": "total_quantity"},
            { "data": "product_prise"},
			{"data":"purchaseDate"},
			{"data":"product_photo",
				render: function (data, type, row, meta) {
        			var imgsrc = 'data:image/jpg;base64,' + data;
        			return '<img src="' + imgsrc +'" height="100px" width="100px">';
    			}
			}
        ]
	});
});
