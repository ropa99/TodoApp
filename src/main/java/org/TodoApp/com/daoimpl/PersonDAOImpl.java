package org.TodoApp.com.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.TodoApp.com.dao.PersonDAO;
import org.TodoApp.com.db.dbConnection;
import org.TodoApp.com.model.Person;

public class PersonDAOImpl implements PersonDAO {

    private  final List<Person> personList = new ArrayList<>();
    private Connection con = getAlternateConnection();

    //Save to db
    @Override
    public Person create(Person person) {
        String insertNewPerson = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
        //String insertNewPerson = "INSERT INTO person (1,2) VALUES (?, ?)";
        try (
                Connection connection = dbConnection.getDbConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(insertNewPerson, java.sql.PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Insert operation for person table successfully.");
            } else {
                connection.rollback();
                System.out.println("Insert operation for person table failed.");
            }
            try (
                    java.sql.ResultSet generatedKey = preparedStatement.getGeneratedKeys()
            ) {
                if (generatedKey.next()) {
                    person.setId(generatedKey.getInt(1));
                } else {
                    connection.rollback();
                    System.out.println("Insert operation for city table failed.");
                }
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Insert failed : " + e.getMessage());
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        try (

                Connection connection = dbConnection.getDbConnection();
                java.sql.Statement statement = connection.createStatement();
                java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM person")
        ) {
            while (resultSet.next()) {
                personList.add(new Person(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));

            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch data for findAll() " + e.getMessage());
        }
        return personList;
    }

    @Override
    public Person findById(int id) {
        Person person = null;
        try (
                Connection connection = dbConnection.getDbConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?")
        ) {
            preparedStatement.setInt(1, id);
            try (
                    java.sql.ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                //todo:byt ut till while
                if (resultSet.next()) {
                    person = new Person(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch data for findById() with id: " + id + " " + e.getMessage());
        }
        return person;

    }



    @Override
    public Collection<Person> findByName(String name) {

        try (
                Connection connection = dbConnection.getDbConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE name = ?")
        ) {
            preparedStatement.setString(1, name);
            try (
                    java.sql.ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    personList.add(new Person(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch data for findByName() with name: " + name + " " + e.getMessage());
        }
        return personList;
    }


    /****************************/

    @Override
    public Person update(Person person) {
        String updatePerson = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";
        try (
                Connection connection = dbConnection.getDbConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(updatePerson)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());

            int rowsInserted = preparedStatement.executeUpdate();

            /* todo: remove */
            if (rowsInserted > 0) {
                System.out.println("Update operation for person table successfully.");
            } else {
                connection.rollback();
                System.out.println("Update operation for person table failed.");
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Exception Updating table Person: " + e.getMessage());
        }
        return person;
    }

    @Override
    public boolean deleteById(int Id) {
        boolean isDeleted = false;
        int rowsDeleted = 0;
        String deletePerson = "DELETE FROM person WHERE person_id = ?";
        try (
                Connection connection = dbConnection.getDbConnection();
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(deletePerson)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, Id);

            rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                isDeleted = true;
                System.out.println("Delete operation for person table successfully.");
            } else {
                connection.rollback();
                System.out.println("Delete operation for person table failed.");
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Delete Id: " + Id +" failed: " + e.getMessage());
        }
        return isDeleted;
    }

    private Connection getAlternateConnection() {

            return dbConnection.getDbConnection();

    }
}
