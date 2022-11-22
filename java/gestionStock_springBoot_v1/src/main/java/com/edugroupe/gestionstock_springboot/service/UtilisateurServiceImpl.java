package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.RoleRepository;
import com.edugroupe.gestionstock_springboot.dao.UtilisateurRepository;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository
            , BCryptPasswordEncoder bCryptPasswordEncoder
                                  ) {
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
}
