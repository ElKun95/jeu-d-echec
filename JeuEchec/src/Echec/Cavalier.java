package Echec;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("89a1b4e1-57eb-45cc-95db-1992e9b85af4")
public class Cavalier extends Piece {
	
	public Cavalier(String couleur){
		super(couleur);
		this.nom="C";
	}
	public boolean deplacementValide(Deplacement depl){
		return Math.abs(depl.getDeplX() / depl.getDeplY()) == 2 || 
				Math.abs(depl.getDeplX() / depl.getDeplY()) == 0.5;
		// Il se deplace en L, soit de 2 en colonne et en 1 ligne et inversement
	}

}
