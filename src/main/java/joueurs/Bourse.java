package joueurs;

import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;

import java.util.ArrayList;

import static cartes.ouvrier.CarteOuvriers.getCarteOuvById;
import static cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur;

/**
 * La classe Bourse permet de créer une bourse pour chaque joueur et de savoir les écus qu'ils possèdent
 */

public class Bourse {
    private int pieceArgent, pieceOr, ecus, idJoueur;

    /**
     * Constructeur de la Bourse, on récupère les pièces d'argent et d'or pour créer le nombre d'écus.
     * @param pieceArgent le nombre de piece d'argent qu'on donne au joueur en début de partie.
     * @param pieceOr     le nombre de piece d'or qu'on donne au joueur en début de partie
     * @param idJoueur    le numero du joueur auquel on assigne la bourse.
     */

    public Bourse(int pieceArgent, int pieceOr, int idJoueur) {
        this.pieceArgent = pieceArgent;
        this.pieceOr = pieceOr;
        this.idJoueur = idJoueur;
        this.ecus = pieceArgent + 5 * pieceOr;
    }

    /**
     * @param idJoueur le numéro du joueur
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus(int idJoueur) {
        return this.ecus;
    }

    /**
     * actionAutorisee permet d'autoriser ou non une action à l'IA en fonction de l'argent qu'elle dispose
     * @param idJoueur le numéro du joueur
     * @param deckOuvrier le deck contenant les cartes ouvriers
     * @param idCarte le numéro de la carte
     * @return true ou false
     */
    public boolean actionAutorisee(int idJoueur, ArrayList<CarteOuvriers> deckOuvrier, int idCarte){
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, deckOuvrier);
        return getCarteOuvById(idCarteOuvrierDuJoueur.get(idCarte),deckOuvrier).getCout() <= getEcus(idJoueur);
    }
}
