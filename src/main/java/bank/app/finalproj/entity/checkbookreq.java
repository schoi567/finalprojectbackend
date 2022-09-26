package bank.app.finalproj.entity;
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
@Table(name="checkbookreq")
@Controller
public class checkbookreq {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Column(name="username", nullable = true)
	private String username;
    @Column(nullable = true)
    private Date date;
    @Column(nullable = true)
	private String accounttype;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
	private boolean accept;
	
	public checkbookreq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public checkbookreq(Long id, String username, Date date, String accounttype, String description, boolean accept) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.accounttype = accounttype;
		this.description = description;
		this.accept = accept;
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

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	
 
	
	
	
	

}
