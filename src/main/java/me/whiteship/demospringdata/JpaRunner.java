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
//
//        Post post = new Post();
//        post.setTitle("Spring DATA START!!!");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 하고 싶다.");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("금방 할 수 있다!");
//        post.addComment(comment1);



        Session session = entityManager.unwrap(Session.class);
       // session.save(post);

        Post post = session.get(Post.class,1l);
        System.out.println("==========");
        System.out.println(post.getTitle());

    }
}
