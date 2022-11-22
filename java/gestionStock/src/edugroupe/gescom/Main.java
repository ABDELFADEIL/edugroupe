package edugroupe.gescom;

import edugroupe.gescom.dao.ClientRepository;
import edugroupe.gescom.model.Client;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("Récupérer la liste des clients");
        ClientRepository clientRepository = new ClientRepository();
        // get all clients
        List<Client> clients = clientRepository.findAll();
        clients.forEach(System.out::println);
        System.out.println("********************* Fin liste des clients ******************");

        System.out.println("Récupérer un client par son id");
        Client client = clientRepository.findById(3);
        System.out.println(client);
        System.out.println("************** Fin récupérer un client par son id ****************");

        Integer integer = clients.stream().map(Client::getId_client)
                .max((x, y)-> (x > y) ? 1: (y > x) ? -1 : 0).orElse(0);
        System.out.println("Max value = " + integer);
        Map<Integer, List<Client>> clientsMap = clients.stream()
                .collect(Collectors.groupingBy(Client::getId_client));
        clientsMap.forEach((k, v)-> System.out.println("key: " + k + " , value: " + v));

        System.out.println("Insérer un client");
        Client client2;
        client2 = clientRepository.save(
                new Client(0, "SAGHA", "Abdelfadeil", "abcd@gmail.com", LocalDate.now()));
        System.out.println(client2);
        System.out.println("************** Fin insérer un client ****************");

        System.out.println("Mettre à jour un client");
        Client
        client3 = clientRepository.update(
                new Client(19, "Eric", "Mario", "eric@gmail.com", LocalDate.now()));
        System.out.println(client3);
        System.out.println("************** Fin Mettre à jour un client ****************");

        System.out.println("************** Fin insérer un client ****************");

        System.out.println("Supprimer un client");
        boolean
                deleted = clientRepository.deleteById(22);
        System.out.println("Client supprimé : " + deleted);
        System.out.println("************** Fin Supprimer un client ****************");

    }
}