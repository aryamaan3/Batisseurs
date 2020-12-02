package commun.joueur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatistiquesTest {
    Statistiques stats = new Statistiques(0);
    @Test
    void getNbPoints() {
        assertEquals(0, stats.getNbPoints());
        stats.addPoints(2);
        assertEquals(2, stats.getNbPoints());
    }

    @Test
    void setNbPoints() {
        stats.addPoints(2);
        assertEquals(2, stats.getNbPoints());
        stats.setNbPoints(0);
        assertEquals(0, stats.getNbPoints());
    }

    @Test
    void addPoints() {
        assertEquals(0, stats.getNbPoints());
        stats.addPoints(42);
        assertEquals(42, stats.getNbPoints());
    }

    @Test
    void getNbEcus() {
        assertEquals(0, stats.getNbEcus());
        stats.addEcus(20);
        assertEquals(20, stats.getNbEcus());
    }

    @Test
    void setNbEcus() {
        stats.addEcus(20);
        assertEquals(20, stats.getNbEcus());
        stats.setNbEcus(0);
        assertEquals(0, stats.getNbEcus());
    }

    @Test
    void addEcus() {
        assertEquals(0, stats.getNbEcus());
        stats.addEcus(5);
        assertEquals(5, stats.getNbEcus());
    }

    @Test
    void getNbEcusDépensésOuv() {
        assertEquals(0, stats.getNbEcusDépensésOuv());
        stats.addEcusDépensésOuv(5);
        assertEquals(5, stats.getNbEcusDépensésOuv());
    }

    @Test
    void setNbEcusDépensésOuv() {
        stats.addEcusDépensésOuv(5);
        assertEquals(5, stats.getNbEcusDépensésOuv());
        stats.setNbEcusDépensésOuv(0);
        assertEquals(0, stats.getNbEcusDépensésOuv());
    }

    @Test
    void addEcusDépensésOuv() {
        assertEquals(0, stats.getNbEcusDépensésOuv());
        stats.addEcusDépensésOuv(5);
        assertEquals(5, stats.getNbEcusDépensésOuv());
    }

    @Test
    void getNbActionsRecrutement() {
        assertEquals(0, stats.getNbActionsRecrutement());
        stats.addActionsRecrutement(5);
        assertEquals(5, stats.getNbActionsRecrutement());
    }

    @Test
    void setNbActionsRecrutement() {
        stats.addActionsRecrutement(5);
        assertEquals(5, stats.getNbActionsRecrutement());
        stats.setNbActionsRecrutement(0);
        assertEquals(0, stats.getNbActionsRecrutement());
    }

    @Test
    void addActionsRecrutement() {
        assertEquals(0, stats.getNbActionsRecrutement());
        stats.addActionsRecrutement(5);
        assertEquals(5, stats.getNbActionsRecrutement());
    }

    @Test
    void getNbRevenusBat() {
        assertEquals(0, stats.getNbRevenusBat());
        stats.addRevenusBat(5);
        assertEquals(5, stats.getNbRevenusBat());
    }

    @Test
    void setNbRevenusBat() {
        stats.addRevenusBat(5);
        assertEquals(5, stats.getNbRevenusBat());
        stats.setNbRevenusBat(0);
        assertEquals(0, stats.getNbRevenusBat());
    }

    @Test
    void addRevenusBat() {
        assertEquals(0, stats.getNbRevenusBat());
        stats.addRevenusBat(5);
        assertEquals(5, stats.getNbRevenusBat());
    }

    @Test
    void getNbActionsTravailler() {
        assertEquals(0, stats.getNbActionsTravailler());
        stats.addActionsTravailler(5);
        assertEquals(5, stats.getNbActionsTravailler());
    }

    @Test
    void setNbActionsTravailler() {
        stats.addActionsTravailler(5);
        assertEquals(5, stats.getNbActionsTravailler());
        stats.setNbActionsTravailler(0);
        assertEquals(0, stats.getNbActionsTravailler());
    }

    @Test
    void addActionsTravailler() {
        assertEquals(0, stats.getNbActionsTravailler());
        stats.addActionsTravailler(5);
        assertEquals(5, stats.getNbActionsTravailler());
    }
}