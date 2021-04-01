package com.lti.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TRANSACTION_GEN")
    @SequenceGenerator(name="TRANSACTION_GEN", sequenceName="transaction_seq",allocationSize=1)
	@Column(name="transaction_Id")
	private int transactionId;
	
	@Column(name="transaction_Date")
	private Date transactionDate;
	
	@Column(name="transaction_Amount")
	private long transactionAmount;
	
	@Column(name="card_Number")
    private long cardNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="consumer_Id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Consumer consumer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_Id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Product product;
	

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Date transactionDate, long transactionAmount, long cardNumber,
			Consumer consumer, Product product) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.cardNumber = cardNumber;
		this.consumer = consumer;
		this.product = product;
	}

	public Transaction(int transactionId, Date transactionDate, long transactionAmount, long cardNumber) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.cardNumber = cardNumber;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
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
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", cardNumber=" + cardNumber + ", consumer=" + consumer
				+ ", product=" + product + "]";
	}
	
}
