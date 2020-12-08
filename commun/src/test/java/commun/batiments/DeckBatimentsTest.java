package commun.batiments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckBatimentsTest {
    DeckBatiments deck = new DeckBatiments();

    @Test
    void nombreDeCarte(){
        assertEquals(42, deck.getSize());
    }
    @Test
    public void getSize(){
        assertEquals(42, deck.getSize());
    }
    @Test
    void getDeck() {
        assertEquals(true, deck.getDeck(1) instanceof ArrayList);
    }
}