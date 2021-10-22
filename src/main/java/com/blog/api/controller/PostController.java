package com.blog.api.controller;

import com.blog.api.dto.PostDTO;
import com.blog.api.model.Post;
import com.blog.api.service.implementation.PostServiceImpl;
import com.blog.api.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "posts")
public class PostController {
    @Autowired
    private IPostService postService;



    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PostDTO entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PostDTO entity ){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(postService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping(value = "", params = {"title"})
    public ResponseEntity<?> getTitle(@RequestParam("title") String title){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findByTitle(title));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping(value = "", params = {"category"})
    public ResponseEntity<?> getCategory(@RequestParam("category") String category){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findByTitle(category));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }


    @GetMapping(value = "", params = {"title","category"})
    public ResponseEntity<?> getTitleAndCategory(@RequestParam("title") String title, @RequestParam("category") String category){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findByTitleAndCategory(title, category));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }
}
