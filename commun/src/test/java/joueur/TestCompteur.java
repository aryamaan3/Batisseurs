package joueur;

import commun.joueur.Compteur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompteur {
    Compteur compteur = new Compteur(0);

    @Test
    public void testActionsFait(){
        compteur.actionsFait(2);
        assertEquals(1,compteur.getNombreAction());
    }

    @Test
    public void testBuyActions(){
        compteur.buyActions(2);
        assertEquals(5,compteur.getNombreAction());
    }

    @Test
    public void testSellActions(){
        compteur.sellActions(1);
        assertEquals(2,compteur.getNombreAction());
    }

    @Test
    public void getNombreActionTest(){
        assertEquals(3,compteur.getNombreAction());
        compteur.sellActions(3);
        assertEquals(0,compteur.getNombreAction());
    }

    @Test
    public void resetTest(){
        compteur.sellActions(3);
        assertEquals(0,compteur.getNombreAction());
        compteur.reset();
        // On a de nouveau 3 actions normalement
        assertEquals(3,compteur.getNombreAction());

    }

}
