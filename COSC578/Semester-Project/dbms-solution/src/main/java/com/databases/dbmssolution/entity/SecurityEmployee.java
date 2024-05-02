/**
 * SECURITY EMPLOYEE ENTITY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Security Employee entity and the UserDetails
 *    information.
 * 
 * @packages
 *    Java Utilities (Arrays, Collection)
 *    Spring Framework Security Core (GrantedAuthority, SimpleGrantedAuthority, UserDetails)
 */

package com.databases.dbmssolution.entity;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityEmployee implements UserDetails {
    private Employee employee;

    public SecurityEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getUsername() {
        return employee.getUsername();
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(new String[] {employee.getRole()})
            .map(SimpleGrantedAuthority::new)
            .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
