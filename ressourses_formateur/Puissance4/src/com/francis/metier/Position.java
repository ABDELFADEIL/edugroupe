package com.francis.metier;

public class Position {
	private int ligne;
	private int colonne;
	
	/**
	 * @param abs
	 * @param ord
	 */
	public Position(int abs,int ord) {
		this.ligne = abs;
		this.colonne = ord;
	}

	public int getLigne() {
		return ligne;
	}

	
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getColonne() {
		return colonne;
	}

	@Override
	public String toString() {
		return "Position {ligne=" + ligne + ", colonne=" + colonne + "}";
		
	}


	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Position))
			return false;
		
		Position pos = (Position)obj;
		
		return this.ligne==pos.ligne && this.colonne==pos.colonne;
	}
	
	
	
}
