package com.exercise.hello.Repository;



import com.exercise.hello.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;







public interface Repo extends JpaRepository<Student,String> {

    List<Student> findByGenderAndDept(String gender, String dept);
    //List<Student> findByName(String name);
    List<Student> findByDept(String department);

    @Query(nativeQuery = true, value="SELECT *FROM student WHERE gender=:gender AND dept=:dept")
    List<Student>findByGenAndDept(String gender,String dept);

    @Query("SELECT s FROM Student s Where s.name=:name")
    List<Student>findByname(String name);

}