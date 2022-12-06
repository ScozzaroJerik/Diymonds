package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.AnnuncioGioiello;
import com.javasampleapproach.diymonds.model.AnnuncioMateriaPrima;
import com.javasampleapproach.diymonds.model.Fornitore;
import com.javasampleapproach.diymonds.model.Venditore;
import com.javasampleapproach.diymonds.repo.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/fornitori/{id}/creaAnnuncioMateriaPrima")
    public AnnuncioMateriaPrima addMateriaPrima(@PathVariable("id") long id, @RequestBody AnnuncioMateriaPrima annuncioMateriaPrima) {
        System.out.println("Creazione Annuncio Gioiello");
        Optional<Fornitore> f = fornitoreRepository.findById(id);
        Fornitore fornitore = f.get();
        annuncioMateriaPrima.setIdFornitore(id);
        fornitore.getAnnunciMateriaPrima().add(annuncioMateriaPrima);
        System.out.println(fornitore);
        fornitoreRepository.save(fornitore);
        return annuncioMateriaPrima;
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
