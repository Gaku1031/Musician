package com.example.musician.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.example.musician.validation.constraints.ImageByte;

import lombok.Data;

@Data
public class TopicForm {

    private Long id;

    private Long userId;
    
    private Long artistId;

    @ImageByte(max = 2000000000)
    private MultipartFile image;

    private String imageData;

    private String path;

    @NotEmpty
    @Size(max = 1000)
    private String description;

    private UserForm user;
    
    private UserForm artist;

}