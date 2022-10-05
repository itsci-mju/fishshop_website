package bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	
	@Column(name="AddressID",length=20)
	@Id
	private int AddressID;
	@Column(name="TrackNo",nullable=false,length=20)
	private String TrackNo;
	@Column(name="Street",nullable=false,length=100)
	private String Street;
	@Column(name="SubDistrict",nullable=false,length=100)
	private String SubDistrict;
	@Column(name="District",nullable=false,length=100)
	private String District;
	@Column(name="Province",nullable=false,length=100)
	private String Province;
	@Column(name="ZipCode",nullable=false,length=10)
	private String ZipCode;
	@Column(name="TelNo",nullable=false,length=10)
	private String TelNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberID")
	private Register register;
	public static void main(String[] args) {
		
	}
	public int getAddressID() {
		return AddressID;
	}
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}
	public String getTrackNo() {
		return TrackNo;
	}
	public void setTrackNo(String trackNo) {
		TrackNo = trackNo;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getSubDistrict() {
		return SubDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		SubDistrict = subDistrict;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getTelNo() {
		return TelNo;
	}
	public void setTelNo(String telNo) {
		TelNo = telNo;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public Address(int addressID, String trackNo, String street, String subDistrict, String district, String province,
			String zipCode, String telNo, Register register) {
		super();
		AddressID = addressID;
		TrackNo = trackNo;
		Street = street;
		SubDistrict = subDistrict;
		District = district;
		Province = province;
		ZipCode = zipCode;
		TelNo = telNo;
		this.register = register;
	}
	

	}
	
	
	
	

