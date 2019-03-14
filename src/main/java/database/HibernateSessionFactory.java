package database;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.math.BigInteger;


public class HibernateSessionFactory {

    public static void AddData(String name , String sname , String fname) {

        RegistrationEntity registrationEntity = new RegistrationEntity();

        registrationEntity.setId(1);
        registrationEntity.setFirst(name);
        registrationEntity.setLast(sname);
        registrationEntity.setFather(fname);

        SessionFactory sessionFactory = buildSessionFactory(RegistrationEntity.class);

        Session session = sessionFactory.openSession();


        Transaction tx = session.beginTransaction();
        session.save(registrationEntity);
        tx.commit();

        RegistrationEntity savedRegistrationEntity = session.get(RegistrationEntity.class , 1);
        System.out.println("______________");
        System.out.println("Name: " + savedRegistrationEntity.getFirst());
        System.out.println("SecondName: " + savedRegistrationEntity.getLast());
        System.out.println("______________");

        System.out.print("Saved to DB!!!");

        session.close();
        sessionFactory.close();

    }
    private static SessionFactory buildSessionFactory(Class clazz){
        try {

            return new Configuration().configure().addAnnotatedClass(clazz).buildSessionFactory();

        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}