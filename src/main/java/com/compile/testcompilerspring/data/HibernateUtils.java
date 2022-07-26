package com.compile.testcompilerspring.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;

    static{
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Configuration cfg = new Configuration().configure();

        addEntityClasses(cfg);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    private static void addEntityClasses(Configuration cfg) {
        cfg.addAnnotatedClass(Worker.class);
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Message.class);
        cfg.addAnnotatedClass(Chat.class);
        cfg.addAnnotatedClass(UsersChat.class);
    }

    /**
     * Get session
     */
    public static Session getSession() {
        // We could also use openSession()
        return sessionFactory.getCurrentSession();
    }

    /**
     * Close session
     */
    public static void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
