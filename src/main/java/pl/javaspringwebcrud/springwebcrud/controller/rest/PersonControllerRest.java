package pl.javaspringwebcrud.springwebcrud.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.javaspringwebcrud.springwebcrud.dao.PersonDao;
import pl.javaspringwebcrud.springwebcrud.model.Person;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonControllerRest {
    private PersonDao personDao;

    @Autowired
    public PersonControllerRest(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person>getPersons(@RequestParam(defaultValue = "firstName")String orderBy){
        List<Person> personList=personDao.getAll();
        if("firstName".equals(orderBy)){
            personList.sort(Comparator.comparing(Person::getFirstName));
        }
        else if("lastName".equals(orderBy)){
            personList.sort(Comparator.comparing(Person::getLastName));
        }
        else if("address".equals(orderBy)){
            personList.sort(Comparator.comparing(Person::getAddress));
        }
        return personList;
    }

    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@PathVariable Long id){
        return personDao.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePerson(@RequestBody Person person){
        personDao.save(person);
    }



}
