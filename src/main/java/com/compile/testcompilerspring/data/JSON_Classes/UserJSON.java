package com.compile.testcompilerspring.data.JSON_Classes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonAutoDetect
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserJSON {
    public String name;
    public String password;
}
