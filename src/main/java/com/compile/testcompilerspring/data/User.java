package com.compile.testcompilerspring.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @Column(length = 64)
    String name;

    @Column(name = "password")
    String password;


    public Boolean tryCreatedUser(Session session) {
        ArrayList<User> users = (ArrayList<User>)session.createSQLQuery("select * from users where users.name = :name")
                .setParameter("name",this.getName())
                .addEntity(User.class)
                .list();
        return users.size() == 0;
    }
    public static User searchUser(Session session,User user) {
        User ourUser = null;

        ArrayList<User> users = (ArrayList<User>)session.createSQLQuery("select * from users where users.name = :name and users.password = :password")
                .setParameter("name",user.getName())
                .setParameter("password",user.getPassword())
                .addEntity(User.class)
                .list();
        for (User userNow:users) {
            ourUser = userNow;
        }
        return ourUser;
    }
}
