package com.edugroupe.gestionstock_springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role implements Serializable, GrantedAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name", nullable = false)
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
