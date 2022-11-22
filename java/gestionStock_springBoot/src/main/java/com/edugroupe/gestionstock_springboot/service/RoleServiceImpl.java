package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.RoleRepository;
import com.edugroupe.gestionstock_springboot.entity.Role;

import java.util.List;

public class RoleServiceImpl implements IRoleService{

    private final RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return null;
    }
}
