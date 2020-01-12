package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {


    @PersistenceContext
    EntityManager entityManager; //JAP 핵심!!

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUsername("one");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");


        account.getStudies().add(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

    }
}
