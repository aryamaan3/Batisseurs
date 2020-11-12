package display;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;

import java.util.ArrayList;

import static display.Couleur.*;

/**
 * Class qui permet l'affichage en System.out.println des différents objets
 */

public class Display {

    /**
     *  Méthode qui imprime les ouvriers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayOuvriersDuJoueur(int idJoueur, ArrayList<CarteOuvriers> deckOuvrier){
        // On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + idJoueur + " possède ce(s) ouvrier(s) :");
        for(int i = 0; i < deckOuvrier.size(); i ++){
            if(idJoueur == deckOuvrier.get(i).getIdJoueur()){
                System.out.println(" - " + deckOuvrier.get(i).getName()
                        + " (id = " + deckOuvrier.get(i).getId() + ")");
            }
        }
    }

    /**
     *  Méthode qui imprime les chantiers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayChantierDuJoueur(int idJoueur, ArrayList<CarteBatiments> deckBatiment){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + idJoueur + " construit ce(s) chantier(s) :");
        for(int i = 0; i < deckBatiment.size(); i ++){
            if(idJoueur == deckBatiment.get(i).getIdJoueur()){
                System.out.println(" - " + deckBatiment.get(i).getName()
                        + " (id = " + deckBatiment.get(i).getId() + ")");
            }
        }
    }

    /**
     * Méthode qui affiche l'etat des chantiers d'un joueur
     * @param idJoueur id joueur
     */
    public static void displayEtatChantiersDuJoueur(int idJoueur, ArrayList<CarteBatiments> deckBatiment){
        for(int i = 0; i < deckBatiment.size(); i ++){
            if(idJoueur == deckBatiment.get(i).getIdJoueur()){
                System.out.println(deckBatiment.get(i).toString());
            }
        }
    }

    /**
     * Imprime dans l'invite de commande l'état des cartes à piocher (toutes les cartes disponibles, ouvrier ou chantier)
     * @param ouvriersDispo Ouvriers Disponibles
     * @param chantiersDispo  Chantiers disponibles
     */
    public static void displayCarteDispo(ArrayList<CarteOuvriers> ouvriersDispo, ArrayList<CarteBatiments> chantiersDispo){
        System.out.print(ANSI_GREEN + "Cartes ouvriers disponibles :"+ ANSI_RESET);
        for(int i = 0; i < ouvriersDispo.size(); i ++){
                System.out.print(" " + ouvriersDispo.get(i).getName() + "(id=" + ouvriersDispo.get(i).getId() + ")");
        }
        System.out.print(ANSI_GREEN + "\nCartes chantiers disponibles :"+ ANSI_RESET);
        for(int i = 0; i < chantiersDispo.size(); i ++){
            System.out.print(" " + chantiersDispo.get(i).getName());
        }
        System.out.println(); // Juste pour un retour à la ligne
    }
}
