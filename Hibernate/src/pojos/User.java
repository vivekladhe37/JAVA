package pojos;
/*
 * userId (PK) Integer,name,email,
 * password,role,confirmPassword:string
	 regAmount : double
	 java.util.Date regDate;
	 UserType userType --enum
	 byte[] image;
 */

import java.util.Date;
import javax.persistence.*;//annotations from JPA specs
@Entity //mandatory
@Table(name ="dac_users")
public class User {
	//ID --MUST be Serializable 
	private Integer userId;
	private String name,email,password,role,confirmPassword;
	private double regAmount;
	private Date regDate;
	private UserType userType;
	private byte[] image;
	//supply def arg less constr --MUST
	public User() {
		System.out.println("in user constr");
	}
	public User(String name, String email, String password, String role, String confirmPassword, double regAmount,
			Date regDate, UserType userType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userType = userType;
	}
	//supply ALL setters / getters : MUST
	@Id //mandatory  PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto inc
	@Column(name ="user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30,unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length = 20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Column(name="reg_amt")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Temporal(TemporalType.DATE) //date
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Enumerated(EnumType.STRING)  //const name
	@Column(name="user_type")
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Lob //column type=blob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ ", userType=" + userType + "]";
	}
	
	

}
