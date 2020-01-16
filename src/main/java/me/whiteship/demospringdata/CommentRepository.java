package me.whiteship.demospringdata;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment,Long>{

    List<Comment> findByTitleContains(String keyword);

}
