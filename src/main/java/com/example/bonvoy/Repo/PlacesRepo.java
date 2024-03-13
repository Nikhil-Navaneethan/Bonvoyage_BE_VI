package com.example.bonvoy.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bonvoy.model.Places;
@Repository
public interface PlacesRepo extends JpaRepository<Places, Integer> {

}
