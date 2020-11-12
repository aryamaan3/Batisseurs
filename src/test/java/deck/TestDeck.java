package deck;

import cartes.Cartes;
import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.DeckOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDeck {
  //On fait un premier test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckBatiments() {
        ArrayList<CarteBatiments> deck = new DeckBatiments().getDeck();
        Cartes carteTest = deck.get(6);
        assertEquals("la maisonnette",carteTest.getNom());
    }
    // On fait un second test pour vérifier qu'on récupère bien les cartes dans le deck des batiments
    @Test
    public void testDeckOuvriers() throws Exception {
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        Cartes carteTest = deck.get(9);
      assertEquals("compagnon",carteTest.getNom());
    }

    @Test
    public void testGetApprenti(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        //CarteOuvriers carteTest = deck[39];
        CarteOuvriers.getApprenti(1, deck);
        int cond = 0;

        for(int i = 36; i < 42; i++){
            System.out.println(deck.get(i));
            if(deck.get(i).getIdJoueur() == 1){

                cond++;
            }
        }
        assertEquals(1, cond);
    }

    @Test
    public void testCarteSurTableOuvrier(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> CartesOuvrierSurTable = CarteOuvriers.carteSurTable(deck);
        for(int i=0;i<CartesOuvrierSurTable.size();i++){
            assertEquals(i,CartesOuvrierSurTable.get(i).getId());
        }
    }

    @Test
    public void testCarteSurTableBatiment(){
        ArrayList<CarteBatiments> deck = new  DeckBatiments().getDeck();
        ArrayList<CarteBatiments> CartesBatimentSurTable =  CarteBatiments.carteSurTable(deck);
        for(int i=0;i<CartesBatimentSurTable.size();i++){
            assertEquals(i,CartesBatimentSurTable.get(i).getId());
        }
    }

}
