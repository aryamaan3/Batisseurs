package IA;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;

import java.util.ArrayList;

import static commun.display.Couleur.ANSI_RED;
import static commun.display.Couleur.ANSI_RESET;

public class IADumb implements IA {

    private Joueur joueur;
    private Compteur compteur;
    private final Display display = new Display(false);

    public IADumb(Joueur joueur, Compteur compteur){
        this.joueur = joueur;
        this.compteur = compteur;
    }
    @Override
    public Joueur getJoueur() {
        return joueur;
    }

    @Override
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public void setCompteur(Compteur c) {
        this.compteur = c;
    }
    @Override
    public void setDisplay(boolean display) {
        this.display.setAfficher(display);
    }

    @Override
    public boolean getDisplay() {
        return this.display.isAfficher();
    }

    @Override
    public Compteur getCompteur() {
        return compteur;
    }

    @Override
    public void ajouteTour(int n) {
        if (joueur.getBourse().getEcus() >= n * 5 + 5){ // verifie si le joueur possede assez d'ecus pour acheter des actions
            compteur.buyActions(n);
            joueur.getBourse().subEcus(n*5);
        }
    }

    @Override
    public void passeTour(int n) {
        int nbEcus =0;
        if (compteur.getNombreAction() >= n) { // verifie si le joueur possede le nombre d'actions requis pour les vendre
            if(n==1) {
                joueur.getBourse().addEcus(1);
                nbEcus = 1;
            }
            if(n==2) {
                joueur.getBourse().addEcus(3);
                nbEcus = 3;
            }
            if(n==3) {
                joueur.getBourse().addEcus(6);
                nbEcus = 6;
            }
        }
        display.displayPasseTour(joueur.getId(),n,nbEcus);
        compteur.sellActions(n);
        display.displayUtiliseAction(n);

    }

    @Override
    public void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable) {
        if(joueur.getMainBat().size()==0 && carteBatSurTable.size()>0){
            choisitBatiment(2,carteBatSurTable);
            if(joueur.getMainOuv().size()==1 && carteOuvSurTable.size()>0){
                choisitOuvrier(1,carteOuvSurTable);
            } else{
                passeTour(1);
            }
        } else if(joueur.getMainOuv().size()>0 && joueur.getMainOuv().get(0).getCout()<=joueur.getBourse().getEcus()){
                poserOuvrierSurChantier();
                passeTour(2);
        } else if(joueur.getMainOuv().size()==0 && carteOuvSurTable.size()>1) {
                choisitOuvrier(2,carteOuvSurTable);
                passeTour(1);

        } else {
                passeTour(3);
               }
        }



    @Override
    public void poserOuvrierSurChantier() {
        if(joueur.getMainBat().size()>0 && joueur.getMainOuv().size()>0){
            display.displayOuvPoseeSurChantier(joueur.getMainOuv().get(0),joueur.getMainBat().get(0),joueur.getId());
            joueur.attribuerOuvrierAChantier(joueur.getMainOuv().get(0),joueur.getMainBat().get(0));
            compteur.actionsFait(1);
            display.displayUtiliseAction(1);

        }

    }

    @Override
    public void choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable) {
        if(carteBatSurTable.size()>0) {
            for (int i = 0;i<nbChoix;i++){
                joueur.ajouteBatiment((CarteBatiments)carteBatSurTable.get(0));
                display.displayBatimentChoisi(joueur.getId(),carteBatSurTable.get(0));
                carteBatSurTable.remove(0);
            }
            compteur.actionsFait(nbChoix);
            display.displayUtiliseAction(nbChoix);
        }
    }

    @Override
    public void choisitOuvrier(int nbChoix, ArrayList<CarteOuvriers> cartesOuvSurTable) {
        if(cartesOuvSurTable.size()>0){
            display.displayString("Le joueur "+joueur.getId()+" a pioché :");
            for (int i = 0;i<nbChoix;i++){
                joueur.ajouteOuvrier(cartesOuvSurTable.get(0));
                display.displayOuvrierChoisi(cartesOuvSurTable.get(0));
                cartesOuvSurTable.remove(0);
            }
            compteur.actionsFait(nbChoix);
            display.displayUtiliseAction(nbChoix);
        }
    }


}
