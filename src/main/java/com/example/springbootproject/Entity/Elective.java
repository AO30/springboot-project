package com.example.springbootproject.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Elective {
    @Id
    private int id;
    private int score;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
}
