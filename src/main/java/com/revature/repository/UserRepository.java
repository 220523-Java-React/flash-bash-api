package com.revature.repository;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User>{

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Override
    public User create(User user) {
        // we are receiving a full user object
        // we need a query to insert that record
        //                                                                                1,2,3,4,5
        String sql = "insert into users(first_name, last_name, username, password, role_id) values(?,?,?,?,?)";

        /*
                This is a Try-With-Resources block
                used when you have resources that have open channels that you need to eventually close

                try with resource WILL automatically close anything that implements the AutoClosable interface
         */
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRole().ordinal());

            int success = stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                int id = keys.getInt(1);
                return user.setId(id);
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll(){
        // Empty lists of users, will add any new users from the result set
        List<User> users = new ArrayList<>();
        String sql = "select * from users order by id";

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
                        .setId(results.getInt("id"))
                        .setRole(Role.values()[results.getInt("role_id")])
                );


                User user2 = new User().setFirstName("first");
            }


        }catch(SQLException e){
            logger.warn(e.getMessage());
        }

        return users;
    }

    @Override
    public User getById(int id){

        String sql = "select * from users where id = ?";
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                // build return the user and return it
                return new User()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setUsername(rs.getString("username"))
                        .setPassword(rs.getString("password"))
                        .setRole(Role.values()[rs.getInt("role_id")]);
            }
        } catch(SQLException e){
            logger.warn(e.getMessage());
        }
        return null;
    }

    public User getByUsername(String username){
        String sql = "select * from users where username = ?";
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                // build return the user and return it
                return new User()
                        .setId(rs.getInt("id"))
                        .setFirstName(rs.getString("first_name"))
                        .setLastName(rs.getString("last_name"))
                        .setUsername(rs.getString("username"))
                        .setPassword(rs.getString("password"))
                        .setRole(Role.values()[rs.getInt("role_id")]);
            }
        } catch(SQLException e){
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public User update(User user) {
        String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ?, role_id = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRole().ordinal());

            stmt.setInt(6, user.getId());

            int success = stmt.executeUpdate();

            // if we successfully update the user, return the new database record for it
            if(success != 0){
                return getById(user.getId());
            }
        } catch(SQLException e){
            logger.warn(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from users where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int success = stmt.executeUpdate();
            // returns true if success is not 0 and thus the operation was a success
            return success != 0;
        }catch(SQLException e){
            logger.warn(e.getMessage());
        }
        return false;
    }
}
