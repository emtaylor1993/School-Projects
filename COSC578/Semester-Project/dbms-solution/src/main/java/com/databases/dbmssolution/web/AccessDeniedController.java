/**
 * ACCESS DENIED CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Access Denied view.
 * 
 * @packages
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework Web Bind Annotation (GetMapping)
 */

package com.databases.dbmssolution.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
    
    @GetMapping("/access_denied")
    public String getAccessDenied() {
        return "access_denied";
    }
}
