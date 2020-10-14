package moteurdejeu;

import cartes.Cartes;
import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestMoteur {
    
    @Test
    void TestPiocher (){
        int cond = 0;
        Joueurs toto = new Joueurs(2);
        Cartes fofo = new Cartes(2, "eglise",2,6,9,5);
        MoteurDeJeu.piocher(toto, fofo);
        if(MoteurDeJeu.DeckJoueur[toto.getId()][0].getIdCarte().equals("eglise")){
            cond++;
        }
        assertEquals(1, cond);
    }
}
