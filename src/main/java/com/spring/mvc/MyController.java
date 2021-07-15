package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.ws.Binding;
import javax.xml.ws.RequestWrapper;

@Controller
//@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView()
    {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails()
    {
        return "askTest";
    }

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails()
//    {
//        return "show-emp-details-view";
//    }


//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(HttpServletRequest request, Model model)
//    {
//        String empName = request.getParameter("employeeName"); //employeeName из askTest
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttr", empName);
//
//        return "show-emp-details-view";
//    }

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model)
    {
        empName = "Mr. " + empName;
        model.addAttribute("nameAttr", empName);

        return "show-emp-details-view";
    }


    @RequestMapping("/askDetailsForm")
    public String askEmployeeDetailsForm(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "askForm";
    }

    @RequestMapping("/showDetailsForm")
    public String showEmployeeDetailsForm(@ModelAttribute("employee") Employee emp)
    {
        String name = emp.getName();
        emp.setName("Mr " + name);
        String surname = emp.getSurname();
        emp.setSurname(surname + " !");
        int salary = emp.getSalary();
        emp.setSalary(salary*10);
        return "showForm";
    }

    @RequestMapping("/askDetailsFormVal")
    public String askEmployeeDetailsFormVal(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "askFormVal";
    }

    @RequestMapping("/showDetailsFormVal")
    public String showEmployeeDetailsFormVal(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult)
    {   //bindingResult идет строго после модели объекта, на случай, если параметров в методе больше
        //System.out.println("length " + emp.getSurname().length());
        if (bindingResult.hasErrors()) //успешна валидация или нет
        {
            return "askFormVal"; //неуспешна
        }
        else return "showFormVal";
    }

}
