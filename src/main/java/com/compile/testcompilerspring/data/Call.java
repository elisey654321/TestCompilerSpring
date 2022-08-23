package com.compile.testcompilerspring.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@JsonAutoDetect
public class Call {

    @Id
    @Column(name = "id")
    private String id;

    private String Number1;    
    private String Number2;
    private String calltouch;
    private Date date1;
    private Date date2;
    private Date date3;
    private Integer duration1;
    private Integer duration2;
    private String condition;



}
