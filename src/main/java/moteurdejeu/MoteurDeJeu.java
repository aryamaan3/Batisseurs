package moteurdejeu;


import cartes.Cartes;
import cartes.cartesouvrier.CarteOuvriers;
import joueurs.Joueurs;



public class MoteurDeJeu {

    // Desk de carte : la première carte du joueur 0 sera à l'indice [0][0]
    // Contient donc les cartes ouvrier de TOUS les joueurs
    public static Cartes[][] DeckOuvrier = new Cartes[2][2];  //Contiendra des objects "cartes" que possède les joueur

    /*  Supprimé
    // Variable qui contient les zones de construction (où les batiments sont placés)
    // Contient les cartes en construction de TOUS les joueurs
    // (ex : ZoneDeConstruction[1][2] joueur 1, carte numéro 3 (indice 2)
    public static Cartes[][] ZoneDeConstruction = new Cartes[2][2];
    */

    // Methode permettant à un joueur de piocher une carte (les deux sont en paramètre de la méthode
    // Ajoute la carte piocher à l'indice 0 du deck du joueur
    public static void piocher(Joueurs joueur, Cartes carteOuvrier) {
        DeckOuvrier[joueur.getId()][0] = carteOuvrier;

        // Regroupe les decks de tout le monde, le deck du la première carte du joueur 1 sera à la position Deck[0][0]
    }

    // Permet à un joueur de choisir une carteBatiment d'assigner le champs "idJoueur" de carteBatiment (qui est initialisé à -1 au début)
    public static void choisirChantier(Joueurs joueur, Cartes carteBatiment){
        // [13] correspond à l'indice du champ idJoueur de la carteBatiment
        // [0] correspond à la première carte (n°0) qui devrait aussi etre la carteBatiment dont l'id est 0

    }

    // Future méthode placerOuvrier

    public static void main(String[] args) throws Exception {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur
        int compteTour = 1;//Pour compter le nombre de tour au fil de la partie



        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        Cartes c1 = new CarteOuvriers(0,"ouvrier",2,1,3,4,1,0,-1);

        while (true){
            System.out.println("Voici vos choix " + c1 + "");

            System.out.println("le joueur a selectionné " + c1 + "");

            piocher(j1,c1);

            System.out.println("Le joueur "+j1.getId()+ " possède ces cartes : "+DeckOuvrier[j1.getId()][0]);
            compteTour++;
            // Condition de victoire
            if(DeckOuvrier[j1.getId()][0].getIdCarte().equals("ouvrier")){
                System.out.println("Vous avez gagné");
                break;
            }
            System.out.println("Fin du tour : "+compteTour+"");//On affiche le numéro du tour à la fin de ce dernier
            //On incrémente compteTour
        }
    }
}

