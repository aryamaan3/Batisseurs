package IA;

import java.util.ArrayList;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
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
        ArrayList<CarteChantier> cartes = new ArrayList<>();
        cartes.add(new CarteBatiments(0,"test1",1,5,4,4,3,9));
        cartes.add(new CarteBatiments(0,"test2",3,1,5,1,3,9));
        cartes.add(new CarteBatiments(0,"test3",1,1,1,1,3,9));
        cartes.add(new CarteBatiments(0,"test4",4,2,3,5,3,9));
        cartes.add(new CarteBatiments(0,"test5",7,4,2,2,3,9));
        iatest.choisitBatiment(1,cartes);
        assertEquals("test3",j1.getMainBat().get(0).getNom());
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
        assertEquals(4,iatest.getCompteur().getNombreAction());
    }

    @Test
    public void TestOuvrierIdeal(){
        ArrayList<CarteChantier> cartesBat = new ArrayList<>();
        cartesBat.add(new CarteBatiments(0,"test1",2,5,4,4,3,9));
        ArrayList<CarteOuvriers> cartesOuv = new ArrayList<>();
        cartesOuv.add(new CarteOuvriers(0,"ouv1",0,1,3,6,5));
        cartesOuv.add(new CarteOuvriers(1,"ouv2",0,1,2,3,5));
        cartesOuv.add(new CarteOuvriers(2,"ouv3",0,0,3,6,5));
        cartesOuv.add(new CarteOuvriers(3,"ouv4",0,2,5,4,5));
        Joueur j = new Joueur(0);
        Compteur c = new Compteur(0);
        IA ia = new IA(j, c);
        ia.choisitOuvrier(4, cartesOuv);
        //System.out.println("mainOuv");
        /*for (int i = 0; i < j.getMainOuv().size(); i++){
            System.out.println(j.getMainOuv().get(i).getIdCarte());
        }*/
        ia.choisitBatiment(1, cartesBat);

        int id = ia.idealOuvToChantier();
        assertEquals(3, j.getMainOuv().get(id).getIdCarte());
    }

    @Test
    public void TestPlusieursOuvrierIdeal(){
        ArrayList<CarteChantier> cartesBat = new ArrayList<>();
        cartesBat.add(new CarteBatiments(0,"test1",6,5,4,4,3,9));
        ArrayList<CarteOuvriers> cartesOuv = new ArrayList<>();
        cartesOuv.add(new CarteOuvriers(1,"ouv1",0,3,3,6,5));
        cartesOuv.add(new CarteOuvriers(2,"ouv2",0,1,2,3,5));
        cartesOuv.add(new CarteOuvriers(3,"ouv3",0,0,3,6,5));
        cartesOuv.add(new CarteOuvriers(4,"ouv4",0,3,5,4,5));
        Joueur j = new Joueur(0);
        Compteur c = new Compteur(0);
        IA ia = new IA(j, c);
        ia.choisitOuvrier(4, cartesOuv);
        ia.choisitBatiment(1, cartesBat);
        //on pose deux ouvriers sur le chantier
        ia.poserOuvrierSurChantier();

        //ia.poserOuvrierSurChantier();
        //System.out.println(j.getMainBat().get(0).getOuvriers());

        int id = ia.idealOuvToChantier();
        assertEquals(1, j.getMainOuv().get(id).getIdCarte());
    }

}
