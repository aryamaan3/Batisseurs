package ia;

import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;

import static cartes.cartesouvrier.CarteOuvriers.obtenirDeckJoueur;
import static cartes.cartesbatiments.CarteBatiments.obtenirDeckJoueur;
import static moteurdejeu.MoteurDeJeu.choisirOuvrier;
import static moteurdejeu.MoteurDeJeu.choisirChantier;
import static moteurdejeu.MoteurDeJeu.placerOuvrierSurChantier;

public class IA {
    /**
     * L'IA va choisir une ou plusieurs carte ouvrier parmit celles présentes dans les CartesOuvriersSurTables[]
     * @param idJoueur
     * @param CartesDisponibles CartesOuvriersSurTables[]
     */
    public void iaChoisitOuvrier(int idJoueur, CarteOuvriers[] CartesDisponibles, int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirOuvrier(idJoueur, CartesDisponibles[i]);
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    /**
     * L'IA va choisir une ou plusieurs carte chantier parmi celles présentes dans les CartesChantiersSurTables[]
     * @param idJoueur
     * @param CartesDisponibles CartesChantiersSurTables[]
     */
    public void iaChoisitChantier(int idJoueur, CarteBatiments[] CartesDisponibles, int nbChoix){
        // Pour l'instant, choisi 2 ouvrier (les deux premiers de CartesDisponibles[0])
        for (int i = 0; i < nbChoix; i ++) {
            choisirChantier(idJoueur, CartesDisponibles[i]);
            /* A verifier si on peut lui donner CartesDisponibles[0] à chaque fois
             puisse que CartesDisponibles est censé se MAJ en focntion de l'assign */
        }
    }

    public void iaAttributOuvrierAChantier(int idJoueur, CarteOuvriers[] DeckOuvrier, CarteBatiments[] DeckBatiment){
        // On veut les id des  cartes qui appartiennent au joueur
        int [] carteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, DeckOuvrier);
        int [] carteBatimentDuJoueur = obtenirDeckJoueur(idJoueur, DeckBatiment);
        //placerOuvrierSurChantier(CarteBatimentsSurTable[2], CarteOuvriersSurTable[6]);
    }

}
