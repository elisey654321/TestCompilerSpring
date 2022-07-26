package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsersChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

}
