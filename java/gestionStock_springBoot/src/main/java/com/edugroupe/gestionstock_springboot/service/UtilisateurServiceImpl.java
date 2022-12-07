package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.RoleRepository;
import com.edugroupe.gestionstock_springboot.dao.UserProfileUpdate;
import com.edugroupe.gestionstock_springboot.dao.UtilisateurRepository;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Page<Utilisateur> findByNomOrDesignationContains(Pageable pageable, String keyword) {
        return utilisateurRepository.findByNomContainsOrPrenomContains(pageable, keyword, keyword);
    }

    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
        List<Role> roles = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> {
            Role role1 = roleRepository.findByRoleName(role.getRoleName());
            if(role1 != null){
                roles.add(role1);
            }
        });
        utilisateur.setRoles(roles);
        if (utilisateur.getId() == 0){
            utilisateur.setPassword(bCryptPasswordEncoder.encode("password"));
            return utilisateurRepository.save(utilisateur);
        } else {
            Optional<Utilisateur> optionalUtilisateur =
                    utilisateurRepository.findById(utilisateur.getId());
            if (optionalUtilisateur.isPresent()){
                Utilisateur user = optionalUtilisateur.get();
                if (!Objects.equals(utilisateur.getNom(), user.getNom())){
                    user.setNom(utilisateur.getNom());
                }
                if (!Objects.equals(utilisateur.getPrenom(), user.getPrenom())){
                    user.setPrenom(utilisateur.getPrenom());
                }
                if (!Objects.equals(utilisateur.getEmail(), user.getEmail())){
                    user.setEmail(utilisateur.getEmail());
                }
                if (!Objects.equals(utilisateur.getDateNaissance(), user.getDateNaissance())){
                    user.setDateNaissance(utilisateur.getDateNaissance());
                }
                if (!Objects.equals(utilisateur.getAdresse(), user.getAdresse())){
                    user.setAdresse(utilisateur.getAdresse());
                }
               return utilisateurRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        if (utilisateurRepository.existsById(userId)) {
            utilisateurRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public Utilisateur updateProfile(UserProfileUpdate profileUpdate, Integer utlisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utlisateurId).orElse(null);
        if (utilisateur == null){
            return null;
        }
        if (Objects.equals(profileUpdate.getFieldName(), "email")){
            utilisateur.setEmail(profileUpdate.getValue());
        }
        if (Objects.equals(profileUpdate.getFieldName(), "address")){
            utilisateur.setAdresse(profileUpdate.getValue());
        }
        if (Objects.equals(profileUpdate.getFieldName(), "password")){
            utilisateur.setPassword(bCryptPasswordEncoder.encode(profileUpdate.getValue()));
        }
        return utilisateurRepository.save(utilisateur);
    }

}
