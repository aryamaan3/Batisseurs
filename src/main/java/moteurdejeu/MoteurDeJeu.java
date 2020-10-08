package moteurdejeu;


import cartes.CarteOuvrier;
import cartes.Cartes;
import joueurs.Joueurs;



public class MoteurDeJeu{

    public static void main(String[] args) {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur
        System.out.println("Il y a %d joueur(s)"+nbjoueurs+"");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        CarteOuvrier c1 = new CarteOuvrier("ouvrier");

        System.out.println("Voici vos choix" + c1 +"");

        j1.piocher(c1);

        System.out.println(Deckjoueur[1]);
    }

    Cartes DeckJoueur1[];  //Contiendra des objects "cartes" que possède le joueur 1

    private void piocher(Cartes Carte){
        DeckJoueur1[0] = Carte;
    }

}
