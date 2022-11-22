package edugroupe.gescom.dao;

import edugroupe.gescom.model.Client;
import edugroupe.gescom.model.Commande;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommandeRepository implements DaoRepository<Commande>{

    private Connection connection;

    public CommandeRepository() throws SQLException {
        connection = ConnectionSingleton.getConnection();
    }

    @Override
    public Commande save(Commande commande) throws SQLException {
        String query = "INSERT" +
                " INTO t_commande(num_cmd, date_cmd, num_client)" +
                "values(?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, commande.getNum_cmd());
        ps.setDate(2, Date.valueOf(commande.getDate_cmd()));
        ps.setInt(3, commande.getNum_client());
        int inserted = ps.executeUpdate();
        System.out.println("inserted " + inserted);
        ResultSet rs=ps.getGeneratedKeys();
        Commande commande1 = null;
        if (rs.next())
         commande1 = findById(rs.getInt(1));
        return commande1;
    }
//

    @Override
    public Commande update(Commande commande) throws SQLException {
        String query = "UPDATE " +
                "t_commande SET num_cmd=?, date_cmd=?, num_client=? " +
                "WHERE num_cmd= num_cmd";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, commande.getNum_cmd());
        ps.setDate(2, Date.valueOf(commande.getDate_cmd()));
        ps.setInt(3, commande.getNum_client());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        Commande commande1 = null;
        if (rs.next())
            commande1 = findById(rs.getInt(1));
        return commande1;
    }


    @Override
    public Commande findById(int id) throws SQLException {
        String query = "SELECT * " +
                "FROM t_commande " +
                "WHERE num_cmd= ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
        ResultSet rs = ps.executeQuery();
        Commande commande = null;
        if(rs.next()){
             commande = new Commande(
                    rs.getInt("num_cmd"),
                    rs.getDate("ddn_client").toLocalDate(),
                    rs.getInt("num_client")
            );
        }
        return commande;
    }

    @Override
    public List<Commande> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * " +
                "FROM t_client ";
        ResultSet rs = statement.executeQuery(query);
        List<Commande> commandeList = new ArrayList<>();
        while(rs.next()){
            Commande commande = new Commande(
                    rs.getInt("num_cmd"),
                    rs.getDate("ddn_client").toLocalDate(),
                    rs.getInt("num_client")
                    );
            commandeList.add(commande);
        }
        return commandeList;
    }


    @Override
    public boolean deleteById(int id) throws SQLException {
        String query = "DELETE FROM t_commande WHERE num_cmd= ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
       int i =  ps.executeUpdate();
        return (i == 1);
    }
}
