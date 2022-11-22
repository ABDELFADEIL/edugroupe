package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.CommandeRepository;
import com.edugroupe.gestionstock_springboot.entity.Commande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements ICommandeService{

    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(final CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }
    @Override
    public Commande findById(Integer idCommande) {
        return commandeRepository.findById(idCommande).orElse(null);
    }
}
