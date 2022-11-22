package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.LigneCommandeRepository;
import com.edugroupe.gestionstock_springboot.entity.LigneCommande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeServiceImpl implements ILigneCommandeService{

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeServiceImpl(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public List<LigneCommande> findAll() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public LigneCommande findById(Integer idLigneCommande) {
        return ligneCommandeRepository.findById(idLigneCommande).orElse(null);
    }

    @Override
    public List<LigneCommande> findByIdCommande(Integer idCommande) {
        return ligneCommandeRepository.findAllByCommande_Id(idCommande);
    }
}
