package commun.joueur;



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
     * Méthode retournant le nombre d'écus que le joueur possède
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus() {
        return this.ecus;
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
