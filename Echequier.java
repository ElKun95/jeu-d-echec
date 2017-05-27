
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d8847c5e-41a3-4189-8f64-e0144452e752")
public class Echequier {
	private Case grille[][];
	private String couleur ;
	//private Position position;
	private Piece piece;
	
	public Echequier(){
		grille = new Case[8][8];
		
		for(int i = 0; i < 8; i++ ){
			for(int j = 0; j < 8 ; j++){
				this.grille[i][j] = new Case();
			}
		}
	}
	
	public void intialise(){
		
		for(int i = 0; i < 8; i++){
			couleur="noir";
			for(int j = 0; j < 8;  j++){
				if(i > 5)
					couleur = "blanc";
				
				
				if(i == 1 || i == 6 )
					this.grille[i][j].setPiece(new Pion(couleur));
		
				if(i == 0 || i == 7){
					this.grille[i][0].setPiece(new Tour(couleur));
					this.grille[i][1].setPiece(new Chevalier(couleur));
					this.grille[i][2].setPiece(new Fou(couleur));
					this.grille[i][3].setPiece(new Reine(couleur));
					this.grille[i][4].setPiece(new Roi(couleur));
					this.grille[i][5].setPiece(new Fou(couleur));	
					this.grille[i][6].setPiece(new Chevalier(couleur));
					this.grille[i][7].setPiece(new Tour(couleur));
				}
			}
		}
	}
	
	public void afficher_grille(){
		intialise();
		System.out.println("   A   B   C   D   E   F   G   H");
		System.out.println(" ---------------------------------");		
		for(int i = 0; i < 8; i++ ){
			for(int j = 0; j < 8 ; j++){
				if(grille[i][j].getPiece() != null )
					System.out.print(" | " + (this.grille[i][j].getPiece().getNom()));
				else
					System.out.print(" |  ");
			}
			
			System.out.println( " | ");
			System.out.println("  --------------------------------");
		}
		
		System.out.println("    A   B   C   D   E   F   G   H");
		
	}
	
	public void CapturePion(Deplacement deplacement){
		if(grille[deplacement.getDepart().getLigne()][deplacement.getDepart().getColonne()].getPiece() instanceof Pion){
			
			Case Arrivee= grille[(int)deplacement.getArrive().getColonne()][(int)deplacement.getArrive().getLigne()];
			String couleur= grille[(int)deplacement.getArrive().getColonne()][(int)deplacement.getArrive().getLigne()].getPiece().getCouleur();
			
			if(Arrivee.estOccupee(couleur.equals("blanc")))
				return (deplacement.getDeplY() * Math.abs(deplacement.getDeplX()) == (couleur.equals("noir")==1));
			else
				return (deplacement.getDeplY() * Math.abs(deplacement.getDeplX()) == (couleur.equals("blanc")== -1));
		}
	}
	
	
}
