package com.example.springbootlaptoop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootlaptoop.repository.LaptopRepository;
import com.example.springbootlaptoop.model.Laptop;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Optional<Laptop> findById(Long id) {
        return laptopRepository.findById(id);
    }

    public Laptop addLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public void deleteLaptopById(Long id) {
        laptopRepository.deleteById(id);
    }
     public  Laptop updeta (Laptop laptop){
        return laptopRepository.save(laptop);
    }
}
