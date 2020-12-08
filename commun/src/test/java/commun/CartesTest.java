package commun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartesTest {
    Cartes carte = new Cartes(0, "carte1",1,2,3,4);

    @Test
    void getBois() {
        assertEquals(2, carte.getBois());
    }

    @Test
    void getPierre() {
        assertEquals(1, carte.getPierre());
    }

    @Test
    void getSavoir() {
        assertEquals(3, carte.getSavoir());
    }

    @Test
    void getTuile() {
        assertEquals(4, carte.getTuile());
    }

    @Test
    void getIdCarte() {
        assertEquals(0, carte.getIdCarte());
    }

    @Test
    void getNom() {
        assertEquals("carte1", carte.getNom());
    }
}