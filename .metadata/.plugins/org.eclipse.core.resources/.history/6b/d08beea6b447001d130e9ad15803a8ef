package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int postId;
    private String title;
    private String content;
    @OneToMany
    private List<Comments> list = new ArrayList<>();
}
