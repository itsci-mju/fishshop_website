package org.itsci.fishshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Column(name="CartID",length=20)
	@Id
	private String CartID ;
	@Column(name="UserName",nullable=false,length=100)
	private String UserName;
	@Column(name="ProductID",nullable=false,length=20)
	private String ProductID;
	@Column(name="ProductName",nullable=false,length=100)
	private String ProductName;
	@Column(name="Quantity",nullable=false,length=50)
	private String Quantity;
	@Column(name="Price",nullable=false,length=50)
	private String Price;

	
	

	public Cart(String cartID, String userName, String productID, String productName, String quantity, String price) {
		super();
		CartID = cartID;
		UserName = userName;
		ProductID = productID;
		ProductName = productName;
		Quantity = quantity;
		Price = price;
	}

	public String getCartID() {
		return CartID;
	}


	public void setCartID(String cartID) {
		CartID = cartID;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}




	public String getProductID() {
		return ProductID;
	}




	public void setProductID(String productID) {
		ProductID = productID;
	}




	public String getProductName() {
		return ProductName;
	}




	public void setProductName(String productName) {
		ProductName = productName;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
	}


	public String getPrice() {
		return Price;
	}


	public void setPrice(String price) {
		Price = price;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
