/**
 * SECURITY CONFIGURATION CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Security Configuration that defines roles-based access.
 * 
 * @packages
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Context (Bean, Configuration)
 *    Spring Framework HTTP (HttpMethod)
 *    Spring Framework Security (HttpSecurity, EnableWebSecurity)
 *    Spring Framework Security Web (SecurityFilterChain, AccessDeniedHandler, AntPathRequestMatcher)
 *    DBMS Solution Service (CustomUserDetailsService)
 */

package com.databases.dbmssolution.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.databases.dbmssolution.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.ignoringAntMatchers("/h2/**").disable())
            .authorizeRequests(auth -> auth
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/login?error=true").permitAll()
                .antMatchers(HttpMethod.GET, "/employees", "/employee_form", "/deleteEmployee").hasAuthority("Administrator")
                .antMatchers(HttpMethod.POST, "/submitEmployee").hasAuthority("Administrator")
                .antMatchers(HttpMethod.GET, "/financial_data", "financial_data_form", "deleteFinancialData").hasAnyAuthority("Administrator", "Accountant")
                .antMatchers(HttpMethod.POST, "submitFinancialData").hasAnyAuthority("Administrator", "Accountant")
                .antMatchers(HttpMethod.GET, "/change_orders", "/change_order_form", "/deleteChangeOrder",
                    "/inventory", "/inventory_form", "/deleteInventory",
                    "/purchase_orders", "/purchase_order_form", "/deletePurchaseOrder").hasAnyAuthority("Administrator", "Program Manager")
                .antMatchers(HttpMethod.POST, "/submitChangeOrder", "/submitInventory", "/submitPurchaseOrder").hasAnyAuthority("Administrator", "Program Manager")
                .antMatchers("/img/*.jpg", "/*.js", "/*.css").permitAll()
                .anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/login").permitAll())
            .userDetailsService(customUserDetailsService)
            .headers(headers -> headers.frameOptions().sameOrigin())
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())
            .exceptionHandling(handler -> handler.accessDeniedHandler(accessDeniedHandler()))
            // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}
