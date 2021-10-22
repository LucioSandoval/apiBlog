package com.blog.api.service.implementation;

import com.blog.api.config.ImageValidator;
import com.blog.api.dto.PostDTO;
import com.blog.api.model.Post;
import com.blog.api.repository.PostRepository;
import com.blog.api.service.interfaces.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService<Post> {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    private PostDTO convertetEntityDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO = modelMapper.map(post,PostDTO.class);
        return  postDTO;
    }

    private Post convertetDTOEntity(PostDTO postDTO){
        Post post = new Post();
        post = modelMapper.map(postDTO,Post.class);
        return  post;
    }



    @Override
    @Transactional
    public List<PostDTO> findAll() throws Exception {
        try {
            List<Post> postList=postRepository.findAll();

            return postList.stream().map(post -> convertetEntityDTO(post)).collect(Collectors.toList());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PostDTO findById(Long id) throws Exception {
        try {
            Optional<Post> optionalPost = postRepository.findById(id);

            return convertetEntityDTO(optionalPost.get());

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PostDTO save(PostDTO postDTO) throws Exception {
        try{
            ImageValidator imageValidator= new ImageValidator();
           if(!imageValidator.validate(postDTO.getImage())){
               return  null;
           }
            Post post = convertetDTOEntity(new PostDTO(postDTO.getTitle(), postDTO.getImage(), postDTO.getCategory()));

            Post newPost=postRepository.save(post);

            return convertetEntityDTO(newPost);



        }catch (Exception e){
           throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public PostDTO update(Long id, PostDTO entity) throws Exception {
        try{
            Post post = postRepository.findById(id).get();

            post.setTitle(entity.getTitle());
            post.setImage(entity.getImage());
            post.setCategory(entity.getCategory());
            post.setCreationDate(entity.getCreationDate());

            Post updatePost= postRepository.save(post);

            return convertetEntityDTO(updatePost);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            Post post = postRepository.findById(id).get();
            postRepository.delete(post);
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public List<PostDTO> findByTitle(String title) throws Exception {
        try {
            List<Post> postList = postRepository.findByTitle(title).stream().sorted(Comparator.comparing(Post::getCreationDate).reversed()).collect(Collectors.toList());
            return postList.stream().map(post -> convertetEntityDTO(post)).collect(Collectors.toList());
        }catch (Exception e){
             throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public List<PostDTO> findByCategory(String category) throws Exception {
        try {
            List<Post> postList = postRepository.findByCategory(category).stream().sorted(Comparator.comparing(Post::getCreationDate).reversed()).collect(Collectors.toList());
            return postList.stream().map(post -> convertetEntityDTO(post)).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<PostDTO> findByTitleAndCategory(String title, String category) throws Exception {
        try{
            List<Post> postList = postRepository.findByTitleAndCategory(title, category).stream().sorted(Comparator.comparing(Post::getCreationDate).reversed()).collect(Collectors.toList());
            return postList.stream().map(post -> convertetEntityDTO(post)).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
