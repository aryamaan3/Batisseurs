package commun.ouvriers;

import commun.batiments.CarteBatiments;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteOuvriersTest {
    CarteOuvriers carteOuv = new CarteOuvriers(0,"maitre",4,3,2,1,5);
    CarteBatiments carteBat = new CarteBatiments(0,"batiment",2,3,6,5,9,5);

    @Test
    void getCout() {
        assertEquals(4, carteOuv.getCout());
    }

    @Test
    void setCout() {
        assertEquals(4, carteOuv.getCout());
        carteOuv.setCout(1);
        assertEquals(1, carteOuv.getCout());
    }

    @Test
    void isBusy() {
        assertEquals(false, carteOuv.isBusy());
        carteBat.attribuerOuvrier(carteOuv);
        assertEquals(true, carteOuv.isBusy());
    }

    @Test
    void setAssign() {
        carteBat.attribuerOuvrier(carteOuv);
        carteOuv.setAssign(false);
        assertEquals(false, carteOuv.isBusy());
    }
}