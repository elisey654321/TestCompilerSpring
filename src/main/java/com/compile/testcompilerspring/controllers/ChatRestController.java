package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.Chat;
import com.compile.testcompilerspring.data.HibernateUtils;
import com.compile.testcompilerspring.data.Message;
import com.compile.testcompilerspring.data.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/Rest")
public class ChatRestController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/chat.{name}")
    public String fillChat(@PathVariable String name) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        User ourUser = User.searchUserNotPassword(session, name);
        Chat.ChatBuilder builder = Chat.builder();
        builder.id(4);
        builder.nameChat("chat1");
        Chat nowChat = builder.build();
        ArrayList<Message> arrayMessage = Message.getListMessagesFromChat(session, nowChat);

        String myText = Message.getMessageMy();
        String messageOut = Message.getMessageOut();
        String chatLayout = "";

        for (Message mess : arrayMessage) {
            if (mess.getUser().equals(ourUser)) {
                chatLayout += myText.replace("<text>", mess.getMessage());
            } else
                chatLayout += messageOut.replace("<text>", mess.getMessage()).replace("<user>", mess.getUser().getName());
        }
        session.getTransaction().commit();
        return chatLayout;
    }

    @GetMapping("/sendMessage.{name}.{text}")
    @SendTo("/sendMessage/greetings")
    public String createMessage(@PathVariable String name, @PathVariable String text) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        User ourUser = User.searchUserNotPassword(session, name);
        Chat.ChatBuilder builder = Chat.builder();
        builder.id(4);
        builder.nameChat("chat1");
        Chat nowChat = builder.build();
        Message message = Message.builder()
                .message(text)
                .chat(nowChat)
                .user(ourUser)
                .timestamp(new Date())
                .build();
        session.save(message);
        session.getTransaction().commit();

        simpMessagingTemplate.convertAndSend("/sendMessage/greetings", "Hello");

        return "ok";
    }
}
