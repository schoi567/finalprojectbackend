package bank.app.finalproj.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;


@Entity
@Table(name="customers")
@Controller
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Column(name="username", unique=true)
	private String username; 
	private String password;
    @Column(name="email", unique=true)
	private String email; 
    @Column(name="phonenumber", unique=true)
	private long phonenumber;
	private String firstname; 
	private String lastname;
    @Column(name="primaryaccountnumber", unique=true)
	private int primaryaccountnumber;    
    @Column(name="savingsaccountnumber", unique=true)
	private int savingsaccountnumber;
	private String block;
	
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(Long id, String username, String password, String email, long phonenumber, String firstname,
			String lastname, int primaryaccountnumber, int savingsaccountnumber, String block) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.primaryaccountnumber = primaryaccountnumber;
		this.savingsaccountnumber = savingsaccountnumber;
		this.block = block;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPrimaryaccountnumber() {
		return primaryaccountnumber;
	}
	public void setPrimaryaccountnumber(int primaryaccountnumber) {
		this.primaryaccountnumber = primaryaccountnumber;
	}
	public int getSavingsaccountnumber() {
		return savingsaccountnumber;
	}
	public void setSavingsaccountnumber(int savingsaccountnumber) {
		this.savingsaccountnumber = savingsaccountnumber;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	
	
	
	
}
