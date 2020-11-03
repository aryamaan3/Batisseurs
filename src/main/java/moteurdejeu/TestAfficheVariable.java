package moteurdejeu;

import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;

import java.util.ArrayList;

/**
 * Class pour afficher librement les variables
 */
public class TestAfficheVariable {
    public static void main(String[] args) {
        CarteBatiments bat = MoteurDeJeu.DeckBatiment.get(2);
        CarteOuvriers ouv = MoteurDeJeu.DeckOuvrier.get(3);

        bat.sumRessources();

        System.out.println(bat.toString());
        ArrayList<Integer> b = bat.getIdOuvrier();
        System.out.println("Ouvrier n°1 : "+b.get(0));
        System.out.println("Ouvrier n°2 : "+b.get(1));

        System.out.println(ouv.toString());
    }
}
