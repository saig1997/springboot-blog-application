package com.hellosaint.saintlouis.controller;

import com.hellosaint.saintlouis.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student= new Student(
                1,
                "Sai",
                "Chowdary"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Sai").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Sai", "Kumar"));
        students.add(new Student(2, "Hari", "Nekkalapu"));
        students.add(new Student(3, "Bindu", "Bandarupally"));
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getPathVariable(@PathVariable("id") int studentId){

        Student student= new Student(studentId, "Chandu", "Bathula");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/query")
    public ResponseEntity<Student> getRequestParam(@RequestParam("id") int studentId){
        Student student= new Student(studentId, "Navya", "Ch");
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
  //  @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
      //  return ResponseEntity.created(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int studentId)
    {
        return "Student details deleted successfully!";
    }

}
