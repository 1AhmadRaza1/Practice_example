package com.digimart.DAO;

import java.util.List;
import java.util.Map;

import com.digimart.entity.CategoryMaster;
import com.digimart.entity.CustomerDetail;
import com.digimart.entity.Offer;
import com.digimart.entity.PracticeImage;
import com.digimart.entity.ProductMaster;
import com.digimart.entity.PurchaseItemMaster;
import com.digimart.entity.PurchaseMaster;
import com.digimart.entity.PurchaseProductItemMasterHistory;
import com.digimart.entity.SalesDetail;
import com.digimart.entity.SearchHistory;
import com.digimart.entity.SubCategoryMaster;
import com.digimart.entity.SuplierDetailMaster;

public interface ProductCategoryDao {

	public int addCategory(CategoryMaster categoryMaster);
	public int addSubCategory(SubCategoryMaster subCategoryMaster);
	public int addProduct(ProductMaster productMaster);
	public List<CategoryMaster> listCategoryMasters();
	public List<Object> listCategory();
	public List<SubCategoryMaster> listSubCategory();
	public List<ProductMaster> listProduct();
	public int editSubCategory(SubCategoryMaster subCategoryMaster);
	public int editCategory(CategoryMaster categoryMaster);
	public int editProduct(ProductMaster productMaster);
	public CategoryMaster categoryById(int category_id);
	public SubCategoryMaster subCategoryById(int sub_cattegory_master_id);
	public ProductMaster productByID(int product_master_id);
	public void deleteCategory(int cattegory_master_id);
	public void deleteSubCategory(int sub_cattegory_master_id);
	public void deleteProduct(int product_master_id);
	public int addPurchaseDetai(PurchaseMaster purchase);
	public List<Object> listAllStock();
	public PurchaseMaster getPurchaseById(int purchase_id);
	public int editPurchase(PurchaseMaster purchase);
	public int addOffer(Offer offer);
	public Offer getOfferById(int offer_id);
	public int editOffer(Offer offer);
	public List<Offer> getOfferList();
	public void deleteOfferById(int offer_id);
	public int addCustomerDetail(CustomerDetail customerDetail);
	public List<CustomerDetail> getAllCustomerName();
//	public int addSalesDetail(SalesDetail salesDetail);
	public List<SuplierDetailMaster> getListSupplier();
	public List<CustomerDetail> getCustomerName();
//	public List<SalesDetail> getSupplierName();
//	public List<Object> getByField(SearchHistory searchHistory);
	public int addSuplier(SuplierDetailMaster suplierDetail);
	public List<ProductMaster> getProductelist();
	public int addPurchaseMaster(PurchaseMaster purchaseMaster);
	public List<PurchaseMaster> getlastPurchaseDetail();
	public int addPurchaseItemMaster(PurchaseItemMaster purchaseItemMaster);
	public List<PurchaseItemMaster> getLastPurchaseItemMaster();
	public PurchaseItemMaster getPurchaseItemById(int purchase_item_master_id);
	public List<PurchaseItemMaster> listPurchaseItemMasters();
	public int editPurchaseItemMaster(PurchaseItemMaster purchaseItemMaster);
	public void deletePurchaseItemMaster(int purchase_item_master_id);
	public int addPurchaseProductIemMaster(PurchaseProductItemMasterHistory purchaseProductItemMasterHistory);
}
