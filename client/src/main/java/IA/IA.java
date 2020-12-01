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
     */
    public void choisitOuvrier(int nbChoix,ArrayList<CarteOuvriers> cartesOuvSurTable){
        if (joueur.getMainOuv().size() < 5 && cartesOuvSurTable.size() > 0){
            for(int i=0;i<nbChoix;i++){ // on utilise la méthode idealOuvToChantier pour choisir la carte ouvrier la plus adapté selon les batiments que l'on possède
                joueur.ajouteOuvrier(cartesOuvSurTable.get(idealOuvToChantier(cartesOuvSurTable)));
                cartesOuvSurTable.remove(idealOuvToChantier(cartesOuvSurTable)); // on enlève ensuite la carte choisie des cartes ouvriers sur table
            }
            compteur.actionsFait(nbChoix);
        }
        else { passeTour(1);}


    }
    /**
     *  Méthode qui permet à l'IA de poser elle même un ouvrier sur un batiment
     */
    public void poserOuvrierSurChantier(){
        int meilleurCarteOuvID;
        if(joueur.getMainOuv().size()>0) {
            for (int i = 0; i < 1; i++) {   //On peut poser qu'un ouvrier par tour pour l'instant
                for (int j = 0; j < joueur.getMainBat().size(); j++) {
                    if (!joueur.getMainBat().get(j).isContruit()) {
                        meilleurCarteOuvID = idealOuvToChantier(joueur.getMainOuv());
                        joueur.attribuerOuvrierAChantier(joueur.getMainOuv().get(meilleurCarteOuvID), joueur.getMainBat().get(j));
                        compteur.actionsFait(1);
                        break;
                    }
                }
            }
        } else{
              passeTour(1);
        }
    }

    /**
     * trouve le meilleur ouvrier à placer sur un batiment
     * @return l'indice du meilleur ouvrier à placer sur le batiment
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
     */
    public void actionIA(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){
        //compteur.buyActions(1);
        if (joueur.getMainOuv().size() < 2) {
            if (choisitBatiment(1, carteBatSurTable) == 1){ //verifie que le joueur ne possedaient pas de carte batiment et en choisi un
                choisitOuvrier(2, carteOuvSurTable); //on choisit donc deux carte ouvriers
            }
            else {
                choisitOuvrier(3, carteOuvSurTable);
            }
        }
        else {
            choisitBatiment(1, carteBatSurTable); // si le joueur possede plus de 2 cartes ouv
            choisitOuvrier(1, carteOuvSurTable);
            poserOuvrierSurChantier();
        }
        Display.displayOuvriersDuJoueur(getJoueur());
        for(int i=0;i<getJoueur().getMainOuv().size();i++){
            carteOuvSurTable.remove(getJoueur().getMainOuv().get(i)); //on enleve toutes les cartes selectionn"
        }

        /*System.out.println(compteur.getNb());
        ajouteTour(1);
        System.out.println(compteur.getNb());
        passeTour(1);*/
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

