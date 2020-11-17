package display;

import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;
import joueurs.IA;
import joueurs.Joueurs;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static display.Display.displayOuvriersDuJoueur;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDisplay {
    private static ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
    private static ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
    Joueurs test = new Joueurs(1);

    @Test
    public void TestdisplayOuvriersDuJoueur(){
    }

}
