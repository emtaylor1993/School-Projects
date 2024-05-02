/**
 * CUSTOM USER DETAILS SERVICE IMPLEMENTATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Custom User Details Service and the feature to
 *    load the current logged in User.
 * 
 * @packages
 *    Spring Framework Security (UserDetails, UserDetailsService, UsernameNotFoundException)
 *    Spring Framework Stereotype (Service)
 *    DBMS Solution (SecurityEmployee, EmployeeRepository)
 *    Lombok (AllArgsConstructor)
 */

package com.databases.dbmssolution.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.databases.dbmssolution.entity.SecurityEmployee;
import com.databases.dbmssolution.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository
            .findByUsername(username)
            .map(SecurityEmployee::new)
            .orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }
}
