package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.*;
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

    @GetMapping("/GetMain_Display.{name}")
    public String GetMain_Display(@PathVariable String name){
        return "";
    }

    @GetMapping("/GetContacts.{name}")
    public String GetContacts(@PathVariable String name){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        User ourUser = User.searchUserNotPassword(session, name);
        ArrayList<UsersChat> arrayListContacts = UsersChat.getArrayListContacts(ourUser, session);

        StringBuilder contactsLayout = new StringBuilder();

        for (UsersChat usersChat:arrayListContacts) {
            contactsLayout.append(UsersChat.getContact()
                    .replace("numberContact","chat" + usersChat.getChat().getId())
                    .replace("name",usersChat.getChat().getNameChat()));
        }
        session.getTransaction().commit();
        return contactsLayout.toString();
    }

    @GetMapping("/chat.{id_chat}.{name}")
    public String fillChat(@PathVariable String name, @PathVariable Integer id_chat) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        User ourUser = User.searchUserNotPassword(session, name);
        Chat nowChat = Chat.builder().id(id_chat).build();

        ArrayList<Message> arrayMessage = Message.getListMessagesFromChat(session, nowChat);

        String myText = Message.getMessageMy();
        String messageOut = Message.getMessageOut();
        StringBuilder chatLayout = new StringBuilder();

        for (Message mess : arrayMessage) {
            if (mess.getUser().equals(ourUser)) {
                chatLayout.append(myText.replace("<text>", mess.getMessage()));
            } else
                chatLayout.append(messageOut.replace("<text>", mess.getMessage()).replace("<user>", mess.getUser().getName()));
        }
        session.getTransaction().commit();
        return chatLayout.toString();
    }

    @GetMapping("/sendMessage.{id_chat}.{name}.{text}")
    @SendTo("/sendMessage/greetings")
    public String createMessage(@PathVariable String name, @PathVariable String text, @PathVariable Integer id_chat) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        User ourUser = User.searchUserNotPassword(session, name);
        Chat nowChat = Chat.builder().id(id_chat).build();

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
