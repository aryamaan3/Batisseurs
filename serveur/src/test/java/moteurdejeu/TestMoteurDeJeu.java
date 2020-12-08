package moteurdejeu;

import IA.IASmart;
import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.batiments.DeckBatiments;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import commun.ouvriers.DeckOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMoteurDeJeu {
    MoteurDeJeu m1 = new MoteurDeJeu();
    Joueur j1 = new Joueur(1);
    Compteur c1 = new Compteur();
    IASmart iaTest = new IASmart(j1,c1);

    @Test
    public void testCarteOuvriersSurTable(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckOuv.size());
    }
    @Test
    public void testCarteBatimentsSurTable(){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteChantier> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckBat.size());
    }
    @Test
    public void testFillCartesOuvriers(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesOuvriers(deckOuv,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
    @Test
    public void testFillCartesBatiments(){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteChantier> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesBatiments(deckBat,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
    @Test
    public void testIsBuild(){
        CarteBatiments carteBat = new CarteBatiments(0,"carteTest",1,2,5,4,6,9);
        carteBat.setConstruit(true);
        j1.getMainBat().add(carteBat);
        assertTrue(m1.isBuild(iaTest));
    }
    

}
