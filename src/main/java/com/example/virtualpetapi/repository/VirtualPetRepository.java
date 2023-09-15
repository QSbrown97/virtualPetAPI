package com.example.virtualpetapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.virtualpetapi.model.VirtualPet;

public interface VirtualPetRepository extends CrudRepository<VirtualPet, Long> {
  
}
