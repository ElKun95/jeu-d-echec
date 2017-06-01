
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("daccf8da-3434-4289-b0fa-b90631be57b0")
public abstract class Piece {
    @objid ("711ad3e5-1c30-4662-852f-5f65c76036c7")
    protected String nom;
	protected String couleur;
    
    public Piece(String couleur){
		this.couleur = couleur;
	}
	
		// Accesseur
	public String getCouleur(){
		return couleur;
	}
	
	public String getNom(){
		return nom;
	}
		// Mutateur
	public void setCouleur(String couleur){
		this.couleur = couleur;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}

	public abstract boolean deplacementValide(Deplacement depl);


}
