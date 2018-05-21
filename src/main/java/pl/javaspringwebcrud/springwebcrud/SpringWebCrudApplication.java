package pl.javaspringwebcrud.springwebcrud;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.provider.HibernateUtils;
import pl.javaspringwebcrud.springwebcrud.PersonDao.PersonDao;
import pl.javaspringwebcrud.springwebcrud.modelDAO.Person;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringWebCrudApplication {


    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(SpringWebCrudApplication.class, args);
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringWebCrudApplication.class, args);

        PersonDao dao=ctx.getBean(PersonDao.class);

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Pawel","Walczuk","Lublin"));
        personList.add(new Person("Piotrek","Lin","Krakow"));
        personList.add(new Person("Leszek","Sakuya","Lubartów"));
        personList.add(new Person("Patryk","Menek","Krakow "));
        personList.add(new Person("Agnieszka","Golab","Chelm"));


        PersonDao personDao = ctx.getBean(PersonDao.class);
        personList.forEach(personDao::save);

       List<Person>allPerson=dao.getAll();
       allPerson.forEach(System.out::println);

       

        ctx.close();

    }
}
