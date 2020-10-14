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
        Joueurs toto = new Joueurs(1);
        Cartes fofo = new Cartes(1, "eglise");
        MoteurDeJeu.piocher(toto, fofo);
        if(MoteurDeJeu.carteBatiment[Joueurs.getId()][0].getIdCarte().equals("eglise")){
            cond++;
        }
        assertEquals(1, cond);
    }
}
