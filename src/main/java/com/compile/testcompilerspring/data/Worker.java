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

    @Lob
    @Column(name = "post", nullable = false)
    private String post;

    @Lob
    @Column(name = "dateemployment")
    private String dateemployment;

    @Id
    @Lob
    @Column(name = "name")
    private String name;

}