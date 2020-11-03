package moteurdejeu;

import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;

/**
 * Class pour afficher librement les variables
 */
public class TestAfficheVariable {
    public static void main(String[] args) {
        CarteBatiments bat = MoteurDeJeu.DeckBatiment.get(2);
        CarteOuvriers ouv = MoteurDeJeu.DeckOuvrier.get(3);

        bat.sumRessources();

        System.out.println(bat.toString());
        int[] b = bat.getIdOuvrier();
        System.out.println("Ouvrier n°1 : "+b[0]);
        System.out.println("Ouvrier n°2 : "+b[1]);

        System.out.println(ouv.toString());
    }
}
