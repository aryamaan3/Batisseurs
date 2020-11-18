package cartes;

import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.DeckOuvriers;
import joueurs.Joueurs;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static moteurdejeu.MoteurDeJeu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCartes { //test le constructeur de cartes
    @Test
    public void testcartes(){
        int cond = 0;
        Cartes test = new Cartes(1,"test",1,2,3,4 );
        if (test.getIdCarte() == 1){ //verifie si l'id de carte est bien 1
            cond++;
        }

        if (test.getBois() == 1){ //verifie si parametre bois est bien implementé
            cond++;
        }

        if (test.getTuile() == 2){ //verifie si parametre tuile est bien implementé
            cond++;
        }

        if (test.getSavoir() == 3){ //verifie si parametre savoir est bien implementé
            cond++;
        }

        if (test.getPierre() == 4){ //verifie si parametre pierre est bien implementé
            cond++;
        }

        if (test.getNom().equals("test")){ //verifie si le nom est bien implementé
            cond++;
        }
        assertEquals(6, cond);

    }

    @Test
    public void testGetBois_Pierre_Savoir_Tuile_IdCarte_Nom_(){
        Cartes test = new Cartes(1,"test",1,2,3,4 );
        assertEquals(test.getBois(),1);
        assertEquals(test.getIdCarte(),1);
        assertEquals(test.getNom(),"test");
        assertEquals(test.getPierre(),4);
        assertEquals(test.getTuile(), 2);
        assertEquals(test.getSavoir(), 3);
    }


}
