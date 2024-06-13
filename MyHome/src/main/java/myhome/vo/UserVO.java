package myhome.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class UserVO {
	private Long no;
	private String name;
	private String password;
	private String email;
	private String gender;
	private Timestamp createdAt;
	
	public UserVO() {
		super();
	}

	public UserVO(String name, String password, String email, String gender) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}

	public UserVO(Long no, String name, String password, String email, String gender, Timestamp createdAt) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.createdAt = createdAt;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "UsersVO [no=" + no + ", name=" + name + ", email=" + email + ", gender=" + gender + ", createdAt="
				+ createdAt + "]";
	}

	
}
