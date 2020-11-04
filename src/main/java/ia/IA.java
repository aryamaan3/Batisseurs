package ia;

//import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import moteurdejeu.MoteurDeJeu;
//import decks.DeckBatiments;

import java.util.ArrayList;

import static cartes.cartesbatiments.CarteBatiments.*;
import static cartes.cartesouvrier.CarteOuvriers.obtenirDeckJoueur;
import static cartes.cartesbatiments.CarteBatiments.obtenirDeckJoueur;
import static moteurdejeu.MoteurDeJeu.choisirOuvrier;
import static moteurdejeu.MoteurDeJeu.choisirChantier;
import static moteurdejeu.MoteurDeJeu.placerOuvrierSurChantier;
import static cartes.cartesouvrier.CarteOuvriers.getCarteOuvById;

public class IA {
    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param idJoueur idDuJoueur
     * @param nbChoix le nombre de choix que l'IA peut faire
     * @param  nbChoix
     */
    public static void iaChoisitOuvrier(int idJoueur, int nbChoix){
        ArrayList<CarteOuvriers> CartesDisponibles = CarteOuvriers.carteSurTable(MoteurDeJeu.DeckOuvrier);
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
     * @param nbChoix
     */
    public static void iaChoisitChantier(int idJoueur, int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        ArrayList<CarteBatiments> CartesDisponibles = carteSurTable(MoteurDeJeu.DeckBatiment);
        for (int i = 0; i < nbChoix; i ++) {
            choisirChantier(idJoueur, CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    public static void iaAttributOuvrierAChantier(int idJoueur){
        ArrayList<CarteOuvriers> DeckOuvrier = MoteurDeJeu.DeckOuvrier;
        ArrayList<CarteBatiments> DeckBatiment = MoteurDeJeu.DeckBatiment;
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

    public static void  ActionsIA(int idJoueur){
        iaChoisitOuvrier(idJoueur,3);
        iaChoisitChantier(idJoueur, 1);
        iaAttributOuvrierAChantier(idJoueur);
    }

}
