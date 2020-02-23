package com.example.springoauth2demo.member;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String username;

    private String remark;

    public Member() {
    }

}
