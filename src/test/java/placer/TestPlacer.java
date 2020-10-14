package placer;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestPlacer {
   @Test
    public void testchoisir(){
        CarteBatiments chantier = new CarteBatiments (1,"B1",0,0,0,0,0,0,0,-1);
        //MoteurDeJeu.placerouvrier (j1, chantier, ouvrier);
        MoteurDeJeu.choisirChantier (1, chantier);
        int cond = 0;
        if (chantier.getIdjoueur()==1){
            cond++;
        }
        assertEquals(1, cond);
    }
}
