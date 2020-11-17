package joueurs;

import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;

import java.util.ArrayList;

/**
 * La classe Assets contient des méthodes permettant la gestion des ressources du joueur.
 */

public class Assets {

    /**
     * Méthode qui renvoie une ArrayList des ouvriers disponibles
     * @param idJoueur le numéro du joueur
     * @param deck Arraylist contenant les cartes ouvriers
     * @return une ArrayList des ouvriers disponibles
     */

    public static ArrayList<CarteOuvriers> getOuvriersDisponibles(int idJoueur, ArrayList<CarteOuvriers> deck){
        ArrayList<CarteOuvriers> OuvriersDisponibles = new ArrayList<>();
        for(int i=0;i< deck.size();i++){
            if(deck.get(i).getIdJoueur()==idJoueur && deck.get(i).getChantier()==-1){
                OuvriersDisponibles.add(deck.get(i));
            }
        }
        return OuvriersDisponibles;
    }

    /**
     * Méthode permettant de savoir les ouvriers occupés pour un joueur
     * @param idJoueur le numéro du joueur
     * @param deck ArrayList contenant les cartes ouvriers
     * @return une ArrayList contenant les cartes d'ouvriers affectées à un chantier
     */
    public static ArrayList<CarteOuvriers> getOuvriersOccupes(int idJoueur, ArrayList<CarteOuvriers> deck){
        ArrayList<CarteOuvriers> OuvriersOccupes = new ArrayList<>();
        for(int i=0;i< deck.size();i++){
            if(deck.get(i).getIdJoueur()==idJoueur && deck.get(i).getChantier()!=-1){
                OuvriersOccupes.add(deck.get(i));
            }
        }
        return OuvriersOccupes;
    }

    /**
     * Méthode permettant de savoir les batiments que le joueur possède
     * @param idJoueur le numéro du joueur
     * @param deck ArrayList contenant les cartes batiements
     * @return une ArrayList des batiments que le joueur possède
     */
    public static ArrayList<CarteBatiments> getChantiers(int idJoueur, ArrayList<CarteBatiments> deck) {
        ArrayList<CarteBatiments> Chantiers = new ArrayList<>();
        for(int i=0;i< deck.size();i++){
            if (deck.get(i).getIdJoueur() == idJoueur) {
                Chantiers.add(deck.get(i));
            }
        }
        return Chantiers;
    }
}
