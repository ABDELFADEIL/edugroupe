package edugroupe.gescom.dao;

import edugroupe.gescom.model.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements DaoRepository<Client>{

    private Connection connection;

    public ClientRepository() throws SQLException {
        connection = ConnectionSingleton.getConnection();
    }

    @Override
    public Client save(Client client) throws SQLException {
        String query = "INSERT" +
                " INTO t_client(" +
                "id_client, nom_client, prenom_client, adresse, ddn_client" +
                ")" +
                "values(?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, client.getId_client() );
        ps.setString(2, client.getNom_client());
        ps.setString(3, client.getNom_client());
        ps.setString(4, client.getAdresse());
        ps.setDate(5, Date.valueOf(LocalDate.of(1990, 12, 2)));
        int inserted = ps.executeUpdate();
        System.out.println("inserted " + inserted);
        ResultSet rs=ps.getGeneratedKeys();
        Client client1 = null;
        if (rs.next())
         client1 = findById(rs.getInt(1));
        return client1;
    }
//

    @Override
    public Client update(Client client) throws SQLException {
        String query = "UPDATE " +
                "t_client SET nom_client=?, prenom_client=?, adresse=?, ddn_client=?" +
                "WHERE id_client= ?";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, client.getNom_client());
        ps.setString(2, client.getNom_client());
        ps.setString(3, client.getAdresse());
        ps.setDate(4, Date.valueOf(client.getDdn_client()));
        ps.setInt(5, client.getId_client());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        Client client1 = null;
        if (rs.next())
            client1 = findById(rs.getInt(1));
        return client1;
    }


    @Override
    public Client findById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * " +
                "FROM t_client " +
                "WHERE id_client= ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
        ResultSet rs = ps.executeQuery();
        Client client1 = null;
        if(rs.next()){
            client1 = new Client(
                    rs.getInt("id_client"),
                    rs.getString("nom_client"),
                    rs.getString("prenom_client"),
                    rs.getString("adresse"),
                    rs.getDate("ddn_client").toLocalDate()
            );
        }
        return client1;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * " +
                "FROM t_client ";
        ResultSet rs = statement.executeQuery(query);
        List<Client> clientList = new ArrayList<>();
        while(rs.next()){
            Client client1 = new Client(
                    rs.getInt("id_client"),
                    rs.getString("nom_client"),
                    rs.getString("prenom_client"),
                    rs.getString("adresse"),
                    rs.getDate("ddn_client").toLocalDate()
            );
            clientList.add(client1);
        }
        return clientList;
    }


    @Override
    public boolean deleteById(int id) throws SQLException {
        String query = "DELETE FROM t_client WHERE id_client= ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id );
       int i =  ps.executeUpdate();
        return (i == 1);
    }
}
