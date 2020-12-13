package IA;


import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.ArrayList;

import static commun.display.Couleur.*;

/**
 *  Classe qui regroupe les informations et les méthodes de l'IA
 */

public class IASmart implements IA {
    private Joueur joueur;
    private Compteur compteur;
    private final Display display = new Display(false);

    public IASmart(Joueur joueur, Compteur compteur){
        this.joueur = joueur;
        this.compteur = compteur;
    }
    @Override
    public void setDisplay(boolean display){
        this.display.setAfficher(display);
    }
    @Override
    public boolean getDisplay(){
        return this.display.isAfficher();
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
    public Compteur getCompteur() { return compteur;}
    @Override
    public void setCompteur(Compteur c){ this.compteur = c;}


    /**
     *  Méthode qui permet à l'IA de choisir elle même un batiment
     * @param nbChoix le nombre de batiments que l'IA doit piocher
     * @param carteBatSurTable les cartes dans lesquelles l'IA doit piocher
     */

    public void choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable){
        int Sum = carteBatSurTable.get(0).getSumRessources();
        CarteChantier carteMini = carteBatSurTable.get(0);
        if(joueur.getMainBat().size()==0){
            for(int i=1;i<carteBatSurTable.size();i++){  // l'ia sélectionne la carte batiment qui nécessite le moins de ressources
                if(Sum > carteBatSurTable.get(i).getSumRessources()){
                    Sum = carteBatSurTable.get(i).getSumRessources();
                    carteMini = carteBatSurTable.get(i);
                }
            }
            display.displayBatimentChoisi(joueur.getId(),carteMini);
            joueur.ajouteBatiment((CarteBatiments) carteMini); // on ajoute cette carte à la main de l'ia , puis on l'a supprime des cartes sur table
            compteur.actionsFait(nbChoix);
            display.displayUtiliseAction(nbChoix);
            carteBatSurTable.remove(carteMini);
        }

    }
    /**
     *  Méthode qui permet à l'IA de choisir elle même un ouvrier
     * @param nbChoix le nombre d'ouvriers que l'IA doit piocher
     * @param cartesOuvSurTable les cartes dans lesquelles l'IA doit piocher
     */

    public void choisitOuvrier(int nbChoix,ArrayList<CarteOuvriers> cartesOuvSurTable){
        if (joueur.getMainOuv().size() < 5 && cartesOuvSurTable.size() >= nbChoix){
            display.displayString("Le joueur "+joueur.getId()+" a pioché :");
            for(int i=0;i<nbChoix;i++){ // on utilise la méthode idealOuvToChantier pour choisir la carte ouvrier la plus adapté selon les batiments que l'on possède
                display.displayOuvrierChoisi(cartesOuvSurTable.get(idealOuvToChantier(cartesOuvSurTable)));
                joueur.ajouteOuvrier(cartesOuvSurTable.get(idealOuvToChantier(cartesOuvSurTable)));
                cartesOuvSurTable.remove(idealOuvToChantier(cartesOuvSurTable)); // on enlève ensuite la carte choisie des cartes ouvriers sur table
            }
            compteur.actionsFait(nbChoix);
            display.displayUtiliseAction(nbChoix);
        }
    }
    /**
     *  Méthode qui permet à l'IA de poser elle même un ouvrier sur un batiment
     */
    @Override
    public void poserOuvrierSurChantier(){
        int meilleurCarteOuvID;
        if(joueur.getMainOuv().size()>0) {
            for (int j = 0; j < joueur.getMainBat().size(); j++) {
                if (!joueur.getMainBat().get(j).isContruit()) {
                    meilleurCarteOuvID = idealOuvToChantier(joueur.getMainOuv());
                    //System.out.println(meilleurCarteOuvID);
                    display.displayOuvPoseeSurChantier(joueur.getMainOuv().get(meilleurCarteOuvID),joueur.getMainBat().get(j),joueur.getId());
                    joueur.attribuerOuvrierAChantier(joueur.getMainOuv().get(meilleurCarteOuvID), joueur.getMainBat().get(j));
                    compteur.actionsFait(1);
                    display.displayUtiliseAction(1);
                }
            }
        }

    }




    /**
     * trouve le meilleur ouvrier à placer sur un batiment
     * @return l'indice du meilleur ouvrier à placer sur le batiment
     * @param ListeOuv ArrayList des cartes ouvriers
     */
    public int idealOuvToChantier(ArrayList<CarteOuvriers> ListeOuv){
        int bois, pierre, tuile, savoir, bestID = 0;
        int[] res = new int[ListeOuv.size()];
        bois = joueur.getMainBat().get(0).getBois();
        pierre = joueur.getMainBat().get(0).getPierre();
        tuile = joueur.getMainBat().get(0).getTuile();
        savoir = joueur.getMainBat().get(0).getSavoir();
        for (int i = 0; i < ListeOuv.size(); i++){
            CarteOuvriers c = ListeOuv.get(i);
            //on verifie si les ressources de la carte sont superieur au ressources requis
            if ((c.getBois() + joueur.getMainBat().get(0).getSumBoisOuv()) >= bois && joueur.getMainBat().get(0).getSumBoisOuv() < bois){
                // et on ne rentre pas dans le if si les ressources sont déjà remplis avec les cartes déjà posées
                res[i] += 1;
            }
            if ((c.getPierre() + joueur.getMainBat().get(0).getSumPierreOuv()) >= pierre && joueur.getMainBat().get(0).getSumPierreOuv() < pierre){
                res[i] += 1;
            }
            if ((c.getTuile() + joueur.getMainBat().get(0).getSumTuileOuv()) >= tuile && joueur.getMainBat().get(0).getSumTuileOuv() < tuile){
                res[i] += 1;
            }
            if ((c.getSavoir() + joueur.getMainBat().get(0).getSumSavoirOuv()) >= savoir && joueur.getMainBat().get(0).getSumSavoirOuv() < savoir){
                res[i] += 1;
            }
        }
        int max = 0; //swap
        for (int i = 0; i < res.length; i++){ //on itere sur le nb de cartes
            if ((ListeOuv.get(i).getCout() + 2) > joueur.getBourse().getEcus() && res[i] > 0){
                res[i] -= 1; // si le joueur ne possede pas assez d'ecus pour utiliser la carte on enleve un point
            }
            if (res[i] >= max){
                max = res[i]; //max prends la valeur de res(i) si c'est le plus grand
                bestID = i;
            }
        }
        //System.out.println(bestID);
        return bestID; //on retourne l'id
    }

    /**
     *  Méthode qui appel une suite de méthodes de l'IA pour qu'elle soit plus "intelligente"
     * @param carteOuvSurTable les cartes ouvriers disponibles sur le plateau
     * @param carteBatSurTable les cartes batiments disponibles sur le plateau
     */
    public void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){

        if (joueur.getBourse().getEcus() < 5){ // si le joueur ne possede pas assez d'ecus ppour effectuer des actions
            passeTour(3);
        }
        else if (joueur.getMainOuv().size() < 2) { //si le joueur possede moins de 2 cartes ouv

            if (joueur.getMainBat().size()==0){ //verifie que le joueur ne possede pas de carte batiment et en choisi un
                choisitBatiment(1, carteBatSurTable);
                if(carteOuvSurTable.size()>0) {
                    choisitOuvrier(2, carteOuvSurTable); //on choisit donc deux carte ouvriers
                } else { // si on peut pas piocher carte ouv
                    if (joueur.getMainOuv().size()>0) {
                        poserOuvrierSurChantier();
                        passeTour(1); // on vend le tour restant
                    }
                    else{
                        passeTour(2);
                    }
                }
            }
            else { // si le joueur possede deja un chantier en cours
                if (joueur.getMainOuv().size() < 3 && carteOuvSurTable.size() >= 3) {// on choisi 3 ouvriers à la place
                    choisitOuvrier(3, carteOuvSurTable);
                }
                else if (joueur.getMainOuv().size() < 4 && carteOuvSurTable.size() >= 2){ // on essaye de piocher 2 ouvrier
                    choisitOuvrier(2, carteOuvSurTable);
                    if (joueur.getMainOuv().size()>0){
                        poserOuvrierSurChantier();
                    } // on essaye de poser un ouv sur un chantier
                    else{passeTour(1);} // sinon on vend l'actions restant
                }
                else if (joueur.getMainOuv().size() < 5 && carteOuvSurTable.size() >= 1){ // on essaye d'en piocher 1
                    choisitOuvrier(1, carteOuvSurTable);
                    if (joueur.getMainOuv().size()>0) { //on essaye de place un ouv sur un chantier
                        poserOuvrierSurChantier();
                        passeTour(1); // on vend le tour restant
                    }
                    else{passeTour(2);} // on vends les tour restants
                }

            }
        }
        else { // si le joueur a plus de 1 cartes ouv

            if (joueur.getMainBat().size()==0) { // en choisi un seulement s'il en a pas un
                choisitBatiment(1, carteBatSurTable);
                if (carteOuvSurTable.size()>0) { //on essaye de piocher un ouvrier
                    choisitOuvrier(1, carteOuvSurTable);
                    if (joueur.getMainOuv().size()>0) {
                        poserOuvrierSurChantier();
                    }
                    else {passeTour(1);}
                }
                else { // si on peut pas piocher d'ouvrier
                    if (joueur.getMainOuv().size()>=2) {//on place un ouvrier sur un chantier
                        for (int i = 0; i < 2; i++) {
                            poserOuvrierSurChantier();
                        }
                    }
                    else if (joueur.getMainOuv().size()==1){ // on essaye de placer le deuxieme
                            poserOuvrierSurChantier();
                            passeTour(1); // on place la seule carte disponible et on vend l'action restante
                    }
                    else {passeTour(2);// sinon on vend les actions
                    }
                }




            }
            else{ // si chantier en cours
                if (carteOuvSurTable.size()>0) { // on essaye de piocher un ouvrier
                    choisitOuvrier(1, carteOuvSurTable);
                    if (joueur.getMainOuv().size()>=2) {//on place un ouvrier sur un chantier
                        for (int i = 0; i < 2; i++) {
                            poserOuvrierSurChantier();
                        }
                    }
                    else if (joueur.getMainOuv().size()==1){ // on essaye de placer le deuxieme
                        poserOuvrierSurChantier();
                        passeTour(1); // on place la seule carte disponible et on vend l'action restante
                    }
                    else {passeTour(2);} // sinon on vends les actions
                }
                else{
                    if (joueur.getMainOuv().size()>0) {
                        poserOuvrierSurChantier();//on pose l'ouvrier sur le chantier
                        passeTour(2); // on vend les tours restants
                    }
                    else{passeTour(3);} // on vends les tours restants
                }
            }
        }

        if (joueur.getBourse().getEcus() > 10 && carteOuvSurTable.size() > 0){
            // achete des actions s'il possede beaucoup d'ecus et il y des cartes ouv à piocher
            int nbAchetee = (joueur.getBourse().getEcus() / 10) % 2;
            ajouteTour(nbAchetee); // n'ajoute pas plus de deux actions à la fois
            display.displayAjouteTour(joueur.getId(),nbAchetee,nbAchetee*5);
            for (int i = 0; i < nbAchetee+1; i++){ // boucle sur le nb d'actions achetée
                if (joueur.getMainBat().size()==0){
                    choisitBatiment(1, carteBatSurTable);
                }
                // choisi une carte batiment si le joueur en possede pas
                else if (joueur.getMainOuv().size() < 2){ // si le joueur possede moins de deux cartes ouv
                    choisitOuvrier(1, carteOuvSurTable);
                }
                else {
                    poserOuvrierSurChantier();

                }
            }
        }

        for(int i=0;i<getJoueur().getMainOuv().size();i++){
            carteOuvSurTable.remove(getJoueur().getMainOuv().get(i)); //on enleve toutes les cartes selectionné
        }



    }
    /**
     * verifie si le joueur possede assez de tours pour passer et ajoute les ecus
     * @param n nb de tours à passer
     */
    public void passeTour(int n){
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



    /**
     * verifie si le joueur a les moyens d'acheter des tours et en achete
     * @param n nb de tours à ajouter
     */
    public void ajouteTour(int n){
        if (joueur.getBourse().getEcus() >= n * 5 + 5){ // verifie si le joueur possede assez d'ecus pour acheter des actions
            compteur.buyActions(n);
            joueur.getBourse().subEcus(n*5);
        }

    }
}

