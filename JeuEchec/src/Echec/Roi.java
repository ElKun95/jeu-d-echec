package Echec;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("db6f91da-7853-4c60-b98b-4c1974d00baa")
public class Roi extends Piece{

	public Roi(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265A";
		else
			this.nom="\u2654";	
	}
	
	public boolean deplacementValide(Deplacement depl){
		return (Math.abs(depl.getDeplX()) == 1 && Math.abs(depl.getDeplY()) == 0) || 
				Math.abs(depl.getDeplY()) == 1 && Math.abs(depl.getDeplX()) == 0 || 
				Math.abs(depl.getDeplX() - depl.getDeplY() ) == 0 && !depl.DeplacementNull();
	}

	
	 
}
