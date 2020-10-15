package deck;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import org.junit.jupiter.api.Test;


public class TestDeck {
  //On fait un premier test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckBatiments() {
        CarteBatiments[] deck = new DeckBatiments().getDeck();
        Cartes carteTest = deck[6];
        System.out.print(carteTest);
    }
    // On fait un second test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
  @Test
    public void testDeckOuvriers() throws Exception {
        CarteOuvriers[] deck = new DeckOuvriers().getDeck();
        Cartes carteTest = deck[10];
        System.out.print(carteTest);
    }


}
