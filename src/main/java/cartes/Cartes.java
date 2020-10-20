package cartes;

public class Cartes { //Classe pour creer l'objet cartes

    protected int idCart,bois,tuile,savoir,pierre;
    protected String nom;



    public Cartes(int id, String nom, int bois,int tuile,int savoir,int pierre){
        this.idCart = id;
        this.bois = bois;
        this.tuile = tuile;
        this.savoir = savoir;
        this.pierre = pierre;
        this.nom = nom;


    }

    public int getBois() {
        return bois;
    }

    public int getPierre() {
        return pierre;
    }

    public int getSavoir() {
        return savoir;
    }

    public int getTuile() {
        return tuile;
    }

    // La personne qui a créée cette fonction doit la modifier pour renvoyer un int : idCarte et pas un nom !
    public int getIdCarte(){
        return idCart;
    }

    public String getNom(){
        return nom;
    }


    @Override
    public String toString() {      //méthode pour visualiser
        return "Carte : "
                 +nom+"";
    }

}
