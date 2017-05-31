package Echec;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("31121675-cef2-443b-912c-80e2866e6b2e")
public class Fou extends Piece {
	
	public Fou(String couleur){
		super(couleur);
		this.nom="F";
	}
	
	public boolean deplacementValide(Deplacement depl){
		return Math.abs(depl.getDeplX() - depl.getDeplY()) == 0 && !depl.DeplacementNull();
				
	}

}     
