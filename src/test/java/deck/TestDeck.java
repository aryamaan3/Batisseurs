package deck;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import decks.Shuffle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


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
        Cartes carteTest = deck[9];
        System.out.print(carteTest);
    }

    @Test
    public void testShuffleOuvrier(){
        CarteOuvriers[] deck = new DeckOuvriers().getDeck();
        CarteOuvriers[] d2 = new DeckOuvriers().getDeck();
        //Shuffle.shuffleOuvrier(deck);
        CarteOuvriers.shuffle(deck); //on shuffle
        int cond = 0;
        /*System.out.println(deck[3]);
        System.out.println(d2[3]);*/
        if (deck[3] != d2[3] || deck[5] != d2[5] || deck[10] != d2[10]){
            cond++; //on verifie si deck est d2 sont differenciés à au moins un des trois conditions
        }
        assertEquals(1, cond);
    }

    @Test
    public void testShuffleBatiment(){
        CarteBatiments[] deck = new DeckBatiments().getDeck();
        CarteBatiments[] d2 = new DeckBatiments().getDeck();
        //Shuffle.shuffleOuvrier(deck);
        CarteBatiments.shuffle(deck); //on shuffle
        int cond = 0;
        /*System.out.println(deck[3]);
        System.out.println(d2[3]);*/
        if (deck[3] != d2[3] || deck[5] != d2[5] || deck[10] != d2[10]){
            cond++; //on verifie si deck est d2 sont differenciés à au moins un des trois conditions
        }
        assertEquals(1, cond);
    }

    @Test
    public void testGetApprenti(){
        CarteOuvriers[] deck = new DeckOuvriers().getDeck();
        //CarteOuvriers carteTest = deck[39];
        CarteOuvriers.getApprenti(1, deck);
        int cond = 0;

        for(int i = 36; i < 42; i++){
            System.out.println(deck[i]);
            if(deck[i].getIdjoueur() == 1){

                cond++;
            }
        }
        assertEquals(1, cond);
    }
}
