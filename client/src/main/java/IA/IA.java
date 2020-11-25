package IA;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.ArrayList;

/**
 *  Classe qui regroupe les informations et les méthodes de l'IA
 */

public class IA {
    private Joueur joueur;
    private int nbActions;
    private Compteur compteur;

    public IA(Joueur joueur, Compteur compteur){
        this.joueur = joueur;
        this.nbActions = 6;
        this.compteur = compteur;
    }
    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    public int getNbActions() {
        return nbActions;
    }
    public Compteur getCompteur() { return compteur;}
    public void setNbActions(int nbActions) {
        this.nbActions = nbActions;
    }

    /**
     *  Méthode qui permet à l'IA de choisir elle même un batiment
     * @param nbChoix le nombre de batiments que l'IA doit piocher
     * @param cartesBatSurTable les cartes dans lesquelles l'IA doit piocher
     */

    public void choisitBatiment(int nbChoix, ArrayList<CarteChantier> cartesBatSurTable){

        if(joueur.getMainBat().size()==0){
            joueur.ajouteBatiment((CarteBatiments) cartesBatSurTable.get(0));
            compteur.actionsFait(nbChoix);
        }
    }
    /**
     *  Méthode qui permet à l'IA de choisir elle même un ouvrier
     * @param nbChoix le nombre d'ouvriers que l'IA doit piocher
     * @param cartesOuvSurTable les cartes dans lesquelles l'IA doit piocher
     */
    public void choisitOuvrier(int nbChoix,ArrayList<CarteOuvriers> cartesOuvSurTable){
        for(int i=0;i<nbChoix;i++){
            joueur.ajouteOuvrier(cartesOuvSurTable.get(i));
        }
        compteur.actionsFait(nbChoix);

    }
    /**
     *  Méthode qui permet à l'IA de poser elle même un ouvrier sur un batiment
     */
    public void poserOuvrierSurChantier(){
        for(int i = 0; i<1; i++){   //On peut poser qu'un ouvrier par tour pour l'instant
            for(int j = 0; j<joueur.getMainBat().size(); j++) {
                if (!joueur.getMainBat().get(j).isContruit()) {
                    joueur.attribuerOuvrierAChantier(joueur.getMainOuv().get(0), joueur.getMainBat().get(j));
                    break;
                }
            }
        }
    }
    /**
     *  Méthode qui appel une suite de méthodes de l'IA pour qu'elle soit plus "intelligente"
     * @param carteOuvSurTable les cartes ouvriers disponibles sur le plateau
     * @param carteBatSurTable les cartes batiments disponibles sur le plateau
     */
    public void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){
        compteur.buyActions(2);
        choisitBatiment(1,carteBatSurTable);
        carteBatSurTable.remove(getJoueur().getMainBat().get(0));
        choisitOuvrier(1,carteOuvSurTable);
        ajouteTour(1);
        Display.displayOuvriersDuJoueur(getJoueur());
        for(int i=0;i<getJoueur().getMainOuv().size();i++){
            carteOuvSurTable.remove(getJoueur().getMainOuv().get(i));
        }
        poserOuvrierSurChantier();
        passeTour(1);
    }
    /**
     * verifie si le joueur possede assez de tours pour passer et ajoute les ecus
     * @param n nb de tours à passer
     */
    public void passeTour(int n){
        if (compteur.getNombreAction() >= n) {
            for (int i = 1; i < n + 1; i++) {
                joueur.getBourse().addEcus(i);
            }
            compteur.sellActions(n);
        }
    }

    /**
     * verifie si le joueur a les moyens d'acheter des tours
     * @param n nb de tours à ajouter
     */
    public void ajouteTour(int n){
        if (joueur.getBourse().getEcus() >= n * 5 + 5){
            compteur.buyActions(n);
            joueur.getBourse().subEcus(n*5);
        }
    }

}

