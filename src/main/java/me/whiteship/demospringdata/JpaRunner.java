package me.whiteship.demospringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
    PostRpository postRpository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post =new Post();
        post.setTitle("Spring");

        Comment comment = new Comment();
        comment.setComment("hello");

        postRpository.save(post);
    }

}
