package com.example.bonvoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bonvoy.Repo.DestinationRepo;
import com.example.bonvoy.model.Destination;
import com.example.bonvoy.model.Register;

@RestController
@RequestMapping("/state")
public class DestinationController {
@Autowired
private DestinationRepo destinationRepo;

@PostMapping("/add")
public ResponseEntity<?> addDestination(@RequestBody Destination destination){
Destination savedEntity = destinationRepo.saveAndFlush(destination);
return ResponseEntity
		.status(HttpStatus.OK)
		.body(savedEntity);
}

@GetMapping("/check")
public ResponseEntity<?> findby(@RequestParam String name, String destination){
	System.out.println("==name==="+name);
	System.out.println("==destination==="+destination);

    Destination state = destinationRepo.findBy(name,destination);
    return ResponseEntity
    		.status(HttpStatus.OK)
    		.body(state);
}
}
