package com.example.musician.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Table(name = "topic")
@Data
public class Topic extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "topic_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long artistId;
    
    @Column(nullable = false)
    private String path;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @OneToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
    
    @OneToOne
    @JoinColumn(name = "artistId", insertable = false, updatable = false)
    private Artist artist;
    
    @OneToMany
    @JoinColumn(name = "topicId", insertable = false, updatable = false)
    private List<Favorite> favorites;
}