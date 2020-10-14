package deck;

import cartes.Cartes;
import org.junit.jupiter.api.Test;


public class TestDeck {
    // On fait un premier test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckBatiments() throws Exception {
        Deck deck1 = new Deck("batiment");
        Cartes [] deckBatiments = deck1.CreateDeck();
        Cartes carteTest = deckBatiments[6];
        System.out.print(carteTest);
    }
    // On fait un second test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckOuvriers() throws Exception {
        Deck deck1 = new Deck("ouvrier");
        Cartes [] deckOuvrier = deck1.CreateDeck();
        Cartes carteTest = deckOuvrier[10];
        System.out.print(carteTest);
    }


}
