package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Categorie;

import java.util.List;

public interface ICategorieService {

    List<Categorie> getCategories();
}
