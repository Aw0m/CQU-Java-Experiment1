package com.example.javaexperiment.dao;

import com.example.javaexperiment.models.User;
import com.example.javaexperiment.utils.Utilities;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Criteria.where;

//import java.util.List;

/**
 * @Author: Awom
 * @Date: 2021/10/27 23:08
 */
public class UserDao {
    private final MongoOperations mongoOperations = Utilities.GetMongoTemplate();

    public boolean createUser(User user) {
        if (mongoOperations.findById(user.getUserName(), User.class) != null) {
            return false;
        }
        mongoOperations.insert(user);
        return true;
    }

//    public boolean createUser(List<User> users) {
//        for (User user:users) {
//            if (mongoOperations.findById(user.getUserName(), User.class) != null) {
//                System.out.println(user.toString() + " is in MongoDB");
//                return false;
//            }
//        }
//        for (User user:users) {
//            mongoOperations.insert(user);
//        }
//        return true;
//    }

    public boolean deleteUser(User user) {
        DeleteResult deleteResult = mongoOperations.remove(user);
        return true;
    }

    public User retrieveUser(String userName) {
        return mongoOperations.findById(userName, User.class);
    }

    public void updateUser(String userName, String password) {
        UpdateResult updateResult = mongoOperations.updateFirst(
                query(where("userName").is(userName)),
                update("password", password),
                User.class
        );
    }
}
