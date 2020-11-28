package application.model;

import java.util.Date;

//@Entity
//@Table(name = "MEMBERS")
public class Member {
//	@Id
	private String email;
	private String password;
	private String name;
	private Date birthday;
	private boolean female;
	private String degree;
	private String address;
	private String phone;

	public Member() {
	}

	public Member(String email, String password, String name, Date birthday, boolean female, String degree,
			String address, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.female = female;
		this.degree = degree;
		this.address = address;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isFemale() {
		return female;
	}

	public void setFemale(boolean female) {
		this.female = female;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", female=" + female + ", degree=" + degree + ", address=" + address + ", phone=" + phone + "]";
	}
}
