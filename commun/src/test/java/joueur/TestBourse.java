package joueur;

import commun.joueur.Bourse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBourse {
    Bourse bourse = new Bourse(0);

    @Test
    public void testAddEcus(){
       bourse.addEcus(10);
       assertEquals(20,bourse.getEcus());
    }

    @Test
    public void testSubEcus(){
        bourse.subEcus(5);
        assertEquals(5,bourse.getEcus());
    }
}
