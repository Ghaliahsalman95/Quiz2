package com.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class Student {
//: ID , name , age , major  ( all should not be empty)
    @NotNull(message = "ID should not be empty")
    @Size(min = 2,message = "ID length 2 at least")
    private String ID;
    @NotNull(message = "name should not be empty")
    private String name;
    @NotNull(message = "age should not be empty")
    @Min(20)
    private int age;
    @NotNull(message = "major should not be empty")
    private String major;


}
