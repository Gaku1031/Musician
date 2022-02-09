package com.example.musician.form;

import lombok.Data;

@Data
public class FavoriteForm {

    private Long userId;

    private Long artistId;
    
    private Long topicId;

    private TopicForm topic;
}