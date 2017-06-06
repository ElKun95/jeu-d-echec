package Echec;

import java.io.*;
import java.util.*;
public class Partie{
	
	private ArrayList<Deplacement>  SavePos = new ArrayList<Deplacement>();
	private Echequier g1;
	private Joueur joueur[] = new Joueur[2];
	Deplacement depl;
	private boolean fini_jeu;
	private Joueur CurrentPlayer;
	
	
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
		CurrentPlayer = joueur[0]; // le premier joueur est le blanc
	}
	
	public void jeu(){
		
		int x,y ;
		Position depart;
		Position arriver;
		Scanner input = new Scanner(System.in);
		
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
			
			if(g1.getCase(depl.getDepart().getLigne(), depl.getDepart().getColonne()).getPiece().getCouleur().equals(CurrentPlayer.getCouleur())){
				
				if(g1.deplacement(depl)){
					// change de joueur courrant
					if(CurrentPlayer == joueur[0])
						CurrentPlayer = joueur[1];
					else
						CurrentPlayer = joueur[0];
				}
				else
					System.out.println("Deplacement faux");
			}
			else
				System.out.println("Ce n'est pas a votre tour de jouer !");
			
			g1.afficher_grille();
			SavePos.add(depl);
			System.out.println("sauvegarde ?");
			
			String sauve = input.next();
			if(sauve.equals("oui"))
				sauvegarde();
			else if(sauve.equals("charger"))
				charger();
			
			g1.afficher_grille();
		}

	}
	
	public boolean sauvegarde(){
	    try{
		    File file = new File("sauvegarde.txt"); 
		    FileWriter fw;
	    	ListIterator<Deplacement> ite = SavePos.listIterator(); 
    		fw = new FileWriter(file);   
    		
    		while(ite.hasNext()){
    			Deplacement depl = ite.next();
	    		fw.write(depl.getDepart().getLigne()+""+ depl.getDepart().getColonne() 
	    				+ " " 
	    				+ depl.getArrive().getLigne()+""+ depl.getArrive().getColonne()
	    				+ '\n');
	   
	    	}
    		
    		
	    	fw.write(CurrentPlayer.getCouleur());  
	    	
    		fw.close(); 
	    	return true;
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    	return false;
	    }

	}
	
	public boolean charger(){
		try{
			intialise();
			File file = new File("sauvegarde.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
		
			while(s != null && !(s.equals("Blanc") || s.equals("Noir"))){
			
				int ligneDepart = Integer.parseInt(s.substring(0, 1)); // recupere un caractere et le transformer en int
				int colonneDepart = Integer.parseInt(s.substring(1,2));
				int ligneArrivee = Integer.parseInt(s.substring(3, 4));
				int colonneArrivee = Integer.parseInt(s.substring(4,5));
				Piece pieceDepart = g1.getCase(ligneDepart,colonneDepart).getPiece();
				g1.getCase(ligneArrivee, colonneArrivee).setPiece(pieceDepart);
				g1.getCase(ligneDepart,colonneDepart).setPiece(null);
				s = br.readLine();
			}
			
			if(s.equals("blanc"))
				CurrentPlayer = joueur[0];
			else if(s.equals("noir"))
				CurrentPlayer = joueur[1];
			
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
