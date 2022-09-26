package bank.app.finalproj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import bank.app.finalproj.repository.CustomerRepository;

@Component
@Controller
public class CreateSchema {
 
	@Autowired
	CustomerRepository CustomerRepository; 
	

	public void Startdb() throws SQLException {  
			Statement stmt = null;
			Integer rs = null;		
			String name,pass,url;  
			Connection conn = null;  
       try {Class.forName("com.mysql.cj.jdbc.Driver");  
           url="jdbc:mysql://localhost:3306";  
           name="root";  
           pass="12345678";  
           conn = DriverManager.getConnection(url,name,pass);  
           System.out.println("Connection created");  }  
           catch (Exception e) {  
           System.out.println(e.toString());  }  		
		try {stmt = conn.createStatement();
		    rs = stmt.executeUpdate("create schema bank;");}		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    stmt.close();
		    conn.close();
		    System.out.println("Connection closed");  return;} 
			stmt.close();  conn.close();	}
	
			
/* 	public void Startdb() throws SQLException {  
			Statement stmt = null;
			Integer rs = null;		
			String name,pass,url;  
			Connection conn = null;  
       try {Class.forName("com.mysql.cj.jdbc.Driver");  
           url="jdbc:mysql://localhost:3306";  
           name="root";  
           pass="12345678";  
           conn = DriverManager.getConnection(url,name,pass);  
           System.out.println("Connection created");  }  
           catch (Exception e) {  
           System.out.println(e.toString());  }  		
		try {stmt = conn.createStatement();
		    rs = stmt.executeUpdate("create schema bank;");}		
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    stmt.close();
		    conn.close();
		    System.out.println("Connection closed");  return;} 
			stmt.close();  conn.close();	}
			
						*/ 
	
			
	
	
	
}




 




