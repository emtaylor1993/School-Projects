/**
 * DBMS SOLUTION APPLICATION ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the entry point of the DBMS Solution
 *    Application.
 * 
 * @packages
 *    Java Utilities (List)
 *    Spring Framework Boot (CommandLineRunner, SpringApplication)
 *    Spring Framework Boot Auto Configure (SpringBootApplication)
 *    Spring Framework Context Annotation (Bean)
 *    Spring Framework Security Crypto (BCryptPasswordEncoder, PasswordEncoder)
 *    DBMS Solution (Employee, EmployeeRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.databases.dbmssolution.entity.Employee;
import com.databases.dbmssolution.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class DbmsSolutionApplication implements CommandLineRunner {
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DbmsSolutionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).setPassword(passwordEncoder().encode(employees.get(i).getPassword()));
			employeeRepository.save(employees.get(i));
		}
	}

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}