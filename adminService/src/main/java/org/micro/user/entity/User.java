package org.micro.user.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
}
