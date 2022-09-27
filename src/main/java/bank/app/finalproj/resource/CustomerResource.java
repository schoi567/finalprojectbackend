package bank.app.finalproj.resource;
import java.math.BigDecimal;
import java.net.URI;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import bank.app.finalproj.entity.Customers;
import bank.app.finalproj.entity.CustomerAccont;
import bank.app.finalproj.entity.checkbookreq;
import bank.app.finalproj.entity.depositwithdrawmoney;
import bank.app.finalproj.entity.transfer;
import bank.app.finalproj.repository.*;
 
@CrossOrigin(origins={	
		"http://3.226.243.189:4200/primaryaccounttransfer",
		"http://3.226.243.189:4200",
		"http://18.232.38.151:4201",
		"http://3.226.243.189:4200/uprofile",
		"http://3.226.243.189:4200/changeusrprof/{username}",
		"http://3.226.243.189:4200/requestcheck/{username}", 
		"http://3.226.243.189:4200/checkbook",
		"http://18.232.38.151:4201/useraccount", 
		"http://18.232.38.151:4201/changeblock", 
		"http://18.232.38.151:4201/checkbookrequestdes", 
	    "http://3.226.243.189:4200/depositwithdraw",
		"http://3.226.243.189:4200/primaryhistory/{username}",
		"http://3.226.243.189:4200/primaryaccounttransfer/{username}", 
		"http://3.226.243.189:4200/savingsaccounttransfer/{username}", 
		"http://18.232.38.151:4201/transferchange" 
		
	 
	 
})
 

 
@RestController
public class CustomerResource {
	@Autowired
	CustomerRepository CustomerRepository; 
	@Autowired
	CustomerAccountRepository CustomerAccountRepository; 
	@Autowired
	Customers customers; 
	@Autowired
	Customers depositwithdrawmoney; 
	@Autowired
	CustomerAccont CustomerAccount; 
	@Autowired
	checkbookreqRepository checkbookreqRepository; 
	@Autowired
	depositwithdrawRepository depositwithdrawRepository; 
	@Autowired
	transferRepository transferRepository; 	
	@Autowired
	transfer transfer; 	
	
	

	
	@GetMapping("/customers/login/{username}")
	public Customers FindCustomerbyName(@PathVariable String username){
		return CustomerRepository.findByUsername(username);   } 
	
	
	@GetMapping("/customers")
	public List<Customers> FindAll(){
		return CustomerRepository.findAll();
	} 
	
	@GetMapping("/checkrequests")
	public List<checkbookreq> FindAllCheckRequests(){
		return checkbookreqRepository.findAll();
	} 
	
	@GetMapping("/checkrequests/{checkbookusername}")
	public checkbookreq FindSingleCheckRequests(@PathVariable String checkbookusername){
		return checkbookreqRepository.findByUsername(checkbookusername);
	} 

	@GetMapping("/customers/accounts")
	public 	List<CustomerAccont> findAllAccounts(){
		return CustomerAccountRepository.findAll();
	} 
	
	
	@GetMapping("/customers/accounts/{id}")
	public CustomerAccont findSingleAccount(@PathVariable long id){
		return CustomerAccountRepository.findByid(id);
		
		
		
	} 
	
	@PostMapping("/checkrequests/{username}")
	public ResponseEntity<Void> getcheckbookreq(@PathVariable String username,
			@RequestBody checkbookreq checkbookreq) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		checkbookreq checkbookreq1 = checkbookreqRepository.save(checkbookreq); 
		checkbookreq1.setDate(date);
		checkbookreq1.setUsername(username);
		checkbookreq1.setAccounttype(checkbookreq.getAccounttype());
		checkbookreq1.setDescription(checkbookreq.getDescription().toString());
		checkbookreq1.setAccept(false); 
		//checkbookreq1.setDescription(checkbookreq.getDescription());	
		checkbookreqRepository.save(checkbookreq1);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();}
	

	@PutMapping(path = "/customers/change/{username}")
	public ResponseEntity<Customers> updateCustomers(@PathVariable String username,
			@RequestBody Customers customers) {
		Customers cust = CustomerRepository.findByUsername(username);
		cust.setUsername(customers.getUsername()); 	
		cust.setLastname(customers.getLastname()); 	
		cust.setFirstname(customers.getFirstname()); 	
		cust.setPhonenumber(customers.getPhonenumber()); 	
		cust.setEmail(customers.getEmail()); 
		cust.setPassword(customers.getPassword()); 		
		CustomerRepository.save(cust);		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	
	@PutMapping(path = "/customersblock/{username}")
	public ResponseEntity<Customers> changeblock(@PathVariable String username,
			@RequestBody Customers customers) {
		Customers cust = CustomerRepository.findByUsername(username);
		cust.setBlock(customers.getBlock()); 	
		CustomerRepository.save(cust);	
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
		 
 
	@PostMapping(path = "/customers")
	public ResponseEntity<Void> addcustomers(
			@RequestBody Customers customers) {
		
		Customers addedcustomer = CustomerRepository.save(customers); 
		
		Long customerid = addedcustomer.getId(); 
		String username = addedcustomer.getUsername(); 
		
	 	CustomerAccont CustomerAccont = 
				 new CustomerAccont(customerid, username, new BigDecimal("0.00"), new BigDecimal("0.00")); 

		CustomerAccountRepository.save(CustomerAccont); 
 

		// Response Header : location
		// Status Code : 201
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand()
				.toUri();		
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping("/checkrequests/{checkbookusername}")
	public ResponseEntity<checkbookreq> ChangeCheckbookReqStatus(@PathVariable String checkbookusername, 
			@RequestBody checkbookreq checkbookreq){
		checkbookreq checkbookreq1 =  checkbookreqRepository.findByUsername(checkbookusername);
		checkbookreq1.setAccept(checkbookreq.isAccept()); 
		checkbookreqRepository.save(checkbookreq1); 	
		return new ResponseEntity<checkbookreq>(checkbookreq, HttpStatus.OK);
		
	} 

	
	@PostMapping(path = "/depositwithdrawmoney")
	public ResponseEntity<Void> postdepositwithdrawmoney( 
			@RequestBody depositwithdrawmoney depositwithdrawmoney) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		depositwithdrawmoney depositwithdrawmoney1 = depositwithdrawRepository.save(depositwithdrawmoney); 
		depositwithdrawmoney1.setDate(date); 
		depositwithdrawmoney1.setUsername(depositwithdrawmoney.getUsername());
		depositwithdrawmoney1.setAmount(depositwithdrawmoney.getAmount());
		depositwithdrawmoney1.setAccount(depositwithdrawmoney.getAccount());
		depositwithdrawmoney1.setApproved("pending"); 
		depositwithdrawRepository.save(depositwithdrawmoney1);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();}
	
	
	@PutMapping("/depositwithdrawmoney/all/{id}")
	public ResponseEntity<depositwithdrawmoney> ChangePendingStatus(@PathVariable long id, 
			@RequestBody depositwithdrawmoney depositwithdrawmoney){
		depositwithdrawmoney depositwithdrawmoney1 =  depositwithdrawRepository.findByid(id);
		depositwithdrawmoney1.setApproved(depositwithdrawmoney.getApproved());
		depositwithdrawRepository.save(depositwithdrawmoney1); 		 
		double revaluedamount = depositwithdrawmoney1.getAmount().doubleValue(); 
	
		String approved = depositwithdrawmoney1.getApproved().toString();
		String account = depositwithdrawmoney1.getAccount().toString();
	 
		if (approved.equals("yes") && account.equals("savingsaccountnumber")) 
		{   CustomerAccount = CustomerAccountRepository.findByUsername(depositwithdrawmoney.getUsername()); 
			BigDecimal newnumber = CustomerAccount.getSavingsaccountnumber().add(depositwithdrawmoney1.getAmount());
			System.out.println(newnumber);
			CustomerAccount.setSavingsaccountnumber(newnumber); 
			CustomerAccountRepository.save(CustomerAccount); 
			
	 	
		} 
		
		if (approved.equals("yes") && account.equals("primaryaccountnumber")) 
		{  CustomerAccount = CustomerAccountRepository.findByUsername(depositwithdrawmoney.getUsername()); 
		BigDecimal newnumber = CustomerAccount.getPrimaryaccountnumber().add(depositwithdrawmoney1.getAmount());
		System.out.println(newnumber);
		CustomerAccount.setPrimaryaccountnumber(newnumber); 
		CustomerAccountRepository.save(CustomerAccount); } 			
		return new ResponseEntity<depositwithdrawmoney>(depositwithdrawmoney, HttpStatus.OK);
	} 

	@GetMapping("/depositwithdrawmoney/all")
	public 	List<depositwithdrawmoney> findAllDepositWithdraw(){
		return depositwithdrawRepository.findAll();
	} 
	
	
	
	@GetMapping("/depositwithdrawmoney/all/{id}")
	public depositwithdrawmoney findDepositWithdrawById(@PathVariable long id){
		return depositwithdrawRepository.findByid(id);
	}

 
	
	@GetMapping("/depositwithdrawmoney/all/username/{username}")
	public List<depositwithdrawmoney> findDepositWithdrawByUsername(@PathVariable String username){
		return depositwithdrawRepository.findAllByUsername(username);
	}

	
 	
 
	@PostMapping(path="/transfermoney")
	public ResponseEntity<Void> posttransfermoney(
			@RequestBody transfer transfer) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		transfer transfer1 = transferRepository.save(transfer); 
		transfer1.setDate(date); 
		transfer1.setFromusername(transfer.getFromusername());
		transferRepository.save(transfer1);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();}
 
	@PostMapping(path="/transfermoney/admin")
	public ResponseEntity<Void> changetransfermoney(
			@RequestBody transfer transfer) {
		if (transfer.getTransfer().equals("accept") && transfer.getToaccounttype().equals("primaryaccountnumber") && transfer.getFromaccounttype().equals("primaryaccount") ) {
			Customers CustomersReceive = CustomerRepository.findByUsername(transfer.getReceiverusename());
			CustomerAccont CustomerAccontReceive = CustomerAccountRepository.findByid(CustomersReceive.getId()); 			
			Customers CustomersSend = CustomerRepository.findByUsername(transfer.getFromusername());
			CustomerAccont CustomerAccontSend = CustomerAccountRepository.findByid(CustomersSend.getId()); 			
			System.out.println(transfer.getAmount()); 
			System.out.println(CustomerAccontReceive.getPrimaryaccountnumber()); 			
			BigDecimal A = CustomerAccontReceive.getPrimaryaccountnumber().add(transfer.getAmount()); 			
			BigDecimal B = CustomerAccontSend.getPrimaryaccountnumber().subtract(transfer.getAmount()); 			
			System.out.println(A); 
			System.out.println(B);
			CustomerAccontReceive.setPrimaryaccountnumber(A); 
			CustomerAccontSend.setPrimaryaccountnumber(B); 
			CustomerAccountRepository.save(CustomerAccontReceive); 
			CustomerAccountRepository.save(CustomerAccontSend); 			
			transfer.setTransfer("done"); 
			transferRepository.save(transfer); 	
		}
		
		if (transfer.getTransfer().equals("accept") && transfer.getToaccounttype().equals("primaryaccountnumber") && transfer.getFromaccounttype().equals("savingsaccount") ) {
			Customers CustomersReceive = CustomerRepository.findByUsername(transfer.getReceiverusename());
			CustomerAccont CustomerAccontReceive = CustomerAccountRepository.findByid(CustomersReceive.getId()); 			
			Customers CustomersSend = CustomerRepository.findByUsername(transfer.getFromusername());
			CustomerAccont CustomerAccontSend = CustomerAccountRepository.findByid(CustomersSend.getId()); 			
			System.out.println(transfer.getAmount()); 
			System.out.println(CustomerAccontReceive.getPrimaryaccountnumber()); 			
			BigDecimal A = CustomerAccontReceive.getPrimaryaccountnumber().add(transfer.getAmount()); 			
			BigDecimal B = CustomerAccontSend.getSavingsaccountnumber().subtract(transfer.getAmount()); 			
			System.out.println(A); 
			System.out.println(B);
			CustomerAccontReceive.setPrimaryaccountnumber(A); 
			CustomerAccontSend.setSavingsaccountnumber(B); 
			CustomerAccountRepository.save(CustomerAccontReceive); 
			CustomerAccountRepository.save(CustomerAccontSend); 			
			transfer.setTransfer("done"); 
			transferRepository.save(transfer); 	
		}
		 
		if (transfer.getTransfer().equals("accept") && transfer.getToaccounttype().equals("savingsaccountnumber") && transfer.getFromaccounttype().equals("savingsaccount") ) {
			Customers CustomersReceive = CustomerRepository.findByUsername(transfer.getReceiverusename());
			CustomerAccont CustomerAccontReceive = CustomerAccountRepository.findByid(CustomersReceive.getId()); 			
			Customers CustomersSend = CustomerRepository.findByUsername(transfer.getFromusername());
			CustomerAccont CustomerAccontSend = CustomerAccountRepository.findByid(CustomersSend.getId()); 			
 			
			BigDecimal A = CustomerAccontReceive.getSavingsaccountnumber().add(transfer.getAmount()); 			
			BigDecimal B = CustomerAccontSend.getSavingsaccountnumber().subtract(transfer.getAmount()); 			
			System.out.println(A); 
			System.out.println(B);
			CustomerAccontReceive.setSavingsaccountnumber(A); 
			CustomerAccontSend.setSavingsaccountnumber(B); 
			CustomerAccountRepository.save(CustomerAccontReceive); 
			CustomerAccountRepository.save(CustomerAccontSend); 			
			transfer.setTransfer("done"); 
			transferRepository.save(transfer); 	
		}
		
		if (transfer.getTransfer().equals("accept") && transfer.getToaccounttype().equals("savingsaccountnumber") && transfer.getFromaccounttype().equals("primaryaccount") ) {
			Customers CustomersReceive = CustomerRepository.findByUsername(transfer.getReceiverusename());
			CustomerAccont CustomerAccontReceive = CustomerAccountRepository.findByid(CustomersReceive.getId()); 			
			Customers CustomersSend = CustomerRepository.findByUsername(transfer.getFromusername());
			CustomerAccont CustomerAccontSend = CustomerAccountRepository.findByid(CustomersSend.getId()); 			
 			
			BigDecimal A = CustomerAccontReceive.getSavingsaccountnumber().add(transfer.getAmount()); 			
			BigDecimal B = CustomerAccontSend.getPrimaryaccountnumber().subtract(transfer.getAmount()); 			
			System.out.println(A); 
			System.out.println(B);
			CustomerAccontReceive.setSavingsaccountnumber(A); 
			CustomerAccontSend.setPrimaryaccountnumber(B); 
			CustomerAccountRepository.save(CustomerAccontReceive); 
			CustomerAccountRepository.save(CustomerAccontSend); 			
			transfer.setTransfer("done"); 
			transferRepository.save(transfer); 	
		}
		
		 transferRepository.save(transfer); 
		 
	 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand()
				.toUri();
		return ResponseEntity.created(location).build();}
 
	
	@GetMapping("/transfermoney")
	public List<transfer> findAllTransfers(){
		return transferRepository.findAll();
	}
	
	@GetMapping("/transfermoney/{id}")
	public transfer FindCustomerbyName(@PathVariable Long id){
		return transferRepository.findByid(id);   } 
	 
	@GetMapping("/transfermoney/username/{fromusername}")
	public List<transfer> FindTransferbySender(@PathVariable String fromusername){
		return transferRepository.findAllByFromusername(fromusername);   } 
	 
	
 
	
}