package emaillist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmaillistVO {
	private Long no;
	private String lastName;
	private String firstName;
	private String email;
	private Date created_at;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
		EmaillistVO other = (EmaillistVO) obj;
		return Objects.equals(email, other.email);
	}
	@Override
	public String toString() {
		return "EmaillistVO [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", created_at=" + created_at + "]";
	}
	
	
	
}
