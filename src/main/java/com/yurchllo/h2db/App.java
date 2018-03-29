package com.yurchllo.h2db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class App {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setFirstName("AAAA");
        person.setLastName("LLLL");

        SessionFactory sessionFactory = buildSessionFactory(Person.class);

        Session session = sessionFactory.openSession();
        session.save(person);
        Person person1 = session.get(Person.class, 1);
        System.out.println(person1);
        sessionFactory.close();
    }

    private static SessionFactory buildSessionFactory(Class clazz) throws IOException {
        return  new Configuration().configure().addAnnotatedClass(clazz).buildSessionFactory();
    }
}
