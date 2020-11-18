package cartes.batiments;

import cartes.Cartes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDeckBatiments {
    @Test
    public void testDeckBatiments() {
        ArrayList<CarteBatiments> deck = new DeckBatiments().getDeck();
        Cartes carteTest = deck.get(6);
        assertEquals("la pont couvert",carteTest.getNom());
    }
}
