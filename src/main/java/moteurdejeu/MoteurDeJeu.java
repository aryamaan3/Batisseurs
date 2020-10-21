package moteurdejeu;


import cartes.Cartes;
import cartes.cartesouvrier.CarteOuvriers;
import cartes.cartesbatiments.CarteBatiments;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import joueurs.Joueurs;



public class MoteurDeJeu { //Controle le deroulement du jeu

    // Desk de carte : la première carte du joueur 0 sera à l'indice [0][0]
    // Contient donc les cartes ouvrier de TOUS les joueurs
    public static CarteOuvriers[] DeckOuvrier = new CarteOuvriers[2];  //Contiendra des objects "cartes" que possède les joueur
    public static CarteBatiments[] DeckBatiment = new CarteBatiments[2];    // [2] Car on n'a pas plus de carte à donner pour l'instant

    /**
     * Choix de l'ouvrier par le joueur
     * @param id
     * @param ouvrier
     */
    public static void choisirOuvrier(int id, CarteOuvriers ouvrier){
        ouvrier.AffectationOuvrier(id);
    }

    /**
     * Permet à un joueur de choisir une carteBatiment d'assigner le champs "idJoueur" de carteBatiment (qui est initialisé à -1 au début)
     * @param id
     * @param carteBatiment
     */
    public static void choisirChantier(int id, CarteBatiments carteBatiment){
        // [13] correspond à l'indice du champ idJoueur de la carteBatiment
        // [0] correspond à la première carte (n°0) qui devrait aussi etre la carteBatiment dont l'id est 0
        carteBatiment.AffectationChantier(id);
    }



    /**
     * Permet de placer un ouvrier sur un chantier
     * @param batiment
     * @param ouvrier
     */
    public static void placerOuvrierSurChantier(CarteBatiments batiment, CarteOuvriers ouvrier){
        ouvrier.AffectationOuvrierAChantier(batiment.getId());
        batiment.AffectationOuvrierAChantier(ouvrier.getId());

    }

    /**
     * Méthode permettant de le bon fonctionnment du jeux
     */
    public static void déroulementJeux(){
        int nbjoueurs = 2; //pour l'instant seulement 2 joueur
        int compteTour = 1; //Pour compter le nombre de tour au fil de la partie

        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1); //création de tous les joueurs possibles
        Joueurs j2 = new Joueurs(2);
        Joueurs j3 = new Joueurs(3);
        Joueurs j4 = new Joueurs(4);

        CarteOuvriers c1 = new CarteOuvriers(0,"Patrick",2,1,1,1,0,0,-1);
        CarteBatiments batiment1 = new CarteBatiments(1,"TourEiffel",0,0,1,0,1,1);
        CarteOuvriers c2 = new CarteOuvriers(1,"toto",2,1,3,4,1,0,-1);
        CarteBatiments batiment2 = new CarteBatiments(2,"BigBen",0,0,0,0,0,0);

        DeckBatiment[0] = batiment1;
        DeckOuvrier[0] = c1;

        placerOuvrierSurChantier(batiment1, c1);
        choisirOuvrier(0, c1); //joueur choisi un ouvrier
        choisirChantier(0, batiment1); //joueur choisi un chantier

        placerOuvrierSurChantier(batiment2, c2);
        choisirOuvrier(1, c2); //joueur choisi un ouvrier
        choisirChantier(1, batiment2); //joueur choisi un chantier

        while (true){ //loop pour chaque tour
            for (int i = 0; i < nbjoueurs; i++) { //actions de chaque joueur
                if (i == 0) { //actions du joueur 1

                    System.out.println("Le joueur " + (i + 1) + " a selectionné un ouvrier " + c1.getName() + " et un chantier " + batiment1.getName());
                    System.out.println("Sur le chantier " + batiment1.getName() + " on a l'ouvrier " + batiment1.getIdOuvrier()[0]);
                    System.out.println("L'ouvrier " + c1.getName() + " travail sur " + c1.getChantier());
                }
                if (i == 1) { //actions du joueur 2
                    System.out.println("Le joueur " + (i + 1) + " a selectionné un ouvrier " + c2.getName() + " et un chantier " + batiment2.getName());
                    System.out.println("Sur le chantier " + batiment2.getName() + " on a l'ouvrier " + batiment2.getIdOuvrier()[0]);
                    System.out.println("L'ouvrier " + c2.getName() + " travail sur " + c2.getChantier());
                }

                if (i == 2){ //actions joueur 3
                    System.out.println("error");
                }

                if (i == 3){ // actions joueur 4
                    System.out.println("error");
                }
            }

            // Condition de victoire
            /*if(batiment1.getIdOuvrier() == c1.getId() && c1.getChantier() == batiment1.getId()){
                System.out.println("Vous avez gagné");
                break;
            }*/
            if(batiment1.isBuilt()  == 1){
                System.out.println("Vous avez gagné");
                break;
            }
            System.out.println("Fin du tour : "+compteTour+"");//On affiche le numéro du tour à la fin de ce dernier
            compteTour++;//On incrémente compteTour
        }
    }

    public static void main(String[] args) {
        déroulementJeux();
    }
}

