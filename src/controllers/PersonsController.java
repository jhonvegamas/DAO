package controllers;

import dao.DAOImplement;
import java.util.ArrayList;
import logic.Person;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class PersonsController {

    private DAOImplement dao;

    public PersonsController() {
        this.dao = new DAOImplement();
    }

    public void createPerson(Person person) {
        this.dao.create(person);
    }

    public ArrayList<Person> getAllPersons() {
        return this.dao.read();
    }

    public Person getPerson(int id) {
        return this.dao.read().get(id-1);
    }
}
