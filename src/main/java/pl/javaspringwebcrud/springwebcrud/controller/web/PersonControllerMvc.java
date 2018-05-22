package pl.javaspringwebcrud.springwebcrud.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javaspringwebcrud.springwebcrud.dao.PersonDao;
import pl.javaspringwebcrud.springwebcrud.model.Person;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonControllerMvc {
    private PersonDao personDao;

    @Autowired
    public PersonControllerMvc(PersonDao personDao){
        this.personDao=personDao;
    }

    @GetMapping
    public String listCities(Model model) {
        List<Person> personList = personDao.getAll();
        model.addAttribute("personList",personList);
        return "list";
    }

    @PostMapping
    public String addCity(@ModelAttribute Person personModel, RedirectAttributes redirectAttributes){
        personDao.save(personModel);
        redirectAttributes.addFlashAttribute("message","Person added successfuly");
        return "redirect:/";
    }

}
