package joueurs;

import joueurs.Joueurs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestJoueurs {
    /*
    @Test
    public void testJoueur() {
        TestSignature test = new TestSignature(Joueurs.class);

        test.publicConstructors(1);
        test.publicConstructor(int.class);
    }
    */
    @Test
    public void testgetId() {
        int a = ThreadLocalRandom.current().nextInt(0, 99);
        Joueurs test = new Joueurs(a);
        Joueurs test2 = new Joueurs(a + 1);

        assertEquals(test2.getId(), a + 1);
    }
}
