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
    public void TestChoisir(){ //Tests sur les methodes d'attrinution de cartes
        CarteBatiments chantier = new CarteBatiments (1,"B1",0,0,0,0,0,0);
        //MoteurDeJeu.placerouvrier (j1, chantier, ouvrier);
        Joueurs j1 = new Joueurs(1);
        MoteurDeJeu.choisirChantier (j1.getId(), chantier); //on donne au j1 la carte chantier
        int cond = 0;
        if (chantier.getIdjoueur()==1){ //on regarde si la carte chantier appartient au joueur
            cond++;
        }
        assertEquals(1, cond);
        CarteOuvriers ouvrier = new CarteOuvriers(0,"ouvrier",2,1,3,4,1,0,-1);
        MoteurDeJeu.choisirOuvrier(j1.getId(), ouvrier); //on donne au j1 la carte ouvrier
        if (ouvrier.getIdjoueur() == 1){ //on regarde si la carte ouvrier appartient à j1
            cond++;
        }

        MoteurDeJeu.placerOuvrierSurChantier(chantier, ouvrier); //on place un ouvrier sur un chantier
        if (ouvrier.getChantier() == 1){ //on verifie si l'ouvrier est assigné au chantier
            cond++;
        }
        if (chantier.getIdOuvrier() == 0){ //on verifie si le chantier est assigné à l'ouvrier
            cond++;
        }
        assertEquals(4, cond); // si toute les conditions sont remplis le test est validé
    }
}
