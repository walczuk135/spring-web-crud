package pl.javaspringwebcrud.springwebcrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javaspringwebcrud.springwebcrud.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional
public class PersonDao {
    private EntityManager entityManager;

    @Autowired
    public PersonDao(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Transactional
    public void save(Person person){
        entityManager.persist(person);
    }

    @Transactional(readOnly = true)
    public Person get(Long id){
        Person person=entityManager.find(Person.class, id);
        return person;
    }

    @Transactional
    public void update(Person person){
        Person find=entityManager.find(Person.class, person.getId());
        if(find!=null){
            find.setFirstName(person.getFirstName());
            find.setLastName(person.getLastName());
            find.setAddress(person.getAddress());
        }
    }

    @Transactional
    public void delete(Long id){
        Person personToRemove=entityManager.find(Person.class,id);
        entityManager.remove(personToRemove);
    }

    public List<Person> getAll(){
        final String getAll="SELECT p FROM Person p";
        TypedQuery<Person> getAllquery=entityManager.createQuery(getAll,Person.class);
        List<Person> resultList=getAllquery.getResultList();
        return resultList;
    }


}
