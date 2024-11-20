/**
 * SWIFTRECIPE SECURITY CONFIGURATION CLASS
 * 
 * @author Sade Jn Baptiste
 * @author Lakshmi Kotikalapudi
 * @author Andy Nguyen
 * @author Shivani Samarla
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class represents the Security Configuration class.
 * 
 * @packages
 *    Spring Framework Beans Factory Annotation (Autowired)
 *    Spring Framework Context Annotation (Bean, Configuration)
 *    Spring Framework Security Authentication (AuthenticationManager, AuthenticationConfiguration)
 *    Spring Framework Security Configuration Annotation Web Builders (HttpSecurity)
 *    Spring Framework Security Configuration Annotation Web Configuration (EnableWebSecurity)
 *    Spring Framework Security Web (SecurityFilterChain)
 *    Spring Framework Security Web Authentication (UsernamePasswordAuthenticationFilter)
 *    Spring Framework Security Web Utilities Matcher (AntPathRequestMatcher)
 *    SwiftRecipe Utilities (JWTAuthenticationFilter, JWTUtility)
 */

package com.swe.swiftrecipe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.swe.swiftrecipe.utilities.JWTAuthenticationFilter;
import com.swe.swiftrecipe.utilities.JWTUtility;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    JWTUtility jwtUtility;
    
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Configures the security settings for this web application
     * 
     * @param http - HttpSecurity object to configure security settings
     * @return SecurityFilterChain - Object representing the security filter chain
     * @throws Exception - Handle exceptions that may occur during configuration
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.ignoringAntMatchers("/h2/**").disable())
            .authorizeRequests(auth -> auth
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/login?error=true").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/signupUser").permitAll()
                .antMatchers("/reset").permitAll()
                .antMatchers("/resetPassword").permitAll()
                .antMatchers("/api/auth/authenticate").permitAll()
                .antMatchers("/images/*.png", "/*.js", "/*.css").permitAll()
                .anyRequest().authenticated())
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin(form -> form.loginPage("/login").permitAll())
            .userDetailsService(customUserDetailsService)
            .headers(headers -> headers.frameOptions().sameOrigin())
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll())
            .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}