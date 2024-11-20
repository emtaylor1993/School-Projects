/**
 * SWIFTRECIPE JWT AUTHENTICATION FILTER CLASS
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class contains functionality to validate the JSON Web Token for
 *    each incoming request.
 * 
 * @packages
 *    Java IO (IOException)
 *    Java Extensions (FilterChain, ServletException, HttpServletRequest, HttpServletResponse)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Security Authentication (UsernamePasswordAuthenticationToken)
 *    Spring Framework Security Core (SecurityContextHolder, UserDetails, UserDetailsService)
 *    Spring Framework Stereotype (Component)
 *    Spring Framework Web (OncePerRequestFilter)
 */

package com.swe.swiftrecipe.utilities;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtUtility.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtUtility.validateToken(token, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
