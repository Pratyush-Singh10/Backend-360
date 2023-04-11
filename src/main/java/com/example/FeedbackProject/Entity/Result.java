package com.example.FeedbackProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int res_id;

    @Column(name = "Q1")
    private int q1;
    @Column(name = "Q2")
    private int q2;
    @Column(name = "Q3")
    private int q3;
    @Column(name = "Q4")
    private int q4;
    @Column(name = "Q5")
    private int q5;
}
