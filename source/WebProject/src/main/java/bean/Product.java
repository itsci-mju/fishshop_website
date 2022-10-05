package bean;

import java.beans.Transient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name="Product")
public class Product {
	
	@Column(name="ProductID",length=20)
	@Id
	private int ProductID = 1;
	@Column(name="ProductPic",nullable=false,length=100)
	private String ProductPic;
	@Column(name="ProductName",nullable=false,length=100)
	private String ProductName;
	@Column(name="amount",nullable=false,length=50)
	private String amount;
	@Column(name="unit",nullable=false,length=50)
	private String unit;
	@Column(name="Price",nullable=false,length=50)
	private String Price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns(@JoinColumn(name = "CategoriesID"))
	private Categories categories;


	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(int productID, String productPic, String productName, String amount, String unit, String price,
			Categories categories) {
		super();
		ProductID = productID;
		ProductPic = productPic;
		ProductName = productName;
		this.amount = amount;
		this.unit = unit;
		Price = price;
		this.categories = categories;
	}



	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductPic() {
		return ProductPic;
	}
	public void setProductPic(String productPic) {
		ProductPic = productPic;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	

	/*public String getDisplayProduct() {
		if(ProductPic == null||ProductID == 0) {
		return null;
	}
		return "/Fish-photos/"+ProductID+"/"+ProductPic;
	}*/
	
}
