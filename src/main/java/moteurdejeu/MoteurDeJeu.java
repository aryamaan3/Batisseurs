package moteurdejeu;

import cartes.ouvrier.CarteOuvriers;
import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.DeckOuvriers;
import joueurs.IA;
import joueurs.Joueurs;
import joueurs.Bourse;
import java.util.ArrayList;

import static cartes.batiments.CarteBatiments.getCarteBatById;
import static cartes.batiments.CarteBatiments.obtenirDeckJoueur;
import static cartes.ouvrier.CarteOuvriers.getCarteOuvById;
import static display.Display.*;
import static display.Couleur.*;
import joueurs.IA.*;

/**
 * La classe MoteurDeJeu nous permet le déroulement du jeu
 */

public class MoteurDeJeu{ //Controle le deroulement du jeu
    //Déclaration du nombre maximum de joueurs
    Joueurs j1,j2,j3,j4;
    public static ArrayList<Joueurs> listJoueurs = new ArrayList<>();
    public static int nombreDeJoueurActifs = 0;

    // Création des joueurs
    public void creationDesJoueurs(int nombreDeJoueur){
        // Corriger en faisant une boucle for en focntion du nb de joueur désiré
        this.nombreDeJoueurActifs = nombreDeJoueur;
        j1 = new Joueurs(0);
        j2 = new Joueurs(1);
        j3 = new Joueurs(2);
        j4 = new Joueurs(3);
        listJoueurs.add(j1);
        listJoueurs.add(j2);
        listJoueurs.add(j3);
        listJoueurs.add(j4);
    }

    // Deck de carte : la première carte du joueur 0 sera à l'indice [0][0]
    // Contient donc les cartes ouvrier de TOUS les joueurs
    private  ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();  //Contiendra des objects "cartes" que possède les joueur
    private  ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();    // [2] Car on n'a pas plus de carte à donner pour l'instant


    /**
     * Choix de l'ouvrier par le joueur
     * @param id id du joueur
     * @param ouvrier Ouvrier qui va etre assigner
     */
    public static void choisirOuvrier(int id, CarteOuvriers ouvrier){
        ouvrier.AffectationOuvrier(id);
    }

    /**
     * Permet à un joueur de choisir une carteBatiment d'assigner le champs "idJoueur" de carteBatiment (qui est initialisé à -1 au début)
     * @param id id du joueur
     * @param Batiment Batiment qui va etre assigner
     */
    public static void choisirChantier(int id, CarteBatiments Batiment){
        // [13] correspond à l'indice du champ idJoueur de la carteBatiment
        // [0] correspond à la première carte (n°0) qui devrait aussi etre la carteBatiment dont l'id est 0
        Batiment.AffectationChantier(id);
    }

    /**
     * Permet de placer un ouvrier sur un chantier
     * @param batiment Batiment qui va etre assigner
     * @param ouvrier Ouvrier qui va etre assigner
     */
    public static void placerOuvrierSurChantier(CarteBatiments batiment, CarteOuvriers ouvrier){
        if(ouvrier.getAssign() == -1) { // Si l'ouvrier n'est pas déjà affecté, on peut l'affecter !
            ouvrier.AffectationOuvrierAChantier(batiment.getId());
            batiment.AffectationOuvrierAChantier(ouvrier.getId());
        }
        else{System.out.println("Cet ouvrier est déjà occupé sur le chantier n°"+ ouvrier.getAssign());}
    }

    /**
     * Méthode permettant de le bon fonctionnment du jeux
     */
    public void deroulementJeux(){
        //int nbjoueurs = joueurs.length; //pour l'instant seulement 2 joueurs
        int compteTour = 1; //Pour compter le nombre de tour au fil de la
        ArrayList<Bourse> bourse = new ArrayList<>();
        //On prends seulement 5 cartes sur DeckBatiment et du DeckOuvrier pour les poser au milieu du plateau

        for(int acc = 0; acc < nombreDeJoueurActifs; acc++){
            bourse.add(new Bourse(5,1,listJoueurs.get(acc).getId()));
        }
        ArrayList<CarteBatiments> CarteBatimentsSurTable = CarteBatiments.carteSurTable(DeckBatiment);
        ArrayList<CarteOuvriers> CarteOuvriersSurTable = CarteOuvriers.carteSurTable(DeckOuvrier);



        System.out.println("Il y a "+nombreDeJoueurActifs+" joueur(s)");
        System.out.println("Debut du jeu...");

        // On créer un objet IA
        IA IAduJoueur1 = new IA(j1, DeckOuvrier, DeckBatiment);
        IA IAduJoueur2 = new IA(j2, DeckOuvrier, DeckBatiment);

        a:
        while (true){ //loop pour chaque tour
            System.out.println("######################### "+ANSI_PURPLE + "Tour n°" + compteTour + ANSI_RESET + " #########################");
            displayCarteDispo(CarteOuvriersSurTable, CarteBatimentsSurTable);
            for (int i = 0; i < nombreDeJoueurActifs; i++) { //actions de chaque joueur
                if (i == 0) { //actions du joueur 1
                    System.out.println("------------------ Joueur n°" + (i + 1) + "------------------");
                    IAduJoueur1.ActionsIA(i,bourse.get(0));
                    /* A supprimer si display marche bien
                    System.out.println("Le joueur " + (i +1) + " a selectionné un ouvrier " + CarteOuvriersSurTable.get(3).getName() + " et un chantier " + CarteBatimentsSurTable.get(1).getName());
                    System.out.println("Sur le chantier " + CarteBatimentsSurTable.get(1).getName() + " on a l'ouvrier " + CarteBatimentsSurTable.get(1).getIdOuvrier().get(0));
                    System.out.println("L'ouvrier " + CarteOuvriersSurTable.get(3).getName() + " travail sur " + CarteOuvriersSurTable.get(3).getChantier());
                    */
                    displayOuvriersDuJoueur(i,DeckOuvrier);
                    displayChantierDuJoueur(i,DeckBatiment);

                    //ArrayList<Integer> b = CarteBatimentsSurTable.get(1).getIdOuvrier();
                    CarteBatimentsSurTable.get(0).sumRessources();
                    // Il faudra peut etre faire le sumRessources dans le display ?
                    displayEtatChantiersDuJoueur(i,DeckBatiment);
                }
                if (i == 1) { //actions du joueur 2
                    System.out.println("------------------ Joueur n°" + (i +1) + "------------------");
                    IAduJoueur2.ActionsIA(i,bourse.get(1));
                    /*System.out.println("Le joueur " + (i + 1) + " a selectionné un ouvrier " + CarteOuvriersSurTable.get(4).getName() + " et un chantier " + CarteBatimentsSurTable.get(4).getName());
                    System.out.println("Sur le chantier " + CarteBatimentsSurTable.get(4).getName() + " on a l'ouvrier " + CarteBatimentsSurTable.get(4).getIdOuvrier().get(0));
                    System.out.println("L'ouvrier " + CarteOuvriersSurTable.get(4).getName() + " travail sur " + CarteOuvriersSurTable.get(4).getChantier());
                     */
                    displayOuvriersDuJoueur(i,DeckOuvrier);
                    displayChantierDuJoueur(i,DeckBatiment);

                    CarteBatimentsSurTable.get(1).sumRessources();
                    displayEtatChantiersDuJoueur(i,DeckBatiment);

                }

                if (i == 3) { //actions joueur 3
                    System.out.println("------------------ Joueur n°" + (i) + "------------------");
                    System.out.println("Il n'y a pas de 3ème joueur\n");
                }

                if (i == 4) { // actions joueur 4
                    System.out.println("------------------ Joueur n°" + (i) + "------------------");
                    System.out.println("Il n'y a pas de 4ème joueur\n");
                }
            }

            ArrayList<Integer> enConstruction = new ArrayList<Integer>();
            enConstruction = obtenirDeckJoueur(0, DeckBatiment);
            for (int k = 0; k < obtenirDeckJoueur(1, DeckBatiment).size(); k++) {
                enConstruction.add(obtenirDeckJoueur(1, DeckBatiment).get(k));
            }
            b:
            for (int j = 0; j < enConstruction.size(); j++) {
                if (getCarteBatById(enConstruction.get(j), DeckBatiment).isBuilt()) {
                    System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Le joueur "+ (getCarteBatById(enConstruction.get(j), DeckBatiment).getIdJoueur()+1)+ " a fini un batiment, il a donc gagné" + ANSI_RESET);
                    System.out.println("#########################--FIN DE LA PARTIE--#########################");
                    break a;
                }
            }
            System.out.println("Fin du tour : "+compteTour+"");//On affiche le numéro du tour à la fin de ce dernier
            compteTour++;//On incrémente compteTour

            if (compteTour > 20){break;} //Pour eviter des millions de tours ... a retirer à l'avenir
            }

    }

    public static void main(String[] args) {

        MoteurDeJeu m1 = new MoteurDeJeu();
        m1.creationDesJoueurs(4);
        m1.deroulementJeux();
    }
}

