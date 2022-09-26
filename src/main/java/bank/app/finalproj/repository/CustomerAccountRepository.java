package bank.app.finalproj.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import bank.app.finalproj.entity.CustomerAccont;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccont, Long> {

	CustomerAccont findByid(Long id);
	CustomerAccont findByUsername(String username);
	
	
	List<CustomerAccont> findAll();
	
	
}
