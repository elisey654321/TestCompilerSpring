package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.HibernateUtils;
import com.compile.testcompilerspring.data.JSON_Classes.UserJSON;
import com.compile.testcompilerspring.data.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.ArrayList;

@Controller
public class RegistrationController {

    @PostMapping("/Registration")
    public @ResponseBody ResponseEntity<String> CreateItemPost(HttpServletRequest request,
                                          UriComponentsBuilder uriComponentsBuilder) {

        ResponseEntity response = null;

        try(Session session = HibernateUtils.getSession();) {
            session.beginTransaction();

            BufferedReader reader = request.getReader();
            String line,jsonString = "";
            while ((line = reader.readLine()) != null){
                jsonString += line;
            }
            User user = createUserFromJsonString(jsonString);
            Boolean userCreated = tryCreatedUser(session,user);

            if (userCreated){
                session.save(user);
                response = new ResponseEntity<String>("user_created", HttpStatus.OK);
            }else {
                response = new ResponseEntity<String>("user_already", HttpStatus.OK);
            }

            session.getTransaction().commit();
        } catch (IOException e) {
            response = new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
//            throw new RuntimeException(e);
        }

        return response;
    }

    private Boolean tryCreatedUser(Session session, User user) {
        ArrayList<User> users = (ArrayList<User>)session.createSQLQuery("select * from users where users.name = :name")
                .setParameter("name",user.getName())
                .addEntity(User.class)
                .list();
        return users.size() == 0;
    }

    public static User createUserFromJsonString(String jsonString) throws IOException {
        StringReader strReader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();
        UserJSON userJSON = mapper.readValue(strReader, UserJSON.class);
        User user = User.builder()
                .password(userJSON.getPassword())
                .name(userJSON.getName())
                .build();
        return user;

    }

}
