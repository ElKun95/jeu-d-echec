
public class Deplacement {
	protected int deplX;
	protected int deplY;
	protected Position arrive;
	protected Position depart;
	
	public Deplacement(Position depart, Position arrive){
		this.setDepart(depart);
		this.setArrive(arrive);
		this.deplX = arrive.getLigne() - depart.getLigne();
		this.deplY = arrive.getColonne() - depart.getColonne();
	}

	public int getDeplX(){
		return deplX;
	}
	
	public int getDeplY(){
		return deplY;
	}
	
	public void setDeplX(int deplacementX){
		this.deplX = deplacementX;
	}
	
	public void setDeplY(int deplacementY){
		this.deplY = deplacementY;
	}

	public Position getDepart() {
		return depart;
	}

	public void setDepart(Position depart) {
		this.depart = depart;
	}

	public Position getArrive() {
		return arrive;
	}

	public void setArrive(Position arrive) {
		this.arrive = arrive;
	}
	 // Verifie si le deplacement est null ou non
	public boolean DeplacementNull(){
		return deplX == 0 && deplY == 0;
	}
}
