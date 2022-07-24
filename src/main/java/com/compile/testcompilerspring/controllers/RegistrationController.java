package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.JSON_Classes.UserJSON;
import com.compile.testcompilerspring.data.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.Buffer;

@Controller
public class RegistrationController {

    @PostMapping("/Registration")
    public String CreateItemPost(HttpServletRequest request,
                                 UriComponentsBuilder uriComponentsBuilder) {
        try {
            BufferedReader reader = request.getReader();
            String line;
            String jsonString = "";
            while ((line = reader.readLine()) != null){
                jsonString += line;
            }

            createUserFromJsonString(jsonString);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "index.html";
    }

    public static void createUserFromJsonString(String jsonString) throws IOException {
        StringReader strReader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();
        UserJSON user = mapper.readValue(strReader, UserJSON.class);
        System.out.println(user.toString());
    }

}
