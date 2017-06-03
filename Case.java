import java.io.Serializable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1fafbdf8-0a11-47b6-bf40-4f2687c192eb")
public class Case implements Serializable{
	private Piece piece;
	
		// Acesseur
	public Piece getPiece() {
		return piece;
	}
		// Mutateur
	public void setPiece(Piece piece) {
		this.piece = piece;
	   }
	public boolean caseLibre() {
		if(piece == null)
			return true;
		return false;
	}


}
