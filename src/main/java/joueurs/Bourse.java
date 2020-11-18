package joueurs;

import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;

import java.util.ArrayList;

import static cartes.ouvrier.CarteOuvriers.getCarteOuvById;
import static cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur;
import static display.Couleur.*;

/**
 * La classe Bourse permet de créer une bourse pour chaque joueur et de savoir les écus qu'ils possèdent
 */

public class Bourse {
    public int pieceArgent, pieceOr, ecus, idJoueur;

    /**
     * Constructeur de la Bourse, on récupère les pièces d'argent et d'or pour créer le nombre d'écus.
     * @param idJoueur    le numero du joueur auquel on assigne la bourse.
     */

    public Bourse(int idJoueur) {
        this.pieceArgent = 5;
        this.pieceOr = 1;
        this.idJoueur = idJoueur;
        this.ecus = pieceArgent + 5 * pieceOr;
    }

    /**
     * @return le nombre d'écus que le joueur possède.
     */
    public int getEcus() {
        return ecus;
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
        return getCarteOuvById(idCarteOuvrierDuJoueur.get(idCarte),deckOuvrier).getCout() <= getEcus();
    }

    /**
     * @param somme somme d'écus à ajouter à la bourse
     */
    public void addEcus(int somme) {
        this.ecus += somme;
        System.out.println(ANSI_RED + "Le joueur " +(idJoueur+1) +" gagne "+ somme + " écus"+ANSI_RESET);
        System.out.println(ANSI_RED + "Nouveau solde : " +ecus +ANSI_RESET);
    }

    public void subEcus(int somme){
        this.ecus -= somme;
        System.out.println(ANSI_RED + "Le joueur " +(idJoueur+1) +" utilise "+ somme + " écus"+ANSI_RESET);
        System.out.println(ANSI_RED + "Nouveau solde : " +ecus +ANSI_RESET);
    }
}
