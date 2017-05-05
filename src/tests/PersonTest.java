package tests;

import controllers.PersonsController;
import logic.Person;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.createPerson(1, "DAO Pattern", "dao@mail.com");

        PersonsController controller = new PersonsController();
        controller.createPerson(person);

        System.out.println(
                controller.getPerson(1).getId()+ " "
                + controller.getPerson(1).getName() + " "
                + controller.getPerson(1).getEmail()
        );

    }
}
