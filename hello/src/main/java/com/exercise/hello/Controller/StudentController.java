package com.exercise.hello.Controller;



import com.exercise.hello.Model.Student;
import com.exercise.hello.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @PostMapping("/students/add")
    public String addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudents(student);
    }

    @GetMapping("students/{rollNumber}")
    public Student getStudent(@Valid @PathVariable String rollNumber) {
        return studentService.getStudent(rollNumber);
    }

    @PutMapping("students/update")
    public String updateStudent(@Valid @RequestBody Student student) {
        studentService.updateStudent(student);
        return student.getRollNumber() + " Updated Successfully";
    }

    @DeleteMapping("students/delete/{rollNumber}")
    public String deleteStudent(@Valid @PathVariable String rollNumber) {
        studentService.deleteStudent(rollNumber);
        return rollNumber + " Deleted Successfully";
    }

    @DeleteMapping("students/deleteAll")
    public String deleteAllStudent() {
        studentService.deleteAll();
        return "All Students Deleted";
    }

    @GetMapping("csrf-token")
    public String getCSRF(CsrfToken csrfToken) {
        return "CSRF TOKEN" + csrfToken.getToken();
    }

    @GetMapping("students/genderAndDept")
    public List<Student> getStudentByGenderAndDept(@Valid @Param("gender") String gender,
                                                   @Valid @Param("dept") String dept) {
        return studentService.getStudentByGenderAndDept(gender, dept);
    }

    @GetMapping("students/name")
    public List<Student> getStudentByName(@Valid @Param("name") String name) {
        return studentService.getByname(name);
    }

    @GetMapping("students/department/{department}")
    public List<Student> getStudentByDept(@Valid @PathVariable("dept") String dept) {
        return studentService.getByDept(dept);
    }

    //Native Query
    @PostMapping("students/filter")
    public List<Student> getStudentByGenderAndDepartmentByQuery(@Valid @Param("gender") String gender,
                                                                @Valid @Param("dept") String dept) {
        return studentService.getStudentWithGenAndDept(gender, dept);
    }

    //jpl
    @GetMapping("students/Name/{name}")
    public List<Student> getByName(@Valid @PathVariable("name") String name) {
        return studentService.getByStuname(name);
    }

    @GetMapping("student")
    public Page<Student> getAllStuentPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return studentService.getAllStuentPage(page, size);
    }
}