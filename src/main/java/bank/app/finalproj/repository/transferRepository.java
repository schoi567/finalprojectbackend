package bank.app.finalproj.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.app.finalproj.entity.transfer;

public interface transferRepository extends JpaRepository<transfer, Long> {
	transfer findByid(Long id);
	List<transfer> findAll();
	List<transfer> findAllByFromusername(String fromusername);
 
	

}
 