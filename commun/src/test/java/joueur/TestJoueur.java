package joueur;

import commun.batiments.CarteBatiments;
import commun.joueur.Bourse;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(true,joueur.actionAutorisee(carteOuv));

    }
}
