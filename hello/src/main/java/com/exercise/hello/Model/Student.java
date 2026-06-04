package com.exercise.hello.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor //for automatic parameterized constructor
@NoArgsConstructor //for default constructor
@Entity
public class Student {

    @Id
    private String rollNumber;

    @NotBlank(message = "Name Cannot be Null")
    private String name;

    @NotBlank(message = "Department Cannot be null")
    private String dept;

    @NotBlank(message = "Gender cannot be Null")
    private String gender;


    @Email(message = "Enter Valid Email")
    private String email;

    private String password;


}