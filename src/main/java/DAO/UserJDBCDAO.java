package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDAO {
    private Connection connection;

    public UserJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user){
        String update = "insert into users (name, age, money) values (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(update)){
            statement.setString (1,user.getName());
            statement.setInt (2,user.getAge());
            statement.setInt(3, user.getMoney());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String name){
        String update = "delete into users where name = '?'";
        try (PreparedStatement statement = connection.prepareStatement(update)){
            statement.setString (1,name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeUser (User user, String name){
        String update = "UPDATE users SET name = ? age = ?  money = ? where name = ?";
        try (PreparedStatement statement = connection.prepareStatement(update)){
            statement.setString (1,user.getName());
            statement.setInt (2,user.getAge());
            statement.setInt(3, user.getMoney());
            statement.setString(4, name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        String query = "select * from users";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (!resultSet.isLast()){
                resultSet.next();
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getInt("money"));
                list.add(user);
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists users (id bigint auto_increment, name varchar(256), age bigint, money bigint, primary key (id))");
        stmt.close();
    }



}
