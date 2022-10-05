package org.itsci.fishshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="News")
public class News {
	@Column(name="NewsID",length=20)
	@Id
	private int  NewsID = 1;
	@Column(name="NewsPic",nullable=false,length=50)
	private String NewsPic;
	@Column(name="NewsName",nullable=false,length=50)
	private String NewsName;
	@Column(name="NewsDetail",nullable=false,length=500)
	private String NewsDetail;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberID")
	private Register register;
	public static void main(String[] args) {

	}
	public int getNewsID() {
		return NewsID;
	}
	public void setNewsID(int newsID) {
		NewsID = newsID;
	}
	public String getNewsPic() {
		return NewsPic;
	}
	public void setNewsPic(String newsPic) {
		NewsPic = newsPic;
	}
	public String getNewsName() {
		return NewsName;
	}
	public void setNewsName(String newsName) {
		NewsName = newsName;
	}
	public String getNewsDetail() {
		return NewsDetail;
	}
	public void setNewsDetail(String newsDetail) {
		NewsDetail = newsDetail;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public News(int newsID, String newsPic, String newsName, String newsDetail, Register register) {
		super();
		NewsID = newsID;
		NewsPic = newsPic;
		NewsName = newsName;
		NewsDetail = newsDetail;
		this.register = register;
	}
	

}