package com.gold.backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="ID_PRODUCT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_PRODUCT;

	@Column(name="name_product", length=17, nullable=false)
	private String NAME_PRODUCT;

	@Column(name="description_product", length=30)
	private String DESCRIPTION_PRODUCT;

	@Column(name="AMOUNT_PRODUCT")
	private Integer AMOUNT_PRODUCT;

	@Column(name="price_product")
	private float PRICE_PRODUCT;

	public Product(Integer ID_PRODUCT, String NAME_PRODUCT, String DESCRIPTION_PRODUCT, Integer AMOUNT_PRODUCT,
			float PRICE_PRODUCT) {
		super();
		this.AMOUNT_PRODUCT  = ID_PRODUCT;
		this.NAME_PRODUCT = NAME_PRODUCT;
		this.DESCRIPTION_PRODUCT = DESCRIPTION_PRODUCT;
		this.AMOUNT_PRODUCT = AMOUNT_PRODUCT;
		this.PRICE_PRODUCT = PRICE_PRODUCT;
	}
	
	public Product( String NAME_PRODUCT, String DESCRIPTION_PRODUCT, Integer AMOUNT_PRODUCT,
			float PRICE_PRODUCT) {
		super();
		this.NAME_PRODUCT = NAME_PRODUCT;
		this.DESCRIPTION_PRODUCT = DESCRIPTION_PRODUCT;
		this.AMOUNT_PRODUCT = AMOUNT_PRODUCT;
		this.PRICE_PRODUCT = PRICE_PRODUCT;
	}
	
	public Product() {
		super();
	}

	public Integer getID_PRODUCT() {
		return ID_PRODUCT;
	}

	public void setID_PRODUCT(Integer iD_PRODUCT) {
		ID_PRODUCT = iD_PRODUCT;
	}

	public String getNAME_PRODUCT() {
		return NAME_PRODUCT;
	}

	public void setNAME_PRODUCT(String nAME_PRODUCT) {
		NAME_PRODUCT = nAME_PRODUCT;
	}

	public String getDESCRIPTION_PRODUCT() {
		return DESCRIPTION_PRODUCT;
	}

	public void setDESCRIPTION_PRODUCT(String dESCRIPTION_PRODUCT) {
		DESCRIPTION_PRODUCT = dESCRIPTION_PRODUCT;
	}

	public Integer getAMOUNT_PRODUCT() {
		return AMOUNT_PRODUCT;
	}

	public void setAMOUNT_PRODUCT(Integer aMOUNT_PRODUCT) {
		AMOUNT_PRODUCT = aMOUNT_PRODUCT;
	}

	public float getPRICE_PRODUCT() {
		return PRICE_PRODUCT;
	}

	public void setPRICE_PRODUCT(float pRICE_PRODUCT) {
		PRICE_PRODUCT = pRICE_PRODUCT;
	}
	
	
}
