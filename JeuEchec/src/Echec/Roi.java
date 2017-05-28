package Echec;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("db6f91da-7853-4c60-b98b-4c1974d00baa")
public class Roi extends Piece {

	public Roi(String couleur){
		super(couleur);
		this.nom="R";
	}
	
	public boolean deplacementValide(Deplacement depl){
		return (Math.abs(depl.getDeplX()) == 1 && Math.abs(depl.getDeplY()) == 0) || 
				Math.abs(depl.getDeplY()) == 1 && Math.abs(depl.getDeplX()) == 0 || 
				Math.abs(depl.getDeplX() - depl.getDeplY() ) == 0 && ! depl.DeplacementNull();
	}
	
	 
}
