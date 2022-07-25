package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Lob
    String message;

}
