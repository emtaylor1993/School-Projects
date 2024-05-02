/**
 * CUSTOM ACCESS DENIED HANDLER CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Custom Access Denied Handler that will redirect
 *    the user to a more user-friendly error page.
 * 
 * @packages
 *    Java IO (IOException)
 *    JavaX Servlet (ServletException, HttpServletRequest, HttpServletResponse)
 *    Spring Framework Security (AccessDeniedException, AccessDeniedHandler)
 */

package com.databases.dbmssolution.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, 
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath() + "/access_denied");
    }
}
