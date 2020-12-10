package IA;

import java.util.ArrayList;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIASmart {
    Joueur j1 = new Joueur(0);
    Compteur c1 = new Compteur();
    IA iatest = new IASmart(j1,c1);


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
        CarteBatiments carteBat = new CarteBatiments(0,"test2",3,1,5,1,3,9);
        cartes.add(new CarteOuvriers(0,"ouv1",1,2,0,3,1));
        cartes.add(new CarteOuvriers(1,"ouv2",1,1,1,6,5));
        cartes.add(new CarteOuvriers(2,"ouv3",1,1,1,2,0));
        iatest.getJoueur().ajouteBatiment(carteBat);
        iatest.choisitOuvrier(2,cartes);
        assertEquals("ouv3",j1.getMainOuv().get(1).getNom());
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
        Compteur c = new Compteur();
        IASmart ia = new IASmart(j, c);
        //System.out.println("mainOuv");
        /*for (int i = 0; i < j.getMainOuv().size(); i++){
            System.out.println(j.getMainOuv().get(i).getIdCarte());
        }*/
        ia.choisitBatiment(1, cartesBat);
        ia.choisitOuvrier(4, cartesOuv);

        int id = ia.idealOuvToChantier(j.getMainOuv());
        assertEquals(3, j.getMainOuv().get(id).getIdCarte());
    }

    @Test
    public void TestOuvrierIdealAvecCout(){

        ArrayList<CarteChantier> cartesBat = new ArrayList<>();
        cartesBat.add(new CarteBatiments(0,"test1",2,5,4,4,3,9));

        ArrayList<CarteOuvriers> cartesOuv = new ArrayList<>();
        cartesOuv.add(new CarteOuvriers(0,"ouv1",4,2,3,6,5));
        cartesOuv.add(new CarteOuvriers(1,"ouv2",9,1,2,3,5));
        cartesOuv.add(new CarteOuvriers(2,"ouv3",7,0,3,6,5));
        cartesOuv.add(new CarteOuvriers(3,"ouv4",8,2,5,4,5));

        Joueur j = new Joueur(0);
        Compteur c = new Compteur();
        IASmart ia = new IASmart(j, c);

        ia.getJoueur().getBourse().subEcus(3);
        assertEquals(7, ia.getJoueur().getBourse().getEcus());

        ia.choisitBatiment(1, cartesBat);
        ia.choisitOuvrier(4, cartesOuv);

        int id = ia.idealOuvToChantier(j.getMainOuv());
        assertEquals(0, j.getMainOuv().get(id).getIdCarte());
        //on verifie s'il choisie bien l'ouvrier 0 car c'est le plus rentable en termes d'utilité et de coût
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
        Compteur c = new Compteur();
        IASmart ia = new IASmart(j, c);
        ia.choisitBatiment(1, cartesBat);
        ia.choisitOuvrier(4, cartesOuv);
        //on pose deux ouvriers sur le chantier
        ia.poserOuvrierSurChantier();

        //ia.poserOuvrierSurChantier();
        //System.out.println(j.getMainBat().get(0).getOuvriers());

        int id = ia.idealOuvToChantier(j.getMainOuv());
        assertEquals(1, j.getMainOuv().get(id).getIdCarte());
    }

    @Test
    public void TestActionsIA (){
        assertEquals(10, j1.getBourse().getEcus()); // verifie que c'est bien 10
        ArrayList<CarteChantier> cartesBat = new ArrayList<>();
        cartesBat.add(new CarteBatiments(1,"bat1",6,5,4,4,3,9));
        cartesBat.add(new CarteBatiments(2,"bat2",6,5,4,4,3,9));
        cartesBat.add(new CarteBatiments(3,"bat3",6,5,4,4,3,9));
        ArrayList<CarteOuvriers> cartesOuv = new ArrayList<>();
        cartesOuv.add(new CarteOuvriers(1,"ouv1",1,3,3,6,5));
        cartesOuv.add(new CarteOuvriers(2,"ouv2",1,1,2,3,5));
        cartesOuv.add(new CarteOuvriers(3,"ouv3",1,0,3,6,5));
        cartesOuv.add(new CarteOuvriers(4,"ouv4",1,3,5,4,5));
        cartesOuv.add(new CarteOuvriers(5,"ouv5",1,3,5,4,5));
        cartesOuv.add(new CarteOuvriers(6,"ouv6",1,3,5,4,5));
        cartesOuv.add(new CarteOuvriers(7,"ouv7",1,3,5,4,5));
        iatest.actionIA(cartesOuv,cartesBat);
        assertEquals(0,iatest.getCompteur().getNombreAction()); // effectue 3 actions
        /* Les actions effectué sont : */
        assertEquals(1,j1.getMainBat().size()); // le joueur selectionne 1 carte bat
        assertEquals(2, j1.getMainOuv().size()); // le joueur selectionne 2 carte ouv
        /*––––––---–-––––*/
        c1.reset(); // on reste le compteur apres un tour
        iatest.actionIA(cartesOuv,cartesBat);

        // effectue 3 actions et on verifie si il y a bien 2 ouvriers posées
        /* Les actions effectué sont : */
        assertEquals(2, j1.getMainBat().get(0).getOuvriers().size()); // place 2 ouvriers sur le bat
        assertEquals(1, j1.getMainOuv().size()); // selctionne 1 carte ouv
        /*––––––---–-––––*/
        c1.reset(); // on reste le compteur apres un tour

        assertEquals(8, j1.getBourse().getEcus());
        j1.getBourse().addEcus(22);
        /*iatest.actionIA(cartesOuv,cartesBat);
        assertEquals(4,iatest.getCompteur().getNombreAction());*/
        //car le joueur a maintenant assez pour acheter des actions il en effectue 4

        iatest.actionIA(cartesOuv,cartesBat);
        assertEquals(23, j1.getBourse().getEcus());
        j1.getBourse().subEcus(20);


        //assertEquals(0,iatest.actionIA(cartesOuv, cartesBat)[0]);
        //il n'effectue pas d'actions car il n'a pas assez d'ecus, il les vends donc
        c1.reset();
        iatest.actionIA(cartesOuv,cartesBat);
        assertEquals(9, j1.getBourse().getEcus());
        // car le joueur achete 3 actions ce qui lui rapport 6 ecus
    }

}
