import cartes.Cartes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCartes {
    @Test
    public void testcartes(){
        int cond = 0;
        Cartes test = new Cartes(1,"test" );
        if (test.getIdCarte().equals("test")){
            cond++;
        }
        assertEquals(1, cond);
        //assertEquals("test", test);
    }
}
