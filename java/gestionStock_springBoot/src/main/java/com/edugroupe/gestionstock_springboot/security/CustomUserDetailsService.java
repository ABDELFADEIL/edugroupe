package com.edugroupe.gestionstock_springboot.security;


import com.edugroupe.gestionstock_springboot.dao.UtilisateurRepository;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur u =null;
        u=utilisateurRepository.findByEmail(email);
        if(u==null) throw new UsernameNotFoundException(email);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        u.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getAuthority()));
        });
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), authorities);
    }

}