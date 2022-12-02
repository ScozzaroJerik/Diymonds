package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.Fornitore;
import com.javasampleapproach.diymonds.repo.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FornitoreController {

    @Autowired
    FornitoreRepository fornitoreRepository;

    @GetMapping("/fornitori")
    public List<Fornitore> getAllVenditori() {
        System.out.println("Get all Fornitori");
        List<Fornitore> fornitori = new ArrayList<>();
        fornitoreRepository.findAll().forEach(fornitori::add);
        return fornitori;
    }

    @DeleteMapping("/fornitori/{id}")
    public ResponseEntity<String> deleteVenditore(@PathVariable("id") long id) {
        System.out.println("Delete User with ID = " + id + "...");
        fornitoreRepository.deleteById(id);
        return new ResponseEntity<>("Fornitore has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/fornitori/delete")
    public ResponseEntity<String> deleteAllVenditori() {
        System.out.println("Delete All Fornitori...");
        fornitoreRepository.deleteAll();
        return new ResponseEntity<>("All Fornitori have been deleted!", HttpStatus.OK);
    }
}
