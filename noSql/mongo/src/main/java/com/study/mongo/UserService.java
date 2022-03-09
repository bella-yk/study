package com.study.mongo;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Users> getUserList() {
//        Query query = new Query().addCriteria(Criteria.where("title").is(title));
        return mongoTemplate.findAll(Users.class);
    }

    public Users getUserById(String userId) {
        Query query = new Query().addCriteria(Criteria.where("user_id").is(userId));
        return mongoTemplate.findOne(query, Users.class);
    }

    public Users saveUsers(Users users) {
        return mongoTemplate.save(users);
    }

    public DeleteResult deleteUser(Users users) {
        return mongoTemplate.remove(users);
    }
}
