package com.revature.repository;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User>{
    @Override
    public User create(User user) {
        // we are receiving a full user object
        // we need a query to insert that record
        //                                                                                1,2,3,4
        String sql = "insert into users(first_name, last_name, username, password) values(?,?,?,?)";

        /*
                This is a Try-With-Resources block
                used when you have resources that have open channels that you need to eventually close

                try with resource WILL automatically close anything that implements the AutoClosable interface
         */
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());

            int success = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll(){
        // Empty lists of users, will add any new users from the result set
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                // go through each result, build a User object for that data, add that user object the users list
                users.add(new User()
                        .setLastName(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setFirstName(results.getString("first_name"))
                        .setId(results.getInt("id")));


                User user2 = new User().setFirstName("first");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
