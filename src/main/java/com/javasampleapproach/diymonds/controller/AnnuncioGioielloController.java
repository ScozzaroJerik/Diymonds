package com.javasampleapproach.diymonds.controller;

import com.javasampleapproach.diymonds.model.AnnuncioGioiello;
import com.javasampleapproach.diymonds.model.Venditore;
import com.javasampleapproach.diymonds.repo.AnnuncioGioielloRepository;
import com.javasampleapproach.diymonds.repo.VenditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnnuncioGioielloController {

    @Autowired
    AnnuncioGioielloRepository annuncioGioielloRepository;

    @GetMapping("/annunciGioielli")
    public List<AnnuncioGioiello> getAllAnnunciGioielli() {
        System.out.println("Get all Annunci Gioielli");
        List<AnnuncioGioiello> annunciGioielli = new ArrayList<>();
        annuncioGioielloRepository.findAll().forEach(annunciGioielli::add);
        return annunciGioielli;
    }
}
