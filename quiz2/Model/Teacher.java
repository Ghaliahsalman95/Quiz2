package com.example.quiz2.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class Teacher {
    // ID , name , salary ( all should not be empty).
    @NotNull(message = "ID should not be empty")
    @Size(min = 2,message = "ID length 2 at least")
    private String ID;
    @NotNull(message ="name should not be empty" )
    private String name;
    @NotNull(message = "salary should not be empty")
    @Min(value = 3000,message = "at least salary 3000")@Max(value = 10000, message = "maximum salary 10000")
    private double salary;

}
