package com.blog.api.service.interfaces;

import com.blog.api.dto.PostDTO;
import com.blog.api.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPostService<E> {
    public List<PostDTO> findAll() throws Exception;
    public PostDTO findById(Long id) throws Exception;
    public PostDTO save(PostDTO entity) throws Exception;
    public PostDTO update(Long id, PostDTO entity) throws Exception;
    public boolean delete(Long id) throws Exception;
    public List<PostDTO> findByTitle(String title)throws Exception;
    public List<PostDTO> findByCategory(String category) throws Exception;
    public List<PostDTO> findByTitleAndCategory(String title, String category) throws Exception;
}
