package moteurdejeu;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;

import static moteurdejeu.MoteurDeJeu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestMoteur {
    
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
        CarteOuvriers[] OuvTest = CarteOuvriers.carteSurTable(DeckOuvrier);
        CarteBatiments[] BatTest = CarteBatiments.carteSurTable(DeckBatiment);
        placerOuvrierSurChantier(BatTest[2], OuvTest[3]);
        assertEquals(OuvTest[3].getAssign(),BatTest[2].getId());
    }

    @Test
    void TestChoisirChantier(){
        Joueurs toto = new Joueurs(1);
        CarteBatiments[] BatTest = CarteBatiments.carteSurTable(DeckBatiment);
        choisirChantier(1, BatTest[3]);
        assertEquals(toto.getId(),BatTest[3].getIdjoueur());
    }

    @Test
    void TestChoisirOuvirier(){
        Joueurs toto = new Joueurs(1);
        CarteOuvriers[] OuvTest = CarteOuvriers.carteSurTable(DeckOuvrier);
        choisirOuvrier(1, OuvTest[2]);
        assertEquals(toto.getId(), OuvTest[2].getIdjoueur());
    }
}
