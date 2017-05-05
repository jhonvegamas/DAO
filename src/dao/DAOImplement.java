package dao;

import connection.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Person;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class DAOImplement implements PersonDAO {

    private ConnectionMySQL db;

    @Override
    public void create(Person person) {
        try {
            this.db = new ConnectionMySQL();
            String query = "insert into persons (id, name, email) values (?, ?, ?)";
            PreparedStatement preparedStmt = this.db.getConnection().prepareStatement(query);            
            preparedStmt.setInt(1, person.getId());
            preparedStmt.setString(2, person.getName());
            preparedStmt.setString(3, person.getEmail());

            preparedStmt.execute();

            this.db.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Person> read() {
        try {
            this.db = new ConnectionMySQL();
            String query = "select * from persons";
            ArrayList<Person> persons = new ArrayList<>();
            Statement statement = this.db.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Person person = new Person();
                person.createPerson(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email")
                );
                persons.add(person);                
            }
            return persons;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
