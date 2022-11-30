package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.CategorieRepository;
import com.edugroupe.gestionstock_springboot.entity.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements ICategorieService{

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    @Override
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }
}
