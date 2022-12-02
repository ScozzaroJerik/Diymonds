package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.Venditore;
import com.javasampleapproach.diymonds.repo.VenditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VenditoreController {

    @Autowired
    VenditoreRepository venditoreRepository;

    @GetMapping("/venditori")
    public List<Venditore> getAllVenditori() {
        System.out.println("Get all Venditori");
        List<Venditore> venditori = new ArrayList<>();
        venditoreRepository.findAll().forEach(venditori::add);
        return venditori;
    }

    @DeleteMapping("/venditori/{id}")
    public ResponseEntity<String> deleteVenditore(@PathVariable("id") long id) {
        System.out.println("Delete User with ID = " + id + "...");
        venditoreRepository.deleteById(id);
        return new ResponseEntity<>("Venditore has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/venditori/delete")
    public ResponseEntity<String> deleteAllVenditori() {
        System.out.println("Delete All Venditori...");
        venditoreRepository.deleteAll();
        return new ResponseEntity<>("All Venditori have been deleted!", HttpStatus.OK);
    }
}
