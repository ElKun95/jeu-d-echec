package Echec;

public class Joueur {
	private String couleur;

    public Joueur(String couleur){ 
    	this.couleur = couleur;
    }
    
    
	public String getCouleur(){
		return couleur;
	}
	
	public void setCouleur(String couleur){
		this.couleur = couleur;
	}
	
}
