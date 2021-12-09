package com.microserviceone.example.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceone.example.models.JavaResponse;

@RestController
@RequestMapping("/employee")
public class FirstController {
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/message")
	public JavaResponse test() {
System.out.println("===============microserive2==========");
		
		
		JavaResponse j = new JavaResponse();
		j.setResponse("Hello Welcome To  First Service");
		return j;
	}
}
