package bank.app.finalproj.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import bank.app.finalproj.entity.CustomerAccont;
import bank.app.finalproj.entity.depositwithdrawmoney;

public interface depositwithdrawRepository extends JpaRepository<depositwithdrawmoney, Long>  {
	depositwithdrawmoney findByUsername(String username);
	depositwithdrawmoney findByid(Long id);
	 
	
	List<depositwithdrawmoney> findAll();
	List<depositwithdrawmoney> findAllByUsername(String username);
	
 
	
	
}
