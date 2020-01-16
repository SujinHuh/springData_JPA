package me.whiteship.demospringdata;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment,Long>{

    @Query("SELECT c FROM Comment AS c")
    List<Comment> findByTitleContains(String keyword);

}
