package IA;

import java.util.ArrayList;

import commun.batiments.CarteBatiments;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIA {
    Joueur j1 = new Joueur(0);
    Compteur c1 = new Compteur(j1.getId());
    IA iatest = new IA(j1,c1);

    @Test
    public void TestChoisitBatiment(){
        ArrayList<Object> cartes = new ArrayList<>();
        cartes.add(new CarteBatiments(0,"test1",1,5,4,4,3,9));
        cartes.add(new CarteBatiments(0,"test2",3,1,5,1,3,9));
        cartes.add(new CarteBatiments(0,"test3",5,3,1,3,3,9));
        cartes.add(new CarteBatiments(0,"test4",4,2,3,5,3,9));
        cartes.add(new CarteBatiments(0,"test5",1,4,2,2,3,9));
        iatest.choisitBatiment(1,cartes);
        assertEquals("test1",j1.getMainBat().get(0).getNom());
        assertEquals(1,j1.getMainBat().size());
    }
    @Test
    public void TestChoisitOuvrier(){
        ArrayList<CarteOuvriers> cartes = new ArrayList<>();
        cartes.add(new CarteOuvriers(0,"ouv1",1,2,3,6,5));
        cartes.add(new CarteOuvriers(1,"ouv2",1,2,3,6,5));
        cartes.add(new CarteOuvriers(2,"ouv3",1,2,3,6,5));
        iatest.choisitOuvrier(2,cartes);
        assertEquals("ouv2",j1.getMainOuv().get(1).getNom());
        assertEquals(2,j1.getMainOuv().size());
    }
    @Test
    public void TestPoserOuvrierSurChantier(){
        j1.getMainOuv().add(new CarteOuvriers(1,"ouv2",1,1,1,1,1));
        j1.getMainBat().add(new CarteBatiments(0,"test1",10,10,10,10,10,9));
        iatest.poserOuvrierSurChantier();
        assertEquals(1,j1.getMainBat().get(0).getOuvriers().size());
    }
    @Test
    public void TestPasseTour(){
        iatest.passeTour(1);
        assertEquals(11,j1.getBourse().getEcus());
    }
    @Test
    public void TestAjouteTour(){
        iatest.ajouteTour(1);
        assertEquals(5,j1.getBourse().getEcus());
        assertEquals(4,iatest.getCompteur().getNb());
    }

}
