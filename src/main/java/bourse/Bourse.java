package bourse;

public class Bourse {
    int pieceArgent, pieceOr, ecus, idJoueur;

    /**
     * Constructeur de la Bourse, on récupère les pièces d'argent et d'or pour créer le nombre d'écus.
     * @param pieceArgent le nombre de piece d'argent qu'on donne au joueur en début de partie.
     * @param pieceOr le nombre de piece d'or qu'on donne au joueur en début de partie
     * @param idJoueur le numero du joueur auquel on assigne la bourse.
     */

    public Bourse(int pieceArgent, int pieceOr, int idJoueur){
        this.pieceArgent = pieceArgent;
        this.pieceOr = pieceOr;
        this.idJoueur = idJoueur;
        this.ecus = pieceArgent + 5 * pieceOr;
    }

    /**
     *
     * @param idJoueur le numéro du joueur
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus(int idJoueur){
        return this.ecus;
    }
}
