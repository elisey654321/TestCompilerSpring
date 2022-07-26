package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String weight;
    String height;
    String width;
    String globalname;

}
