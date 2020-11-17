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
    Joueurs j;

    public IA(Joueurs j, ArrayList<CarteOuvriers> deckOuvrier, ArrayList<CarteBatiments> deckBatiment){
        this.deckBatiment = deckBatiment;
        this.deckOuvrier = deckOuvrier;
        this.j = j;
    }

    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param nbChoix le nombre de choix que l'IA peut faire
     */
    public void iaChoisitOuvrier(int nbChoix){
        ArrayList<CarteOuvriers> CartesDisponibles = CarteOuvriers.carteSurTable(deckOuvrier);
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirOuvrier(j.getId(), CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    /**
     * L'IA va choisir une ou plusieurs carte chantier parmi celles présentes dans les CartesChantiersSurTables[]
     * @param nbChoix le nombre de choix que l'IA peut faire
     */
    public void iaChoisitChantier(int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        ArrayList<CarteBatiments> CartesDisponibles = carteSurTable(deckBatiment);
        for (int i = 0; i < nbChoix; i ++) {
            choisirChantier(j.getId(), CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    /**
     * Permet l'attribution d'un ouvrier à un chantier (que le joueur possède)
     * en fonction du choix de l'IA
     * @param bourse la bourse du joueur
     */
    public void iaAttributOuvrierAChantier(Bourse bourse){
        // On veut les id des  cartes qui appartiennent au joueur
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(j.getId(), deckOuvrier);
        ArrayList<Integer> idCarteBatimentDuJoueur = obtenirDeckJoueur(j.getId(), deckBatiment);
        for (int i = 0; i < idCarteOuvrierDuJoueur.size(); i++){
            //carteOuvDuJoueur.add(getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));
            //placerOuvrierSurChantier(carteBatDuJoueur.get(0), carteOuvDuJoueur.get(i));
            // à modifier quand on a plusieurs carteBat
            if(bourse.actionAutorisee(j.id,deckOuvrier,i) == true){
            placerOuvrierSurChantier( getCarteBatById(idCarteBatimentDuJoueur.get(0), deckBatiment) ,getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));}
        }
    }

    public void passeTour(){

    }

    /**
     * Permet d'executer l'ensemble des méthodes de cette class en un appel de méthode
     * @param bourse
     */
    public void  ActionsIA(Compteur c, Bourse bourse){
        iaChoisitOuvrier(c.nb - 1);
        c.actionsFait(2);
        iaChoisitChantier(c.nb);
        c.actionsFait(1);
        iaAttributOuvrierAChantier(bourse);
        c.buyActions(3);
        c.actionsFait(1);
        c.sellActions(2);
    }

}
