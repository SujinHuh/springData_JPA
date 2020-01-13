package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {


    @PersistenceContext
    EntityManager entityManager; //JAP 핵심!!

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Post> posts = entityManager.createNativeQuery("SELECT *  from Post", Post.class).getResultList();

        posts.forEach(System.out::println);

    }

}
