package IA;

import commun.batiments.CarteChantier;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;

import java.util.ArrayList;

/**
 * Interface nous permettant d'utiliser les méthodes de IASmart et IADumb
 * sans etre obligé de connaitre le type spécifique dans le moteur de jeu.
 */

public interface IA {
    /**
     * Cette méthode permet de choisir d'afficher les actions du joueur
     * @param display true si on veut afficher les actions des joueurs, false sinon
     */
    void setDisplay(boolean display);

    /**
     * Permet de savoir si on a choisi d'afficher les actions du joueur
     * @return true si on a choisi afficher les actions, false sinon
     */
    boolean getDisplay();

    /**
     * Méthode permettant d'afficher le nombre d'actions restantes du joueur
     * @return le nombre d'actions restantes du joueur
     */
    Compteur getCompteur();

    /**
     * Méthode permettant d'ajouter des actions au joueur
     * @param n le nombre de tours qu'on souhaite ajouter
     */
    void ajouteTour(int n);

    /**
     * Méthode permettant au joueur de passer des tours
     * @param n le nombre de tours que le joueur souhaite passer
     */
    void passeTour(int n);

    /**
     * Méthode qui appelle une suite de méthode de l'IA pour lui permettre de faire des choix
     * @param carteOuvSurTable ArrayList contenant les cartes ouvriers disponibles sur le plateau
     * @param carteBatSurTable ArrayList contenant les cartes bâtiments disponibles sur le plateau
     */
    void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable);

    /**
     * Méthode qui permet au joueur de poser un ouvrier sur un chantier
     */
    void poserOuvrierSurChantier();

    /**
     * Méthode permettant au joueur de choisir des cartes bâtiments
     * @param nbChoix le nombre de bâtiments que le joueur doit piocher
     * @param carteBatSurTable les bâtiments disponibles sur le plateau
     */
    void choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable);

    /**
     * Méthode permettant au joueur de choisir des cartes ouvriers
     * @param nbChoix le nombre d'ouvriers que le joueur doit piocher
     * @param cartesOuvSurTable les ouvriers disponibles sur le plateau
     */
    void choisitOuvrier(int nbChoix, ArrayList<CarteOuvriers> cartesOuvSurTable);

    /**
     * Méthode permettant de récuperer le joueur
     * @return le joueur
     */
    Joueur getJoueur();

    /**
     * Permet d'ajouter des joueurs dans le jeu
     * @param joueur le joueur à mettre dans le jeu
     */
    void setJoueur(Joueur joueur);

    /**
     * Méthode permettant de mettre le compteur d'actions au nombre voulu
     * @param c le nombre d'actions que l'on veut mettre
     */
    void setCompteur(Compteur c);
}
