package com.digimart.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.service.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.digimart.DAO.ProductCategoryDao;
import com.digimart.entity.CategoryMaster;
import com.digimart.entity.CustomerDetail;
import com.digimart.entity.Offer;
import com.digimart.entity.ProductMaster;
import com.digimart.entity.PurchaseItemMaster;
import com.digimart.entity.PurchaseMaster;
import com.digimart.entity.PurchaseProductItemMasterHistory;
import com.digimart.entity.SalesDetail;
import com.digimart.entity.Script_to_controller;
import com.digimart.entity.SearchHistory;
import com.digimart.entity.SubCategoryMaster;
import com.digimart.entity.SuplierDetailMaster;
import com.google.gson.Gson;

@Controller
public class ProductCategoryController {

	@Autowired
	private ProductCategoryDao productCategoryDAO;

	int intValue = 0;
	ModelAndView andView = null;
	String responseString = null;
	List<CategoryMaster> cattegoryList = null;
	List<SubCategoryMaster> subCattegoryList = null;
	List<ProductMaster> productMasters = null;

	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		andView = new ModelAndView("add_category");
		andView.addObject("addCategory", new CategoryMaster());
		return andView;
	}

	@RequestMapping(value = "/add-new-category", method = RequestMethod.POST)
	public String save(@ModelAttribute("addCategory") CategoryMaster categoryMaster, BindingResult result,
			@RequestParam("cattegory_photo") MultipartFile file) throws IOException {
		System.out.println(categoryMaster.getCattegory_priority());
		categoryMaster.setCattegory_photo(Base64.getEncoder().encodeToString(file.getBytes()));

		productCategoryDAO.addCategory(categoryMaster);
		return "redirect:/view-datatable";
	}

	@RequestMapping(value = "/view-datatable", method = RequestMethod.GET)
	public ModelAndView listDatatable() {
		andView = new ModelAndView("show_cattegory");
		return andView;
	}

	@RequestMapping(value = "/list-dataTable", method = RequestMethod.GET)
	@ResponseBody
	public String listCategory() {
		List<Object> l2 = productCategoryDAO.listCategory();
		Map<String, Object> m1 = new HashMap<String, Object>();
		for (Object l1 : l2) {
			m1.put("data", l1);
		}
		String s = JSONValue.toJSONString(m1);
		return s;
	}

	@RequestMapping(value = "/add-sub-category", method = RequestMethod.GET)
	public ModelAndView addSubCategory() {
		andView = new ModelAndView("add_sub_category");
		cattegoryList = productCategoryDAO.listCategoryMasters();
		Map<Integer, String> cattegoryName = new HashMap<Integer, String>();
		for (CategoryMaster categoryMaster : cattegoryList) {
			cattegoryName.put(categoryMaster.getCattegory_master_id(), categoryMaster.getCattegory_name());
		}
		andView.addObject("addsubcategory", new SubCategoryMaster());
		andView.addObject("cattegoryName", cattegoryName);
		return andView;
	}

	@RequestMapping(value = "add-new-sub-category", method = RequestMethod.POST)
	public String addNewSubCategory(@ModelAttribute("addsubcategory") SubCategoryMaster subCategoryMaster,
			BindingResult result, @RequestParam("sub_cattegory_photo") MultipartFile file)
			throws IOException, SerialException, SQLException {
		andView = new ModelAndView("sub_category");
		subCategoryMaster.setSub_cattegory_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.addSubCategory(subCategoryMaster);
		return "redirect:/list-sub-categories";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		andView = new ModelAndView("add_product");
		cattegoryList = productCategoryDAO.listCategoryMasters();
		Map<Integer, String> cattegoryName = new HashMap<Integer, String>();
		for (CategoryMaster categoryMaster : cattegoryList) {
			cattegoryName.put(categoryMaster.getCattegory_master_id(), categoryMaster.getCattegory_name());
		}
		subCattegoryList = productCategoryDAO.listSubCategory();
		Map<Integer, String> subCattegoryName = new HashMap<Integer, String>();
		for (SubCategoryMaster subCategoryMaster : subCattegoryList) {
			subCattegoryName.put(subCategoryMaster.getSub_cattegory_master_id(),
					subCategoryMaster.getSub_cattegory_name());
		}
		andView.addObject("cattegoryName", cattegoryName);
		andView.addObject("subCattegoryName", subCattegoryName);
		andView.addObject("addproduct", new ProductMaster());
		return andView;
	}

	@RequestMapping(value = "/add-new-product", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("addproduct") ProductMaster productMaster, BindingResult result,
			@RequestParam("product_photo") MultipartFile file) throws IOException {
		productMaster.setProduct_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.addProduct(productMaster);
		return "redirect:/list-prouct";
	}

	@RequestMapping(value = "/list-prouct")
	public ModelAndView productList(ProductMaster productMaster) {
		List<ProductMaster> productList = productCategoryDAO.listProduct();
		andView = new ModelAndView("list_product");
		andView.addObject("listproduct", productList);
		return andView;
	}

	@RequestMapping(value = "/edit-product/{product_master_id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int product_master_id) {
		andView = new ModelAndView("edit_product");
		ProductMaster productByid = productCategoryDAO.productByID(product_master_id);
		cattegoryList = productCategoryDAO.listCategoryMasters();
		Map<Integer, String> cattegoryName = new HashMap<Integer, String>();
		for (CategoryMaster categoryMaster : cattegoryList) {
			cattegoryName.put(categoryMaster.getCattegory_master_id(), categoryMaster.getCattegory_name());
		}
		subCattegoryList = productCategoryDAO.listSubCategory();
		Map<Integer, String> subCattegoryName = new HashMap<Integer, String>();
		for (SubCategoryMaster subCategoryMaster : subCattegoryList) {
			subCattegoryName.put(subCategoryMaster.getSub_cattegory_master_id(),
					subCategoryMaster.getSub_cattegory_name());
		}
		andView.addObject("cattegoryName", cattegoryName);
		andView.addObject("subCattegoryName", subCattegoryName);
		andView.addObject("getProductById", productByid);
		return andView;
	}

	@RequestMapping(value = "/edit-new-product", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute() ProductMaster product, BindingResult result,
			@RequestParam("product_photo") MultipartFile file) throws IOException {
		// product.setProduct_name(file.getOriginalFilename());
		product.setProduct_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.editProduct(product);
		return "redirect:/list-prouct";
	}

	@RequestMapping(value = "/edit-category/{cattegory_master_id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int cattegory_master_id) {
		andView = new ModelAndView("edit_category");
		CategoryMaster categoryByid = productCategoryDAO.categoryById(cattegory_master_id);
		andView.addObject("categoryById", categoryByid);
		return andView;
	}

	@RequestMapping(value = "/edit-new-category", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute("categoryById") CategoryMaster categoryMaster, BindingResult result,
			@RequestParam("cattegory_photo") MultipartFile file) throws IOException {
		categoryMaster.setCattegory_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.editCategory(categoryMaster);
		return "redirect:/view-datatable";
	}

	@RequestMapping(value = "/list-sub-categories")
	public ModelAndView showList() {
		andView = new ModelAndView("list_subcategory");
		List<SubCategoryMaster> subCategoryMasters = productCategoryDAO.listSubCategory();
		andView.addObject("subCategory", subCategoryMasters);
		return andView;
	}

	@RequestMapping(value = "/edit-subcategory/{sub_cattegory_master_id}", method = RequestMethod.GET)
	public ModelAndView editSubCategory(@PathVariable int sub_cattegory_master_id) {
		andView = new ModelAndView("edit_subcategory");
		SubCategoryMaster subCategoryByid = productCategoryDAO.subCategoryById(sub_cattegory_master_id);
		List<CategoryMaster> cattegoryList = productCategoryDAO.listCategoryMasters();
		Map<Integer, String> cattegoryName = new HashMap<Integer, String>();
		for (CategoryMaster categoryMaster : cattegoryList) {
			cattegoryName.put(categoryMaster.getCattegory_master_id(), categoryMaster.getCattegory_name());
		}
		andView.addObject("cattegoryName", cattegoryName);
		andView.addObject("getSubCategoryById", subCategoryByid);
		return andView;
	}

	@RequestMapping(value = "/edit-new-sub-category", method = RequestMethod.POST)
	public String editSubCategory(@ModelAttribute() SubCategoryMaster subCategoryMaster, BindingResult result,
			@RequestParam("sub_cattegory_photo") MultipartFile file) throws IOException {
		subCategoryMaster.setSub_cattegory_photo(Base64.getEncoder().encodeToString(file.getBytes()));
		productCategoryDAO.editSubCategory(subCategoryMaster);
		return "redirect:/list-sub-categories";
	}

	@RequestMapping(value = "/delete-category-by/{cattegory_master_id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable int cattegory_master_id) {
		productCategoryDAO.deleteCategory(cattegory_master_id);
		return "redirect:/view-datatable";
	}

	@RequestMapping(value = "/delete-subcategory-by/{sub_cattegory_master_id}", method = RequestMethod.GET)
	public String deleteSubCategory(@PathVariable int sub_cattegory_master_id) {
		productCategoryDAO.deleteSubCategory(sub_cattegory_master_id);
		return "redirect:/list-sub-categories";
	}

	@RequestMapping(value = "/delete-prduct-by/{product_master_id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int product_master_id) {
		productCategoryDAO.deleteProduct(product_master_id);
		return "redirect:/list-prouct";
	}

	  @RequestMapping(value = "/view-stock-datatable",method = RequestMethod.GET)
	  public ModelAndView listStockDatatable(){
		  andView=new ModelAndView("stock_datatable");
		  return andView;
	  }
		
	  @RequestMapping(value = "/list-stock-dataTable",method = RequestMethod.GET)
	  @ResponseBody
	  public String listStock() {
		  List<Object> l2=productCategoryDAO.listAllStock();
		  Map<String, Object> m1=new HashMap<String, Object>();
		  for(Object l1:l2) {
			  m1.put("data", l1);
		  }
		  String s=JSONValue.toJSONString(m1);
		  return s;
	  }
	  
//	  @RequestMapping(value="/edit-purchase/{purchase_master_id}",method = RequestMethod.GET)
//	  public ModelAndView editPurchase(@PathVariable int purchase_master_id){
//			andView=new ModelAndView("edit_purchase");
//			PurchaseMaster purchaseList=productCategoryDAO.getPurchaseById(purchase_master_id);
//			andView.addObject("editpurchase", purchaseList);
//			return andView;
//	  } 
//	  //purchase_master_id, suplier_detail_id, date
//	  @RequestMapping(value = "/edit-new-purchase",method = RequestMethod.POST)
//	  public String editNewPurchase(@ModelAttribute("editpurchase") PurchaseMaster purchaseMaster,@RequestParam("purchase_date_time") Date date) throws IOException{
//		  purchaseMaster.setDate(date);
//		  productCategoryDAO.editPurchase(purchaseMaster);
//		  return "redirect:/view-stock-datatable";
//	  }

	  @RequestMapping(value = "/add-offer",method = RequestMethod.GET)
	  public ModelAndView addOffer() {
		  andView=new ModelAndView("add_offer");
		  andView.addObject("addoffer", new Offer());
		  return andView;
	  }
	  
	  @RequestMapping(value = "/add-new-offer",method = RequestMethod.POST)
	  public String addNewOffer(@ModelAttribute("addoffer") Offer offer,@RequestParam("offer_start_date") Date startDate,@RequestParam("offer_end_date") Date endDate){
		  offer.setOffer_start_date(startDate);
		  offer.setOffer_end_date(endDate);
		  productCategoryDAO.addOffer(offer);
		  return "redirect:/listOffer";
	  }
	  
	  
	  @RequestMapping(value = "/listOffer")
	  public ModelAndView listOffer() {
		  andView=new ModelAndView("offer_list");
		  List<Offer> offerList=productCategoryDAO.getOfferList();
		  andView.addObject("offerList", offerList);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-offer/{offer_id}",method = RequestMethod.GET)
	  public ModelAndView editOffer(@PathVariable("offer_id") int offer_id) {
		  andView=new ModelAndView("edit_offer");
		  Offer offerById=productCategoryDAO.getOfferById(offer_id);
		  andView.addObject("editoffer", offerById);
		  return andView;
	  }
	  
	  @RequestMapping(value = "/edit-new-offer",method = RequestMethod.POST)
	  public String editNewOffer(@ModelAttribute("editoffer") Offer offer,@RequestParam("offer_start_date") Date startDate,@RequestParam("offer_end_date") Date endDate){
		  offer.setOffer_start_date(startDate);
		  offer.setOffer_end_date(endDate);
		  productCategoryDAO.editOffer(offer);
		  return "redirect:/listOffer";
	  }
	  
	  @RequestMapping(value = "/delete-offer/{offer_id}",method = RequestMethod.GET)
	  public String deleteOffer(@PathVariable int offer_id) {
		  productCategoryDAO.deleteOfferById(offer_id);
		  return "redirect:/listOffer";
	  }
	  
	  @RequestMapping(value = "/add-customer-detail",method = RequestMethod.GET)
	  public ModelAndView addCutomerDetail() {
		  andView=new ModelAndView("add_customer_detail");
		  andView.addObject("addcustomerdetail", new CustomerDetail());
		  return andView;
	  }
	  
	  @RequestMapping(value = "/add-new-customer-detail",method = RequestMethod.POST)
	  public ModelAndView addNewCustomerDetail(@ModelAttribute("addcustomerdetail") CustomerDetail customerDetail,BindingResult result,@RequestParam("dob") Date date){
		  customerDetail.setDob(date);
		  intValue= productCategoryDAO.addCustomerDetail(customerDetail);
		  andView=new ModelAndView("add_customer_detail");
		  if(intValue>=0) {
			  andView.addObject("msg", "Added Customer successfully ");
		  }else {
			  andView.addObject("msg", "failed");
		  }
		  return andView;
	  }
	  
//	  @RequestMapping(value = "/add-sales",method = RequestMethod.GET)
//	  public ModelAndView addSales() {
//		  andView=new ModelAndView("add_sales");
//		  List<CustomerDetail> customerDetails=productCategoryDAO.getAllCustomerName();
//		  Map<Integer, String> customers=new HashMap<Integer, String>();
//		  for(CustomerDetail customerName:customerDetails) {
//			  customers.put(customerName.getCustomer_detail_id(), customerName.getCustomer_name());
//		  }
//		  List<Product> productDetails=productCategoryDAO.listProduct();
//		  System.out.println(productDetails);
//		  Map<String, String> products=new HashMap<String, String>();
//		  for(Product productName:productDetails) {
//			  products.put(productName.getProduct_name(),productName.getProduct_name());
//		  }
//		  andView.addObject("addsales", new SalesDetail());
//		  andView.addObject("customers", customers);
//		  andView.addObject("products", products);
//		  return andView;
//	  }
//	  
//	  @RequestMapping(value = "/add-new-sales-detail",method = RequestMethod.POST)
//	  public String addNewSales(@ModelAttribute("addsales") SalesDetail salesDetail,BindingResult result,@RequestParam("datetime") Date date){
//		  System.out.println(salesDetail.getProduct_name());
//		  productCategoryDAO.addSalesDetail(salesDetail);
//		  //andView=new ModelAndView("add_sales");
//		  return "redirect:/add-sales";
//	  }
//	
	  @RequestMapping(value = "/add-supplier",method = RequestMethod.GET)
	  public ModelAndView addSuplier() {
		  andView=new ModelAndView("add_suplier");
		  andView.addObject("addsupplier", new SuplierDetailMaster());
		  return andView;
	  }
	  
	  @RequestMapping(value = "/add-new-supplier",method = RequestMethod.POST)
	  public String addNewSuplier(@ModelAttribute("addsupplier") SuplierDetailMaster suplierDetail){
		  productCategoryDAO.addSuplier(suplierDetail);
		  return "redirect:/";
	  }
	  
//	  @RequestMapping(value = "/search-history",method = RequestMethod.GET)
//	  public ModelAndView searchSalesPurchaseHistory() {
//		  andView=new ModelAndView("search_history");
//		  return andView;
//	 }
//	  
//	  @RequestMapping(value = "/search-historys",method = RequestMethod.GET)
//	  public ModelAndView searchHistory() {
//		  andView=new ModelAndView("search_history");
//		  List<CustomerDetail> customerDetails=productCategoryDAO.getAllCustomerName();
//		  Map<String, String> customers=new HashMap<String, String>();
//		  for(CustomerDetail customerName:customerDetails) {
//			  customers.put(customerName.getCustomer_name(), customerName.getCustomer_name());
//		  }
//		  List<SuplierDetail> suplierDetailsList=productCategoryDAO.getListSupplier();
//		  Map<Integer, String> suppliers=new HashMap<Integer, String>();
//		  for(SuplierDetail Suplier:suplierDetailsList) {
//			  suppliers.put(Suplier.getSuplier_detai_id(),Suplier.getSuplier_name());
//		  }
//		  andView.addObject("myForm", new SearchHistory());
//		  andView.addObject("customers", customers);
//		  andView.addObject("suppliers", suppliers);
//		  return andView;
//	  }
//	  
//	  @RequestMapping(value = "/get-sales-history",method = RequestMethod.POST)
//	  public @ResponseBody String getSalesHistory(@RequestBody SearchHistory searchHistory){
//		  System.out.println("lllllllllllllllllll");
//		  System.out.println(searchHistory.getCustomerName());
//		  System.out.println(searchHistory.getSupplierName());
//		  System.out.println(searchHistory.getToDate());
//		  System.out.println(searchHistory.getFromDate());
//		  System.out.println(searchHistory.getMobileNumber());
//		  
//		  return "hi";
//	  }
//	  
//	  
//	  @RequestMapping(value = "/get-customer-name",method = RequestMethod.GET)
//	  @ResponseBody
//	  public String getCustomerName(){
//		  System.out.println("jjjjjjjjjjjjjjjjjjjj");
//		  Gson gson=new Gson();
//		  responseString=gson.toJson(productCategoryDAO.getCustomerName());
//		  return responseString;
//	  }
//	  @RequestMapping(value = "/get-supplier-name",method = RequestMethod.GET)
//	  @ResponseBody
//	  public String getSupplierName(){
//		  System.out.println("kkkkkkkkkkkkkkkkkkkk");
//		  Gson gson=new Gson();
//		  responseString=gson.toJson(productCategoryDAO.getSupplierName());
//		  return responseString;
//	  }
//	 
//	  
//	  

	@RequestMapping(value = "/get-list-supplier-detail", method = RequestMethod.GET)
	@ResponseBody
	public String getListSupplierName() {
		//System.out.println("sssssssssssss");
		Gson gson = new Gson();
		responseString = gson.toJson(productCategoryDAO.getListSupplier());
		return responseString;
	}

	@RequestMapping(value = "/get-list-product-name", method = RequestMethod.GET)
	@ResponseBody
	public String getListProductName() {
		//System.out.println("kkkkkkkkkkkkkkkkkkkk");
		Gson gson = new Gson();
		responseString = gson.toJson(productCategoryDAO.getProductelist());
		return responseString;
	}

	@RequestMapping(value = "/add-purchase", method = RequestMethod.GET)
	public ModelAndView addPurchase() {
		andView = new ModelAndView("add_purchase");
		return andView;
	}

	@RequestMapping(value = "/add-new-purchase", method = RequestMethod.POST)
	public @ResponseBody String addNewPurchase(@RequestBody PurchaseMaster purchaseMaster, HttpServletRequest request)
			throws IOException {
		//System.out.println("add new purchase ");
		//System.out.println(purchaseMaster.getSuplier_detail_id());
		//System.out.println(purchaseMaster.getPurchaseDate());
		productCategoryDAO.addPurchaseMaster(purchaseMaster);
		return "hi";
	}

	@RequestMapping(value = "/add-new-update-purchase", method = RequestMethod.POST)
	@ResponseBody
	public String updateNewPurchaseItemMaster(@RequestBody PurchaseItemMaster purchaseItemMaster) {
		// productCategoryDAO.addPurchaseItemMaster(purchaseItemMaster);
		return "";
	}

	@RequestMapping(value = "/get-last-purchase-id", method = RequestMethod.GET)
	@ResponseBody
	public String getlastpurchaseId() {
		System.out.println("last purchase..........");
		Gson gson = new Gson();
		responseString = gson.toJson(productCategoryDAO.getlastPurchaseDetail());
		//System.out.println("list data purchase id " + responseString);
		return responseString;
	}
	
	@RequestMapping(value = "/get-last-purchase-item-master-id", method = RequestMethod.GET)
	@ResponseBody
	public String getlastpurchaseItemMasterId() {
		//System.out.println("last purchase..........");
		Gson gson = new Gson();
		responseString = gson.toJson(productCategoryDAO.getLastPurchaseItemMaster());
		//System.out.println("list data purchase id " + responseString);
		return responseString;
	}

	@RequestMapping(value = "/add-multiple-product", method = RequestMethod.POST)
	public @ResponseBody String addNewPurchaseItemMaster(@RequestBody PurchaseItemMaster purchaseItemMaster) {
		//System.out.println("item master");
		//System.out.println(purchaseItemMaster.getQuantity());
		//System.out.println(purchaseItemMaster.getProduct_master_id());
		//System.out.println(purchaseItemMaster.getPurchase_master_id());
		productCategoryDAO.addPurchaseItemMaster(purchaseItemMaster);
		return "hi";
	}

	@RequestMapping(value = "/add-purchase-product-item-history", method = RequestMethod.POST)
	public @ResponseBody String addNewPurchaseProductItemMaster(@RequestBody PurchaseProductItemMasterHistory purchaseProductItemMasterHistory) {
		System.out.println(purchaseProductItemMasterHistory.getPurchase_master_id());
		System.out.println(purchaseProductItemMasterHistory.getSuplier_detail_id());
		System.out.println(purchaseProductItemMasterHistory.getProduct_master_id());
		System.out.println(purchaseProductItemMasterHistory.getPurchase_item_master_id());
		System.out.println(purchaseProductItemMasterHistory.getProduct_item_quantity());
		System.out.println(purchaseProductItemMasterHistory.getPurchase_date());
		//productCategoryDAO.addPurchaseProductIemMaster(purchaseProductItemMasterHistory);
		return "hi";
	}

	
	@RequestMapping(value = "/list-purchase-product-item")
	public ModelAndView listPurchaseItemMaster() {
		andView = new ModelAndView("list_purchase_item_master");
		List<PurchaseItemMaster> purchaseItemMasters = productCategoryDAO.listPurchaseItemMasters();
		andView.addObject("purchaseItemMasters", purchaseItemMasters);
		return andView;
	}

	@RequestMapping(value = "/edit-purchase-product-item/{purchase_item_master_id}", method = RequestMethod.GET)
	public ModelAndView editProductItem(@PathVariable int purchase_item_master_id) {
		andView = new ModelAndView("edit_purchase_product_item");
		PurchaseItemMaster purchaseItemMaster = productCategoryDAO.getPurchaseItemById(purchase_item_master_id);
		System.out.println("list by id " + purchaseItemMaster.getProduct_master_id());
		List<ProductMaster> productMasters = productCategoryDAO.getProductelist();
		System.out.println("list product " + productMasters.get(0).getProduct_name());
		Map<Integer, String> productName = new HashMap<Integer, String>();
		System.out.println(productName);
		for (ProductMaster productMaster : productMasters) {
			productName.put(productMaster.getProduct_master_id(), productMaster.getProduct_name());
			System.out.println("map value " + productName);
		}
		andView.addObject("purchaseItemMaster", purchaseItemMaster);
		andView.addObject("productName", productName);
		return andView;
	}

	@RequestMapping(value = "/edit-new-purchase-product-item", method = RequestMethod.POST)
	public String editNewPurchaseProductitem(@ModelAttribute("purchaseItemMaster") PurchaseItemMaster purchaseItemMaster) {
		productCategoryDAO.editPurchaseItemMaster(purchaseItemMaster);
		return "redirect:/list-purchase-product-item";
	}

	
	@RequestMapping(value ="/delete-purchase-product-item/{purchase_item_master_id}",method =RequestMethod.GET) 
	public String deleteProductitemMaster(@PathVariable int purchase_item_master_id) {
		productCategoryDAO.deletePurchaseItemMaster(purchase_item_master_id);
		return "redirect:/list-purchase-product-item"; 
	}

//	  @RequestMapping(value = "/script-controller",method = RequestMethod.GET)
//	  public ModelAndView scriptToController() {
//		  andView=new ModelAndView("script_to_controller_to_script");
//		  andView.addObject("p", new Script_to_controller());
//		  return andView;
//	}
//	  
//	  @RequestMapping(value = "/script-controller-passed",method = RequestMethod.POST)
//	  public @ResponseBody String scriptToControllerPassed(@RequestBody Script_to_controller script_to_controller) {
//		  //andView=new ModelAndView("script_to_controller_to_script");
//		  System.out.println("pppppppppppppppp");
//		  System.out.println(script_to_controller.getName());
//		  System.out.println("kkkkkkkkkkkkkkkkkk");
//		  return "hello ahmad raza";
//	}

	@RequestMapping(value = "/try-blur", method = RequestMethod.GET)
	public ModelAndView tryblur() {
		andView = new ModelAndView("blur_try");
		return andView;
	}

}
