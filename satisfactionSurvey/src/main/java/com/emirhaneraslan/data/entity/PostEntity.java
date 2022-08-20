package com.emirhaneraslan.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", updatable = false, nullable = false)
    private Long postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_body", length = 3000)
    private String postBody;

    @Column(name = "post_image_url", length = 2000)
    private String imageUrl;

    @Column(name = "post_is_active")
    private boolean postIsActive=true;

    @Column(name = "post_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate=new Date();

    @ManyToOne
    @JoinColumn(name = "post_user_id")
    private UserEntity user;


    public PostEntity(String postTitle, String postBody, String imageUrl, UserEntity user) {
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.imageUrl = imageUrl;
        this.user = user;
    }
}
