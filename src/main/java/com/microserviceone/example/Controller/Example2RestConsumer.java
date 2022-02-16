package com.microserviceone.example.Controller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.microserviceone.example.model.StudentDto;

@FeignClient(name="Example2")
public interface Example2RestConsumer {

	@PostMapping("/student/addStudent")
    public ResponseEntity<StudentDto> createStudent(StudentDto studentDto);
	
}
