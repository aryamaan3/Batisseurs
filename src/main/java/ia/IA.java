package ia;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;

import java.util.ArrayList;

import static cartes.cartesouvrier.CarteOuvriers.obtenirDeckJoueur;
import static cartes.cartesbatiments.CarteBatiments.obtenirDeckJoueur;
import static moteurdejeu.MoteurDeJeu.choisirOuvrier;
import static moteurdejeu.MoteurDeJeu.choisirChantier;
import static moteurdejeu.MoteurDeJeu.placerOuvrierSurChantier;
import static cartes.cartesbatiments.CarteBatiments.getCarteBatById;
import static cartes.cartesouvrier.CarteOuvriers.getCarteOuvById;

public class IA {
    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param idJoueur idDuJoueur
     * @param CartesDisponibles CartesOuvriersSurTables[]
     */
    public void iaChoisitOuvrier(int idJoueur, ArrayList<CarteOuvriers> CartesDisponibles, int nbChoix){
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
     * @param CartesDisponibles CartesChantiersSurTables[]
     */
    public void iaChoisitChantier(int idJoueur, ArrayList<CarteBatiments> CartesDisponibles, int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirChantier(idJoueur, CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    public void iaAttributOuvrierAChantier(int idJoueur, ArrayList<CarteOuvriers> DeckOuvrier, ArrayList<CarteBatiments> DeckBatiment){
        // On veut les id des  cartes qui appartiennent au joueur
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, DeckOuvrier);
        ArrayList<Integer> idCarteBatimentDuJoueur = obtenirDeckJoueur(idJoueur, DeckBatiment);
        int i = 0;
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

    public void ActionsIA (int idJoueur, ArrayList<CarteOuvriers> deckOuv, ArrayList<CarteBatiments> deckBat){
        iaChoisitOuvrier(idJoueur, deckOuv, 3);
        iaChoisitChantier(idJoueur, deckBat, 1);
        
    }

}
