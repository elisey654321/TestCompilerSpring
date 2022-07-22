package com.compile.testcompilerspring;

import com.compile.testcompilerspring.data.Worker;
import com.compile.testcompilerspring.jpaSpring.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TestCompilerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCompilerSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoBean(WorkerRepository repository) {
        return (args -> {
            repository.save(Worker.builder()
                    .name("TestNameOne")
                    .post("manager")
                        .build());
            List<Worker> workers = repository.findByPost("manager");
            System.out.println(workers.get(0).getName());
        });
    }

}
