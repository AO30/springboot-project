package com.example.springbootproject.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(length = 10)
    private int id;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<Elective> electives;
    @ManyToOne
    private Tutor tutor;

}
