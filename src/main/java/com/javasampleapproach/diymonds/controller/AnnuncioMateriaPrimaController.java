package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.AnnuncioMateriaPrima;
import com.javasampleapproach.diymonds.model.Venditore;
import com.javasampleapproach.diymonds.repo.AnnuncioMateriaPrimaRepository;
import com.javasampleapproach.diymonds.repo.VenditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnnuncioMateriaPrimaController {

    @Autowired
    AnnuncioMateriaPrimaRepository annuncioMateriaPrimaRepository;

    @GetMapping("/annunciMateriaPrima")
    public List<AnnuncioMateriaPrima> getAllAnnunciMateriaPrima() {
        System.out.println("Get all AnnunciMateriaPrima");
        List<AnnuncioMateriaPrima> annunciMateriaPrima = new ArrayList<>();
        annuncioMateriaPrimaRepository.findAll().forEach(annunciMateriaPrima::add);
        return annunciMateriaPrima;
    }
}