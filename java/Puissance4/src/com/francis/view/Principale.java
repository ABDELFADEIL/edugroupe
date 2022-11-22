package com.francis.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.francis.metier.Couleur;
import com.francis.metier.Grille;
import com.francis.metier.Jeton;
import com.francis.metier.Puissance4;
import com.francis.metier.Puissance4Exception;

public class Principale {
	
	public static void main(String[] args)   {
		
		// Exception
		int a =10;
		int b=0;
		try {
			System.out.println("a/b = " + (a/b));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int [] tab = {0,1,2,3};
		
		try {
			System.out.println("valeur à l'indice 5 " + tab[5]);
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Bonjour à tous");
		
		//
		try {
			System.out.println("valeur à l'indice 5 " + getElementByIndex(tab, 5));
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		//
		try {
			System.out.println("a/b =  " + divisionDeDeuxNombres(a, b));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static int getElementByIndex(int [] tab,int index) throws ArrayIndexOutOfBoundsException {
		
		return tab[index];
	}
	
	public static double divisionDeDeuxNombres(int x,int y) throws Puissance4Exception {
		
		if(y==0)
			//throw new ArrayIndexOutOfBoundsException("Division par zéro impossible");	
			throw new Puissance4Exception("Division par zéro impossible");
		
		
		return (x/y);
	}
}
