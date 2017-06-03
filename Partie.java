import java.io.Serializable;
import java.util.Scanner;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
public class Partie implements Serializable {
	
	public Partie(){}
	

	public static void main(String[] args){
		
		Sauvegarde s;
		boolean flag = false;
		int x,y ;
		Position depart;
		Position arriver;
		Scanner input = new Scanner(System.in);
		
		Echiquier g1 = new Echiquier(); 
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
			
			//if(input.equals("sauvegarde")){}
				
			
		}
		
		
	}
}
