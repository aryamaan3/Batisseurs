package commun;

/**
 * Classe contenant les méthodes communes aux cartes Batiment et Ouvrier
 */

public class Cartes {

    protected int id,bois,tuile,savoir,pierre;
    protected String nom;

    /**
     * Constructeur commun pour les cartes
     * @param id numéro de la carte
     * @param nom nom de la carte
     * @param bois attribut bois de la carte
     * @param tuile attribut tuile de la carte
     * @param savoir attribut savoir de la carte
     * @param pierre attribut pierre de la carte
     */

    public Cartes(int id, String nom, int pierre,int bois,int savoir,int tuile){
        this.id = id;
        this.bois = bois;
        this.tuile = tuile;
        this.savoir = savoir;
        this.pierre = pierre;
        this.nom = nom;
    }



    /**
     * Méthode retournant le nombre de bois associé à la carte
     * @return La valeur en bois de la carte
     */
    public int getBois() {
        return bois;
    }

    /**
     * Méthode retournant le nombre de pierre associé à la carte
     * @return La valeur en pierre de la carte
     */
    public int getPierre() { return pierre; }

    /**
     * Méthode retournant le nombre de savoir associé à la carte
     * @return La valeur en savoir de la carte
     */
    public int getSavoir() {
        return savoir;
    }

    /**
     * Méthode retournant le nombre de tuile associé à la carte
     * @return La valeur en tuile de la carte
     */
    public int getTuile() {
        return tuile;
    }

    /**
     * Méthode retournant le numéro de la carte
     * @return Le numéro d'une carte
     */
    public int getIdCarte(){
        return id;
    }

    /**
     * Méthode retournant le nom de la carte
     * @return Le nom d'une carte
     */
    public String getNom(){
        return nom;
    }

    @Override
    public String toString() {      //méthode pour visualiser
        return nom
                +" (bois : " + bois +" ; "
                +"pierre : " + pierre +" ; "
                +"tuile : " + tuile +" ; "
                +"savoir : " + savoir +")";
    }
}
