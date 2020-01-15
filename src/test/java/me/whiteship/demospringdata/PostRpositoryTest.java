package me.whiteship.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

        //Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.contains(newPost));

        //When
        Page<Post> page = postRpository.findAll(PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

        //When
        page = postRpository.findByTitleContains("Hi",PageRequest.of(0,10));

        //ThenR
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);

    }

}