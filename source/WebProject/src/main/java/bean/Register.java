package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Register")
public class Register {
	
	@Column(name="MemberID",length=20)
	@Id
	private int MemberID = 1;
	@Column(name="FirstName",nullable=false,length=50)
	private String FirstName;
	@Column(name="LastName",nullable=false,length=50)
	private String LastName;
	@Column(name="PhoneNo",nullable=false,length=10)
	private String PhoneNo;
	@Column(name="Email",nullable=false,length=100)
	private String Email;
	@Column(name="Password",nullable=false,length=100)
	private String Password;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="MemberType",nullable=false,length=100)
	private String MemberType;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
}

	public Register(int memberID, String firstName, String lastName, String phoneNo, String email, String password,
			String memberType) {
		super();
		MemberID = memberID;
		FirstName = firstName;
		LastName = lastName;
		PhoneNo = phoneNo;
		Email = email;
		Password = password;
		MemberType = memberType;
	}

	public int getMemberID() {
		return MemberID;
	}

	public void setMemberID(int memberID) {
		MemberID = memberID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMemberType() {
		return MemberType;
	}

	public void setMemberType(String memberType) {
		MemberType = memberType;
	}
	
}