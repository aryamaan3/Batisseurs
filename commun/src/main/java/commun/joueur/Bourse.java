package commun.joueur;

import commun.ouvriers.CarteOuvriers;

import static commun.display.Couleur.ANSI_RED;
import static commun.display.Couleur.ANSI_RESET;

public class Bourse {
    private int pieceArgent, pieceOr, ecus, idJoueur;

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
     * @param somme somme d'écus à ajouter à la bourse
     */
    public void addEcus(int somme) {
        this.ecus += somme;
        System.out.println(ANSI_RED + "Le joueur " +(idJoueur) +" gagne "+ somme + " écu(s)"+ANSI_RESET);
        System.out.println(ANSI_RED + "Nouveau solde : " +ecus +ANSI_RESET);
    }

    public void subEcus(int somme){
        this.ecus -= somme;
        System.out.println(ANSI_RED + "Le joueur " +(idJoueur) +" utilise "+ somme + " écu(s)"+ANSI_RESET);
        System.out.println(ANSI_RED + "Nouveau solde : " +ecus +ANSI_RESET);
    }


}
