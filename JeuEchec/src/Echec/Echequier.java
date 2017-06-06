package Echec;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d8847c5e-41a3-4189-8f64-e0144452e752")
public class Echequier{
	private Case grille[][];
	private String couleur ;
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
			for(int j = 0; j < 8;  j++){
				if(i <= 1)
					couleur = "noir";
				else if(i > 1 && i < 6)
					couleur = " ";
				else
					couleur = "blanc";
								
				if(i == 0 || i == 7){
					this.grille[i][0].setPiece(new Tour(couleur));
					this.grille[i][1].setPiece(new Cavalier(couleur));
					this.grille[i][2].setPiece(new Fou(couleur));
					this.grille[i][3].setPiece(new Reine(couleur));
					this.grille[i][4].setPiece(new Roi(couleur));
					this.grille[i][5].setPiece(new Fou(couleur));	
					this.grille[i][6].setPiece(new Cavalier(couleur));
					this.grille[i][7].setPiece(new Tour(couleur));
				}
				else if(i == 1 || i == 6 )
					this.grille[i][j].setPiece(new Pion(couleur));
				else
					this.grille[i][j].setPiece(null);
			}
		}
	}
	
	public void afficher_grille(){
		int k =1;
		System.out.println("     A     B    C    D     E    F    G    H");
		System.out.println("  --------------------------------------------");		
		for(int i = 0; i < 8; i++ ){
			System.out.print(k);
			for(int j = 0; j < 8 ; j++){
				if(grille[i][j].getPiece() != null )
					System.out.print("  |  " + (this.grille[i][j].getPiece().getNom()));
				else
					System.out.print("  |  ");
			}
			
			System.out.println( "   |  ");
			System.out.println("  --------------------------------------------");
		k++;
		}
		
	}
	
	// Methode permettant de verifier si le chemin entre le depart et l'arrive il n'y a pas de piece entre les 2
	public boolean cheminValide(Deplacement depl){
		Piece departPiece = this.grille[depl.getDepart().getLigne()][ depl.getDepart().getColonne()].getPiece();
		int deplX = 0;
		int deplY = 0;
		
		if(depl.getDeplX() != 0)
			deplX = depl.getDeplX()/Math.abs(depl.getDeplX());
		if(depl.getDeplY() != 0)
			deplY = depl.getDeplY()/Math.abs(depl.deplY);
	
		if(!(departPiece instanceof Cavalier)){
			if(!(departPiece instanceof Pion) || (departPiece instanceof Pion && ((Pion)departPiece).getnbDepl() == 0)){
				for(int i = depl.getDepart().getLigne() + deplX , j = depl.getDepart().getColonne() + deplY ; i != depl.getArrive().getLigne() ; i+= deplX, j+=deplY){
					if(!(this.grille[i][j].caseLibre()))
						return false;
				}
				return true;
			}	
			else{
				// deplacement concernant les pions
				if(deplY != 0){
					if(this.grille[depl.getArrive().getLigne()][depl.getArrive().getColonne()].caseLibre())
						return false;
					return !this.grille[depl.getArrive().getLigne()][depl.getArrive().getColonne()].getPiece().getCouleur().equals(departPiece.getCouleur());
				}
				return this.grille[depl.getDepart().getLigne()][depl.getDepart().getColonne()].caseLibre();
			}
		}
		return true;
			
	}

	public boolean deplacement(Deplacement depl){
		Piece departPiece =  this.grille[depl.getDepart().getLigne()][ depl.getDepart().getColonne()].getPiece();
		Piece arriverPiece = this.grille[depl.getArrive().getLigne()][ depl.getArrive().getColonne()].getPiece();
		
		if(departPiece != null && !(depl.DeplacementNull())){
			if(arriverPiece == null || arriverPiece.getCouleur() != departPiece.getCouleur()){
				if(cheminValide(depl)){
					if((departPiece).deplacementValide(depl)){
						this.grille[depl.getArrive().getLigne()][depl.getArrive().getColonne()].setPiece(departPiece);
						this.grille[depl.getDepart().getLigne()][depl.getDepart().getColonne()].setPiece(null);
						if(departPiece instanceof Pion)
							((Pion) departPiece).setnbDepl(1);
						return true;
					}
					else
						System.out.println(" Cette piece n'autorise pas ces deplacements ");
				}
				else 
					System.out.println("Le chemin n'est pas valide");
			}
		}
		return false;
	}

	public Case getCase(int i, int j) {
		return grille[i][j];
	
	}


	
}
