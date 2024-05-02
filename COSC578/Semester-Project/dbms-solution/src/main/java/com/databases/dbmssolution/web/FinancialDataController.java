/**
 * FINANCIAL DATA CONTROLLER ENTRY POINT
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class handles web requests for the FinancialData view.
 * 
 * @packages
 *    Java Utilities (ArrayList, List)
 *    Java Validation (Valid)
 *    Spring Framework Beans (Autowired)
 *    Spring Framework Stereotype (Controller)
 *    Spring Framework UI (Model)
 *    Spring Framework Validation (BindingResult)
 *    Spring Framework Web Bind Annotation (GetMapping, PostMapping, RequestParam)
 *    DBMS Solution (FinancialData, FinancialDataService)
 */

package com.databases.dbmssolution.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.databases.dbmssolution.entity.FinancialData;
import com.databases.dbmssolution.service.FinancialDataService;

@Controller
public class FinancialDataController {

    @Autowired
    FinancialDataService financialDataService;

    @GetMapping("/financial_data")
    public String getFinancialDataView(Model model) {
        model.addAttribute("financialData", financialDataService.getAllFinancialData());
        return "financial_data";
    }

    @GetMapping("/financial_data_results")
    public String getFinancialDataResultsView(Model model, @RequestParam(required = false) String username) {
        List<FinancialData> results = new ArrayList<FinancialData>();
        List<FinancialData> financialData = financialDataService.getAllFinancialData();
        for (int i = 0; i < financialData.size(); i++) {
            if (financialData.get(i).getEmployee().getUsername().equals(username)) {
                results.add(financialData.get(i));
            }
        }
        model.addAttribute("results", results);
        return "financial_data_results";
    }

    @GetMapping("/financial_data_search")
    public String getFinancialDataSearch(Model model) {
        model.addAttribute("financialData", financialDataService.getAllFinancialData());
        return "financial_data_search";
    }

    @GetMapping("/financial_data_form")
    public String getFinancialDataForm(Model model, @RequestParam(required = false) Long financialId) {
        int index = getFinancialDataIndex(financialId);
        model.addAttribute("financialData", index == -1000 ? new FinancialData() : financialDataService.getAllFinancialData().get(index));
        return "financial_data_form";
    }

    @GetMapping("/deleteFinancialData")
    public String deleteFinancialData(@RequestParam(required = false) Long financialId) {
        financialDataService.deleteFinancialData(financialId);
        return "redirect:/financial_data";
    }

    @PostMapping("/submitFinancialData")
    public String submitFinancialDataForm(@Valid FinancialData financialData, BindingResult result) {
        if (result.hasErrors()) return "financial_data_form";
        int index = getFinancialDataIndex(financialData.getFinancialId());
        if (index == -1000) {
            financialDataService.saveFinancialData(financialData);
        } else {
            financialDataService.getAllFinancialData().set(index, financialData);
        }
        
        return "redirect:/financial_data";
    }

    public int getFinancialDataIndex(Long financialId) {
        for (int i = 0; i < financialDataService.getAllFinancialData().size(); i++) {
            if (financialDataService.getAllFinancialData().get(i).getFinancialId().equals(financialId)) return i;
        }
        return -1000;
    }
}
