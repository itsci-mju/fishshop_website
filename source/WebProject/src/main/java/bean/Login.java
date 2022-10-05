package bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	@Column(name="Email",length=100)
	@Id
	private String Email;
	@Column(name="Password",nullable=false,length=100)
	private String Password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberID")
	private Register register;

	public static void main(String[] args) {
		

	}
	public Login(String email, String password) {
		super();
		Email = email;
		Password = password;
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

}
