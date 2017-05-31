package Echec;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fbb59554-0223-402c-b01b-6b4d2c652600")
public class Reine extends Piece {
		
	public Reine(String couleur){
		super(couleur);
		this.nom="Q";
	}
	
	public boolean deplacementValide(Deplacement depl){
		return (Math.abs(depl.getDeplX() - depl.getDeplY()) == 0 || (depl.getDeplX() * depl.getDeplY() == 0))
				&& !depl.DeplacementNull();
	}
		
}
