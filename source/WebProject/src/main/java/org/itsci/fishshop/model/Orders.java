package org.itsci.fishshop.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Orders")
public class Orders {
	@Column(name="OrderID",length=20)
	@Id
	private int OrderID;
	@Column(name="OrderDate",nullable=false,length=100)
	private int PreOrderID;
	@Column(name="PreOrderID",nullable=false,length=100)
	private Calendar OrderDate;
	@Column(name="OrderDaliveryDate",nullable=false,length=100)
	private Calendar OrderDaliveryDate;
	@Column(name="OrderStatus",nullable=false,length=100)
	private String OrderStatus;
	@Column(name="Totalprice",nullable=false,length=100)
	private String Totalprice;
	@Column(name="Description",nullable=false,length=100)
	private String Description;
	@Column(name="PreOrderDate",nullable=false,length=100)
	private String PreOrderDate;
	@Column(name="PreOrderDaliveryDate",nullable=false,length=100)
	private String PreOrderDaliveryDate;
	@Column(name="OrderType",nullable=false,length=100)
	private String OrderType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberID")
	private Register register;


	public static void main(String[] args) {
		
	}


	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getPreOrderID() {
		return PreOrderID;
	}

	public void setPreOrderID(int preOrderID) {
		PreOrderID = preOrderID;
	}

	public Calendar getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		OrderDate = orderDate;
	}

	public Calendar getOrderDaliveryDate() {
		return OrderDaliveryDate;
	}

	public void setOrderDaliveryDate(Calendar orderDaliveryDate) {
		OrderDaliveryDate = orderDaliveryDate;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}


	public String getTotalprice() {
		return Totalprice;
	}


	public void setTotalprice(String totalprice) {
		Totalprice = totalprice;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getPreOrderDate() {
		return PreOrderDate;
	}


	public void setPreOrderDate(String preOrderDate) {
		PreOrderDate = preOrderDate;
	}


	public String getPreOrderDaliveryDate() {
		return PreOrderDaliveryDate;
	}


	public void setPreOrderDaliveryDate(String preOrderDaliveryDate) {
		PreOrderDaliveryDate = preOrderDaliveryDate;
	}


	public String getOrderType() {
		return OrderType;
	}


	public void setOrderType(String orderType) {
		OrderType = orderType;
	}


	public Register getRegister() {
		return register;
	}


	public void setRegister(Register register) {
		this.register = register;
	}


	public Orders(int orderID, int preOrderID, Calendar orderDate, Calendar orderDaliveryDate, String orderStatus,
			String totalprice, String description, String preOrderDate, String preOrderDaliveryDate, String orderType,
			Register register) {
		super();
		OrderID = orderID;
		PreOrderID = preOrderID;
		OrderDate = orderDate;
		OrderDaliveryDate = orderDaliveryDate;
		OrderStatus = orderStatus;
		Totalprice = totalprice;
		Description = description;
		PreOrderDate = preOrderDate;
		PreOrderDaliveryDate = preOrderDaliveryDate;
		OrderType = orderType;
		this.register = register;
	}

	
}

