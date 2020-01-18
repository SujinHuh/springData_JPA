package me.whiteship.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment,Long>{

    List<Comment> findByCommentContainsIgnoreCase(String keyword);
}
