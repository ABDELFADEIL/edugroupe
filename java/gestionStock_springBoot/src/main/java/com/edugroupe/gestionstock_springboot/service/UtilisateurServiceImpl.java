package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.RoleRepository;
import com.edugroupe.gestionstock_springboot.dao.UtilisateurRepository;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findById(Integer idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur).orElse(null);
    }

    @Override
    public Utilisateur inscription(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = UtilisateurDto.toUtilisateur(utilisateurDto);
        String password = bCryptPasswordEncoder.encode(utilisateurDto.getPassword());
        utilisateur.setPassword(password);
        Role role = roleRepository.findByRoleName(utilisateurDto.getRoleName());
        List<Role> roles = Arrays.asList(role);
        utilisateur.setRoles(roles);
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    @Override
    public Utilisateur ajouterRoleAUtilisateur(String roleName, int idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElse(null);
        Role role = roleRepository.findByRoleName(roleName);
        if (utilisateur != null && role != null){
          utilisateur.getRoles().add(role);
          utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }

    @Override
    public Utilisateur isUtilisateurExists(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public Utilisateur update(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur =
                utilisateurRepository.findById(utilisateurDto.getId()).orElse(null);
        if(utilisateur == null){
            return null;
        }
        if(!utilisateur.getEmail().equals(utilisateurDto.getEmail())){
            utilisateur.setEmail(utilisateurDto.getEmail());
            utilisateur = utilisateurRepository.save(utilisateur);
        }
        if(!utilisateur.getAdresse().equals(utilisateurDto.getAdresse())){
            utilisateur.setAdresse(utilisateurDto.getAdresse());
            utilisateur = utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }
}
