package moteurdejeu;

import IA.IA;

import commun.batiments.CarteChantier;
import commun.batiments.CarteMachine;
import commun.batiments.DeckBatiments;
import commun.ouvriers.CarteOuvriers;
import commun.ouvriers.DeckOuvriers;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import java.util.ArrayList;
import java.util.Collections;
import static commun.display.Couleur.*;

/**
 *  c'est la classe du moteur de jeu, c'est dans cette classe qu'on va lancer les parties
 */
public class MoteurDeJeu {

    /**
     *  Méthode qui fait appel à toutes les méthodes nécessaires du projet pour créer et afficher une partie
     * @param nbJoueurs le nombre de joueur dans la partie
     */

    public void partie(int nbJoueurs){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<Joueur> joueurs = new ArrayList<>();
        int compteTour =1;
        Joueur j1,j2,j3,j4;
        j1 = new Joueur(1);
        j2 = new Joueur(2);
        j3 = new Joueur(3);
        j4 = new Joueur(4);
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        joueurs.add(j4);
        Compteur c1 = new Compteur(j1.getId());
        Compteur c2 = new Compteur(j2.getId());
        Compteur c3 = new Compteur(j3.getId());
        Compteur c4 = new Compteur(j4.getId());
        IA ia1 = new IA(j1,c1);
        IA ia2 = new IA(j2,c2);
        IA ia3 = new IA(j3,c3);
        IA ia4 = new IA(j4,c4);
        ArrayList<IA> ia = new ArrayList<>();
        ia.add(ia1);
        ia.add(ia2);
        ia.add(ia3);
        ia.add(ia4);
        Collections.shuffle(deckBat);
        Collections.shuffle(deckOuv);
        ArrayList<CarteOuvriers> carteOuvSurTable = carteOuvriersSurTable(deckOuv);
        ArrayList<CarteChantier> carteBatSurTable = carteBatimentsSurTable(deckBat);
        System.out.println("Il y a "+nbJoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        whileTour:
        while (true){ //loop pour chaque tour
            System.out.println("######################### "+ANSI_PURPLE + "Tour n°" + compteTour + ANSI_RESET + " #########################");
            for(int i=0;i<nbJoueurs;i++){
                if(i==0){
                    System.out.println("------------------ Joueur n°" + (i + 1) + "------------------");
                    Display.displayCarteDispo(carteOuvSurTable, carteBatSurTable);
                    Display.displayActions(ia.get(i).getCompteur());
                    ia.get(i).actionIA(carteOuvSurTable,carteBatSurTable);
                    if ( ia.get(i).getCompteur().getNombreAction() > 0){
                        ia.get(i).passeTour(ia.get(i).getCompteur().getNombreAction());
                    }
                    Display.displayActions(ia.get(i).getCompteur());
                    Display.displayOuvriersDuJoueur(joueurs.get(i));
                    Display.displayChantierDuJoueur(joueurs.get(i));
                    if(isBuild(ia.get(i))){
                        for(int j=0 ; j < joueurs.get(i).getMainBat().size() ; j++){
                            if(joueurs.get(i).getMainBat().get(j).isBuilt()){
                                System.out.println("Le joueur "+ (i+1)
                                        +" a fini le batiment "+joueurs.get(i).getMainBat().get(j).getNom()
                                        +", il gagne donc "+ANSI_GREEN+joueurs.get(i).getMainBat().get(j).getPoints()+" point(s)"+ANSI_RESET);
                            }
                        }
                    }
                    Display.displayEtatChantiersDuJoueur(joueurs.get(i));
                    Display.displayChantierFini(joueurs.get(i));
                    ia.get(i).getCompteur().reset();
                    joueurs.get(i).trierBuiltBat();
                    fillCartesBatiments(deckBat,carteBatSurTable);
                    fillCartesOuvriers(deckOuv,carteOuvSurTable);

                }
                if(i==1){
                    System.out.println("------------------ Joueur n°" + (i +1) + "------------------");
                    Display.displayCarteDispo(carteOuvSurTable, carteBatSurTable);
                    Display.displayActions(c2);
                    ia.get(i).actionIA(carteOuvSurTable,carteBatSurTable);
                    if ( c2.getNombreAction() > 0){
                        ia.get(i).passeTour(c2.getNombreAction());
                    }
                    Display.displayActions(c2);
                    Display.displayOuvriersDuJoueur(j2);
                    Display.displayChantierDuJoueur(j2);
                    if(isBuild(ia.get(i))){
                        for(int j=0;j<j2.getMainBat().size();j++){
                            if(j2.getMainBat().get(j).isBuilt()){
                                System.out.println("Le joueur "+ (i+1)
                                        +" a fini le batiment "+j2.getMainBat().get(j).getNom()
                                        +", il gagne donc "+ANSI_GREEN+j2.getMainBat().get(j).getPoints()+" point(s)"+ANSI_RESET);
                            }
                        }
                    }
                    j2.trierBuiltBat();
                    Display.displayEtatChantiersDuJoueur(j2);
                    Display.displayChantierFini(j2);
                    c2.reset();
                    fillCartesBatiments(deckBat,carteBatSurTable);
                    fillCartesOuvriers(deckOuv,carteOuvSurTable);

                }
            }
            System.out.println("Fin du tour : "+compteTour+"");//On affiche le numéro du tour à la fin de ce dernier
            compteTour++;//On incrémente compteTour

            // Condition de victoire en fonction du nombre de point (+ de 5)
            for(int j = 0; j<nbJoueurs; j++){
                Display.displayPoint(joueurs.get(j));
                Display.displayBourse(joueurs.get(j));
                Display.displayChantierFini(joueurs.get(j));
                if(joueurs.get(j).getPoints() > 10){
                    System.out.println(ANSI_CYAN_BACKGROUND+"Le Joueur "+(joueurs.get(j).getId())
                            +" a gagné ! Il a "+joueurs.get(j).getPoints()+ " points."+ANSI_RESET);
                    break whileTour;
                }
            }
            if (compteTour > 20){
                break;} //Pour eviter des millions de tours ... a retirer à l'avenir
        }


    }

    /**
     *  Méthode qui sélectionne les 5 premières cartes du deck ouvrier pour les poser sur le plateau
     * @param deck le deck ouvrier principal
     * @return une ArrayList contenant 5 cartes ouvrier
     */
    public ArrayList<CarteOuvriers> carteOuvriersSurTable(ArrayList<CarteOuvriers> deck){
        ArrayList<CarteOuvriers> cartes = new ArrayList<>();
        for(int i=0;i<5;i++){
            cartes.add(deck.get(i));
            deck.remove(deck.get(i));

        }
        return cartes;
    }
    /**
     *  Méthode qui sélectionne les 5 premières cartes du deck batiment pour les poser sur le plateau
     * @param deck le deck batiment principal
     * @return une ArrayList contenant 5 cartes batiment
     */
    public ArrayList<CarteChantier> carteBatimentsSurTable(ArrayList<CarteChantier> deck) {
        ArrayList<CarteChantier> cartes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cartes.add(deck.get(i));
            deck.remove(deck.get(i));
        }
        return cartes;
    }
    /**
     *  Méthode qui vérifie le nombre de cartes ouvrier disponibles sur le plateau, et qui pioche le nombre de cartes nécessaire
     *  dans le deck principal ouvrier pour toujours avoir 5 cartes ouvrier sur le plateau
     * @param deck le deck ouvrier principal
     * @param carteSurTable les cartes ouvrier sur le plateau
     */
    public void fillCartesOuvriers(ArrayList<CarteOuvriers> deck,ArrayList<CarteOuvriers> carteSurTable){
        int nbCartes;
        if(carteSurTable.size()<5){
            nbCartes = 5 - carteSurTable.size();
            for(int i=0;i<nbCartes;i++){
                carteSurTable.add(deck.get(i));
                deck.remove(deck.get(i));
            }
        }
    }
    /**
     *  Méthode qui vérifie le nombre de cartes batiment disponibles sur le plateau, et qui pioche le nombre de cartes nécessaire
     *  dans le deck principal batiment pour toujours avoir 5 cartes ouvrier sur le plateau
     * @param deck le deck batiment principal
     * @param carteSurTable les cartes batiment sur le plateau
     */
    public void fillCartesBatiments(ArrayList<CarteChantier> deck, ArrayList<CarteChantier> carteSurTable){
        int nbCartes;
        if(carteSurTable.size()<5){
            nbCartes = 5 - carteSurTable.size();
            for(int i=0;i<nbCartes;i++){
                carteSurTable.add(deck.get(i));
                deck.remove(deck.get(i));
            }
        }
    }

    /**
     *  Méthode qui parcourt les cartes batiments dans la main de l'IA pour vérifier si l'une de ses cartes est construite
     *  Si on trouve un batiment construit, on ajoute les points et les écus à l'IA en question
     * @param ia l'IA dont on veut vérifier la main
     * @return true si la carte batiment est terminée, false sinon
     */
    public boolean isBuild(IA ia){
        boolean isBuild = false;
        for(int i=0;i<ia.getJoueur().getMainBat().size();i++){
            if(ia.getJoueur().getMainBat().get(i).isBuilt()) {
                isBuild = true;
                ia.getJoueur().getMainBat().get(i).setConstruit(true);
                ia.getJoueur().addPoints(ia.getJoueur().getMainBat().get(i).getPoints());
                ia.getJoueur().getBourse().addEcus(ia.getJoueur().getMainBat().get(i).getEcu());

                // On vérifie si le chantier qu'on vient de finir est une machine
                if (ia.getJoueur().getMainBat().get(i).isMachine()){
                    // Pour simplifier le code, on place la carte dans carteMachine
                    // Je transforme ma CarteChantier en CarteMachine
                    CarteMachine carteMachine = (CarteMachine) ia.getJoueur().getMainBat().get(i);
                    // Il faut transformer ce chantier en ouvrier
                    CarteOuvriers newMachineAsOuvrier = carteMachine.transformationEnOuvrier();

                    //Il faut ajouter cet ouvrier au deckOuvrier du joueur
                    ia.getJoueur().ajouteOuvrier(newMachineAsOuvrier);
                }
            }
        }
        return isBuild;
    }

    public static void main(String[] args){
        MoteurDeJeu m1 = new MoteurDeJeu();
        int nbJoueurs = 2;
        m1.partie(nbJoueurs);
    }


}
