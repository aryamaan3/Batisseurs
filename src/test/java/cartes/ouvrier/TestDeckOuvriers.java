package cartes.ouvrier;

import cartes.Cartes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDeckOuvriers {
    @Test
    public void testDeckOuvriers() throws Exception {
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        Cartes carteTest = deck.get(9);
        assertEquals("compagnon",carteTest.getNom());
    }
}
