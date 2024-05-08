package org.TodoApp.com.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.TodoApp.com.dao.TodoItemDAO;
import org.TodoApp.com.db.dbConnection;
import org.TodoApp.com.model.Person;
import org.TodoApp.com.model.TodoItem;

public class TodoItemDAOImpl implements TodoItemDAO{

    private  final List<TodoItem> todoItemList = new ArrayList<>();
    static Connection connection = dbConnection.getDbConnection();


    @Override
    public TodoItem create(TodoItem todoItem) {

        String insertNewTodoItem = "INSERT INTO todo_item (title,description,deadline,done,assignee_id) VALUES (?, ?,?,?,?)";

        try (

                PreparedStatement preparedStatement = connection.prepareStatement(insertNewTodoItem, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getTaskDescription());
            preparedStatement.setDate(3,   Date.valueOf(todoItem.getDeadLine()));
            preparedStatement.setBoolean(4, todoItem.getIsDone());
            preparedStatement.setInt(5, todoItem.getAssignee());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Insert operation for todo_item  successfully.");
            } else {
                connection.rollback();
                System.out.println("Insert operation for todo_item failed.");
            }
            try (
                    ResultSet generatedKey = preparedStatement.getGeneratedKeys()
            ) {
                if (generatedKey.next()) {
                    todoItem.setId(generatedKey.getInt(1));
                } else {
                    connection.rollback();
                    System.out.println("Get key operation for todo_item failed.");
                }
            }
            connection.setAutoCommit(true);
        } catch (java.sql.SQLException e) {
            System.out.println("Insert failed : " + e.getMessage());
        }
        return todoItem;

    }

    @Override
    public Collection<TodoItem> findAll() {

        try (


                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM todo_item")
        ) {
            while (resultSet.next()) {
                todoItemList.add(new TodoItem(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)));

            }
        } catch (java.sql.SQLException e) {
            System.out.println("Failed to fetch data for findAll() " + e.getMessage());
        }
        return todoItemList;
    }

    @Override
    public TodoItem findById(int id) {
        TodoItem todoItem = null;
        try (

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_item WHERE todo_id = ?")
        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                //todo:byt ut till while
                if (resultSet.next()) {
                    todoItem = new org.TodoApp.com.model.TodoItem(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getBoolean(5),
                            resultSet.getInt(6));
                }else{
                    System.out.println("Could not find a todo item with id: " + id);
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Failed to find todo item with id: " + id + " " + e.getMessage());
        }
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean isDone) {

        try (


                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_item WHERE done = ?")

        ) {
                preparedStatement.setBoolean(1, isDone);
                try (
                        ResultSet resultSet = preparedStatement.executeQuery()
                ) {
                    while (resultSet.next()) {
                        todoItemList.add(new TodoItem(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getDate(4).toLocalDate(),
                                resultSet.getBoolean(5),
                                resultSet.getInt(6)));
                    }
                }
            } catch (java.sql.SQLException e) {
                System.out.println("Failed to get todo item by status) " + e.getMessage());
            }
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByAssignee(int id) {
        try (


                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_item WHERE assignee_id = ?")

        ) {
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    todoItemList.add(new TodoItem(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getBoolean(5),
                            resultSet.getInt(6)));
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Failed to get todo item by assignee id) " + e.getMessage());
        }
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {
        try (


                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todo_item WHERE assignee_id = ?")

        ) {
            preparedStatement.setInt(1, person.getId());
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    todoItemList.add(new TodoItem(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            resultSet.getBoolean(5),
                            resultSet.getInt(6)));
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Failed to get todo item by assignee id) " + e.getMessage());
        }
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findByUnassignedTodoItems() {
        try (


                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM todo_item WHERE assignee_id = null");

        ) {
            while (resultSet.next()) {
                todoItemList.add(new TodoItem(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getBoolean(5),
                    resultSet.getInt(6)));
                }

        } catch (java.sql.SQLException e) {
            System.out.println("Failed to get unassigned todo items) " + e.getMessage());
        }
        return todoItemList;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        String updateTodoItem= "UPDATE todo_item SET title = ?, description = ?, deadline = ?,done = ?,assignee_id =? WHERE todo_id = ?";
        try (

                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(updateTodoItem)
        ) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1,todoItem.getTitle());
            preparedStatement.setString(2,todoItem.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todoItem.getDeadLine()));
            preparedStatement.setBoolean(4,todoItem.getIsDone());
            preparedStatement.setInt(5,todoItem.getAssignee());
            preparedStatement.setInt(6,todoItem.getId());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Update operation for todo item successfully.");
            } else {
                connection.rollback();
                System.out.println("Update operation for todo item failed.");
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Exception Updating the todo item table: " + e.getMessage());
        }
        return todoItem;
    }

    @Override
    public boolean deleteById(int id) {
        boolean isDeleted = false;
        int rowsDeleted;

        String deleteTodoItem = "DELETE FROM todo_item WHERE todo_id = ?";
        try (
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(deleteTodoItem)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);

            rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                isDeleted = true;
                System.out.println("Delete operation for the todo item table successfully.");
            } else {
                connection.rollback();
                System.out.println("Delete operation for the todo item table failed.");
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Delete todo item id: " + id +" failed: " + e.getMessage());
        }
        return isDeleted;
    }

}

