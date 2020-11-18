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
    Compteur c;
    int compteurChantierTerminé = 0;

    public IA(Joueurs j, ArrayList<CarteOuvriers> deckOuvrier, ArrayList<CarteBatiments> deckBatiment, Compteur c){
        this.deckBatiment = deckBatiment;
        this.deckOuvrier = deckOuvrier;
        this.j = j;
        this.c = c;
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
        c.actionsFait(nbChoix);
    }

    /**
     * L'IA va choisir une ou plusieurs carte chantier parmi celles présentes dans les CartesChantiersSurTables[]
     * @param nbChoix le nombre de choix que l'IA peut faire
     */
    public void iaChoisitChantier(int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        ArrayList<CarteBatiments> CartesDisponibles = carteSurTable(deckBatiment);
        ArrayList<CarteBatiments> chantiersEnCours = obtenirChantierEnCours(j.getId(), deckBatiment);
        // Si on a encore des chantiers en cours, on ne pioche pas de chantier
        if(chantiersEnCours.size() <= 0){
            for (int i = 0; i < nbChoix; i ++) {
                choisirChantier(j.getId(), CartesDisponibles.get(i));
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
            }
        }
        c.actionsFait(nbChoix);
    }

    /**
     * Permet l'attribution d'un ouvrier à un chantier (que le joueur possède)
     * en fonction du choix de l'IA
     */
    public void iaAttributOuvrierAChantier(){
        // On veut les id des  cartes qui appartiennent au joueur
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(j.getId(), deckOuvrier);
        ArrayList<Integer> idCarteBatimentDuJoueur = obtenirDeckJoueur(j.getId(), deckBatiment);
        for (int i = 0; i < idCarteOuvrierDuJoueur.size(); i++){
            //carteOuvDuJoueur.add(getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));
            //placerOuvrierSurChantier(carteBatDuJoueur.get(0), carteOuvDuJoueur.get(i));

            // Est ce que le premier batiment est fini ? Si oui, on passe au deuxième
            if(getCarteBatById(idCarteBatimentDuJoueur.get(compteurChantierTerminé), deckBatiment).isBuiltShort()){
                compteurChantierTerminé ++;
            }
            if((j.bourseJoueur.actionAutorisee(j.id,deckOuvrier,i) == true) && getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier).getAssign() == -1){
                placerOuvrierSurChantier( getCarteBatById(idCarteBatimentDuJoueur.get(compteurChantierTerminé), deckBatiment) ,getCarteOuvById(idCarteOuvrierDuJoueur.get(i), deckOuvrier));}
        }
        c.actionsFait(1);
    }

    /**
     * verifie si le joueur possede assez de tours pour passer et ajoute les ecus
     * @param n nb de tours à passer
     */
    public void passeTour(int n){
       if (c.nb >= n) {
           for (int i = 1; i < n + 1; i++) {
               j.bourseJoueur.addEcus(i);
           }
           c.sellActions(n);
       }
    }

    /**
     * verifie si le joueur a les moyens d'acheter des tours
     * @param n nb de tours à ajouter
     */
    public void ajouteTour(int n){
        if (j.bourseJoueur.ecus >= n * 5 + 5){
            c.buyActions(n);
            j.bourseJoueur.subEcus(n*5);
        }
    }

    /**
     * Permet d'executer l'ensemble des méthodes de cette class en un appel de méthode
     */
    public void ActionsIA(){
        //System.out.println(bourse.getEcus());
        c.buyActions(2);
        iaChoisitOuvrier(2);
        iaChoisitChantier(1);
        ajouteTour(1);
        iaAttributOuvrierAChantier();
        passeTour(1);
    }

}
