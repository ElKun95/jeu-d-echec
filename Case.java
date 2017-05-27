
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1fafbdf8-0a11-47b6-bf40-4f2687c192eb")
public class Case {
	private Piece piece;
	
		// Acesseur
	public Piece getPiece() {
		return piece;
	}
		// Mutateur
	public void setPiece(Piece piece) {
		this.piece = piece;
	   }
	public boolean estOccupee(String couleur) {
		// TODO Auto-generated method stub
		if(piece==null)
			return false;
		else
			return (piece.getCouleur().equals(couleur));
	}


}
