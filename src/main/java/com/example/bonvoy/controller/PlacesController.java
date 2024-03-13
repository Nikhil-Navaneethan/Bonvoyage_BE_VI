package com.example.bonvoy.controller;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import com.example.bonvoy.model.Places;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bonvoy.Repo.PlacesRepo;

@RestController
@RequestMapping("/places")
public class PlacesController {
@Autowired
private PlacesRepo placesRepo;

@PostMapping("/upload")
public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
    if (uploadedFile.isEmpty()) {
        return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
    }
    try {

        byte[] bytes = uploadedFile.getBytes();

        UUID uuid = UUID.randomUUID();
//        String uploadsLocation = env.getProperty("resource.uploads");
        String uploadsLocation = "C:\\Users\\nikhs\\Desktop\\BonVoyage\\bonvoy\\src\\main\\resources\\Uploads\\";
        String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
        Path path = Paths.get(fileLocation);
        Files.write(path, bytes);

        File file = new File(fileLocation);
        return ResponseEntity.status(HttpStatus.OK).body(file.getName());

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

    }
}

@PostMapping("/upload1")
public ResponseEntity<?> Places(@RequestBody Places places){
	Places savedEntity = placesRepo.saveAndFlush(places);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(places);
}

@GetMapping("/allplaces")
public ResponseEntity<?> allplaces(){
	List<Places> places = placesRepo.findAll();
	return ResponseEntity
			.status(HttpStatus.OK)
			.body(places);
}

@GetMapping("/category")
public ResponseEntity<?> findBy(@PathVariable String category){
	List<Places> places = placesRepo.findBy(category);
	return ResponseEntity
			.status(HttpStatus.OK)
			.body(category);
}
}
