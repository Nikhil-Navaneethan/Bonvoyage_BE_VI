package com.example.bonvoy.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bonvoy.model.Destination;
import com.example.bonvoy.model.Register;
@Repository
public interface DestinationRepo extends JpaRepository<Destination, Integer> {
 
	@Query(value = "Select * from states Where name = :name AND destination = :destination", nativeQuery = true)
	Destination findBy(String name, String destination);
}
