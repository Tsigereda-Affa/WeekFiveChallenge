package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;


    @RequestMapping("/")
    public String listEmployees(Model model) {
        model.addAttribute("Employees", employeesRepository.findAll());
        return "list";
    }
    @GetMapping("/addDepartment")
    public String departmentForm(Model model) {
        model.addAttribute("departments", new Departments());
        return "departmentform";
    }

    @PostMapping("/processDepartments")
    public String DepartmentForm(@Valid Departments departments, BindingResult result) {
        if (result.hasErrors()) {
            return "departmentform";
        }
        departmentsRepository.save(departments);
        return "redirect:/";
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


//    @PostMapping("/search2")
//    public String processFormEmp(String department,Model model) {
////        if (result.hasErrors()) {
////            return "list";
////        }
//        model.addAttribute("departments", departmentsRepository.findByDepartment(department));
//        return "list";
//
//    }

}
