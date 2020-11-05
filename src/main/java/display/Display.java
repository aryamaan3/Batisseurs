package display;

import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import moteurdejeu.MoteurDeJeu;

import java.util.ArrayList;

public class Display {
    private static ArrayList<CarteOuvriers> deckOuvrier = new DeckOuvriers().getDeck();
    private static ArrayList<CarteBatiments> deckBatiment= new DeckBatiments().getDeck();
    /**
     *  Classe qui imprime les ouvriers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayOuvriersDuJoueur(int idJoueur){
        // On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + idJoueur + " possède ce(s) ouvrier(s) :");
        for(int i = 0; i < deckOuvrier.size(); i ++){
            if(idJoueur == deckOuvrier.get(i).getIdjoueur()){
                System.out.println(" - " + deckOuvrier.get(i).getName()
                        + " (id = " + deckOuvrier.get(i).getId() + ")");
            }
        }
    }

    /**
     *  Classe qui imprime les chantiers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayChantierDuJoueur(int idJoueur){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + idJoueur + " construit ce(s) chantier(s) :");
        for(int i = 0; i < deckBatiment.size(); i ++){
            if(idJoueur == deckBatiment.get(i).getIdjoueur()){
                System.out.println(" - " + deckBatiment.get(i).getName()
                        + " (id = " + deckBatiment.get(i).getId() + ")");
            }
        }
    }

    /**
     * Classe qui affiche l'etat des chantiers d'un joueur
     * @param idJoueur
     */
    public static void displayEtatChantiersDuJoueur(int idJoueur){
        for(int i = 0; i < deckBatiment.size(); i ++){
            if(idJoueur == deckBatiment.get(i).getIdjoueur()){
                System.out.println(deckBatiment.get(i).toString());
            }
        }
    }
}
