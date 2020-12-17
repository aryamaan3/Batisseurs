package batiments;

import commun.batiments.CarteBatiments;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarteBatiments {
    CarteBatiments carteBat = new CarteBatiments(0,"batiment",2,3,6,5,9,5);
    CarteOuvriers carteOuv1 = new CarteOuvriers(0,"ouvrier1",4,3,2,1,5);
    CarteOuvriers carteOuv2 = new CarteOuvriers(1,"ouvrier2",5,6,4,2,4);
    CarteOuvriers carteOuv3 = new CarteOuvriers(2,"ouvrier3",5,3,4,7,6);

    @Test
    public void testAttribuerOuvrier(){
        carteBat.attribuerOuvrier(carteOuv1);
        assertEquals("ouvrier1",carteBat.getOuvriers().get(0).getNom());
    }
    @Test
    public void testGetSumRessources(){
        assertEquals(16,carteBat.getSumRessources());
    }

    @Test
    public void testlibererOuvrier(){
        carteBat.attribuerOuvrier(carteOuv1);
        carteBat.libererOuvrier();
        assertEquals(0,carteBat.getOuvriers().size());

    }
    @Test
    public void testGetSumBoisOuv(){
        carteBat.attribuerOuvrier(carteOuv1);
        carteBat.attribuerOuvrier(carteOuv2);
        assertEquals(6,carteBat.getSumBoisOuv());
    }

    @Test
    public void testGetSumPierreOuv(){
        carteBat.attribuerOuvrier(carteOuv1);
        carteBat.attribuerOuvrier(carteOuv2);
        assertEquals(9,carteBat.getSumPierreOuv());
    }
    @Test
    public void testGetSumTuileOuv(){
        carteBat.attribuerOuvrier(carteOuv1);
        carteBat.attribuerOuvrier(carteOuv2);
        assertEquals(9,carteBat.getSumTuileOuv());
    }
    @Test
    public void testGetSumSavoirOuv(){
        carteBat.attribuerOuvrier(carteOuv1);
        carteBat.attribuerOuvrier(carteOuv2);
        assertEquals(3,carteBat.getSumSavoirOuv());
    }

    @Test
    public void testIsMachine(){
        CarteBatiments carteTestMachine = new CarteBatiments(0, "testMachine", 1,1,1,1,0,1);
        CarteBatiments carteTestNotMachine = new CarteBatiments(1, "test", 1,1,1,1,1,1);
        assertTrue(carteTestMachine.isMachine());
        assertFalse(carteTestNotMachine.isMachine());
    }

    @Test
    public void getEcu(){
        assertEquals(9, carteBat.getEcu());
    }

    @Test
    public void setEcu(){
        carteBat.setEcu(2);
        assertEquals(2, carteBat.getEcu());
    }

    @Test
    public void getPoints(){

        assertEquals(5, carteBat.getPoints());
    }

    @Test
    public void setPoints(){
        carteBat.setPoints(3);
        assertEquals(3, carteBat.getPoints());
    }

    @Test
    public void isConstruit(){
        assertFalse(carteBat.isContruit());
        carteBat.setConstruit(true);
        assertTrue(carteBat.isContruit());
    }
    @Test
    public void setConstruit(){
        carteBat.setConstruit(true);
        assertTrue(carteBat.isContruit());
        carteBat.setConstruit(false);
        assertFalse(carteBat.isContruit());
    }

    @Test
    public void getOuvrier(){
        assertNotNull(carteBat.getOuvriers());
    }

    @Test
    public void isBuilt(){
        carteBat.attribuerOuvrier(carteOuv3);
        assertTrue(carteBat.isBuilt());
    }

}
