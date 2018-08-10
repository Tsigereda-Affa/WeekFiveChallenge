package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeesRepository employeesRepository;

    @RequestMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("Employees", employeesRepository.findAll());
        return "list";
    }

    @RequestMapping("/detail/{id}")
    public String showEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeesRepository.findById(id).get());
        return "show";
    }

    @PostMapping("/search")
    public String processForm(String firstname,Model model) {
//        if (result.hasErrors()) {
//            return "list";
//        }
        model.addAttribute("employees", employeesRepository.findByFirstName(firstname));
        return "list";

    }


}
