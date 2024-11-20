package com.swe.swiftrecipe.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.swe.swiftrecipe.utilities.JWTUtility;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtility jwtUtility;

    @PostMapping("/authenticate")
    public ModelAndView authenticate(
        @RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request
    ) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtility.generateToken(username);

            ModelAndView modelAndView = new ModelAndView("redirect:/");
            request.getSession().setAttribute("JWT_TOKEN", token);
            return modelAndView;
        } catch (BadCredentialsException e) {
            return new ModelAndView("redirect:/login?error");
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