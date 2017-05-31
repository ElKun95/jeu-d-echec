package Echec;
import java.util.Scanner;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
public class Partie {
	
	public static void main(String[] args){
		
		boolean flag = false;
		 int x,y ;
		Position depart;
		Position arriver;
		Scanner input = new Scanner(System.in);
		
		Echequier g1 = new Echequier(); 
		g1.intialise();
		g1.afficher_grille();
		
		
		while(flag == false){
				
			System.out.println(" Saisir le depart (ligne puis colonne)");
			x = input.nextInt();
			y = input.nextInt();
			depart = new Position(x-1,y-1);
			
			System.out.println(" Saisir arriver (ligne puis colonne) ");
			x = input.nextInt();
			y = input.nextInt();
			arriver = new Position(x-1,y-1);

			Deplacement depl = new Deplacement(depart,arriver);

			g1.deplacement(depl);
			g1.afficher_grille();
	
		
		}
	}
}
