package com.digimart.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.digimart.entity.AdminEntity;
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

public class ProductCategoryDAOImplimentation implements ProductCategoryDao{

	private JdbcTemplate template;
	//private SimpleJdbcCall simpleJdbcCall;
	private String sql="";
	public ProductCategoryDAOImplimentation(DataSource dataSource) {
		template=new JdbcTemplate(dataSource);
		//simpleJdbcCall=new SimpleJdbcCall(dataSource);
	}
	
	public void setTemplate(JdbcTemplate template/* ,SimpleJdbcCall simpleJdbcCall */) {    
	    this.template = template;  
	   // this.simpleJdbcCall=simpleJdbcCall;
	}    
	
	
	@Override
	public int addCategory(CategoryMaster categoryMaster) {
		sql="insert into cattegory_master(cattegory_name, cattegory_priority, cattegory_description, cattegory_photo)values('"+categoryMaster.getCattegory_name()+"','"+categoryMaster.getCattegory_priority()+"','"+categoryMaster.getCattegory_description()+"','"+categoryMaster.getCattegory_photo()+"')";    
		return template.update(sql);
	}
	
	@Override
	public int addSubCategory(SubCategoryMaster subCategoryMaster) {
		sql="insert into sub_cattegory_master(cattegory_master_id, sub_cattegory_name, sub_cattegory_photo)values("+subCategoryMaster.getCattegory_master_id()+",'"+subCategoryMaster.getSub_cattegory_name()+"','"+subCategoryMaster.getSub_cattegory_photo()+"')";
		return template.update(sql);
	}

	@Override
	public int addProduct(ProductMaster productMaster) {
		sql="insert into product_master(cattegory_master_id, sub_cattegory_master_id, product_name, product_description, product_prise, product_photo, product_expiry_date, product_manufacture_date, product_company_name, product_discount_type, product_discount)values("+productMaster.getCattegory_master_id()+","+productMaster.getSub_cattegory_master_id()+",'"+productMaster.getProduct_name()+"','"+productMaster.getProduct_description()+"',"+productMaster.getProduct_prise()+",'"+productMaster.getProduct_photo()+"','"+productMaster.getProduct_expiry_date()+"','"+productMaster.getProduct_manufacture_date()+"','"+productMaster.getProduct_company_name()+"','"+productMaster.getProduct_discount_type()+"',"+productMaster.getProduct_discount()+")";
		return template.update(sql);
	}


	@Override
	public List<Object> listCategory() {
			sql="select * from cattegory_master";
			return template.query(sql,new RowMapper<Object>() {
				List<Map<Object, String>> list=new ArrayList<Map<Object,String>>();
				public Object mapRow(ResultSet rs,int row) throws SQLException{
					ResultSetMetaData resultSetMetaData=rs.getMetaData();
					int countColumn=resultSetMetaData.getColumnCount();	
					if(rs!=null){
							Map<Object, String> resultHashMap1=new HashMap<Object, String>();
							for(int i=1;i<=countColumn;i++) {
								resultHashMap1.put(resultSetMetaData.getColumnName(i),rs.getString(i));
							}
							list.add(resultHashMap1);
						}
					return list;
				}
		});
	}

	@Override
	public List<CategoryMaster> listCategoryMasters() {
		sql="select * from cattegory_master";
		return template.query(sql, new RowMapper<CategoryMaster>() {
			@Override
			public CategoryMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryMaster categoryMaster=new CategoryMaster();
				categoryMaster.setCattegory_master_id(rs.getInt("cattegory_master_id"));
				categoryMaster.setCattegory_name(rs.getString("cattegory_name"));
				categoryMaster.setCattegory_priority(rs.getString("cattegory_priority"));
				categoryMaster.setCattegory_description(rs.getString("cattegory_description"));
				categoryMaster.setCattegory_photo(rs.getString("cattegory_photo"));
				return categoryMaster;
			}
			
		});
	}
	
	
	@Override
	public List<SubCategoryMaster> listSubCategory() {
		sql="select sub_cattegory_master_id, catt_master.cattegory_name,sub_catt_master.cattegory_master_id,"
				+ " sub_catt_master.sub_cattegory_name, sub_catt_master.sub_cattegory_photo from sub_cattegory_master sub_catt_master inner join"
				+ " cattegory_master catt_master where catt_master.cattegory_master_id=sub_catt_master.cattegory_master_id";
		return template.query(sql, new RowMapper<SubCategoryMaster>(){
			@Override
			public SubCategoryMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				SubCategoryMaster subCategoryMaster=new SubCategoryMaster();
				subCategoryMaster.setSub_cattegory_master_id(rs.getInt("sub_cattegory_master_id"));
				subCategoryMaster.setCattegory_name(rs.getString("cattegory_name"));
				subCategoryMaster.setCattegory_master_id(rs.getInt("cattegory_master_id"));
				subCategoryMaster.setSub_cattegory_name(rs.getString("sub_cattegory_name"));
				subCategoryMaster.setSub_cattegory_photo(rs.getString("sub_cattegory_photo"));
				return subCategoryMaster;
			}
		});
	}
	
	@Override
	public List<ProductMaster> listProduct() {
		sql="select catt_master.cattegory_master_id,sub_catt_master.sub_cattegory_master_id,catt_master.cattegory_name,sub_catt_master.sub_cattegory_name,prod_master.product_master_id,prod_master.product_name,prod_master.product_description,"
				+ "prod_master.product_prise,prod_master.product_photo,prod_master.product_expiry_date,prod_master.product_manufacture_date,prod_master.product_company_name,"
				+ "prod_master.product_discount_type,prod_master.product_discount "
				+ "from product_master prod_master "
				+ "inner join cattegory_master catt_master on catt_master.cattegory_master_id=prod_master.cattegory_master_id "
				+ "inner join sub_cattegory_master sub_catt_master on sub_catt_master.sub_cattegory_master_id=prod_master.sub_cattegory_master_id and catt_master.cattegory_master_id=prod_master.cattegory_master_id ";
		return template.query(sql, new RowMapper<ProductMaster>(){
			@Override
			public ProductMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductMaster productMaster=new ProductMaster();
				productMaster.setProduct_master_id(rs.getInt("product_master_id"));
				productMaster.setCattegory_master_id(rs.getInt("cattegory_master_id"));
				productMaster.setCattegory_name(rs.getString("cattegory_name"));
				productMaster.setSub_cattegory_name(rs.getString("sub_cattegory_name"));
				productMaster.setSub_cattegory_master_id(rs.getInt("sub_cattegory_master_id"));
				productMaster.setProduct_name(rs.getString("product_name"));
				productMaster.setProduct_description(rs.getString("product_description"));
				productMaster.setProduct_prise(rs.getInt("product_prise"));
				productMaster.setProduct_photo(rs.getString("product_photo"));
				productMaster.setProduct_expiry_date(rs.getDate("product_expiry_date"));
				productMaster.setProduct_manufacture_date(rs.getDate("product_manufacture_date"));
				productMaster.setProduct_company_name(rs.getString("product_company_name"));
				productMaster.setProduct_discount_type(rs.getString("product_discount_type"));
				productMaster.setProduct_discount(rs.getInt("product_discount"));
				return productMaster;
			}
			
		});
	}

	
//	
	@Override
	public CategoryMaster categoryById(int cattegory_master_id) {
		sql="select * from cattegory_master where cattegory_master_id=?";
		return template.queryForObject(sql, new Object[]{cattegory_master_id},new BeanPropertyRowMapper<CategoryMaster>(CategoryMaster.class));
	}
	
	@Override
	public SubCategoryMaster subCategoryById(int sub_cattegory_master_id) {
		sql="select * from sub_cattegory_master where sub_cattegory_master_id=?";
		return template.queryForObject(sql, new Object[]{sub_cattegory_master_id},new BeanPropertyRowMapper<SubCategoryMaster>(SubCategoryMaster.class));
	}
	
	@Override
	public ProductMaster productByID(int product_master_id) {
		sql="select * from product_master where product_master_id=?";
		return template.queryForObject(sql, new Object[]{product_master_id},new BeanPropertyRowMapper<ProductMaster>(ProductMaster.class));
	}

	@Override
	public int editCategory(CategoryMaster categoryMaster) { 
		sql="update cattegory_master set cattegory_name='"+categoryMaster.getCattegory_name()+"', cattegory_priority='"+categoryMaster.getCattegory_priority()+"', cattegory_description='"+categoryMaster.getCattegory_description()+"', cattegory_photo='"+categoryMaster.getCattegory_photo()+"' where cattegory_master_id="+categoryMaster.getCattegory_master_id();
		return template.update(sql);
	}
	
	@Override
	public int editSubCategory(SubCategoryMaster subCategoryMaster) {
		sql="update sub_cattegory_master set cattegory_master_id="+subCategoryMaster.getCattegory_master_id()+",sub_cattegory_name='"+subCategoryMaster.getSub_cattegory_name()+"',sub_cattegory_photo='"+subCategoryMaster.getSub_cattegory_photo()+"' where sub_cattegory_master_id="+subCategoryMaster.getSub_cattegory_master_id();
		return template.update(sql);
	}
			
	@Override
	public int editProduct(ProductMaster productMaster) {
		sql="update product_master set cattegory_master_id="+productMaster.getCattegory_master_id()+" ,sub_cattegory_master_id="+productMaster.getSub_cattegory_master_id()+",product_name='"+productMaster.getProduct_name()+"',product_description='"+productMaster.getProduct_description()+"',product_prise="+productMaster.getProduct_prise()+",product_photo='"+productMaster.getProduct_photo()+"',product_expiry_date='"+productMaster.getProduct_expiry_date()+"',product_manufacture_date='"+productMaster.getProduct_manufacture_date()+"',product_company_name='"+productMaster.getProduct_company_name()+"',product_discount_type='"+productMaster.getProduct_discount_type()+"',product_discount='"+productMaster.getProduct_discount()+"' where product_master_id="+productMaster.getProduct_master_id();
		return template.update(sql);
	}

	@Override
	public void deleteCategory(int cattegory_master_id) {
		sql="delete from cattegory_master where cattegory_master_id=?";
		template.update(sql,cattegory_master_id);
	}
	
	@Override
	public void deleteSubCategory(int sub_cattegory_master_id) {
		sql="delete from sub_cattegory_master where sub_cattegory_master_id=?";
		template.update(sql, sub_cattegory_master_id);
	}

	@Override
	public void deleteProduct(int product_master_id) {
		sql="delete from product_master where product_master_id=?";
		template.update(sql, product_master_id);
	}

	@Override
	public int addPurchaseDetai(PurchaseMaster purchase) {
		String sql="insert into purchase(product_name, company_name, amount, date_time,number_product)values()";
		return template.update(sql);
	}

	@Override
	public List<Object> listAllStock() {
		sql="select prod_m.product_name,sum(pim.quantity) as total_quantity,sup_d.suplier_name,prod_m.product_company_name,prod_m.product_prise,prod_m.product_photo,pm.purchaseDate from purchase_item_master pim inner join purchase_master pm on pm.purchase_master_id=pim.purchase_master_id"
				+ " inner join product_master prod_m on prod_m.product_master_id=pim.product_master_id"
				+ " inner join suplier_detail_master sup_d on sup_d.suplier_detail_id=pm.suplier_detail_id group by sup_d.suplier_detail_id";
		return template.query(sql,new RowMapper<Object>() {
			List<Map<Object, String>> list=new ArrayList<Map<Object,String>>();
			public Object mapRow(ResultSet rs,int row) throws SQLException{
				ResultSetMetaData resultSetMetaData=rs.getMetaData();
				int countColumn=resultSetMetaData.getColumnCount();	
				if(rs!=null){
						Map<Object, String> resultHashMap1=new HashMap<Object,
								 String>();
						for(int i=1;i<=countColumn;i++) {
							resultHashMap1.put(resultSetMetaData.getColumnName(i),rs.getString(i));
						}
						list.add(resultHashMap1);
					}
				return list;
			}
		});

	}

	@Override
	public PurchaseMaster getPurchaseById(int purchase_id) {
		sql="select * from purchase where purchase_id=?";
		return template.queryForObject(sql, new Object[] {purchase_id},new BeanPropertyRowMapper<PurchaseMaster>(PurchaseMaster.class));
	}

	@Override
	public int editPurchase(PurchaseMaster purchase) {
		sql="";//update purchase set product_name='"++"', company_name='"+purchase.getCompany_name()+"', amount='"+purchase.getAmount()+"', date_time='"+purchase.getDate_time()+"',number_product='"+purchase.getNumber_product()+"' where purchase_id="+purchase.getPurchase_id();
		return template.update(sql);
	}

	@Override
	public int addOffer(Offer offer) {
		sql="insert into offer(offer_name, offer_start_date, offer_end_date, offer_description, offer_code)values('"+offer.getOffer_name()+"','"+offer.getOffer_start_date()+"','"+offer.getOffer_end_date()+"','"+offer.getOffer_description()+"','"+offer.getOffer_code()+"')";
		return template.update(sql);
	}

	@Override
	public Offer getOfferById(int offer_id) {
		sql="select * from offer where offer_id=?";
		return template.queryForObject(sql,new Object[] {offer_id}, new BeanPropertyRowMapper<Offer>(Offer.class));
	}

	@Override
	public int editOffer(Offer offer) {
		sql="update offer set offer_name='"+offer.getOffer_name()+"', offer_start_date='"+offer.getOffer_start_date()+"', offer_end_date='"+offer.getOffer_end_date()+"', offer_description='"+offer.getOffer_description()+"', offer_code='"+offer.getOffer_code()+"' where offer_id="+offer.getOffer_id();
		return template.update(sql);
	}

	@Override
	public List<Offer> getOfferList() {
		sql="select * from offer";
		return template.query(sql,new RowMapper<Offer>() {
			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offerList=new Offer();
				offerList.setOffer_id(rs.getInt("offer_id"));
				offerList.setOffer_name(rs.getString("offer_name"));
				offerList.setOffer_start_date(rs.getDate("offer_start_date"));
				offerList.setOffer_end_date(rs.getDate("offer_end_date"));
				offerList.setOffer_description(rs.getString("offer_description"));
				offerList.setOffer_code(rs.getString("offer_code"));
				return offerList;
			}
		});
	}
	
	@Override
	public void deleteOfferById(int offer_id) {
		sql="delete from offer where offer_id=?";
		template.update(sql,new Object[] {offer_id});
	}

	@Override
	public int addCustomerDetail(CustomerDetail customerDetail) {
		sql="insert into customer_detail(customer_name, gender, dob, email, mobile_number)values('"+customerDetail.getCustomer_name()+"','"+customerDetail.getGender()+"','"+customerDetail.getDob()+"','"+customerDetail.getEmail()+"','"+customerDetail.getMobile_number()+"')";
		return template.update(sql);
	}
	
	@Override
	public int addSuplier(SuplierDetailMaster suplierDetailMaster) {
		sql="insert into suplier_detail_master(suplier_name,suplier_email,suplier_mobileno)values('"+suplierDetailMaster.getSuplier_name()+"','"+suplierDetailMaster.getSuplier_email()+"','"+suplierDetailMaster.getSuplier_mobileno()+"')";
		return template.update(sql);
	}
//
//	@Override
//	public int addSalesDetail(SalesDetail salesDetail) {
//		sql="insert into sales(customer_detail_id, product_name, suplier_name, mobile_number, datetime, total_ammount)values('"+salesDetail.getSales_name()+"','"+salesDetail.getProduct_name()+"','"+salesDetail.getSuplier_name()+"','"+salesDetail.getMobile_number()+"','"+salesDetail.getDatetime()+"','"+salesDetail.getTotal_ammount()+"')";
//		return template.update(sql);
//	}
//
	@Override
	public List<CustomerDetail> getAllCustomerName() {
		sql="select * from customer_detail";
		return template.query(sql,new RowMapper<CustomerDetail>() {

			@Override
			public CustomerDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerDetail customerDetail=new CustomerDetail();
				customerDetail.setCustomer_detail_id(rs.getInt("customer_detail_id"));
				customerDetail.setCustomer_name(rs.getString("customer_name"));
				return customerDetail;
			}
		});
	}

	@Override
	public List<SuplierDetailMaster> getListSupplier() {
		sql="select * from suplier_detail_master";
		return template.query(sql, new RowMapper<SuplierDetailMaster>() {
			@Override 
			public SuplierDetailMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				SuplierDetailMaster suplierDetail=new SuplierDetailMaster();
				suplierDetail.setSuplier_detail_id(rs.getInt("suplier_detail_id"));
				suplierDetail.setSuplier_name(rs.getString("suplier_name"));
				suplierDetail.setSuplier_email(rs.getString("suplier_email"));
				suplierDetail.setSuplier_mobileno(rs.getString("suplier_mobileno"));
				System.out.println(suplierDetail.getSuplier_detail_id()+"  "+suplierDetail.getSuplier_name());
				return suplierDetail;
			}
			
		});
	}

	@Override
	public List<CustomerDetail> getCustomerName() {
		sql="select * from customer_detail";
		return template.query(sql,new RowMapper<CustomerDetail>() {

			@Override
			public CustomerDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerDetail customerDetail=new CustomerDetail();
				//customerDetail.setCustomer_detail_id(rs.getInt("customer_detail_id"));
				customerDetail.setCustomer_name(rs.getString("customer_name"));
				return customerDetail;
			}
		});
	}

	@Override
	public List<ProductMaster> getProductelist() {
		sql="select catt_master.cattegory_master_id,sub_catt_master.sub_cattegory_master_id,catt_master.cattegory_name,sub_catt_master.sub_cattegory_name,prod_master.product_master_id,prod_master.product_name,prod_master.product_description,"
				+ "prod_master.product_prise,prod_master.product_photo,prod_master.product_expiry_date,prod_master.product_manufacture_date,prod_master.product_company_name,"
				+ "prod_master.product_discount_type,prod_master.product_discount "
				+ "from product_master prod_master "
				+ "inner join cattegory_master catt_master on catt_master.cattegory_master_id=prod_master.cattegory_master_id "
				+ "inner join sub_cattegory_master sub_catt_master on sub_catt_master.sub_cattegory_master_id=prod_master.sub_cattegory_master_id and catt_master.cattegory_master_id=prod_master.cattegory_master_id ";
		return template.query(sql, new RowMapper<ProductMaster>(){
			@Override
			public ProductMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductMaster productMaster=new ProductMaster();
				productMaster.setProduct_master_id(rs.getInt("product_master_id"));
				productMaster.setProduct_name(rs.getString("product_name"));
			//	System.out.println(productMaster.getProduct_name());
			//	System.out.println(productMaster);
				return productMaster;
			}
			
		});
	}

	@Override
	public int addPurchaseMaster(PurchaseMaster purchaseMaster) {
		//purchase_master_id, 
		sql="insert into purchase_master(suplier_detail_id,purchaseDate)values("+purchaseMaster.getSuplier_detail_id()+",'"+purchaseMaster.getPurchaseDate()+"')";
		return template.update(sql);
	}
	
	@Override
	public int addPurchaseItemMaster(PurchaseItemMaster purchaseItemMaster) {
		//purchase_item_master_id
		sql="insert into purchase_item_master(purchase_master_id,product_master_id, quantity)values("+purchaseItemMaster.getPurchase_master_id()+","+purchaseItemMaster.getProduct_master_id()+","+purchaseItemMaster.getQuantity()+")";
		return template.update(sql);
	}

	@Override
	public List<PurchaseMaster> getlastPurchaseDetail() {
		sql="select * from purchase_master order by purchase_master_id desc limit 1";
		return template.query(sql, new RowMapper<PurchaseMaster>(){
			@Override
			public PurchaseMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseMaster purchaseMaster=new PurchaseMaster();
				purchaseMaster.setPurchase_master_id(rs.getInt("purchase_master_id"));
				purchaseMaster.setSuplier_detail_id(rs.getInt("suplier_detail_id"));
				purchaseMaster.setPurchaseDate(rs.getString("purchaseDate"));
				return purchaseMaster;
			}
			
		});
	}

	@Override
	public PurchaseItemMaster getPurchaseItemById(int purchase_item_master_id) {
		sql="select purchase_item_master_id, product_master_id, quantity from purchase_item_master where purchase_item_master_id=?";
		//System.out.println(sql);
		return template.queryForObject(sql, new Object[] {purchase_item_master_id}, new BeanPropertyRowMapper<PurchaseItemMaster>(PurchaseItemMaster.class));
	}

	@Override
	public List<PurchaseItemMaster> listPurchaseItemMasters() {
		sql="select pim.purchase_item_master_id,pim.purchase_master_id,pm.product_name,pim.quantity from purchase_item_master pim inner join product_master pm on pm.product_master_id=pim.product_master_id";
		return template.query(sql, new RowMapper<PurchaseItemMaster>() {
			@Override
			public PurchaseItemMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseItemMaster purchaseItemMaster=new PurchaseItemMaster();
				purchaseItemMaster.setPurchase_item_master_id(rs.getInt("purchase_item_master_id"));
				purchaseItemMaster.setPurchase_master_id(rs.getInt("purchase_master_id"));
				purchaseItemMaster.setProduct_name(rs.getString("product_name"));
				purchaseItemMaster.setQuantity(rs.getInt("quantity"));
				return purchaseItemMaster;
			}
		});
	}

	@Override
	public int editPurchaseItemMaster(PurchaseItemMaster purchaseItemMaster) {
		sql="update purchase_item_master set product_master_id="+purchaseItemMaster.getProduct_master_id()+", quantity="+purchaseItemMaster.getQuantity()+" where purchase_item_master_id="+purchaseItemMaster.getPurchase_item_master_id();
		return template.update(sql);
	}

	@Override
	public void deletePurchaseItemMaster(int purchase_item_master_id) {
		sql="delete from purchase_item_master where purchase_item_master_id=?";
		template.update(sql,new Object[] {purchase_item_master_id});
		
	}

	@Override
	public List<PurchaseItemMaster> getLastPurchaseItemMaster() {
		sql=" select * from purchase_item_master order by purchase_item_master_id desc limit 1";
		return template.query(sql, new RowMapper<PurchaseItemMaster>(){
			@Override
			public PurchaseItemMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchaseItemMaster purchaseItemMaster=new PurchaseItemMaster();
				purchaseItemMaster.setPurchase_item_master_id(rs.getInt("purchase_item_master_id"));
				System.out.println(purchaseItemMaster.getPurchase_item_master_id());
				return purchaseItemMaster;
			}
		});
	}

	@Override //purchase_product_item_master_id
	public int addPurchaseProductIemMaster(PurchaseProductItemMasterHistory purProdItemHistory) {
		sql="insert into purchase_product_item_master(purchase_master_id, suplier_detail_id, product_master_id, purchase_item_master_id, product_item_quantity,purchase_date)values("+purProdItemHistory.getPurchase_master_id()+","+purProdItemHistory.getSuplier_detail_id()+","+purProdItemHistory.getProduct_master_id()+","+purProdItemHistory.getPurchase_item_master_id()+","+purProdItemHistory.getProduct_item_quantity()+",'"+purProdItemHistory.getPurchase_date()+"')";
		return template.update(sql);
	}

	

//	@Override
//	public List<SalesDetail> getSupplierName() {
//		sql="select * from sales";
//		return template.query(sql, new RowMapper<SalesDetail>() {
//			@Override
//			public SalesDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
//				SalesDetail salesDetail=new SalesDetail();
//				salesDetail.setSuplier_name(rs.getString("suplier_name"));
//				return salesDetail;
//			}
//			
//		});
//	}
//
//	@Override
//	public List<Object> getByField(SearchHistory searchHistory) {
//		System.out.println(searchHistory.getSupplierName());
//		if(searchHistory.getSupplierName().isEmpty()) {
//			sql="";
//		}else {
//			sql="select * from sales where mobile_number="+searchHistory.getMobileNumber();
//		}
//		return template.query(sql, new RowMapper<Object>() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				List<Map<Object, String>> list1= new ArrayList<Map<Object,String>>();
//				ResultSetMetaData resultSetMetaData=rs.getMetaData();
//				int countColumn=resultSetMetaData.getColumnCount();	
//				if(rs!=null){
//						Map<Object, String> resultHashMap1=new HashMap<Object,
//								 String>();
//						for(int i=1;i<=countColumn;i++) {
//							resultHashMap1.put(resultSetMetaData.getColumnName(i),rs.getString(i));
//						}
//						list1.add(resultHashMap1);
//					}
//
//				return list1;
//			}
//			
//		});
//		
//	}

}
