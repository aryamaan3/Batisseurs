package moteurdejeu;


import cartes.Cartes;
import joueurs.Joueurs;



public class MoteurDeJeu{

    public static void main(String[] args) {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur
        System.out.println("Il y a "+nbjoueurs+ "joueur(s)");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        Cartes c1 = new Cartes("ouvrier");

        //System.out.println("Voici vos choix" + c1 +"");

        String DeckJoueur1[];  //Contiendra des objects "cartes" que possède le joueur 1

        void piocher (j1, DeckJoueur1){
            System.out.println("le joueur 1 a selectionné" + c1 + "");
        }



    }


}
