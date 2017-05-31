package Echec;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0361b96a-a814-45a7-9853-3f8b82932ed5")
public class Partie {
    @objid ("79a79119-486c-438f-8ebb-7c21de0ea085")
    public String Nom;

    @objid ("2fcc6eb3-e47a-46e9-8391-a379d152504d")
    public Jouer jouer;

    @objid ("ae1f5a80-2722-4317-a060-4cb8cefc7dc8")
    public Couleur couleur;

    @objid ("3a83b2e3-14ca-4ac8-ae6c-f3464a865e3f")
    public Echequier echequier;

    @objid ("b2d4b827-1818-43da-bea8-6860641f13b4")
    public void InitialiserPartie() {
    }

}
