package commun.batiments;

import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;

import java.util.ArrayList;

/**
 * Interface nous permettant d'utiliser les méthodes de CartesBatiment et CarteChantier
 * sans etre obligé de connaitre le type spécifique dans le moteur de jeu.
 */
public interface CarteChantier {
    int getEcu();
    int getPoints();
    void setEcu(int ecu);
    void setPoints(int points);
    boolean isContruit();
    void setConstruit(boolean bool);
    ArrayList<CarteOuvriers> getOuvriers();
    void attribuerOuvrier(CarteOuvriers carte);
    void libererOuvrier();
    int getSumRessources();
    int getSumBoisOuv();
    int getSumPierreOuv();
    int getSumSavoirOuv();
    int getSumTuileOuv();
    String toString(Joueur joueur);
    boolean isBuilt();
    boolean isMachine();

    // Méthode de la class Carte
    String getNom();
    int getBois();
    int getPierre();
    int getSavoir();
    int getTuile();
    int getIdCarte();
}
