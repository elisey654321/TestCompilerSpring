package com.compile.testcompilerspring.data;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void createTable(){
        User user = User.builder()
                .name("test")
                .password("123")
                .build();

        Message message = Message.builder()
                .message("Test")
                .user(user)
                .build();

        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.saveOrUpdate(user);
        session.saveOrUpdate(message);

        session.getTransaction().commit();

    }
}