package moteurdejeu;


import cartes.CarteOuvrier;
import joueurs.Joueurs;



public class MoteurDeJeu{

    public static void main(String[] args) {
        int nbjoueurs = 1; //pour l'instant seulement 1 joueur
        System.out.println("Il y a %d joueur(s)"+nbjoueurs+"");
        System.out.println("Debut du jeu...");

        Joueurs j1 = new Joueurs(1);
        CarteOuvrier c1 = new CarteOuvrier("ouvrier");

        System.out.println("Voici vos choix" + c1 +"");

        private void piocher (j1, c1){

        }



    }


}
