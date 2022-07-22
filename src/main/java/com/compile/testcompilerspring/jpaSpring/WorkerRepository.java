package com.compile.testcompilerspring.jpaSpring;

import com.compile.testcompilerspring.data.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    List<Worker> findByPost(String name);
}
