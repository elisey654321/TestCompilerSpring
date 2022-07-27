package com.compile.testcompilerspring.data;

import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Getter
    @Transient
    static String messageMy = "<div class=\"message-box-holder\">\n" +
            "    <div class=\"message-box\">\n" +
            "      <text>\n" +
            "    </div>\n" +
            "  </div>";

    @Getter
    @Transient
    static String messageOut = "<div class=\"message-box-holder-sender\">\n" +
            "    <div class=\"message-sender\">\n" +
            "      <user>\n" +
            "    </div>\n" +
            "    <div class=\"message-box-sender\">\n" +
            "      <text>\n" +
            "    </div>\n" +
            "  </div>";

    public static ArrayList<Message> getListMessagesFromChat(Session session,Chat chat){
        String sqlQuery = "select\n" +
                "       *\n" +
                "from message\n" +
                "where\n" +
                "      message.chat_id = :chat_id\n" +
                "order by timestamp";
        ArrayList<Message> arrayList = (ArrayList<Message>)session.createSQLQuery(sqlQuery)
                .setParameter("chat_id",chat.getId())
                .addEntity(Message.class)
                .list();

        return arrayList;
    }

}
