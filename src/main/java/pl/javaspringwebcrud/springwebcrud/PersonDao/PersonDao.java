package pl.javaspringwebcrud.springwebcrud.PersonDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javaspringwebcrud.springwebcrud.modelDAO.Person;

import javax.persistence.EntityManager;


@Repository
@Transactional
public class PersonDao {
    private EntityManager entityManager;

    @Autowired
    public PersonDao(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public void save(Person person){
        entityManager.persist(person);
    }
    public Person get(Long id){
        Person person=entityManager.find(Person.class, id);
        return person;
    }
    public void update(Person person){
        entityManager.merge(person);
    }
    public void delete(Person person){
        entityManager.remove(person);
    }

}
