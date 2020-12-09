package batiments;

import commun.batiments.CarteMachine;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCarteMachine {
    CarteMachine carteMachine = new CarteMachine(34,"machine",1,0,0,2,0,2, 0, 0, 3, 0);

    @Test
    public void testGetApportBois(){
        assertEquals(0, carteMachine.getApportBois());
    }

    @Test
    public void testGetApportPierre(){
        assertEquals(0,carteMachine.getApportPierre());
    }

    @Test
    public void testGetApportSavoir(){
        assertEquals(3, carteMachine.getApportSavoir());
    }

    @Test
    public void testGetApportTuile(){
        assertEquals(0,carteMachine.getApportTuile());
    }

    @Test
    public void testTransformationEnOuvrier(){
        CarteOuvriers machine = carteMachine.transformationEnOuvrier();
        assertEquals("machine",machine.getNom());
        assertEquals(134, machine.getIdCarte());
        assertEquals(0,machine.getBois());
        assertEquals(0,machine.getPierre());
        assertEquals(3,machine.getSavoir());
        assertEquals(0,machine.getTuile());
        assertEquals(0,machine.getCout());
    }
}
