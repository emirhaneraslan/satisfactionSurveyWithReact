package com.emirhaneraslan.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_adress")
    private String userAdress;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_is_active")
    private boolean isActive=true;

    @Column(name = "user_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate=new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AnswerEntity> answers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts;

    public UserEntity(String userName, String userSurname, String userEmail, String userAdress,String userPassword,boolean isActive) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userAdress = userAdress;
        this.userPassword = userPassword;
        this.isActive=isActive();
    }
}
