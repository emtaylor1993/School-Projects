/**
 * EMPLOYEE CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the Employee view.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 *    Java Validation (Valid)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Security Crypto Password (PasswordEncoder)
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework UI (Model)
 *    Spring Framework Validation (BindingResult)
 *    Spring Framework Web Bind Annotation (GetMapping, PostMapping, RequestParam)
 *    DBMS Solution (Employee, EmployeeService)
 */

package com.databases.dbmssolution.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.databases.dbmssolution.entity.Employee;
import com.databases.dbmssolution.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @GetMapping("/employees")
    public String getEmployeeView(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees";
    }

    @GetMapping("/employee_results")
    public String getEmployeeReultsView(Model model, @RequestParam(required = false) String role) {
        List<Employee> results = new ArrayList<Employee>();
        List<Employee> employees = employeeService.getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getRole().equals(role)) {
                results.add(employees.get(i));
            }
        }
        model.addAttribute("results", results);
        return "employee_results";
    }

    @GetMapping("/employee_search")
    public String getEmployeeSearch() {
        return "employee_search";
    }
    
    @GetMapping("/employee_form")
    public String getEmployeeForm(Model model, @RequestParam(required = false) Long employeeId) {
        int index = getEmployeeIndex(employeeId);
        model.addAttribute("employee", index == -1000 ? new Employee() : employeeService.getEmployees().get(index));
        return "employee_form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(required = false) Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees";
    }

    @PostMapping("/submitEmployee")
    public String submitEmployeeForm(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) return "employee_form";
        int index = getEmployeeIndex(employee.getEmployeeId());
        if (index == -1000) {
            System.out.println(employee.getEmployeeId());
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeService.saveEmployee(employee);
        } else {
            System.out.println(employee.getEmployeeId());
            employeeService.getEmployees().set(index, employee);
        }
        
        return "redirect:/employees";
    }

    public int getEmployeeIndex(Long employeeId) {
        for (int i = 0; i < employeeService.getEmployees().size(); i++) {
            if (employeeService.getEmployees().get(i).getEmployeeId().equals(employeeId)) return i;
        }
        return -1000;
    }
}
