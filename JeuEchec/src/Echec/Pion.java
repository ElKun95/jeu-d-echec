package Echec;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f053f634-0d8b-4a1f-b597-aaea20c94652")
public class Pion extends Piece{
	protected int nbDepl;
	
	public Pion(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265F";
		else
			this.nom="\u2659";	
	}
	public int getnbDepl(){
		return nbDepl;
		
	}
	
	public void setnbDepl(int nbdeplacement){
		this.nbDepl = nbdeplacement;
	}
	public boolean deplacementValide(Deplacement depl){
		if(this.nbDepl == 0 &&(depl.getDeplX() == 1 || depl.getDeplX() == 2) && this.getCouleur().equals("noir"))
			return ((depl.getDeplY() == 0) && !(depl.DeplacementNull()));
		
		if(this.nbDepl == 0 &&(depl.getDeplX() == -1 || depl.getDeplX() == -2) && this.getCouleur().equals("blanc"))
			return ((depl.getDeplY() == 0) && !(depl.DeplacementNull()));
		
		if(this.nbDepl == 1 &&(depl.getDeplX() == 1) && this.getCouleur().equals("noir"))
			return ((depl.getDeplY() == 0 || depl.getDeplY() == 1 || depl.getDeplY() == -1) && !(depl.DeplacementNull()));
		
		if(this.nbDepl == 1 &&(depl.getDeplX() == -1) && this.getCouleur().equals("blanc"))
			return ((depl.getDeplY() == 0 || depl.getDeplY() == 1 || depl.getDeplY() == -1) && !(depl.DeplacementNull()));
		return false;
			
	} 
}
