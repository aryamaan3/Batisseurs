package batiments;

import commun.batiments.CarteBatiments;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarteBatiments {
    CarteBatiments carteBat = new CarteBatiments(0,"batiment",2,3,6,5,9,5);
    CarteOuvriers carteOuv1 = new CarteOuvriers(0,"ouvrier1",4,3,2,1,5);
    CarteOuvriers carteOuv2 = new CarteOuvriers(1,"ouvrier2",5,6,4,2,4);

    @Test
    public void testAttribuerOuvrier(){
        carteBat.attribuerOuvrier(carteOuv1);
        assertEquals("ouvrier1",carteBat.getOuvriers().get(0).getNom());
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
}
