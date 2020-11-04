package display;

import moteurdejeu.MoteurDeJeu;

public class Display {
    /**
     *  Classe qui imprime les ouvriers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayOuvriersDuJoueur(int idJoueur){
        // On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
        for(int i = 0; i < MoteurDeJeu.DeckOuvrier.size(); i ++){
            if(idJoueur == MoteurDeJeu.DeckOuvrier.get(i).getIdjoueur()){
                System.out.println("Le joueur " + idJoueur
                        + " possède " + MoteurDeJeu.DeckOuvrier.get(i).getName()
                        + " (id = " + MoteurDeJeu.DeckOuvrier.get(i).getId() + ")");
            }
        }
    }

    public static void displayChantierDuJoueur(int idJoueur){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        for(int i = 0; i < MoteurDeJeu.DeckBatiment.size(); i ++){
            if(idJoueur == MoteurDeJeu.DeckBatiment.get(i).getIdjoueur()){
                System.out.println("Le joueur " + idJoueur
                        + " construit " + MoteurDeJeu.DeckBatiment.get(i).getName()
                        + " (id = " + MoteurDeJeu.DeckBatiment.get(i).getId() + ")");
            }
        }
    }
}
