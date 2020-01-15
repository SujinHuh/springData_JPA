package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRpositoryTest {


    @Autowired
    PostRpository postRpository;


    @Test
    @Rollback(false)
    public void crudRepository() {

        //Given
        Post post = new Post();
        post.setTitle("Hi~ SpringBoot!!");

        //When
        assertThat(post.getId()).isNull();
        Post newPost = postRpository.save(post);

        //Then
        assertThat(newPost.getId()).isNotNull();

        //When
        List<Post> posts = postRpository.findAll();
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.contains(newPost));
    }

}