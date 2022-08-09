package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.HibernateUtils;
import com.compile.testcompilerspring.data.classes_from_json.UserJSON;
import com.compile.testcompilerspring.data.User;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
public class EnterController {

    @PostMapping("/Enter")
    public @ResponseBody
    ResponseEntity<String> CreateItemPost(HttpServletRequest request,
                                          UriComponentsBuilder uriComponentsBuilder) {

        ResponseEntity response = null;

        try (Session session = HibernateUtils.getSession();) {
            session.beginTransaction();

            BufferedReader reader = request.getReader();
            String line, jsonString = "";
            while ((line = reader.readLine()) != null) {
                jsonString += line;
            }
            User user = UserJSON.createUserFromJsonString(jsonString);
            user = user.searchUser(session, user);
            if (user != null)
                response = new ResponseEntity<String>(user.getName(), HttpStatus.OK);
            else
                response = new ResponseEntity<String>("bad", HttpStatus.BAD_REQUEST);
            session.getTransaction().commit();
        } catch (IOException e) {
            e.getMessage();
        } 

        return response;
    }


}
