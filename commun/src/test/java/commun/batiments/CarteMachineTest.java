package commun.batiments;

import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteMachineTest {
    CarteMachine carteMachineTest = new CarteMachine(42, "testMachine", 1,1,1,1,0,1, 2,4,6,8);

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

    @Test
    public void transformationEnOuvrier(){
        CarteOuvriers ouvrier = new CarteOuvriers(carteMachineTest.getIdCarte()+100,"test",0,2,4,6,8);
        // Le type de la carte ?
        CarteOuvriers newMachineAsOuvrier = carteMachineTest.transformationEnOuvrier();
        assertEquals(ouvrier.getClass(), newMachineAsOuvrier.getClass());
        assertEquals(ouvrier.getIdCarte(), newMachineAsOuvrier.getIdCarte());
        // Une machine a un cout de 0
        assertEquals(0, newMachineAsOuvrier.getCout());
        assertEquals(ouvrier.getPierre(), newMachineAsOuvrier.getPierre());
        assertEquals(ouvrier.getBois(), newMachineAsOuvrier.getBois());
        assertEquals(ouvrier.getSavoir(), newMachineAsOuvrier.getSavoir());
        assertEquals(ouvrier.getTuile(), newMachineAsOuvrier.getTuile());
    }
}