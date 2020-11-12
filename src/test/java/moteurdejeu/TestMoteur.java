package moteurdejeu;

import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckBatiments;
import decks.DeckOuvriers;
import joueurs.Joueurs;
import org.junit.jupiter.api.Test;

import static moteurdejeu.MoteurDeJeu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class TestMoteur {
    private static ArrayList<CarteOuvriers> deckOuvrier = new DeckOuvriers().getDeck();
    private static ArrayList<CarteBatiments> deckBatiment= new DeckBatiments().getDeck();
    
    //@Test
    /*void TestPiocher (){
        int cond = 0;
        Joueurs toto = new Joueurs(1);
        Cartes fofo = new Cartes(1, "eglise",1,2,3,6);
        MoteurDeJeu.piocher(toto, fofo);
        if(MoteurDeJeu.CarteBatiments[Joueurs.getId()][0].getIdCarte().equals("eglise")){
            cond++;
        }
        assertEquals(1, cond);
    }*/

    @Test
    void TestPlacerOuvrierSurChantier(){
        ArrayList<CarteOuvriers> OuvTest = CarteOuvriers.carteSurTable(deckOuvrier);
        ArrayList<CarteBatiments> BatTest = CarteBatiments.carteSurTable(deckBatiment);
        placerOuvrierSurChantier(BatTest.get(2), OuvTest.get(3));
        assertEquals(OuvTest.get(3).getAssign(),BatTest.get(2).getId());
    }

    @Test
    void TestChoisirChantier(){
        Joueurs toto = new Joueurs(1);
        ArrayList<CarteBatiments> BatTest = CarteBatiments.carteSurTable(deckBatiment);
        choisirChantier(1, BatTest.get(3));
        assertEquals(toto.getId(),BatTest.get(3).getIdJoueur());
    }

    @Test
    void TestChoisirOuvirier(){
        Joueurs toto = new Joueurs(1);
        ArrayList<CarteOuvriers> OuvTest = CarteOuvriers.carteSurTable(deckOuvrier);
        choisirOuvrier(1, OuvTest.get(2));
        assertEquals(toto.getId(), OuvTest.get(2).getIdJoueur());
    }
}
