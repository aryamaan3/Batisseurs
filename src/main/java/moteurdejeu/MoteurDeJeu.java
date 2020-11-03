package moteurdejeu;

import cartes.cartesouvrier.CarteOuvriers;
import cartes.cartesbatiments.CarteBatiments;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import joueurs.Joueurs;
import bourse.Bourse;

public class MoteurDeJeu { //Controle le deroulement du jeu

    // Deck de carte : la première carte du joueur 0 sera à l'indice [0][0]
    // Contient donc les cartes ouvrier de TOUS les joueurs
    public static CarteOuvriers[] DeckOuvrier = new DeckOuvriers().getDeck();  //Contiendra des objects "cartes" que possède les joueur
    public static CarteBatiments[] DeckBatiment = new DeckBatiments().getDeck();    // [2] Car on n'a pas plus de carte à donner pour l'instant

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
     * @param carteBatiment Batiment qui va etre assigner
     */
    public static void choisirChantier(int id, CarteBatiments carteBatiment){
        // [13] correspond à l'indice du champ idJoueur de la carteBatiment
        // [0] correspond à la première carte (n°0) qui devrait aussi etre la carteBatiment dont l'id est 0
        carteBatiment.AffectationChantier(id);
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
        int nbjoueurs = 2; //pour l'instant seulement 2 joueurs
        int compteTour = 1; //Pour compter le nombre de tour au fil de la partie
        //On prends seulement 5 cartes sur DeckBatiment et du DeckOuvrier pour les poser au milieu du plateau
        CarteBatiments[] CarteBatimentsSurTable = CarteBatiments.carteSurTable(DeckBatiment);
        CarteOuvriers[] CarteOuvriersSurTable = CarteOuvriers.carteSurTable(DeckOuvrier);

        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        choisirOuvrier(0, CarteOuvriersSurTable[3]); //joueur0 choisit un ouvrier
        choisirOuvrier(0, CarteOuvriersSurTable[6]); //joueur0 choisit un ouvrier
        choisirChantier(0,  CarteBatimentsSurTable[2]); //joueur0 choisit un chantier
        placerOuvrierSurChantier(CarteBatimentsSurTable[2], CarteOuvriersSurTable[3]);
        placerOuvrierSurChantier(CarteBatimentsSurTable[2], CarteOuvriersSurTable[6]);

        placerOuvrierSurChantier(CarteBatimentsSurTable[4], CarteOuvriersSurTable[4]);
        choisirOuvrier(1, CarteOuvriersSurTable[4]); //joueur2 choisit un ouvrier
        choisirChantier(1, CarteBatimentsSurTable[4]); //joueur2 choisit un chantier


        while (true){ //loop pour chaque tour
            System.out.println("######################### Tour n°" + compteTour + "#########################");
            for (int i = 0; i < nbjoueurs; i++) { //actions de chaque joueur
                if (i == 0) { //actions du joueur 1
                    System.out.println("------------------ Joueur n°" + (i + 1) + "------------------");
                    System.out.println("Le joueur " + (i + 1) + " a selectionné un ouvrier " + CarteOuvriersSurTable[3].getName() + " et un chantier " + CarteBatimentsSurTable[2].getName());
                    System.out.println("Sur le chantier " + CarteBatimentsSurTable[2].getName() + " on a l'ouvrier " + CarteBatimentsSurTable[2].getIdOuvrier()[0]);
                    System.out.println("L'ouvrier " + CarteOuvriersSurTable[3].getName() + " travail sur " + CarteOuvriersSurTable[3].getChantier());

                    int[] b = CarteBatimentsSurTable[2].getIdOuvrier();
                    System.out.println("Ouvrier n°1 : "+b[0]);
                    System.out.println("Ouvrier n°2 : "+b[1]);
                    System.out.println("Ouvrier n°3 : "+b[2]);

                    CarteBatimentsSurTable[2].sumRessources();
                    System.out.println(CarteBatimentsSurTable[2].toString());
                }
                if (i == 1) { //actions du joueur 2
                    System.out.println("------------------ Joueur n°" + (i + 1) + "------------------");
                    System.out.println("Le joueur " + (i + 1) + " a selectionné un ouvrier " + CarteOuvriersSurTable[4].getName() + " et un chantier " + CarteBatimentsSurTable[4].getName());
                    System.out.println("Sur le chantier " + CarteBatimentsSurTable[4].getName() + " on a l'ouvrier " + CarteBatimentsSurTable[4].getIdOuvrier()[0]);
                    System.out.println("L'ouvrier " + CarteOuvriersSurTable[4].getName() + " travail sur " + CarteOuvriersSurTable[4].getChantier());
                }

                if (i == 2) { //actions joueur 3
                    System.out.println("error");
                }

                if (i == 3) { // actions joueur 4
                    System.out.println("error");
                }
            }

            // Condition de victoire
            /*if(batiment1.getIdOuvrier() == c1.getId() && c1.getChantier() == batiment1.getId()){
                System.out.println("Vous avez gagné");
                break;
            }*/
            if(CarteBatimentsSurTable[2].isBuilt()  == 1){
                System.out.println("Vous avez gagné");
                break;
            }
            System.out.println("Fin du tour : "+compteTour+"");//On affiche le numéro du tour à la fin de ce dernier
            compteTour++;//On incrémente compteTour

            if (compteTour > 20){break;} //Pour eviter des millions de tours ... a retirer à l'avenir
        }
    }

    public static void main(String[] args) {
        Joueurs j1 = new Joueurs(1); //création de tous les joueurs possibles
        Joueurs j2 = new Joueurs(2);
        Joueurs j3 = new Joueurs(3);
        Joueurs j4 = new Joueurs(4);
        Bourse BourseJ1 = new Bourse(5,1,j1.getId());
        Bourse BourseJ2 = new Bourse(5,1,j2.getId());
        Bourse BourseJ3 = new Bourse(5,1,j3.getId());
        Bourse BourseJ4 = new Bourse(5,1,j4.getId());
        MoteurDeJeu m1 = new MoteurDeJeu();
        m1.deroulementJeux();
    }
}

