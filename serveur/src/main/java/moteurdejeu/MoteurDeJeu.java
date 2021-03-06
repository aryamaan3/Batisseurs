package moteurdejeu;

import IA.IA;
import IA.IADumb;
import IA.IASmart;
import commun.batiments.CarteMachine;
import commun.ouvriers.CarteOuvriers;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.DeckOuvriers;
import plateau.Plateau;

import java.util.*;

import static commun.display.Couleur.*;

/**
 *  c'est la classe du moteur de jeu, c'est dans cette classe qu'on va lancer les parties
 */
public class MoteurDeJeu {

    /**
     *  Méthode qui fait appel à toutes les méthodes nécessaires du projet pour créer et afficher une partie
     * @param joueurs le liste des joueurs
     * @param isDisplay true si on veut avec le display
     * @return le joueur gagnant
     */

    public Joueur partie(ArrayList<Joueur> joueurs, boolean isDisplay){
        Plateau plateau = new Plateau();
        Display display = new Display(isDisplay);
        int compteTour =1;
        int ptsGagnant = -1;
        int[] ancienneBourse = new int[4];
        int joueurGagnant = -1;
        boolean victoire = false;
        int nbJoueurs = joueurs.size();

        Compteur c1 = new Compteur();
        Compteur c2 = new Compteur();
        Compteur c3 = new Compteur();
        Compteur c4 = new Compteur();
        ArrayList<IA> ia = new ArrayList<>();
        ia.add(new IASmart(joueurs.get(0),c1));
        ia.add(new IASmart(joueurs.get(1),c2));
        ia.add(new IADumb(joueurs.get(2),c3));
        ia.add(new IADumb(joueurs.get(3),c4));
        setDisplayIA(isDisplay,ia);
        // Selection du premier joueur en fonction du totem : l'orde est défini par la position dans l'arrayList ia
        Random rand = new Random(); //instance of random class
        int totem = rand.nextInt(nbJoueurs);
        totem ++;
        display.displayString(ANSI_CYAN+"C'est le joueur "+ totem + " qui a gagné le totem."+ANSI_RESET);
        Collections.swap(ia, 0, totem-1);
        display.displayString(ANSI_CYAN+"Ordre de jeu :"+ANSI_RESET);
        for(int i = 0; i < nbJoueurs ; i ++){
            display.displayString(ANSI_CYAN+ (i+1)+" : " + "joueur " + ia.get(i).getJoueur().getId()+ANSI_RESET);
        }


        // On attribut automatiquement un apprenti par joueur
        // 6 apprentis dans le decks
        ArrayList<Integer> indiceApprentis = new ArrayList<>();
        // On boucle sur les indices du deck (qui a été shuffle)
        for(int i = 0; i < plateau.getDeckOuvrier().size() ; i++){
            if(plateau.getDeckOuvrier().get(i).getNom().equals("apprenti")){
                indiceApprentis.add(i);
            }
        }
        for(int i = 0; i < nbJoueurs ; i ++){
            // On prend à chaque fois le premier apprenti de la lite qui a été shuffle
            // Puis le deuxième joueur prendra le deuxième ...
            ia.get(i).getJoueur().ajouteOuvrier(plateau.getDeckOuvrier().get( indiceApprentis.get(i)) );
        }
        // On remove tous les apprentis qu'on a selectionné (les 4 premiers)
        plateau.getDeckOuvrier().remove(indiceApprentis.subList( 0, 4) );
        plateau.carteBatimentsSurTable();
        plateau.carteOuvriersSurTable();


        display.displayString("Debut du jeu...");

        while (true){ //loop pour chaque tour
            display.displayString("\n######################### "+ANSI_PURPLE + "Tour n°" + compteTour + ANSI_RESET + " #########################");
            for(int i=0;i<nbJoueurs;i++){
                display.displayString(ANSI_CYAN+"------------------ Joueur n°" + ia.get(i).getJoueur().getId() + "------------------\n"+ANSI_RESET);
                display.displayCarteDispo(plateau.getCartesOuvSurTable(),plateau.getCartesBatSurTable());
                display.displayActions(ia.get(i).getCompteur());
                ia.get(i).actionIA(plateau.getCartesOuvSurTable(),plateau.getCartesBatSurTable()); // effectue les actions et l'affichage

                display.displayChantierDuJoueur(ia.get(i).getJoueur());
                display.displayOuvriersDuJoueur(ia.get(i).getJoueur());
                display.displayEtatChantiersDuJoueur(ia.get(i).getJoueur());
                if(isBuild(ia.get(i))){
                    for(int j=0 ; j < ia.get(i).getJoueur().getMainBat().size() ; j++){
                        if(ia.get(i).getJoueur().getMainBat().get(j).isBuilt()){
                            display.displayString("Le joueur "+ ia.get(i).getJoueur().getId()
                                    +" a fini le batiment "+ia.get(i).getJoueur().getMainBat().get(j).getNom()
                                    +", il gagne donc "+ANSI_GREEN+ia.get(i).getJoueur().getMainBat().get(j).getPoints()+" point(s)"+ANSI_RESET+" et "+ANSI_YELLOW+ia.get(i).getJoueur().getMainBat().get(j).getEcu()+" écu(s)."+ANSI_RESET);
                        }
                    }
                }

                ia.get(i).getJoueur().trierBuiltBat();
                display.displayChantierFini(ia.get(i).getJoueur());
                ia.get(i).getCompteur().reset();

                display.displayEcus(ia.get(i).getJoueur().getId(),ia.get(i).getJoueur().getBourse().getEcus());
                plateau.fillCartesBatiments();
                plateau.fillCartesOuvriers();
            }
            display.displayString("Fin du tour : "+compteTour+"\n");//On affiche le numéro du tour à la fin de ce dernier
            compteTour++;//On incrémente compteTour

            // Condition de victoire en fonction du nombre de point (+ de 5)
            for (Joueur joueur : joueurs) { //itere sur le nb de joueur
                if (joueur.getPoints() > 16) {
                    victoire = true;
                    break;
                }
            }

            for (Joueur joueur : joueurs) { //itere sur le nb de joueurs
                // maintenant qu'on sait que la partie est finie, on convertit les écus en points.
                if (victoire && joueur.getBourse().getEcus() >= 10) {
                    // on stocke les anciennes bourses pour pouvoir départager les joueurs en cas d'égalité. getId()-1 car l'id des joueurs commence à 1.
                    ancienneBourse[joueur.getId()-1] = joueur.getBourse().getEcus();
                    joueur.conversionEcuPoint();
                    int pointsgagnes = ancienneBourse[joueur.getId()-1] - joueur.getBourse().getEcus();
                    display.displayConversionEcuPoint(joueur.getId(),pointsgagnes);

                }
                display.displayPoint(joueur);
                display.displayBourse(joueur);
                display.displayChantierFini(joueur);
            }

            for (Joueur joueur : joueurs) { //itere sur le nb de joueur
                //on stocke l'id du joueur ayant le plus de points.
                if (joueur.getPoints() > 16 && joueur.getPoints() > ptsGagnant) {
                    ptsGagnant = joueur.getPoints();
                    joueurGagnant = joueur.getId();
                }
            }

            for(int i = 0; i < 3; i++){
                if(joueurs.get(i).getPoints() == joueurs.get(i+1).getPoints() && joueurs.get(i).getPoints() > 16){
                    if(ancienneBourse[i] > ancienneBourse[i+1]){
                        // car le joueur i a moins de points de batiment que le joueur i+1
                        joueurGagnant = joueurs.get(i+1).getId();
                    }
                    else{
                        joueurGagnant = joueurs.get(i).getId();
                    }
                }
            }

            if(ptsGagnant > 16){
                display.displayGagnant(joueurGagnant);
                display.displayClassement(joueurs);
                return joueurs.get((joueurGagnant - 1));
            }

            if (compteTour > 30){
                display.displayString("not done");
                return null;} //Pour eviter des millions de tours ... a retirer à l'avenir
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

    /**
     * Méthode permettant de choisir ou non d'afficher les actions des IA
     * @param display true si on veut afficher les actions, false sinon
     * @param iaList ArrayList contenant les différents joueurs
     */
    public void setDisplayIA(boolean display, ArrayList<IA> iaList){
        for (IA ia : iaList) { //itere sur le size de iaList
            ia.setDisplay(display);
        }
    }


    /**
     * Cette méthode permet de lancer le jeu avec des arguments tels que le nombre de partie ou ou l'affichage ou non des actions des joueurs
     * @param args les arguments que prend la méthode
     */
    public static void main(String[] args){
        //int nbPartie =Integer.parseInt(args[0]);
        int nbPartie = 500;
        ArrayList<Joueur> joueursGagnants = new ArrayList<>();
        for (int i = 0; i < nbPartie; i++) {
            MoteurDeJeu m1 = new MoteurDeJeu();
            Joueur j1,j2,j3,j4;
            j1 = new Joueur(1);
            j2 = new Joueur(2);
            j3 = new Joueur(3);
            j4 = new Joueur(4);
            ArrayList<Joueur> joueurs = new ArrayList<>();
            joueurs.add(j1);
            joueurs.add(j2);
            joueurs.add(j3);
            joueurs.add(j4);
            //joueursGagnants.add(m1.partie(joueurs, Boolean.parseBoolean(args[1])));
            joueursGagnants.add(m1.partie(joueurs, false));
            //true pour mode display
            //false pour mode sans display
        }
        Display.plusieursParties(joueursGagnants);
    }
}
