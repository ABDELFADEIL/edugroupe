package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();
    Role findByRoleName(String roleName);
}
