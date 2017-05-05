package dao;

import java.util.ArrayList;
import logic.Person;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public interface PersonDAO {

    public void create(Person person);

    public ArrayList<Person> read();

    public void update(Person person);

    public void delete(Person person);
}
