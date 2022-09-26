package bank.app.finalproj;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import bank.app.finalproj.repository.CustomerRepository;
import bank.app.finalproj.CreateSchema; 



@SpringBootApplication
public class FinalprojApplication {
  
	public static void main(String[] args) throws SQLException {
	  CreateSchema CS = new CreateSchema(); 
  CS.Startdb(); 
		SpringApplication.run(FinalprojApplication.class, args);
	}

}
