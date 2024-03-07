package com.example.bonvoy.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bonvoy.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>{

	@Query(value = "Select * from registers Where email = :email AND passcode = :passcode", nativeQuery = true)
	Register findBy(String email, String passcode);
		
}
