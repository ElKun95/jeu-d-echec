
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5c773756-6660-4021-ba6d-00a88cbeb2c1")
public class Tour extends Piece {
	
	public Tour(String couleur){
		super(couleur);
		if(couleur.equals("noir"))
			this.nom="\u265C ";
		else
			this.nom="\u2656 ";	
	}
	
	public boolean deplacementValide(Deplacement depl){
		return depl.getDeplX() * depl.getDeplY() == 0 && !depl.DeplacementNull();
		// Si x vaut 0 le deplacement est verticale, si y vaut 0 le deplacement horizontale
	}
}
