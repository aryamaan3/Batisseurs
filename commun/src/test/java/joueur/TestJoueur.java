package joueur;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.joueur.Bourse;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestJoueur {
    Joueur joueur = new Joueur(0);
    CarteBatiments carteBat = new CarteBatiments(0,"batiment1",2,3,5,4,6,8);
    CarteOuvriers carteOuv = new CarteOuvriers(0,"ouvrier",1,3,6,5,8);

    @Test
    public void testAjouteBatiment(){
        joueur.ajouteBatiment(carteBat);
        assertEquals(1, joueur.getMainBat().size());
        assertEquals("batiment1", joueur.getMainBat().get(0).getNom());
    }
    @Test
    public void testAjouteOuvrier(){
        joueur.ajouteOuvrier(carteOuv);
        assertEquals(1, joueur.getMainOuv().size());
        assertEquals("ouvrier", joueur.getMainOuv().get(0).getNom());

    }
    @Test
    public void testAttribuerOuvrierAChantier(){
        joueur.ajouteBatiment(carteBat);
        joueur.attribuerOuvrierAChantier(carteOuv, joueur.getMainBat().get(0));
        joueur.attribuerOuvrierAChantier(carteOuv, joueur.getMainBat().get(0));
        assertEquals("ouvrier", joueur.getMainBat().get(0).getOuvriers().get(0).getNom());
        assertEquals(2, joueur.getMainBat().get(0).getOuvriers().size());
        joueur.getBourse().subEcus(8);
        int test = joueur.attribuerOuvrierAChantier(carteOuv, joueur.getMainBat().get(0));
        assertEquals(0,test);
    }

    @Test
    public void testTrierBuiltBat(){
        carteBat.setConstruit(true);
        joueur.ajouteBatiment(carteBat);
        joueur.trierBuiltBat();
        assertEquals(1,joueur.getBuiltBat().size());
        assertEquals(carteBat,joueur.getBuiltBat().get(0));
    }
    @Test
    public void testActionAutorisee(){
        joueur.getBourse().addEcus(10);
        assertTrue(joueur.actionAutorisee(carteOuv));

    }
    @Test
    public void addPointsTest(){
        // aucun point
        assertEquals(0, joueur.getPoints());
        // ajout de point
        joueur.addPoints(19);
        assertEquals(19, joueur.getPoints());
    }
    @Test
    public void getBourseTest(){
        // A 10 ecus de base
        assertEquals(10, joueur.getBourse().getEcus());
    }
    @Test
    public void conversionEcuPointTest(){
        joueur.setPoints(0);
        assertEquals(10, joueur.getBourse().getEcus());
        joueur.getBourse().addEcus(11);
        assertEquals(21, joueur.getBourse().getEcus());
        // Le joueur a 0 point et 21 écus
        // Après cette fonction, on doit avoir +2 point et 1 écu
        joueur.conversionEcuPoint();
        assertEquals(1, joueur.getBourse().getEcus());
        assertEquals(2, joueur.getPoints());
    }

    @Test
    public void setBourseTest(){
        joueur.setBourse(new Bourse(0));
        boolean type;
        type = joueur.getBourse() != null;
        assertTrue(type);
    }
    @Test
    public void getIdTest(){
        assertEquals(0, joueur.getId());
    }
    @Test
    public void setIdTest(){
        joueur.setId(3);
        assertEquals(3, joueur.getId());
    }
    @Test
    public void getPointsTest(){
        assertEquals(0, joueur.getPoints());
        joueur.addPoints(2);
        assertEquals(2, joueur.getPoints());
    }
    @Test
    public void setPointsTest(){
        assertEquals(0, joueur.getPoints());
        joueur.addPoints(2);
        assertEquals(2, joueur.getPoints());
        joueur.setPoints(0);
        assertEquals(0, joueur.getPoints());
    }
    @Test
    public void getMainBat() {
        ArrayList<CarteChantier> deckChantier = joueur.getMainBat();
        assertNotNull(deckChantier);
    }
    @Test
    public void getMainOuv() {
        ArrayList<CarteOuvriers> deckOuvrier = joueur.getMainOuv();
        assertNotNull(deckOuvrier);
    }
    @Test
    public void getBuildBat() {
        ArrayList<CarteChantier> deckChantier = joueur.getBuiltBat();
        assertNotNull(deckChantier);
    }
}
