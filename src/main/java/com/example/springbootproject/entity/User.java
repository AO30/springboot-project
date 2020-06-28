package com.example.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    public enum Role {
        STUDENT, TEACHER, ADMIN
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Column(unique = true)
    @NotBlank(message = "学/工号不能为空")
    private Integer number;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Role role;

    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "timestamp default current_timestamp"+" on update current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;
}
