package moteurdejeu;


import cartes.Cartes;
import joueurs.Joueurs;



public class MoteurDeJeu {

    static Cartes DeckJoueur[][] = new Cartes[2][2];  //Contiendra des objects "cartes" que possède les joueur

    private static void piocher(Joueurs joueur, Cartes carte) {
        DeckJoueur[joueur.getId()][0] = carte; // Regroupe les decks de tout le monde, le deck du la première carte du joueur 1 sera à la position Deck[0][0]

    }

    public static void main(String[] args) {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur

        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        Cartes c1 = new Cartes(1,"ouvrier");

        System.out.println("Voici vos choix" + c1 + "");

        System.out.println("le joueur a selctionné" + c1 + "");

        piocher(j1,c1);

        System.out.println("Votre deck possède ces cartes : "+DeckJoueur[0][0]);
    }
}

