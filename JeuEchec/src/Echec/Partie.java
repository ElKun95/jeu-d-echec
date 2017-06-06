package Echec;

import java.io.*;
import java.util.*;
public class Partie{

	private ArrayList<Deplacement>  SavePos = new ArrayList<Deplacement>();
	private Echequier g1;
	private Joueur joueur[] = new Joueur[2];
	Deplacement depl;
	private boolean fini_jeu;
	private Joueur JoueurActuel;
	
	
	public Partie(){
		
		intialise();
		jeu();
	}
	
	public void intialise(){
		g1 = new Echequier();
		g1.intialise();
    	// initialise les joueurs
    	for(int i = 0; i<2;i++){
    		if(i == 0)
        		joueur[i] = new Joueur("blanc");
    		else
        		joueur[i] = new Joueur("noir");
    	}
    	
		fini_jeu = false; // le jeu commence donc on met false
		JoueurActuel = joueur[0]; // le premier joueur est le blanc
	}
	
	public void jeu(){
		
		int x,y ;
		Position depart;
		Position arriver;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Voulez vous charger une partie ?");
		String charge = input.next();
		if(charge.equals("oui")){
			System.out.println("Quelle partie voulez voue chargez ?");
			String nomcharge = input.next();
			charger(nomcharge);
		}
		else
			g1.afficher_grille();
	
		while(fini_jeu == false){
			
			System.out.println(" Saisir le depart (ligne puis colonne)");
			x = input.nextInt();
			y = input.nextInt();
			depart = new Position(x-1,y-1);
			
			System.out.println(" Saisir arriver (ligne puis colonne) ");
			x = input.nextInt();
			y = input.nextInt();
			arriver = new Position(x-1,y-1);

			Deplacement depl = new Deplacement(depart,arriver);
			
			if(g1.getCase(depl.getDepart().getLigne(), depl.getDepart().getColonne()).getPiece().getCouleur().equals(JoueurActuel.getCouleur())){
				
				if(g1.deplacement(depl)){
					// change de joueur courrant
					if(JoueurActuel == joueur[0])
						JoueurActuel = joueur[1];
					else
						JoueurActuel = joueur[0];
				}
				else
					System.out.println("Deplacement faux");
			}
			else
				System.out.println("Ce n'est pas a votre tour de jouer !");
			
			g1.afficher_grille();
			SavePos.add(depl);
			
			System.out.println(" Voulez vous sauvegarde ?");
			String sauve = input.next();
			if(sauve.equals("oui")){
				System.out.println("Quelle sera le nom de la partie ?");
				String str = input.next();
				sauvegarde(str);
			}	
			g1.afficher_grille();
		}

	}
	
	public boolean sauvegarde(String nomsauve){
	    try{
		    File file = new File(nomsauve + ".txt"); 
		    FileWriter fw;
	    	ListIterator<Deplacement> ite = SavePos.listIterator(); 
    		fw = new FileWriter(file);   
    		
    		while(ite.hasNext()){
    			Deplacement depl = ite.next();
	    		fw.write(depl.getDepart().getLigne()+""+ depl.getDepart().getColonne() // ecris en String
	    				+ " " 
	    				+ depl.getArrive().getLigne()+""+ depl.getArrive().getColonne()
	    				+ '\n');
	   
	    	}
    		
    		
	    	fw.write(JoueurActuel.getCouleur());  
	    	
    		fw.close(); 
	    	return true;
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    	return false;
	    }

	}
	
	public boolean charger(String nomcharge){
		try{
			intialise();
			File file = new File(nomcharge + ".txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr); // Extension de filereader mais plus elle lit les fichiers ligne par ligne 
			String s = br.readLine(); // recupere la ligne
		
			while(s != null && !(s.equals("blanc") || s.equals("noir"))){
			
				int ligneDepart = Integer.parseInt(s.substring(0, 1)); // Convertir une chaine de caractére en int ; Substring recupere la position ecrite dans le fichier
				int colonneDepart = Integer.parseInt(s.substring(1,2));
				int ligneArrivee = Integer.parseInt(s.substring(3, 4));
				int colonneArrivee = Integer.parseInt(s.substring(4,5));
				Piece pieceDepart = g1.getCase(ligneDepart,colonneDepart).getPiece();
				g1.getCase(ligneArrivee, colonneArrivee).setPiece(pieceDepart);
				g1.getCase(ligneDepart,colonneDepart).setPiece(null);
				s = br.readLine();
			}
			
			if(s.equals("blanc"))
				JoueurActuel = joueur[0];
			else if(s.equals("noir"))
				JoueurActuel = joueur[1];
			
			br.close();
			fr.close();

			g1.afficher_grille();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();

		}
		return false;
	}
	

	
	public static void main(String[] args){
		
		new Partie();
		
	
	}
}
