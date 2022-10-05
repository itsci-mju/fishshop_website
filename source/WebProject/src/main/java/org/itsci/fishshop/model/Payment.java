package org.itsci.fishshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Column(name="PaymentID",length=20)
	@Id
	private int PaymentID;
	@Column(name="PaymentPic",nullable=false,length=100)
	private String PaymentPic;
	@Column(name="TimesPayment",nullable=false,length=100)
	private String TimesPayment;
	@Column(name="PaymentName",nullable=false,length=100)
	private String PaymentName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderID")
	private Orders orders;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


}
	public Payment(int paymentID, String paymentPic, String timesPayment, String paymentName) {
		super();
		PaymentID = paymentID;
		PaymentPic = paymentPic;
		TimesPayment = timesPayment;
		PaymentName = paymentName;
	}
	public int getPaymentID() {
		return PaymentID;
	}
	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}
	public String getPaymentPic() {
		return PaymentPic;
	}
	public void setPaymentPic(String paymentPic) {
		PaymentPic = paymentPic;
	}
	public String getTimesPayment() {
		return TimesPayment;
	}
	public void setTimesPayment(String timesPayment) {
		TimesPayment = timesPayment;
	}
	public String getPaymentName() {
		return PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}
}
