package moteurdejeu;

import IA.IA;
import IA.IADumb;
import IA.IASmart;

import commun.batiments.CarteChantier;
import commun.batiments.CarteMachine;
import commun.batiments.DeckBatiments;
import commun.ouvriers.CarteOuvriers;
import commun.ouvriers.DeckOuvriers;
import commun.display.Display;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.*;

import static commun.display.Couleur.*;

/**
 *  c'est la classe du moteur de jeu, c'est dans cette classe qu'on va lancer les parties
 */
public class MoteurDeJeu {

    /**
     *  Méthode qui fait appel à toutes les méthodes nécessaires du projet pour créer et afficher une partie
     * @param joueurs le liste des joueurs
     * @return le joueur gagnant
     */

    public Joueur partie(ArrayList<Joueur> joueurs, boolean isDisplay, int choixDeck){

        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck(choixDeck);
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck(choixDeck);
        Display display = new Display(isDisplay);
        int compteTour =1;
        int ptsGagnant = -1;
        //boolean egalite = false;
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
        display.displayString(ANSI_CYAN+"C'est le joueur "+ totem + " qui commence."+ANSI_RESET);
        Collections.swap(ia, 0, totem-1);
        display.displayString(ANSI_CYAN+"Ordre de jeu :"+ANSI_RESET);
        for(int i = 0; i < nbJoueurs ; i ++){
            display.displayString(ANSI_CYAN+ (i+1)+" : " + "joueur " + ia.get(i).getJoueur().getId()+ANSI_RESET);
        }

        Collections.shuffle(deckBat);
        Collections.shuffle(deckOuv);

        // On attribut automatiquement un apprenti par joueur
        // 6 apprentis dans le decks
        ArrayList<Integer> indiceApprentis = new ArrayList<>();
        // On boucle sur les indices du deck (qui a été shuffle)
        for(int i = 0; i < deckOuv.size() ; i++){
            if(deckOuv.get(i).getNom().equals("apprenti")){
                indiceApprentis.add(i);
            }
        }
        for(int i = 0; i < nbJoueurs ; i ++){
            // On prend à chaque fois le premier apprenti de la lite qui a été shuffle
            // Puis le deuxième joueur prendra le deuxième ...
            ia.get(i).getJoueur().ajouteOuvrier(deckOuv.get( indiceApprentis.get(i)) );
        }
        // On remove tous les apprentis qu'on a selectionné (les 4 premiers)
        deckOuv.remove( indiceApprentis.subList( 0, 4) );


        ArrayList<CarteOuvriers> carteOuvSurTable = carteOuvriersSurTable(deckOuv);
        ArrayList<CarteChantier> carteBatSurTable = carteBatimentsSurTable(deckBat);
        display.displayString("Il y a " + nbJoueurs + " joueur(s)");
        display.displayString("Debut du jeu...");

        //whileTour:
        while (true){ //loop pour chaque tour
            display.displayString("\n######################### "+ANSI_PURPLE + "Tour n°" + compteTour + ANSI_RESET + " #########################");
            for(int i=0;i<nbJoueurs;i++){
                display.displayString(ANSI_CYAN+"------------------ Joueur n°" + ia.get(i).getJoueur().getId() + "------------------\n"+ANSI_RESET);
                display.displayCarteDispo(carteOuvSurTable, carteBatSurTable);
                display.displayActions(ia.get(i).getCompteur());
                ia.get(i).actionIA(carteOuvSurTable,carteBatSurTable); // effectue les actions et l'affichage





                display.displayChantierDuJoueur(ia.get(i).getJoueur());
                display.displayOuvriersDuJoueur(ia.get(i).getJoueur());
                display.displayEtatChantiersDuJoueur(ia.get(i).getJoueur());
                if(isBuild(ia.get(i))){
                    for(int j=0 ; j < ia.get(i).getJoueur().getMainBat().size() ; j++){
                        if(ia.get(i).getJoueur().getMainBat().get(j).isBuilt()){
                            display.displayString("Le joueur "+ ia.get(i).getJoueur().getId()
                                    +" a fini le batiment "+ia.get(i).getJoueur().getMainBat().get(j).getNom()
                                    +", il gagne donc "+ANSI_GREEN+ia.get(i).getJoueur().getMainBat().get(j).getPoints()+" point(s)"+" et "+ia.get(i).getJoueur().getMainBat().get(j).getEcu()+" écu(s)."+ANSI_RESET);
                        }
                    }
                }
                //ia.get(i).getJoueur().getBourse().addEcus(2);
                ia.get(i).getJoueur().trierBuiltBat();
                display.displayChantierFini(ia.get(i).getJoueur());
                ia.get(i).getCompteur().reset();

                display.displayEcus(ia.get(i).getJoueur().getId(),ia.get(i).getJoueur().getBourse().getEcus());
                fillCartesBatiments(deckBat,carteBatSurTable);
                fillCartesOuvriers(deckOuv,carteOuvSurTable);
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
                    int ancienneBourse = joueur.getBourse().getEcus();
                    joueur.conversionEcuPoint();
                    int pointsgagnes = ancienneBourse - joueur.getBourse().getEcus();
                    display.displayString("Le joueur " + joueur.getId() + " utilise " + (pointsgagnes) + " écus pour gagner " + (pointsgagnes / 10) + " points");
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
            if (deck.size() > nbCartes + 1) {
                for (int i = 0; i < nbCartes; i++) {
                    carteSurTable.add(deck.get(i));
                    deck.remove(deck.get(i));
                }
            }
            else {
                for (int i = 0; i < deck.size(); i++){
                    carteSurTable.add(deck.get(i));
                    deck.remove(deck.get(i));
                }
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
                ia.getJoueur().getStats().addRevenusBat(ia.getJoueur().getMainBat().get(i).getEcu());

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

    public void setDisplayIA(boolean display, ArrayList<IA> iaList){
        for (IA ia : iaList) { //itere sur le size de iaList
            ia.setDisplay(display);
        }
    }
    /**
     * Méthode qui permet de rentrer le nombre de parties que l'utilisateur veut lancer
     * @return un entier qui représente le nombre de parties
     */
    public static int nbPartie(){
        System.out.println("combien de partie voulez vous jouer ? : ");
        Scanner nbPartie = new Scanner(System.in);
        return nbPartie.nextInt();
    }

    /**
     * demande le choix de l'utilisateur concernant le deck
     * @return 1 pour deck moyen age, 2 pour Antiquités
     */
    public static int whichDeck(){
        do {
            System.out.println("Vous voulez jouer quel jeu ?");
            System.out.println("Tapez 1 pour Les Batisseurs : Moyen Age");
            System.out.println("Tapez 2 pour Les Batisseurs : Antiquités");
            Scanner deck = new Scanner(System.in);
            int val = deck.nextInt();
            if (val == 1 || val == 2) {
                return val;
            }
            else {
                System.out.println("\nOn n'a seulement deux jeux à vous proposer pour l'instant\n");
            }
        }while(true);
    }

    public static void main(String[] args){
        //int nbPartie =Integer.parseInt(args[0]);
        int nbPartie = 1; //afin de lancer avec main à enlever pour lancer avec maven
        int whichDeck = whichDeck(); //l'utilisateur choisi le deck
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
            //m1.partie(joueurs,Boolean.parseBoolean(args[1]));
            joueursGagnants.add(m1.partie(joueurs, true, whichDeck)); // à enlever pour lancer avec maven
            //true pour mode display
            //false pour mode sans display
        }
        if (!Display.afficher){
            Display.plusieursParties(joueursGagnants);
        }
    }
}
