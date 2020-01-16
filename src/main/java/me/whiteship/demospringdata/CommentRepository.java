package me.whiteship.demospringdata;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment,Long>{

    @Query(value = "SELECT c FROM Comment AS c",nativeQuery = true)
    List<Comment> findByTitleContains(String keyword);

}
