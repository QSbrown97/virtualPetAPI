package com.example.virtualpetapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virtualpetapi.model.VirtualPet;
import com.example.virtualpetapi.repository.VirtualPetRepository;

@RestController
@RequestMapping("/api/virtualPets")
public class VirtualPetController {
  
  @Autowired
  private VirtualPetRepository virtualPetRepository;

  @GetMapping("")
  public ResponseEntity<List<VirtualPet>> getAllPets() {
    List<VirtualPet> virtualPets = (List<VirtualPet>) virtualPetRepository.findAll();
    if (virtualPets.isEmpty())
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(virtualPets, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<VirtualPet> getPet(@PathVariable Long id) {
    return virtualPetRepository.findById(id)
        .map(virtualPet -> new ResponseEntity<>(virtualPet, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  @PostMapping("/new")
  public ResponseEntity<VirtualPet> addPet(@RequestBody VirtualPet pet) {
    VirtualPet newPet = virtualPetRepository.save(pet);
    return new ResponseEntity<VirtualPet>(newPet, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<VirtualPet> deletePet(@PathVariable Long id) {
    return virtualPetRepository.findById(id)
        .map(virtualPet -> {
          virtualPetRepository.deleteById(id);
          return new ResponseEntity<>(virtualPet, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  @PutMapping("/edit/{id}")
    public ResponseEntity<VirtualPet> updatePet(@PathVariable Long id, @RequestBody VirtualPet updatedPet) {
        return virtualPetRepository.findById(id)
                .map(existingPet -> {
                    if (updatedPet.getName() != null)
                        existingPet.setName(updatedPet.getName());
                    if (updatedPet.getDescription() != null)
                    existingPet.setDescription(updatedPet.getDescription());
                        
                    VirtualPet savedPet = virtualPetRepository.save(existingPet); 
                    return new ResponseEntity<>(savedPet, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
