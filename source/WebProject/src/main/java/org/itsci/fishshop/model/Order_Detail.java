package org.itsci.fishshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_Detail")
public class Order_Detail {
	
	@Column(name="OrderDetailID",length=20)
	@Id
	private String OrderDetailID;
	@Column(name="Amount",nullable=false,length=50)
	private int Amount;
	@Column(name="Unit",nullable=false,length=50)
	private int Unit;
	@Column(name="price",nullable=false,length=50)
	private Double price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderID")
	private Orders orders;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns(@JoinColumn(name = "ProductID"))
	private Product Product;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public String getOrderDetailID() {
		return OrderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		OrderDetailID = orderDetailID;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getUnit() {
		return Unit;
	}

	public void setUnit(int unit) {
		Unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public Order_Detail(String orderDetailID, int amount, int unit, Double price, int orderID) {
		super();
		OrderDetailID = orderDetailID;
		Amount = amount;
		Unit = unit;
		this.price = price;
		
	}

}
