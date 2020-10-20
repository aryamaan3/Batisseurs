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
    public static Cartes[] DeckOuvrier = new Cartes[2];  //Contiendra des objects "cartes" que possède les joueur
    public static Cartes[] DeckBatiment = new Cartes[2];    // [2] Car on n'a pas plus de carte à donner pour l'instant

    // Choix de l'ouvrier par le joueur
    public static void choisirOuvrier(Joueurs joueur, CarteOuvriers ouvrier){
        ouvrier.AffectationOuvrier(joueur.getId());
    }

    // Permet à un joueur de choisir une carteBatiment d'assigner le champs "idJoueur" de carteBatiment (qui est initialisé à -1 au début)
    public static void choisirChantier(Joueurs joueur, CarteBatiments carteBatiment){
        // [13] correspond à l'indice du champ idJoueur de la carteBatiment
        // [0] correspond à la première carte (n°0) qui devrait aussi etre la carteBatiment dont l'id est 0
        carteBatiment.AffectationChantier(joueur.getId());
    }

    // Future méthode placerOuvrier

    public static void placerOuvrierSurChantier(CarteBatiments batiment, CarteOuvriers ouvrier){
        //  On place l'id du batiment dans le champ assign de la carte ouvrier pour savoir sur quoi il travaille
        ouvrier.AffectationOuvrierAChantier(batiment.getId());
        batiment.AffectationOuvrierAChantier(ouvrier.getId());

    }

    public static void déroulementJeux(){
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur
        int compteTour = 1; //Pour compter le nombre de tour au fil de la partie

        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        CarteOuvriers c1 = new CarteOuvriers(0,"Patrick",2,1,3,4,1,0,-1);
        CarteBatiments batiment1 = new CarteBatiments(1,"TourEiffle",0,0,0,0,0,0,0,-1, -1);

        placerOuvrierSurChantier(batiment1, c1);

        DeckBatiment[0] = batiment1;

        while (true){ //loop pour chaque tour
            choisirOuvrier(j1,c1); //joueur choisi un ouvrier
            choisirChantier(j1, batiment1); //joueur choisi un chantier
            System.out.println("Le joueur "+j1.getId()+ " a selectionné un ouvrier " + c1.getName() + " et un chantier " + batiment1.getName());

            System.out.println("Sur le chantier " +batiment1.getName()+ " on a l'ouvrier "+ batiment1.getIdOuvrier());
            System.out.println("L'ouvrier " +c1.getName()+ " travail sur "+ c1.getChantier());


            // Condition de victoire
            if(batiment1.getIdOuvrier() == c1.getId() && c1.getChantier() == batiment1.getId()){
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

