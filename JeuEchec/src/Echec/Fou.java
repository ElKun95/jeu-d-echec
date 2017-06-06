package Echec;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("31121675-cef2-443b-912c-80e2866e6b2e")
public class Fou extends Piece{
	
	public Fou(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265D";
		else
			this.nom="\u2657";	
	}
	
	public boolean deplacementValide(Deplacement depl){
		return Math.abs(depl.getDeplX() - depl.getDeplY()) == 0 && !depl.DeplacementNull();
				
	}

}     
