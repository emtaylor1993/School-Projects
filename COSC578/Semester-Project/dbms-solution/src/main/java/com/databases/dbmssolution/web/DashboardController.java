/**
 * DASHBOARD CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Dashboard view.
 * 
 * @packages
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework Web Bind Annotation GetMapping)
 */

package com.databases.dbmssolution.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String getDashboard() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String getLogout() {
        return "redirect:/login";
    }
}
