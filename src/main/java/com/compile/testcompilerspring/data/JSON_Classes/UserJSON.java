package com.compile.testcompilerspring.data.JSON_Classes;

import com.compile.testcompilerspring.data.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.io.StringReader;

@JsonAutoDetect
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserJSON {
    public String name;
    public String password;

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
