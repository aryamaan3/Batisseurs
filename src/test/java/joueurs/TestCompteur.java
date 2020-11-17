package joueurs;

import joueurs.Compteur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompteur {

    @Test
    public void testCompteur(){
        Compteur c = new Compteur(0);
        c.actionsFait(2);
        assertEquals(1, c.nb);
        c.buyActions(3);
        assertEquals(4, c.nb);
        c.sellActions(2);
        assertEquals(2, c.nb);
    }
}
