package emaillist;

import java.util.Date;
import java.util.Objects;

public class EmailListVO {
	private Long no;
	private String lastName;
	private String firstName;
	private String email;
	private Date createdAt;
	
	public EmailListVO() {
		super();
	}

	public EmailListVO(Long no, String lastName, String firstName, String email, Date createdAt) {
		super();
		this.no = no;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.createdAt = createdAt;
	}
	
	public EmailListVO(String lastName, String firstName, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
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
		EmailListVO other = (EmailListVO) obj;
		return Objects.equals(email, other.email);
	}
	@Override
	public String toString() {
		return "EmaillistVO [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
