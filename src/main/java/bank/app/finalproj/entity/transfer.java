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
@Table(name="transfer")
@Controller

public class transfer {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="fromusername", nullable = true)
	private String fromusername;
    
    @Column(name="fromaccounttype", nullable = true)
	private String fromaccounttype;  
    
    @Column(nullable = true)
    private Date date;
   
    @Column(nullable = true)
	private String toaccounttype;
    
    @Column(nullable = true)
 	private String receiverusename;
    
    @Column(nullable = true)
    private BigDecimal amount;
    
    @Column(nullable = true)
	private String transfer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromusername() {
		return fromusername;
	}

	public void setFromusername(String fromusername) {
		this.fromusername = fromusername;
	}

	public String getFromaccounttype() {
		return fromaccounttype;
	}

	public void setFromaccounttype(String fromaccounttype) {
		this.fromaccounttype = fromaccounttype;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getToaccounttype() {
		return toaccounttype;
	}

	public void setToaccounttype(String toaccounttype) {
		this.toaccounttype = toaccounttype;
	}

	public String getReceiverusename() {
		return receiverusename;
	}

	public void setReceiverusename(String receiverusename) {
		this.receiverusename = receiverusename;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public transfer(Long id, String fromusername, String fromaccounttype, Date date, String toaccounttype,
			String receiverusename, BigDecimal amount, String transfer) {
		super();
		this.id = id;
		this.fromusername = fromusername;
		this.fromaccounttype = fromaccounttype;
		this.date = date;
		this.toaccounttype = toaccounttype;
		this.receiverusename = receiverusename;
		this.amount = amount;
		this.transfer = transfer;
	}
 
    
    
    
	

}
