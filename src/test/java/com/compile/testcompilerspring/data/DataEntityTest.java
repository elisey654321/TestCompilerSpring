package com.compile.testcompilerspring.data;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.Date;

class DataEntityTest {

    @Test
    void createTable(){
        User user1 = User.builder()
                .name("User1")
                .password("123")
                .build();

        User user2 = User.builder()
                .name("User2")
                .password("123")
                .build();

        Chat chat = Chat.builder()
                .nameChat("chat1")
                .build();

        UsersChat usersChat1 = UsersChat.builder()
                .user(user1)
                .build();

        UsersChat usersChat2 = UsersChat.builder()
                .user(user2)
                .build();

        Message message = Message.builder()
                .message("Test")
                .user(user1)
                .chat(chat)
                .timestamp(new Date())
                .build();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message message1 = Message.builder()
                .message("new message user1")
                .user(user1)
                .chat(chat)
                .timestamp(new Date())
                .build();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message message2 = Message.builder()
                .message("new message user2")
                .user(user2)
                .chat(chat)
                .timestamp(new Date())
                .build();

        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.saveOrUpdate(user1);
        session.saveOrUpdate(user2);
        session.saveOrUpdate(chat);
        session.saveOrUpdate(usersChat1);
        session.saveOrUpdate(usersChat2);
        session.saveOrUpdate(message);
        session.saveOrUpdate(message1);
        session.saveOrUpdate(message2);

        session.getTransaction().commit();

    }
}