package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.Chat;
import com.compile.testcompilerspring.data.HibernateUtils;
import com.compile.testcompilerspring.data.Message;
import com.compile.testcompilerspring.data.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/chatRest")
public class ChatRestController {

    @GetMapping("")
    public String fillChat(String test) {
        System.out.println(test);
//        Session session = HibernateUtils.getSession();
//        session.beginTransaction();
//
//        User ourUser = User.searchUserNotPassword(session,name);
//        Chat nowChat = Chat.builder()
//                .id(4)
//                .nameChat("chat1")
//                .build();
//        ArrayList<Message> arrayMessage = Message.getListMessagesFromChat(session,nowChat);
//
//        String myText = Message.getMessageMy();
//        String messageOut = Message.getMessageOut();
//        String chatLayout = "";
//
//        for (Message mess: arrayMessage) {
//            if (mess.getUser().equals(ourUser)){
//                chatLayout += myText.replace("<text>",mess.getMessage());
//            }else
//                chatLayout += messageOut.replace("<text>",mess.getMessage()).replace("<user>",mess.getUser().getName());
//        }
//
//        model.addAttribute("chatLayout", chatLayout);
//        model.addAttribute("chatName","first chat");
////        model.addAttribute("name", name);
//
//        session.getTransaction().commit();
        return "chat";
    }
}
