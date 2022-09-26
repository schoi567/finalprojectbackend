package bank.app.finalproj.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import bank.app.finalproj.entity.Customers;
 
 public interface CustomerRepository extends JpaRepository<Customers, Long>  {
	 
	 Customers findByUsername(String username);
	 List<Customers> findAll();
 
	 
	 
 }
