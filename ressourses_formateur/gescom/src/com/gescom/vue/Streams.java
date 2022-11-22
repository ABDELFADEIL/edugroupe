package com.gescom.vue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.gescom.metier.Client;
import com.gescom.services.CLientDao;

public class Streams {
	
	
	public static void main(String[] args) {
		
			try {
				List<Client> listeClient = new CLientDao().findAll();
				
				System.out.println(listeClient);
				
				//1-	AnyMatch  : Vérifie l'existence d'un client via son id 5
				
					/*
					 * for(Client clt: listeClient) {
					 * 
					 * if(clt.getId() == 15) System.out.println("Le client existe");
					 * 
					 * }
					 */
					if(listeClient.stream().anyMatch(elt-> elt.getId() == 5))
						System.out.println("Le client existe");
				//2	filter
					
					List<Client> lt = listeClient.stream().filter(elt-> elt.getPrenom().equals("Lisa")).collect(Collectors.toList());
				//3-	Limit
					List<Client> lt2 = listeClient.stream().filter(elt-> elt.getPrenom().equals("Lisa")).limit(1).collect(Collectors.toList());
					System.out.println(lt2);
				//4-	distinct  : 
					List<Client> lt3 = listeClient.stream().filter(elt-> elt.getPrenom().equals("Lisa")).distinct().collect(Collectors.toList());
					System.out.println(lt3);
				
				//5-	Afficher uniquement les prénoms
					String lt4 = listeClient.stream().map(elt->elt.getPrenom()).distinct().collect(Collectors.toList()).get(0);
					System.out.println(lt4);
				//6-
					listeClient.stream().count();
				//7-	Id Max et Id min
					
					System.out.println(listeClient.stream().map(elt->elt.getId()).max((x,y)->  x.compareTo(y) ).get());
					
					System.out.println(listeClient.stream().map(elt->elt.getId()).max(Integer::compareTo).get());
					
					System.out.println(listeClient.stream().map(elt->elt.getId()).reduce(Integer::max).get());   //  max((x,y)-> x > y ? x:y).get());
					
					
					System.out.println(listeClient.stream().map(elt->elt.getId()).reduce(0,(x,y)->x+y)); 
					
				//8-	Faire un goupement sur les prénom et compter
					
					Map<String, Long> map =
							listeClient.stream()
							.map(c->c.getPrenom())
							.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
					
					
					map.forEach((k,v)->System.out.println( k + " nombre : " + v));

					
					
							
			}catch (Exception e) {
				// TODO: handle exception
			}
	
		
		
	}
}
