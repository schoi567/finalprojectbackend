package bank.app.finalproj.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Entity
@Table(name="customeraccount")
@Controller
public class CustomerAccont {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="username", nullable = true)
	private String username; 
	private BigDecimal savingsaccountnumber; 
	private BigDecimal primaryaccountnumber;
	
	
	
	
	 
	public CustomerAccont(Long id, String username, BigDecimal savingsaccountnumber, BigDecimal primaryaccountnumber) {
		super();
		this.id = id;
		this.username = username;
		this.savingsaccountnumber = savingsaccountnumber;
		this.primaryaccountnumber = primaryaccountnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CustomerAccont() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getSavingsaccountnumber() {
		return savingsaccountnumber;
	}
	public void setSavingsaccountnumber(BigDecimal savingsaccountnumber) {
		this.savingsaccountnumber = savingsaccountnumber;
	}
	public BigDecimal getPrimaryaccountnumber() {
		return primaryaccountnumber;
	}
	public void setPrimaryaccountnumber(BigDecimal primaryaccountnumber) {
		this.primaryaccountnumber = primaryaccountnumber;
	}
	
	
	
 
	
	
	
	
	
	
	
	
	
	

}
