package me.whiteship.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRpository extends JpaRepository<Post,Long> {

    Page<Post> findByTitleContains(String titile, Pageable pageable);
}

