package plateau;

import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class TestPlateau {

    Plateau plateau = new Plateau();

    @Test
    public void testFillCartesBatiments(){
        plateau.carteBatimentsSurTable();
        plateau.getCartesBatSurTable().remove(0);
        assertEquals(4,plateau.getCartesBatSurTable().size());
        plateau.fillCartesBatiments();
        assertEquals(5,plateau.getCartesBatSurTable().size());
        assertNotEquals(plateau.getCartesBatSurTable().size(), 0);

        assertNotNull(plateau.getCartesBatSurTable().get(0));
    }

    @Test
    public void testCarteOuvriersSurTable(){
        plateau.carteOuvriersSurTable();
        assertEquals(5,plateau.getCartesOuvSurTable().size());
        assertEquals(42-5,plateau.getDeckOuvrier().size());
        assertNotEquals(plateau.getCartesOuvSurTable().size(), 0);

        assertNotNull(plateau.getCartesOuvSurTable().get(0));
        assertFalse(plateau.getCartesOuvSurTable().get(0) instanceof CarteChantier);
    }
    @Test
    public void testCarteBatimentsSurTable(){
        plateau.carteBatimentsSurTable();
        assertEquals(5,plateau.getCartesBatSurTable().size());
        assertEquals(42-5,plateau.getDeckBatiment().size());
        assertNotEquals(plateau.getCartesBatSurTable().size(), 0);

        assertNotNull(plateau.getCartesBatSurTable().get(0));
        assertFalse(plateau.getCartesBatSurTable().get(0) instanceof CarteOuvriers);
    }
    @Test
    public void testFillCartesOuvriers(){
        plateau.carteOuvriersSurTable();
        plateau.getCartesOuvSurTable().remove(0);
        assertEquals(4,plateau.getCartesOuvSurTable().size());
        plateau.fillCartesOuvriers();
        assertEquals(5,plateau.getCartesOuvSurTable().size());
        assertNotEquals(plateau.getCartesOuvSurTable().size(), 0);

        assertNotNull(plateau.getCartesOuvSurTable().get(0));
    }
}
