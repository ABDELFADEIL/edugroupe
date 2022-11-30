package com.edugroupe.gestionstock_springboot.controller;


import com.edugroupe.gestionstock_springboot.entity.Categorie;
import com.edugroupe.gestionstock_springboot.service.ICategorieService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {


    private final ICategorieService categorieService;

    public CategorieController(ICategorieService categorieService) {
        this.categorieService = categorieService;
    }

    // category
    @GetMapping( "")
    public ResponseEntity<List<Categorie>> getCategories(){
        List<Categorie> categories = categorieService.getCategories();
        if(categories == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }
}
