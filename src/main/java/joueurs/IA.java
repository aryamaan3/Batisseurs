package joueurs;

//import cartes.Cartes;
import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.DeckOuvriers;
//import org.fusesource.jansi.AnsiConsole;
//import cartes.batiments.DeckBatiments;

import java.util.ArrayList;

import static cartes.batiments.CarteBatiments.*;
import static cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur;
import static cartes.batiments.CarteBatiments.obtenirDeckJoueur;
import static moteurdejeu.MoteurDeJeu.choisirOuvrier;
import static moteurdejeu.MoteurDeJeu.choisirChantier;
import static moteurdejeu.MoteurDeJeu.placerOuvrierSurChantier;
import static cartes.ouvrier.CarteOuvriers.getCarteOuvById;
import static display.Couleur.*;

/**
 * La classe IA contient les méthodes qui permettent à l'IA de faire des choix et de jouer
 */

public class IA {
    ArrayList<CarteOuvriers> deckOuvrier;
    ArrayList<CarteBatiments> deckBatiment;

    public IA(ArrayList<CarteOuvriers> deckOuvrier, ArrayList<CarteBatiments> deckBatiment){
        this.deckBatiment = deckBatiment;
        this.deckOuvrier = deckOuvrier;
    }

    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param idJoueur idDuJoueur
     * @param nbChoix le nombre de choix que l'IA peut faire
     */
    public void iaChoisitOuvrier(int idJoueur, int nbChoix){
        ArrayList<CarteOuvriers> CartesDisponibles = CarteOuvriers.carteSurTable(deckOuvrier);
        /*System.out.println(ANSI_BLUE+
                "Carte dispo [0] (dont id="+ CartesDisponibles.get(0).getId() +") = "+CartesDisponibles.get(0)
                + "\nCarte dispo [1] (dont id=" + CartesDisponibles.get(1).getId() + ") = "+CartesDisponibles.get(1)
                + "\nCarte dispo [2] (dont id="+ CartesDisponibles.get(2).getId() +") = "+CartesDisponibles.get(2)
                +ANSI_RESET);*/
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirOuvrier(idJoueur, CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    /**
     * L'IA va choisir une ou plusieurs carte chantier parmi celles présentes dans les CartesChantiersSurTables[]
     * @param idJoueur idDuJoueur
     * @param nbChoix le nombre de choix que l'IA peut faire
     */
    public void iaChoisitChantier(int idJoueur, int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        ArrayList<CarteBatiments> CartesDisponibles = carteSurTable(deckBatiment);
        for (int i = 0; i < nbChoix; i ++) {
            choisirChantier(idJoueur, CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    /**
     * Permet l'attribution d'un ouvrier à un chantier (que le joueur possède)
     * en fonction du choix de l'IA
     * @param idJoueur id du joueur
     */
    public void iaAttributOuvrierAChantier(int idJoueur){
        // On veut les id des  cartes qui appartiennent au joueur
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, deckOuvrier);
        ArrayList<Integer> idCarteBatimentDuJoueur = obtenirDeckJoueur(idJoueur, deckBatiment);
        for (int i = 0; i < idCarteOuvrierDuJoueur.size(); i++){
            //carteOuvDuJoueur.add(getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));
            //placerOuvrierSurChantier(carteBatDuJoueur.get(0), carteOuvDuJoueur.get(i));
            // à modifier quand on a plusieurs carteBat
            placerOuvrierSurChantier( getCarteBatById(idCarteBatimentDuJoueur.get(0), deckBatiment) ,getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));
        }
    }

    /**
     * Permet d'executer l'ensemble des méthodes de cette class en un appel de méthode
     * @param idJoueur id du joueur
     */
    public void  ActionsIA(int idJoueur){
        iaChoisitOuvrier(idJoueur,2);
        iaChoisitChantier(idJoueur, 1);
        iaAttributOuvrierAChantier(idJoueur);
    }

}
