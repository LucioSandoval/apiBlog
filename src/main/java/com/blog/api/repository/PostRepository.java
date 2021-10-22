package com.blog.api.repository;

import com.blog.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(@Param("title") String title);
    List<Post> findByCategory(@Param("category") String category);
    List<Post> findByTitleAndCategory( @Param("title") String title, @Param("category") String category);
}
