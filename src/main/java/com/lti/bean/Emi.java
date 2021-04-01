package com.lti.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="emis")
public class Emi {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EMI_GEN")
    @SequenceGenerator(name="EMI_GEN", sequenceName="emi_seq",allocationSize=1)
	@Column(name="emi_Id")
	private int emiId;
	
	@Column(name="card_Number")
    private long cardNumber ;
	
	
	@Column(name="tenure")
	private  int tenure;
	
	@Column(name="emi")
	private long emi;
	
	@Column(name="card_Limit")
	private long cardLimit;
	
	@Column(name="valid_Date")
	private  Date validDate;
	
	@Column(name="paid")
	private String paid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="consumer_Id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Consumer consumer;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="product_Id")
	private Product product;

	public Emi() {
		super();
	}

	public Emi(int emiId, long cardNumber, int tenure, long emi, long cardLimit, Date validDate, String paid,
			Consumer consumer, Product product) {
		super();
		this.emiId = emiId;
		this.cardNumber = cardNumber;
		this.tenure = tenure;
		this.emi = emi;
		this.cardLimit = cardLimit;
		this.validDate = validDate;
		this.paid = paid;
		this.consumer = consumer;
		this.product = product;
	}

	public Emi(int emiId, long cardNumber, int tenure, long emi, long cardLimit, Date validDate, String paid) {
		super();
		this.emiId = emiId;
		this.cardNumber = cardNumber;
		this.tenure = tenure;
		this.emi = emi;
		this.cardLimit = cardLimit;
		this.validDate = validDate;
		this.paid = paid;
	}
	
	

	public int getEmiId() {
		return emiId;
	}

	public void setEmiId(int emiId) {
		this.emiId = emiId;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public long getEmi() {
		return emi;
	}

	public void setEmi(long emi) {
		this.emi = emi;
	}

	public long getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(long cardLimit) {
		this.cardLimit = cardLimit;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Emi [emiId=" + emiId + ", cardNumber=" + cardNumber + ", tenure=" + tenure + ", emi=" + emi
				+ ", cardLimit=" + cardLimit + ", validDate=" + validDate + ", paid=" + paid + ", consumer=" + consumer
				+ ", product=" + product + "]";
	}
	
	
}
