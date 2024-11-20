/**
 * SWIFTRECIPE AUTHENTICATION CONTROLLER CLASS
 *
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class ensures that only authenticated users can receive access
 *    tokens. It checks for valid credentials before assigning a JWT to the client.
 * 
 * @packages
 *    Java Extensions Servlet (HttpServletRequest)
 *    Spring Framework Beans Factory Annotation (Autowired)
 *    Spring Framework Security Authentication (AuthenticationManager, BadCredentialsException, UsernamePasswordAuthenticationToken)
 *    Spring Framework Security Core (Authentication, SecurityContextHolder)
 *    Spring Framework Web Bind Annotation (PostMapping, RequestMapping, RequestParam, RestController)
 *    Spring Framework HTTP (HttpHeaders, HttpStatus)
 *    SwiftRecipe Utilities (JWTUtility)
 */

package com.swe.swiftrecipe.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.swe.swiftrecipe.utilities.JWTUtility;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtility jwtUtility;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
        @RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request
    ) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtility.generateToken(username);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/");
            headers.add("Authorization", "Bearer " + token);
            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
        } catch (BadCredentialsException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/login?error");
            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
        }
    }

    @PostMapping("/verify-session-token")
    public String verifySessionToken(HttpServletRequest request) {
        String token = (String) request.getSession().getAttribute("JWT_TOKEN");
        if (token != null) {
            return "Token is present: " + token;
        } else {
            return "No token found in session.";
        }
    }
}