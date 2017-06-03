import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Charger implements Serializable{
	public static void main(String[] args){
		File fichier=new File("sauvegarde.txt");
		if(!fichier.exists()){
			try {
				fichier.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*try (FileInputStream in= new FileInputStream(fichier)){
			Scanner scan= new Scanner(fichier);
			while(scan.hasNextLine()){
				System.out.println(scan.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fichier))){
			Partie p1= (Partie)in.readObject();
			System.out.println(p1);
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
