package placer;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestPlacer {
   @Test
    public void TestChoisir(){
        CarteBatiments chantier = new CarteBatiments (1,"B1",0,0,0,0,0,0,0,-1, -1);
        //MoteurDeJeu.placerouvrier (j1, chantier, ouvrier);
        Joueurs j1 = new Joueurs(1);
        MoteurDeJeu.choisirChantier (j1, chantier);
        int cond = 0;
        if (chantier.getIdjoueur()==1){
            cond++;
        }
        assertEquals(1, cond);
        CarteOuvriers ouvrier = new CarteOuvriers(0,"ouvrier",2,1,3,4,1,0,-1);
        MoteurDeJeu.choisirOuvrier(j1, ouvrier);
        if (ouvrier.getIdjoueur() == 1){
            cond++;
        }

        MoteurDeJeu.placerOuvrierSurChantier(chantier, ouvrier);
        if (ouvrier.getChantier() == 1){
            cond++;
        }
        if (chantier.getIdOuvrier() == 0){
            cond++;
        }
        assertEquals(4, cond);
    }
}
