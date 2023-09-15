package com.example.virtualpetapi.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.virtualpetapi.model.VirtualPet;
import com.example.virtualpetapi.repository.VirtualPetRepository;

@Configuration
public class LoadDatabase {
  
  @Bean
  public CommandLineRunner loadDB(VirtualPetRepository virtualPetRepository) {
    return args -> {
      //Make some pets
      VirtualPet pet01 = new VirtualPet("Sparky", "Male, Black, Dalmatian");
      VirtualPet pet02 = new VirtualPet("Bella", "Female, Tri-colored, Beagle");
      VirtualPet pet03 = new VirtualPet("Ollie", "Male, Brown, Dachshund");
      VirtualPet pet04 = new VirtualPet("Max", "Male, Tri-colored, Beagle");

      virtualPetRepository.save(pet01);
      virtualPetRepository.save(pet02);
      virtualPetRepository.save(pet03);
      virtualPetRepository.save(pet04);
    };
  }
}
