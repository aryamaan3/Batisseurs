package display;

import cartes.Cartes;
import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;
import joueurs.Joueurs;
import joueurs.Compteur;
import joueurs.Bourse;

import java.util.ArrayList;

import static display.Couleur.*;

/**
 * Classe qui permet l'affichage en System.out.println des différents objets
 */

public class Display {

    /**
     *  Méthode qui imprime les ouvriers d'un joueur
     * @param idJoueur id joueur
     * @param deckOuvrier Arraylist contenant les cartes ouvriers
     */
    public static void displayOuvriersDuJoueur(int idJoueur, ArrayList<CarteOuvriers> deckOuvrier){
        // On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + (idJoueur+1)+ " possède ce(s) ouvrier(s) :");
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
     * @param deckBatiment ArrayList contenant les cartes batiments
     */
    public static void displayChantierDuJoueur(int idJoueur, ArrayList<CarteBatiments> deckBatiment){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + (idJoueur+1) + " construit ce(s) chantier(s) :");
        for(int i = 0; i < deckBatiment.size(); i ++){
            if(idJoueur == deckBatiment.get(i).getIdJoueur() && !(deckBatiment.get(i).isBuiltShort())){
                System.out.println(" - " + deckBatiment.get(i).getName()
                        + " (id = " + deckBatiment.get(i).getId() + ")");
            }
        }
    }

    /**
     * Méthode qui affiche l'etat des chantiers d'un joueur
     * @param idJoueur id joueur
     * @param deckBatiment ArrayList contenant les cartes batiments
     */
    public static void displayEtatChantiersDuJoueur(int idJoueur, ArrayList<CarteBatiments> deckBatiment){
        for(int i = 0; i < deckBatiment.size(); i ++){
                System.out.println(deckBatiment.get(i).toString());
        }
    }

    /**
     * Imprime les Bâtiments (chantiers terminés) d'un joueur
     * @param joueurs Objet joueur
     * @param deckBatiment Deck Batiment du main
     */
    public static void displayChantierFini(Joueurs joueurs, ArrayList<CarteBatiments> deckBatiment){
        System.out.print("Joueur "+(joueurs.getId()+1) + " a ce(s) bâtiment(s) de construit(s): ");
        for(int i = 0; i < deckBatiment.size(); i ++){
            if((deckBatiment.get(i).getIdJoueur() == joueurs.getId()) && deckBatiment.get(i).isBuiltShort())
                System.out.print(deckBatiment.get(i).getName());
        }
        System.out.println(); // juste pour le retour à la ligne
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

    /**
     *
     */
    public static void displayPoint(Joueurs joueur){
        System.out.println("Le joueur n°" + (joueur.getId()+1) + " a "
                + ANSI_GREEN + joueur.getPoints() + " point(s)" +ANSI_RESET);
    }
    public static void displayActions(Compteur c){
        System.out.println("Il reste "+c.nb+" action(s)");
    }

    public static void displayBourse(Joueurs joueurs){
            System.out.println("Le joueur "+ (joueurs.getId()+1) + " possede "+joueurs.getBourseJoueur().getEcus()+" ecus");

    }
}
