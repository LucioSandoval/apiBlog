package com.blog.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor

public class PostDTO implements Serializable {
    private long id;
    private String title;
    private String image;
    private  String category;
    private Date creationDate;

    public PostDTO(String title, String image, String category) {
        this.title = title;
        this.image = image;
        this.category = category;
        this.creationDate = new Date();
    }

}
