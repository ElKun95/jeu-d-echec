import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sauvegarde implements Serializable{

	public static void main(String[] args) {
		File fichier= new File("sauvegarde.txt");
		
		if(!fichier.exists()){
			try {
				fichier.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(fichier))){
			Partie p1= new Partie();
			out.writeObject(p1);
			out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
