package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository  studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
       return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email Already Taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
           boolean exists = studentRepository.existsById(studentId);
           if(!exists)
                throw new IllegalStateException("Student by Id "+ studentId +" does not exist");
           studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
            throw new IllegalStateException("Student don't exist");
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentOptional.ifPresent(user->{
            user.setEmail(email);
            user.setName(name);

        });


    }

    public Optional<Student> getStudentsByMail(String studentMail) {
       return( studentRepository.findStudentsByEmail(studentMail) );


    }
}
