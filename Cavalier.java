import java.io.Serializable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("89a1b4e1-57eb-45cc-95db-1992e9b85af4")
public class Cavalier extends Piece implements Serializable{
	
	public Cavalier(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265E ";
		else
			this.nom="\u2658 ";	
	}
	
	public boolean deplacementValide(Deplacement depl){
		return Math.abs(depl.getDeplX() / depl.getDeplY()) == 2 || 
				Math.abs(depl.getDeplX() / depl.getDeplY()) == 0.5;
		// Il se deplace en L, soit de 2 en colonne et en 1 ligne et inversement
	}

}
