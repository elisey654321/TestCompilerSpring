package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "workers")
public class Worker {

    @Column(name = "post", nullable = false)
    private String post;


    @Column(name = "dateemployment")
    private String dateemployment;

    @Id
    @Column(name = "name")
    private String name;

}