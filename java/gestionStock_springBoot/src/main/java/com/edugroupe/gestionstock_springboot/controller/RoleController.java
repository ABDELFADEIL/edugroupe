package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.service.IRoleService;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("")
    public ResponseEntity<List<Role>> getRoles(
    ) {
        List<Role> roles = roleService.findAll();
        if (roles == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/getRoleByName")
    public ResponseEntity<Role> getRoles(
            @RequestParam(name = "roleName", required = true) String roleName
    ) {
        Role role = roleService.findByRoleName(roleName);
        if (role == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(role);
    }
    
}
