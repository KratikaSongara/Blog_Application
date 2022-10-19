package com.masai.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter //@Data is giving stackoverflow error, so replaced @Data with @Getter and @Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer commentId;
    private String comment;
    @NotNull(message="name is mandatory")
    private String username;
    @JoinColumn(name="postId")
    @ManyToOne()
    private Post post;
}
