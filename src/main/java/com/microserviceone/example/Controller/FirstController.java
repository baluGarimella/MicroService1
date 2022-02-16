package com.microserviceone.example.Controller;


import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceone.example.model.StudentDto;

@RestController
@RequestMapping("/employee")
public class FirstController {
	
	 @Autowired
     private Example2RestConsumer example2App;
	
	//not used any produces object , how converted to json
	// answer : @Responsebody takes care convert object to excepted ouptut using mappers.
	 
	//not used any consumes object
	 //answer : bydefault it is json format , based on http header content type @RequestBody change from json to object
	//content-type in httpheader by default application/json .if in your application support
	//Accept is http headers by default */* , consumes any type
	 //how to pass httpheaders to feign client method
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/createStudent",consumes = {"application/json","application/xml"}, produces = {"application/json","application/xml"})
	public String test(@RequestBody StudentDto studentDto) {
    System.out.println("===============microserive2==========");
    
    //HttpHeaders headers = new HttpHeaders();
    //headers.add("Content-Type","application/json");
    //headers.add("Accept","application/json");
    
    
    ResponseEntity<StudentDto> result= example2App.createStudent(studentDto);
	String message;
		if(result.getStatusCode()==HttpStatus.OK) {
			message = "Student created successfully";
		}else {
			message = "Student creation failed";
		}
		return message;
	}
}
