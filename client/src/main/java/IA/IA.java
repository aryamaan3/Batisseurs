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
    void setDisplay(boolean display);
    boolean getDisplay();
    Compteur getCompteur();
    void ajouteTour(int n);
    void passeTour(int n);
    void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable);
    void poserOuvrierSurChantier();
    void choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable);
    void choisitOuvrier(int nbChoix, ArrayList<CarteOuvriers> cartesOuvSurTable);
    Joueur getJoueur();
    void setJoueur(Joueur joueur);
    void setCompteur(Compteur c);
}
