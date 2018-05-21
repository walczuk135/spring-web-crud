package pl.javaspringwebcrud.springwebcrud.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javaspringwebcrud.springwebcrud.model.Person;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("personModel",new Person());
        return "index";
    }

}
