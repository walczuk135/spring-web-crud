package pl.javaspringwebcrud.springwebcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javaspringwebcrud.springwebcrud.PersonDao.PersonDao;
import pl.javaspringwebcrud.springwebcrud.modelDAO.Person;

@SpringBootApplication
public class SpringWebCrudApplication {


    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(SpringWebCrudApplication.class, args);
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringWebCrudApplication.class, args);

        PersonDao dao=ctx.getBean(PersonDao.class);

        Person person=new Person("Pawel","Walczuk","Lublin , Jana Pawla II 135");
        Person person2=new Person("Piotrek","Lin","Krakow , Pana Balcera 22");
        Person person3=new Person("Leszek","Sakuya","Lubartów");
        Person person4=new Person("Patryk","Menek","Krakow ");
        Person person5=new Person("Agnieszka","Golab","Chelm");

        dao.save(person);
        dao.save(person2);
        dao.save(person3);
        dao.save(person4);
        dao.save(person5);


    }
}
