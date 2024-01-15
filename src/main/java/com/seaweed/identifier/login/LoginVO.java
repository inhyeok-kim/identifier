package com.seaweed.identifier.login;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
@Table(name="USER")
public class LoginVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private String name;
    @Column(unique = true)
    private String id;
    private String password;
}
