package cartes;

import cartes.Cartes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCartes { //test le constructeur de cartes
    @Test
    public void testcartes(){
        int cond = 0;
        Cartes test = new Cartes(1,"test",1,2,3,4 );
        if (test.getIdCarte().equals("test")){ //verifie si la carte test est bien crée
            cond++;
        }
        assertEquals(1, cond);
        //assertEquals("test", test);
    }
}
