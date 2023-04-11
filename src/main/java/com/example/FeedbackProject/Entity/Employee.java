package com.example.FeedbackProject.Entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name="emp_Id")
    private String id;

//    @Column(name = "Emp_Name")
    private String name;

    @Column(name="manager_Id")
    private String ManagerId;

    @NotEmpty
    @Email(message = "Entry Should be Email Only")
    private String email_Id;

    @NotEmpty
    @Column(name = "password")
    @Size(min = 8)
    @Pattern(regexp = "")
    private String pass;

    @Column(name = "emp_type")
    private String uType;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Feed_id;
}
