package bank.app.finalproj.entity;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;

@Entity
@Table(name="depositwithdrawmoney")
@Controller

public class depositwithdrawmoney {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="username", nullable = true)
	private String username; 
    
    @Column(nullable = true)
    private Date date;
   
    @Column(name="account", nullable = true)
 	private String account;    
 
 
    @Column(nullable = true)
    private BigDecimal amount;
    
    @Column(nullable = true)
	private String approved;
    
	public depositwithdrawmoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	public depositwithdrawmoney(Long id, String username, Date date, String account, BigDecimal amount,
			String approved) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.account = account;
		this.amount = amount;
		this.approved = approved;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

    
    
     
    
    
	

}
