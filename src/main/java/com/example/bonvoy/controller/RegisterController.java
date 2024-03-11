package com.example.bonvoy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bonvoy.Repo.RegisterRepo;
import com.example.bonvoy.model.Register;

@RestController
@RequestMapping("/register")
//@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
@Autowired
private RegisterRepo registerRepo; 

@PostMapping("/add")
public ResponseEntity<?> addRegister(@RequestBody Register register){
	Register savedEntity = registerRepo.saveAndFlush(register);
	return ResponseEntity
			.status(HttpStatus.OK)
			.body(savedEntity);
	
}

@GetMapping("/check")
public ResponseEntity<?> findby(@RequestParam String email, String passcode){
	System.out.println("==Email==="+email);
	System.out.println("==Password==="+passcode);

    Register regist = registerRepo.findBy(email,passcode);
    return ResponseEntity
    		.status(HttpStatus.OK)
    		.body(regist);
		
}
@GetMapping("/userdetails")
public ResponseEntity<?> getdetails(){
    List<Register> register = registerRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK)
            .body(register);  
}
//@GetMapping("/delete")
//public ResponseEntity<?> deleteStudent(@RequestParam int id){
//	  Student stud = studentRepository.findById(id).get();
//	  studentRepository.delete(stud);
//
//	  
//	  return ResponseEntity.status(HttpStatus.OK)
//			  .body("data deleted");
//	
}

