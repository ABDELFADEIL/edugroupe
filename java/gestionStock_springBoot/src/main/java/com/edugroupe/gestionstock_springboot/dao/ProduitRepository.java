package com.edugroupe.gestionstock_springboot.dao;

import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    Page<Produit> findAllByNomContainsOrDesignationContains(Pageable pageable, String nom, String designation);
    Page<Produit> findByNomContainsOrDesignationContainsAndCategorieId(
            Pageable pageable,
            @Param("nom") String nom, @Param("designation") String designation,
            @Param("id") Integer categoryId);

    @Query("select p from Produit p where p.categorie.id=:categoryId and " +
            "(p.nom like %:nom% or p.designation like %:designation%)" )
    Page<Produit> findByCategorieIdAndNomContainingOrDesignationContaining(
            Pageable pageable,
            @Param("categoryId") Integer categoryId,
            @Param("nom") String nom, @Param("designation") String designation);
    /*
    Page<Produit> findByCategorieIdAndNomContainsOrDesignationContains(
            Pageable pageable, @Param("id") Integer categoryId,
            @Param("nom") String nom, @Param("designation") String designation);
     */
}
