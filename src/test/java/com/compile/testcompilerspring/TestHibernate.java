package com.compile.testcompilerspring;

import com.compile.testcompilerspring.data.HibernateUtils;
import com.compile.testcompilerspring.data.Worker;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestHibernate {

    @Test
    void test(){
        try {

            Session session = HibernateUtils.getSession();
            session.beginTransaction();
            session.saveOrUpdate(Worker.builder()
                    .name("фывфывфы")
                    .post("фывфыв")
                    .dateemployment("20фывыфв22").build());

            session.saveOrUpdate(Worker.builder()
                    .name("фывфывфыqwe")
                    .post("фывфывqweqwe")
                    .dateemployment("20фывыфв22qweqwe").build());

            ArrayList<Worker> workerArrayList = (ArrayList<Worker>)session.createSQLQuery("select * from workers").addEntity(Worker.class).list();
            System.out.println("<____________________________>\n" + workerArrayList.size());

            for (Worker worker: workerArrayList) {
                System.out.println("Name worker ---> " + worker.getName());
            }

            session.getTransaction().commit();
//            HibernateUtils.closeSession(session);
        }catch (Exception e){
            Assertions.fail(e.getMessage());
        }

    }
}
