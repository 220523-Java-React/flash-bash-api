package com.revature.repository;

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
        return null;
    }

    @Override
    public List<User> getAll() {
        // Empty lists of users, will add any new users from the result set
        List<User> users = new ArrayList<>();

        Connection connection = ConnectionUtility.getConnection();
        String sql = "select * from users";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                System.out.println(results.getString("first_name"));
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
