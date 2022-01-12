package com.example.springSecurityDemo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Builder(toBuilder = true)
@Getter
@Setter
public class User {
    @Id
    String Id;
    String name;
    String role;
    String password;
    String email;
}
