package com.revature.repository;

import com.revature.model.Flashcard;
import com.revature.model.Role;
import com.revature.model.Topic;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
        Acts as our Central Source for Flashcard storage and operations that affect what is contained
 */
public class FlashcardRepository implements DAO<Flashcard> {

    private static final Logger logger = LoggerFactory.getLogger(FlashcardRepository.class);

    @Override
    public Flashcard create(Flashcard flashcard) {
        return null;
    }

    @Override
    public List<Flashcard> getAll() {
        List<Flashcard> flashcards = new ArrayList<>();

        String sql = "select f.id as flashcard_id, question, answer, topic, \n" +
                "u.id as user_id, first_name, last_name, username, password, role_id from flashcards f \n" +
                "join users u on f.user_id = u.id";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Flashcard flashcard = new Flashcard()
                        .setId(rs.getInt("flashcard_id"))
                        .setQuestion(rs.getString("question"))
                        .setAnswer(rs.getString("answer"))
                        .setTopic(Topic.valueOf(rs.getString("topic")))
                        .setCreator(new User()
                                .setId(rs.getInt("user_id"))
                                .setFirstName(rs.getString("first_name"))
                                .setLastName(rs.getString("last_name"))
                                .setUsername(rs.getString("username"))
                                .setRole(Role.values()[rs.getInt("role_id")])
                        );

                flashcards.add(flashcard);
            }


        } catch(SQLException e){
            logger.warn(e.getMessage());
        }
        return flashcards;
    }

    @Override
    public Flashcard getById(int id) {
        return null;
    }

    @Override
    public Flashcard update(Flashcard flashcard) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
