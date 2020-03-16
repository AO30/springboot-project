package com.example.springbootproject.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Tutor {
    @Id
    @Column(length = 10)
    private int id;
    private String name;
    private String password;
    private int optNum;
    private int seledNum;
    @OneToMany(mappedBy = "tutor")
    private List<Student> students;
}
