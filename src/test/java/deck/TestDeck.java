package deck;

import cartes.Cartes;
import org.junit.jupiter.api.Test;


public class TestDeck {
    // On fait un premier test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckBatiments() throws Exception {
        Cartes[] deck = new Deck("batiment").getDeck();
        Cartes carteTest = deck[6];
        System.out.print(carteTest);
    }
    // On fait un second test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
  @Test
    public void testDeckOuvriers() throws Exception {
        Cartes[] deck = new Deck("ouvrier").getDeck();
        Cartes carteTest = deck[10];
        System.out.print(carteTest);
    }


}
