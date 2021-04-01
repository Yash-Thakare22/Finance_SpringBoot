package com.lti.bean;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="logins")
public class Login{
		
	    @Id
		@Column(name="consumer_Username")
	    private String consumerUsername;
		
		@Column(name="consumer_Password")
		private String consumerPassword;
		
		@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="consumer_Id")
		private Consumer consumer;

		
		public Login(String consumerUsername, String consumerPassword) {
			super();
			this.consumerUsername = consumerUsername;
			this.consumerPassword = consumerPassword;
		}

		public Login(String consumerUsername, String consumerPassword, Consumer consumer) {
			super();
			this.consumerUsername = consumerUsername;
			this.consumerPassword = consumerPassword;
			this.consumer = consumer;
		}

		public Login() {
			super();
		}

		public String getConsumerUsername() {
			return consumerUsername;
		}

		public void setConsumerUsername(String consumerUsername) {
			this.consumerUsername = consumerUsername;
		}

		public String getConsumerPassword() {
			return consumerPassword;
		}

		public void setConsumerPassword(String consumerPassword) {
			this.consumerPassword = consumerPassword;
		}

		public Consumer getConsumer() {
			return consumer;
		}

		public void setConsumer(Consumer consumer) {
			this.consumer = consumer;
		}

		@Override
		public String toString() {
			return "Login [consumerUsername=" + consumerUsername + ", consumerPassword=" + consumerPassword
					+ ", consumer=" + consumer + "]";
		}
	
	}