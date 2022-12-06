package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.AnnuncioGioiello;
import com.javasampleapproach.diymonds.model.Venditore;
import com.javasampleapproach.diymonds.repo.AnnuncioGioielloRepository;
import com.javasampleapproach.diymonds.repo.VenditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VenditoreController {

    @Autowired
    VenditoreRepository venditoreRepository;
    @Autowired
    AnnuncioGioielloRepository annuncioGioielloRepository;

    @GetMapping("/venditori")
    public List<Venditore> getAllVenditori() {
        System.out.println("Get all Venditori");
        List<Venditore> venditori = new ArrayList<>();
        venditoreRepository.findAll().forEach(venditori::add);
        return venditori;
    }

    @PostMapping("/venditori/{id}/creaAnnuncioGioiello")
    public AnnuncioGioiello addAnnuncioGioiello(@PathVariable("id") long id, @RequestBody AnnuncioGioiello annuncioGioiello) {
        System.out.println("Creazione Annuncio Gioiello");
        Optional<Venditore> v = venditoreRepository.findById(id);
        Venditore venditore = v.get();
        annuncioGioiello.setIdVenditore(id);
        venditore.getAnnunciGioelli().add(annuncioGioiello);
        annuncioGioielloRepository.save(annuncioGioiello);
        venditoreRepository.save(venditore);
        return annuncioGioiello;
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
