package com.example.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"courses", "students"})
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @MapsId
    private User user;
    private int optNum;//希望选择的学生范围
    private int selNum;//可选学生数
    @Column(columnDefinition = "timestamp default current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "timestamp default current_timestamp"+" on update current_timestamp",
            insertable = false,
            updatable = false)
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "tutor")
    private List<Student> students;//已选择学生 统计list总数得已选学生数
    @OneToMany(mappedBy = "tutor")
    private List<Course> courses;
    @OneToMany(mappedBy = "tutor")
    private List<Direction> directions;

    public Tutor(Integer id) {
        this.id = id;
    }
}
