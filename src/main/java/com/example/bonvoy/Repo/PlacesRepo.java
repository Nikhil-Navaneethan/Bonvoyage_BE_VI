package com.example.bonvoy.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bonvoy.model.Places;
import com.example.bonvoy.model.Register;
@Repository
public interface PlacesRepo extends JpaRepository<Places, Integer> {
	@Query(value = "Select * from registers Where category = :category", nativeQuery = true)
	List<Places> findBy(String category);

}
