package commun.batiments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteMachineTest {
    CarteMachine carteMachineTest = new CarteMachine(0, "testMachine", 1,1,1,1,0,1, 2,4,6,8);

    @Test
    public void getApportPierreTest(){
        assertEquals(2, carteMachineTest.getApportPierre());
    }

    @Test
    public void getApportBoisTest(){
        assertEquals(4, carteMachineTest.getApportBois());
    }

    @Test
    public void getApportSavoirTest(){
        assertEquals(6, carteMachineTest.getApportSavoir());
    }

    @Test
    public void getApportTuileTest(){
        assertEquals(8, carteMachineTest.getApportTuile());
    }
}