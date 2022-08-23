package com.compile.testcompilerspring.controllers;

import com.compile.testcompilerspring.data.Call;
import com.compile.testcompilerspring.data.HibernateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Data
public class CallsRestController {

    private static ArrayList<Call> calls = new ArrayList<>();

    @GetMapping("/getCalls")
    public static String getCalls(){

        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Call> callLIst = session.createSQLQuery("SELECT * FROM call LIMIT 10")
                .addEntity(Call.class)
                .list();

        String result = "test";
        try {
            result = new ObjectMapper().writeValueAsString(callLIst);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        return result;
    }

//    @Bean
//    public CallsRestController getInstance() {
//        return new CallsRestController();
//    }

}
