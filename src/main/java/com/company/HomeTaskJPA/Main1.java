package com.company.HomeTaskJPA;

import com.company.Client;
import com.company.Course;
import com.company.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 * Created by macbookair on 20.03.16.
 */
public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();

        Course course = new Course("English");
        em.merge(course);

        Group g1 = new Group();
        g1.setName("Group1");


        g1.addClient(new Client("Mike1", "Mike@yandex.ru", "0953484345"));
        g1.addClient(new Client("Kate1", "Kate@yandex.ru", "0985435656"));
        g1.addClient(new Client("Dima1", "Dima@yandex.ru", "0951063000"));
        g1.addClient(new Client("Karina1", "Karina@yande.ru", "0985435656"));
        g1.addClient(new Client("Marina1", "Marina@yandex.ru", "0985435656"));
        em.merge(g1);

        Group g2 = new Group();
        g2.setName("Group2");

        g2.addClient(new Client("Mike2", "Mike@yandex.ru", "0953484345"));
        g2.addClient(new Client("Kate2", "Kate@yandex.ru", "0985435656"));
        g2.addClient(new Client("Dima2", "Dima@yandex.ru", "0951063000"));
        g2.addClient(new Client("Karina2", "Karina@yande.ru", "0985435656"));
        g2.addClient(new Client("Marina2", "Marina@yandex.ru", "0985435656"));

        em.merge(g2);

        Group g3 = new Group();
        g3.setName("Group3");

        g3.addClient(new Client("Mike3", "Mike@yandex.ru", "0953484345"));
        g3.addClient(new Client("Kate3", "Kate@yandex.ru", "0985435656"));
        g3.addClient(new Client("Dima3", "Dima@yandex.ru", "0951063000"));
        g3.addClient(new Client("Karina3", "Karina@yande.ru", "0985435656"));
        g3.addClient(new Client("Marina3", "Marina@yandex.ru", "0985435656"));

        em.merge(g3);

        List<Client> cl = new ArrayList<Client>();

        cl.addAll(g1.getClients());
        cl.addAll(g2.getClients());
        cl.addAll(g3.getClients());
        course.setClients(cl);
        em.merge(course);

        List<Client> list = course.getClients();

        for (Client e : list){
            System.out.println(e.getName()+"; "+e.getGroup().getName()+" ");
        }

    }
}
