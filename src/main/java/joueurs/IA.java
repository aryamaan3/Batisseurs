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

public class IA {
     private static ArrayList<CarteOuvriers> deckOuvrier = new DeckOuvriers().getDeck();
     private static ArrayList<CarteBatiments> deckBatiment= new DeckBatiments().getDeck();

    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param idJoueur idDuJoueur
     * @param nbChoix le nombre de choix que l'IA peut faire
     * @param  nbChoix
     */
    public static void iaChoisitOuvrier(int idJoueur, int nbChoix){
        System.out.println(ANSI_BLUE+"L'ia choisit un/des ouvrier(s) pour le joueur "+idJoueur+ANSI_RESET);
        ArrayList<CarteOuvriers> CartesDisponibles = CarteOuvriers.carteSurTable(deckOuvrier);
        System.out.println(ANSI_BLUE+
                "Carte dispo [0] (dont id="+ CartesDisponibles.get(0).getId() +") = "+CartesDisponibles.get(0)
                + "\nCarte dispo [1] (dont id=" + CartesDisponibles.get(1).getId() + ") = "+CartesDisponibles.get(1)
                + "\nCarte dispo [2] (dont id="+ CartesDisponibles.get(2).getId() +") = "+CartesDisponibles.get(2)
                +ANSI_RESET);
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirOuvrier(idJoueur, CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
        System.out.println(ANSI_BLUE+ getCarteOuvById(0, deckOuvrier).getIdJoueur() +ANSI_RESET);
        System.out.println(ANSI_BLUE+ getCarteOuvById(1, deckOuvrier).getIdJoueur() +ANSI_RESET);
        System.out.println(ANSI_BLUE+ getCarteOuvById(2, deckOuvrier).getIdJoueur() +ANSI_RESET);
        // Affectation vérifiée ! Tout ok
    }

    /**
     * L'IA va choisir une ou plusieurs carte chantier parmi celles présentes dans les CartesChantiersSurTables[]
     * @param idJoueur idDuJoueur
     * @param nbChoix le nombre de choix que l'IA peut faire
     * @param nbChoix
     */
    public static void iaChoisitChantier(int idJoueur, int nbChoix){
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
    public static void iaAttributOuvrierAChantier(int idJoueur){
        ArrayList<CarteOuvriers> DeckOuvrier = deckOuvrier;
        ArrayList<CarteBatiments> DeckBatiment = deckBatiment;
        // On veut les id des  cartes qui appartiennent au joueur
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, DeckOuvrier);
        ArrayList<Integer> idCarteBatimentDuJoueur = obtenirDeckJoueur(idJoueur, DeckBatiment);
        int i;
        ArrayList<CarteBatiments> carteBatDuJoueur = new ArrayList<>();
        ArrayList<CarteOuvriers> carteOuvDuJoueur = new ArrayList<>();
        for (i = 0; i < idCarteBatimentDuJoueur.size(); i++){
            carteBatDuJoueur.add(getCarteBatById(idCarteBatimentDuJoueur.get(i), DeckBatiment));
        }
        for (i = 0; i < idCarteOuvrierDuJoueur.size(); i++){
            carteOuvDuJoueur.add(getCarteOuvById(idCarteOuvrierDuJoueur.get(i), DeckOuvrier));
            placerOuvrierSurChantier(carteBatDuJoueur.get(0), carteOuvDuJoueur.get(i));
            // à modifier quand on a plusieurs carteBat
        }
        //return carteBatDuJoueur;
    }

    /**
     * Permet d'executer l'ensemble des méthodes de cette class en un appel de méthode
     * @param idJoueur id du joueur
     */
    public static void  ActionsIA(int idJoueur){
        iaChoisitOuvrier(idJoueur,3);
        iaChoisitChantier(idJoueur, 1);
        iaAttributOuvrierAChantier(idJoueur);
    }

}
