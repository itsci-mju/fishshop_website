package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Categories {
	@Column(name="CategoriesID",length=20)
	@Id
	private String CategoriesID;
	@Column(name="CategoryName",nullable=false,length=100)
	private String CategoryName;

	public Categories(String categoriesID, String categoryName) {
		super();
		CategoriesID = categoriesID;
		CategoryName = categoryName;
	}

	public String getCategoriesID() {
		return CategoriesID;
	}

	public void setCategoriesID(String categoriesID) {
		CategoriesID = categoriesID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
