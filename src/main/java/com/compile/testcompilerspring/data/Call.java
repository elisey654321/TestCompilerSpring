package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Call {

    @Id
    @Column(name = "id")
    private String id;

    private String Number1;    
    private String Number2;
    private String calltouch;
    private String date1;
    private String date2;
    private String date3;
    private String duration1;
    private String duration2;
    private String condition;
    
}
