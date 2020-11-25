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
}
