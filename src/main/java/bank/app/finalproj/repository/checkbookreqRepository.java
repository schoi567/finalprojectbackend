package bank.app.finalproj.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import bank.app.finalproj.entity.Customers;
import bank.app.finalproj.entity.checkbookreq;

public interface checkbookreqRepository extends JpaRepository<checkbookreq, Long>  {
	checkbookreq findByUsername(String username);
	checkbookreqRepository findByid(Long id);
	List<checkbookreq> findAll();
	
}
