package com.compile.testcompilerspring.data;

import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;

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

    @Getter
    @Transient
    static String contact = "<div onclick=\"clickDiv(this.id)\" id=\"numberContact\">\n" +
            "      <p>name</p>\n" +
            "    </div>";
    /*
    get array contacts
     */
    public static ArrayList<UsersChat> getArrayListContacts(User nowUser, Session session){
        ArrayList<UsersChat> usersChats = (ArrayList<UsersChat>) session.createSQLQuery(getSqlQuerry()).addEntity(UsersChat.class).list();


        return new ArrayList<>();
    }

    private static String getSqlQuerry() {
        return "select * from user";
    }

}
