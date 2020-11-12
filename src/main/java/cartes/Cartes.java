package cartes;

/**
 * La classe Cartes contient des méthodes générales sur les cartes (ouvriers et batiments)
 */

public class Cartes { //Classe mère des classes CarteBatiments et CarteOuvriers

    protected int id,bois,tuile,savoir,pierre;
    protected String nom;


    public Cartes(int id, String nom, int bois,int tuile,int savoir,int pierre){
        this.id = id;
        this.bois = bois;
        this.tuile = tuile;
        this.savoir = savoir;
        this.pierre = pierre;
        this.nom = nom;
    }



    /**
     *
     * @return La valeur en bois de la carte
     */
    public int getBois() {
        return bois;
    }

    /**
     *
     * @return La valeur en pierre de la carte
     */
    public int getPierre() { return pierre; }

    /**
     *
     * @return La valeur en savoir de la carte
     */
    public int getSavoir() {
        return savoir;
    }

    /**
     *
     * @return La valeur en tuile de la carte
     */
    public int getTuile() {
        return tuile;
    }

    /**
     *
     * @return L'id d'une carte
     */
    public int getIdCarte(){
        return id;
    }

    /**
     *
     * @return Le nom d'une carte
     */
    public String getNom(){
        return nom;
    }

    /**
     *
     * @return Le nom de la carte
     */
    @Override
    public String toString() {      //méthode pour visualiser
        return "Carte : "
                 +nom+"";
    }

}
