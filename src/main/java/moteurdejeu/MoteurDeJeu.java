package moteurdejeu;


import cartes.Cartes;
import joueurs.Joueurs;



public class MoteurDeJeu {

    static Cartes DeckJoueur1[] = new Cartes[2];  //Contiendra des objects "cartes" que possède le joueur 1

    private static void piocher(Cartes carte) {
        DeckJoueur1[0] = carte;
    }

    public static void main(String[] args) {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur

        System.out.println("Il y a "+nbjoueurs+" joueur(s)");
        System.out.println("Debut du jeu...");

        //Joueurs j1 = new Joueurs(1);
        Cartes c1 = new Cartes(1,"ouvrier");

        System.out.println("Voici vos choix" + c1 + "");

        System.out.println("le joueur a selctionné" + c1 + "");

        piocher(c1);

        System.out.println("Votre deck possède ces cartes : "+DeckJoueur1[0]);
    }
}

