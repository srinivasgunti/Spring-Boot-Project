package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student Advika =  new Student(1L,
                     "Advika",
                    "advika.rama@gmail.com",
                    LocalDate.of(2014, Month.JANUARY, 22)
                    );
            Student Anvit =  new Student(2L,
                    "Anvit",
                    "anvit.rama@gmail.com",
                    LocalDate.of(2020, Month.APRIL, 14)
                    );
            repository.saveAll(List.of(Advika, Anvit));
        };
    }

}
