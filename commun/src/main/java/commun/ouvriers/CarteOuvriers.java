package commun.ouvriers;

import commun.Cartes;

/**
 * Classe qui regroupe les informations et les méthodes des cartes ouvriers
 */
public class CarteOuvriers extends Cartes {
    private int cout;
    private boolean isBusy;

    /**
     * Constructeur pour les cartes ouvriers, on crée la carte en y associant ses caractéristiques
     * @param id le numéro de la carte
     * @param nom le nom de la carte
     * @param cout le coût de l'ouvrier
     * @param pierre le nombre de pierre que l'ouvrier apporte
     * @param bois le nombre de bois que l'ouvrier apporte
     * @param savoir le nombre de savoir que l'ouvrier apporte
     * @param tuile le nombre de tuile que l'ouvrier apporte
     */
    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile){
        super(id, nom , pierre, bois, savoir, tuile);
        this.cout = cout;
        this.isBusy = false;

    }

    /**
     * Méthode retournant le coût de l'ouvrier
     * @return le coût de l'ouvrier
     */
    public int getCout() {
        return cout;
    }

    /**
     * Assigne le coût d'un ouvrier
     * @param cout le coût de l'ouvrier
     */
    public void setCout(int cout) {
        this.cout = cout;
    }

    /**
     * Méthode permettant de savoir si l'ouvrier est occupé
     * @return true si l'ouvrier est assigné à un batiment, false sinon
     */
    public boolean isBusy() { return isBusy;
    }

    /**
     * Méthode permettant de changer le statut de l'ouvrier (si il est occupé ou pas)
     * @param isBusy true ou false
     */
    public void setAssign(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public String toString(){
        return ("Ouvrier "+nom+
                " (bois : "+ this.bois +" ;" +
                " pierre : " + this.pierre +" ;" +
                " tuile : " + this.tuile +" ;" +
                " savoir : " + this.savoir +")");
    }

}
