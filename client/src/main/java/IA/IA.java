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
    public void setDisplay(boolean display);
    public boolean getDisplay();
    public Compteur getCompteur();
    public void ajouteTour(int n);
    public void passeTour(int n);
    public void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable);
    public void poserOuvrierSurChantier();
    public void choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable);
    public void choisitOuvrier(int nbChoix,ArrayList<CarteOuvriers> cartesOuvSurTable);
    public Joueur getJoueur();
    public void setJoueur(Joueur joueur);
    public void setCompteur(Compteur c);
}
