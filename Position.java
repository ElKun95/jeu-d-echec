import java.io.Serializable;

public class Position implements Serializable{
	protected int ligne;
	protected int colonne;
	
	// Accesseur
	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}
	
	//Mutateur
	public void setLigne(int ligne){
		this.ligne = ligne;
	}
	public void setColonne(int colonne){
		this.colonne = colonne;
	}
	
	// Constructeur
	
	public Position(int ligne,int colonne){
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public boolean equals(Position position){
		return position.getColonne() == this.getColonne() && position.getLigne() == this.ligne;
	}

}
