package joueurs;

import cartes.Cartes;
import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIA {

    ArrayList<CarteBatiments> deckBat = new DeckBatiments().getDeck();
    ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
    Joueurs j1 = new Joueurs(0);
    IA test = new IA(j1, deckOuv, deckBat) ;

    @Test
    public void TestChoisitChantier(){
        test.iaChoisitChantier(1, 1);
        ArrayList<Integer> nb;
        nb = cartes.batiments.CarteBatiments.obtenirDeckJoueur(1, deckBat);
        assertEquals(1, nb.size());
    }

    @Test
    public void TestChoisitOuvrier(){
        test.iaChoisitOuvrier(1, 1);
        ArrayList<Integer> nb;
        nb = cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur(1, deckOuv);
        assertEquals(1, nb.size());
    }

    @Test
    public void TestAttribution(){
        test.iaChoisitChantier(1, 1);
        test.iaChoisitOuvrier(1, 1);
        test.iaAttributOuvrierAChantier(1);

        ArrayList<Integer> nbO;
        nbO = cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur(1, deckOuv);
        ArrayList<Integer> nbC;
        nbC = cartes.batiments.CarteBatiments.obtenirDeckJoueur(1, deckBat);

        CarteOuvriers testOuv = CarteOuvriers.getCarteOuvById(nbO.get(0), deckOuv);
        CarteBatiments testBat = CarteBatiments.getCarteBatById(nbC.get(0), deckBat);

        assertEquals(testOuv.getChantier(), testBat.getId());
        assertEquals(testOuv.getId(), testBat.getIdOuvrier().get(0));

    }
}
