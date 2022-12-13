package com.edugroupe.servletprojet.dao;

import com.edugroupe.servletprojet.models.Utilisateur;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepository implements IDaoRepository<Utilisateur>{


    private Connection connection;

    public UtilisateurRepository() throws SQLException {
        connection = ConnectionDB.getConnection();
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) throws SQLException {
        String query = "INSERT INTO " +
                "utilisateur(" +
                "id, nom, prenom, adresse, date_naissance, email, password" +
                ") values" +
                "(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, utilisateur.getId() );
        ps.setString(2, utilisateur.getNom());
        ps.setString(3, utilisateur.getPrenom());
        ps.setString(4, utilisateur.getAdresse());
        ps.setDate(5, Date.valueOf(utilisateur.getDateNaissance()));
        ps.setString(6, utilisateur.getEmail());
        ps.setString(7, utilisateur.getPassword());

        int inserted = ps.executeUpdate();
        System.out.println("inserted " + inserted);
        ResultSet rs=ps.getGeneratedKeys();
        Utilisateur client1 = null;
        if (rs.next())
            client1 = findById(rs.getInt(1));
        return client1;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) throws SQLException {
        String query = "UPDATE " +
                "utilisateur SET nom=?, prenom=?, adresse=?, date_naissance=?, email=?, password=?" +
                "WHERE id= ?";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, utilisateur.getNom());
        ps.setString(2, utilisateur.getPrenom());
        ps.setString(3, utilisateur.getAdresse());
        ps.setDate(4, Date.valueOf(utilisateur.getDateNaissance()));
        ps.setString(5, utilisateur.getEmail());
        ps.setString(6, utilisateur.getPassword());
        ps.setInt(7, utilisateur.getId());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        Utilisateur utilisateur1 = null;
        if (rs.next())
            utilisateur1 = findById(rs.getInt(1));
        return utilisateur1;
    }

    @Override
    public Utilisateur findById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * " +
                "FROM utilisateur " +
                "WHERE id= ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
        ResultSet rs = ps.executeQuery();
        Utilisateur client1 = null;
        if(rs.next()){
            client1 = new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getDate("date_naissance").toLocalDate(),
                    rs.getString("email"),
                    rs.getString("password"),
                    null
            );
        }
        return client1;
    }

    @Override
    public List<Utilisateur> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * " +
                "FROM utilisateur ";
        ResultSet rs = statement.executeQuery(query);
        List<Utilisateur> clientList = new ArrayList<>();
        while(rs.next()){
            Utilisateur client1 = new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("adresse"),
                    rs.getDate("date_naissance").toLocalDate(),
                    rs.getString("email"),
                    rs.getString("password"),
                    null
            );
            clientList.add(client1);
        }
        return clientList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String query = "DELETE FROM utilisateur WHERE id= ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
        int i =  ps.executeUpdate();
        return (i == 1);
    }
}
