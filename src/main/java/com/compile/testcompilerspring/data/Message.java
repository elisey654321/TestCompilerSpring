package com.compile.testcompilerspring.data;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
    Date timestamp;

    @OneToOne
    @JoinColumn(name = "chat_id")
    Chat chat;

    @Transient
    String messageMy = "<div class=\"message-box-holder\">\n" +
            "        <div class=\"message-box\">\n" +
            "          myText\n" +
            "        </div>\n" +
            "      </div>";

    @Transient
    String messageOut = "<div class=\"message-box-holder\">\n" +
            "        <div class=\"message-sender\">\n" +
            "          <user>\n" +
            "        </div>\n" +
            "        <div class=\"message-box message-partner\">\n" +
            "          <text>\n" +
            "        </div>\n" +
            "      </div>";
}
