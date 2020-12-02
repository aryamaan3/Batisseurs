package IA;

import commun.Cartes;
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
     * @param carteBatSurTable les cartes dans lesquelles l'IA doit piocher
     * @return 1 si l'IA pioche un batiment, 0 sinon
     */

    public int choisitBatiment(int nbChoix, ArrayList<CarteChantier> carteBatSurTable){
        int Sum = carteBatSurTable.get(0).getSumRessources();
        CarteChantier carteMini = carteBatSurTable.get(0);
        if(joueur.getMainBat().size()==0){
            for(int i=1;i<carteBatSurTable.size();i++){  // l'ia sélectionne la carte batiment qui nécessite le moins de ressources
                if(Sum > carteBatSurTable.get(i).getSumRessources()){
                    Sum = carteBatSurTable.get(i).getSumRessources();
                    carteMini = carteBatSurTable.get(i);
                }
            }
            joueur.ajouteBatiment((CarteBatiments) carteMini); // on ajoute cette carte à la main de l'ia , puis on l'a supprime des cartes sur table
            compteur.actionsFait(nbChoix);
            carteBatSurTable.remove(carteMini);
            return 1;
        }
        return 0; //si on déjà une carte batiment pas encore construit
    }
    /**
     *  Méthode qui permet à l'IA de choisir elle même un ouvrier
     * @param nbChoix le nombre d'ouvriers que l'IA doit piocher
     * @param cartesOuvSurTable les cartes dans lesquelles l'IA doit piocher
     * @return 1 si l'ia a pu piocher un ouvrier, 0 sinon
     */
    public int choisitOuvrier(int nbChoix,ArrayList<CarteOuvriers> cartesOuvSurTable){
        if (joueur.getMainOuv().size() < 5 && cartesOuvSurTable.size() >= nbChoix){
            for(int i=0;i<nbChoix;i++){ // on utilise la méthode idealOuvToChantier pour choisir la carte ouvrier la plus adapté selon les batiments que l'on possède
                joueur.ajouteOuvrier(cartesOuvSurTable.get(idealOuvToChantier(cartesOuvSurTable)));
                cartesOuvSurTable.remove(idealOuvToChantier(cartesOuvSurTable)); // on enlève ensuite la carte choisie des cartes ouvriers sur table
            }
            compteur.actionsFait(nbChoix);
            return 1;
        }
        else {
            return 0;
        }


    }
    /**
     *  Méthode qui permet à l'IA de poser elle même un ouvrier sur un batiment
     */
    public boolean poserOuvrierSurChantier(){
        int meilleurCarteOuvID;
        if(joueur.getMainOuv().size()>0) {
            for (int j = 0; j < joueur.getMainBat().size(); j++) {
                if (!joueur.getMainBat().get(j).isContruit()) {
                    meilleurCarteOuvID = idealOuvToChantier(joueur.getMainOuv());
                    joueur.attribuerOuvrierAChantier(joueur.getMainOuv().get(meilleurCarteOuvID), joueur.getMainBat().get(j));
                    compteur.actionsFait(1);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * trouve le meilleur ouvrier à placer sur un batiment
     * @return l'indice du meilleur ouvrier à placer sur le batiment
     * @param ListeOuv ArrayList des cartes ouvriers
     */
    public int idealOuvToChantier(ArrayList<CarteOuvriers> ListeOuv){
        int bois, pierre, tuile, savoir, bestID = 0;
        int res[] = new int[ListeOuv.size()];
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
            //System.out.println("le res du id "+i+" = "+res[i] + " le bestID = "+bestID + " max = "+max);
            if (res[i] >= max){
                max = res[i]; //max prends la valeur de res(i) si c'est le plus grand
                bestID = i;
            }
        }
        return bestID; //on retourne l'id
    }

    /**
     *  Méthode qui appel une suite de méthodes de l'IA pour qu'elle soit plus "intelligente"
     * @param carteOuvSurTable les cartes ouvriers disponibles sur le plateau
     * @param carteBatSurTable les cartes batiments disponibles sur le plateau
     * @return tableau avec le nb d'actions effectué et le nb d'ouvrier posée sur un chantier en construction
     */
    public int[] actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){
        //compteur.buyActions(1);
        int countActions = 0, nbOuvPosee = 0, nbEcus = 0, check;
        if (joueur.getBourse().getEcus() < 5){ // si le joueur ne possede pas assez d'ecus ppour effectuer des actions
            nbEcus += passeTour(3);
        }
        else if (joueur.getMainOuv().size() < 2) { //si le joueur possede moins de 2 cartes ouv

            if (choisitBatiment(1, carteBatSurTable) == 1){ //verifie que le joueur ne possede pas de carte batiment et en choisi un
                // cette condition "if" ^^ fait la verificatioin et l'attribution sur la même ligne
                countActions += 1;
                if (choisitOuvrier(2, carteOuvSurTable) == 1) { //on choisit donc deux carte ouvriers
                    countActions += 2;
                }
                else { // si on peut pas piocher carte ouv
                    if (poserOuvrierSurChantier()) {
                        nbEcus += passeTour(1); // on vend le tour restant
                        countActions += 1;
                        nbOuvPosee += 2;
                    }
                    else{
                        nbEcus += passeTour(2);
                    }
                }
            }
            else { // si le joueur possede deja un chantier en cours
                if (choisitOuvrier(3, carteOuvSurTable) == 1) {// on choisi 3 ouvriers à la place
                    countActions += 3;
                }
                else if (choisitOuvrier(2, carteOuvSurTable) == 1){ // on essaye de piocher 2 ouvrier
                    countActions += 2;
                    if (poserOuvrierSurChantier()){} // on essaye de poser un ouv sur un chantier
                    else{ nbEcus+= passeTour(1);} // sinon on vend l'actions restant
                }
                else if (choisitOuvrier(1, carteOuvSurTable) == 1){ // on essaye d'en piocher 1
                    countActions += 1;
                    if (poserOuvrierSurChantier()) { //on essaye de place un ouv sur un chantier
                        countActions += 1;
                        nbEcus += passeTour(1); // on vend le tour restant
                    }
                    else{nbEcus += passeTour(2);} // on vends les tour restants
                }

            }
        }
        else { // si le joueur a plus de 1 cartes ouv

            if (choisitBatiment(1, carteBatSurTable)==1) { // en choisi un seulement s'il en a pas un
                // cette condition "if" ^^ fait la verificatioin et l'attribution sur la même ligne
                countActions += 1;
                if (choisitOuvrier(1, carteOuvSurTable) == 1) { //on essaye de piocher un ouvrier
                    countActions += 1;
                    if (poserOuvrierSurChantier()) {
                        countActions += 1;
                        nbOuvPosee += 1;
                    }
                    else {nbEcus += passeTour(1);}
                }
                else { // si on peut pas piocher d'ouvrier
                    if (poserOuvrierSurChantier()){//on place un ouvrier sur un chantier
                        countActions += 1;
                        nbOuvPosee += 1;
                        if (poserOuvrierSurChantier()){ // on essaye de placer le deuxieme
                            countActions += 1;
                            nbOuvPosee += 1;
                        }
                        else {nbEcus += passeTour(1);} // sinon on vend l'action
                    }

                    else {nbEcus += passeTour(2);} // sinon on vends les actions

                }
            }
            else{ // si chantier en cours
                if (choisitOuvrier(1, carteOuvSurTable) == 1) { // on essaye de piocher un ouvrier
                    countActions += 1;
                    if (poserOuvrierSurChantier()){//on place un ouvrier sur un chantier
                        countActions += 1;
                        nbOuvPosee += 1;
                        if (poserOuvrierSurChantier()){ // on essaye de placer le deuxieme
                            countActions += 1;
                            nbOuvPosee += 1;
                        }
                        else {nbEcus += passeTour(1);} // sinon on vend l'action
                    }

                    else {nbEcus += passeTour(2);} // sinon on vends les actions
                }
                else{
                    if (poserOuvrierSurChantier()) { //on pose l'ouvrier sur le chantier
                        nbEcus += passeTour(2); // on vend les tours restants
                        countActions += 1;
                        nbOuvPosee += 1;
                    }
                    else{nbEcus += passeTour(3);} // on vends les tours restants
                }
            }
        }

        if (joueur.getBourse().getEcus() > 10 && carteOuvSurTable.size() > 0){
            // achete des actions s'il possede beaucoup d'ecus et il y des cartes ouv à piocher
            int nbAchetee = (joueur.getBourse().getEcus() / 10) % 2;
            ajouteTour(nbAchetee); // n'ajoute pas plus de deux actions à la fois
            nbEcus -= nbAchetee;
            countActions += nbAchetee;
            for (int i = 0; i < nbAchetee; i++){ // boucle sur le nb d'actions achetée
                if (choisitBatiment(1, carteBatSurTable)==1){}
                // choisi une carte batiment si le joueur en possede pas
                else if (joueur.getMainOuv().size() < 2){ // si le joueur possede moins de deux cartes ouv
                    choisitOuvrier(1, carteOuvSurTable);
                }
                else {
                    poserOuvrierSurChantier();
                    nbOuvPosee += 1;
                }
            }
        }
        //Display.displayOuvriersDuJoueur(getJoueur());
        for(int i=0;i<getJoueur().getMainOuv().size();i++){
            carteOuvSurTable.remove(getJoueur().getMainOuv().get(i)); //on enleve toutes les cartes selectionné
        }

        /*System.out.println(compteur.getNb());
        ajouteTour(1);
        System.out.println(compteur.getNb());
        passeTour(1);*/
        return new int[]{countActions, nbOuvPosee, nbEcus}; //return le nb d'actions fait et le nb d'ouvrier posée (pour faciliter les tests)
    }
    /**
     * verifie si le joueur possede assez de tours pour passer et ajoute les ecus
     * @param n nb de tours à passer
     * @return le nb d'ecus à ajouter
     */
    public int passeTour(int n){
        int ecus = 0;
        if (compteur.getNombreAction() >= n) { // verifie si le joueur possede le nombre d'actions requis pour les vendre
            for (int i = 1; i < n + 1; i++) { // on boucle sur le nb d'actions à vendre
                joueur.getBourse().addEcus(i);
                ecus += i;
            }
            compteur.sellActions(n);
        }
        return ecus;
    }

    /**
     * verifie si le joueur a les moyens d'acheter des tours et en achete
     * @param n nb de tours à ajouter
     * @return le nb d'ecus à supp
     */
    public int ajouteTour(int n){
        if (joueur.getBourse().getEcus() >= n * 5 + 5){ // verifie si le joueur possede assez d'ecus pour acheter des actions
            compteur.buyActions(n);
            joueur.getBourse().subEcus(n*5);
            return n*5;
        }
        return 0;
    }
}

