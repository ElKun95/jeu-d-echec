
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fbb59554-0223-402c-b01b-6b4d2c652600")
public class Reine extends Piece {
		
	public Reine(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265B ";
		else
			this.nom="\u2655 ";	
	}
	
	public boolean deplacementValide(Deplacement depl){
		return (Math.abs(depl.getDeplX() - depl.getDeplY()) == 0 || (depl.getDeplX() * depl.getDeplY() == 0))
				&& !depl.DeplacementNull();
	}
		
}
