package commun.joueur;

import commun.ouvriers.CarteOuvriers;

/**
 * Classe regroupant les informations et les méthodes associées aux bourses
 */
public class Bourse {
    private int ecus;
    private final int idJoueur;

    /**
     * Constructeur de la Bourse, on récupère les pièces d'argent et d'or pour créer le nombre d'écus.
     * @param idJoueur    le numero du joueur auquel on assigne la bourse.
     */

    public Bourse(int idJoueur) {
        int pieceArgent = 5;
        int pieceOr = 1;
        this.idJoueur = idJoueur;
        this.ecus = pieceArgent + 5 * pieceOr;
    }

    /**
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus() {
        return this.ecus;
    }

    /**
     * actionAutorisee permet d'autoriser ou non une action à l'IA en fonction de l'argent qu'elle dispose
     * @param carte la carte ouvrier
     * @return true ou false
     */
    public boolean isActionOuvAutorisee(CarteOuvriers carte){
        return carte.getCout() <= getEcus();
    }
    /**
     * Ajoute des écus à un joueur
     * @param somme somme d'écus à ajouter à la bourse
     */
    public void addEcus(int somme) {
        this.ecus += somme;
    }

    /**
     * Soustrait des écus à un joueur
     * @param somme somme d'écus à ajouter à la bourse
     */
    public void subEcus(int somme){
        this.ecus -= somme;
    }


}
