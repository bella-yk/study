package com.study.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Getter
@Setter
public class Users {
    @Id
    private String _id;

    private String user_id;

    private String name;
}
