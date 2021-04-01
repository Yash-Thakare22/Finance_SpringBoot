package com.lti.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="consumers")
public class Consumer{
	
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CONSUMER_GEN")
	    @SequenceGenerator(name="CONSUMER_GEN", sequenceName="consumer_seq",allocationSize=1)
		@Column(name="consumer_Id")
		private int consumerId;
		
		@Column(name="consumer_Name")
		private String consumerName;
		
		@Column(name="consumer_Email")
		private String consumerEmail;
		
		@Column(name="consumer_Phone")
		private long consumerPhone;
		
		
		@Column(name="consumer_Address")
		private String consumerAddress;
		
		@Column(name="consumer_Cardtype")
		private String consumerCardtype;
		
		@Column(name="active_User")
		private String activeUser;
		
		@Column(name="eligibility")
		private String eligibility;
		
		@Column(name="consumer_Salary")
		private long consumerSalary ;
		
		@Column(name = "consumer_Bankname")
		private String consumerBankName;
		
		@Column(name = "consumer_account_number")
		private long consumerAccountNumber;
		
		@Column(name = "consumer_IFSC")
		private String consumerIFSC;

		public Consumer(int consumerId, String consumerName, String consumerEmail, long consumerPhone,
				String consumerAddress, String consumerCardtype, String activeUser, String eligibility,
				long consumerSalary, String consumerBankName, long consumerAccountNumber, String consumerIFSC) {
			super();
			this.consumerId = consumerId;
			this.consumerName = consumerName;
			this.consumerEmail = consumerEmail;
			this.consumerPhone = consumerPhone;
			this.consumerAddress = consumerAddress;
			this.consumerCardtype = consumerCardtype;
			this.activeUser = activeUser;
			this.eligibility = eligibility;
			this.consumerSalary = consumerSalary;
			this.consumerBankName = consumerBankName;
			this.consumerAccountNumber = consumerAccountNumber;
			this.consumerIFSC = consumerIFSC;
		}

		public Consumer() {
			super();
		}

		public int getConsumerId() {
			return consumerId;
		}

		public void setConsumerId(int consumerId) {
			this.consumerId = consumerId;
		}

		public String getConsumerName() {
			return consumerName;
		}

		public void setConsumerName(String consumerName) {
			this.consumerName = consumerName;
		}

		public String getConsumerEmail() {
			return consumerEmail;
		}

		public void setConsumerEmail(String consumerEmail) {
			this.consumerEmail = consumerEmail;
		}

		public long getConsumerPhone() {
			return consumerPhone;
		}

		public void setConsumerPhone(long consumerPhone) {
			this.consumerPhone = consumerPhone;
		}

		public String getConsumerAddress() {
			return consumerAddress;
		}

		public void setConsumerAddress(String consumerAddress) {
			this.consumerAddress = consumerAddress;
		}

		public String getConsumerCardtype() {
			return consumerCardtype;
		}

		public void setConsumerCardtype(String consumerCardtype) {
			this.consumerCardtype = consumerCardtype;
		}

		public String getActiveUser() {
			return activeUser;
		}

		public void setActiveUser(String activeUser) {
			this.activeUser = activeUser;
		}

		public String getEligibility() {
			return eligibility;
		}

		public void setEligibility(String eligibility) {
			this.eligibility = eligibility;
		}

		public long getConsumerSalary() {
			return consumerSalary;
		}

		public void setConsumerSalary(long consumerSalary) {
			this.consumerSalary = consumerSalary;
		}

		public String getConsumerBankName() {
			return consumerBankName;
		}

		public void setConsumerBankName(String consumerBankName) {
			this.consumerBankName = consumerBankName;
		}

		public long getConsumerAccountNumber() {
			return consumerAccountNumber;
		}

		public void setConsumerAccountNumber(long consumerAccountNumber) {
			this.consumerAccountNumber = consumerAccountNumber;
		}

		public String getConsumerIFSC() {
			return consumerIFSC;
		}

		public void setConsumerIFSC(String consumerIFSC) {
			this.consumerIFSC = consumerIFSC;
		}
				
	}