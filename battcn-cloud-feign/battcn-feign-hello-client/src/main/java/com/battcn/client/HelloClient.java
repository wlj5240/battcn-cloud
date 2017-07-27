package com.battcn.client;

import com.battcn.pojo.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟完整的CRUD操作
 */
@FeignClient(name = "battcn-feign-hello")
public interface HelloClient {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/hello")
    Student findStudentByName(@RequestParam("name") String name);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/hello")
    Student addStudent(@RequestBody Student student);

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/hello/{studentId}")
    Student editStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/hello/{studentId}")
    void deleteStudent(@PathVariable("studentId") Long studentId);
}
