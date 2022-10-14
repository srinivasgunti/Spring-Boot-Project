package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
    @GetMapping(path = "api/v1/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping(value ="api/v1/studentsbymail/{studentMail}")
    public Optional<Student> getStudentsByMail(@PathVariable("studentMail") String studentMail){
        return studentService.getStudentsByMail(studentMail);
    }

    @PostMapping(path = "api/v1/student")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
/*
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void udpateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {

        studentService.updateStudent(studentId, name, email);
    }*/
}

