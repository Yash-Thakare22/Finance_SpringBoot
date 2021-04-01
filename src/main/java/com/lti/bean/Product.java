package com.lti.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="prod")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PRODUCT_GEN")
    @SequenceGenerator(name="PRODUCT_GEN", sequenceName="prod_seq",allocationSize=1)
	@Column(name="product_Id")
	private  int productId;
	
	@Column(name="product_Name")
	private  String productName;
	
	@Column(name="product_Type")
	private  String productType;
	
	@Column(name="product_Cost")
	private long productCost;
	
	@Column(name="product_Details")
	private  String productDetails;

	public Product(int productId, String productName, String productType, long productCost, String productDetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productCost = productCost;
		this.productDetails = productDetails;
	}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public long getProductCost() {
		return productCost;
	}

	public void setProductCost(long productCost) {
		this.productCost = productCost;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productCost=" + productCost + ", productDetails=" + productDetails + "]";
	}

}
