package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Call_old {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}
