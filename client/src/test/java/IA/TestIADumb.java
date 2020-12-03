package IA;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIADumb {
    Joueur j1 = new Joueur(0);
    Compteur c1 = new Compteur(j1.getId());
    IA ia = new IADumb(j1,c1);

    @Test
    public void TestChoisitBatiment(){

        ArrayList<CarteChantier> cartes = new ArrayList<>();
        cartes.add(new CarteBatiments(0,"test1",1,5,4,4,3,9));
        cartes.add(new CarteBatiments(0,"test2",3,1,5,1,3,9));
        cartes.add(new CarteBatiments(0,"test3",1,1,1,1,3,9));
        cartes.add(new CarteBatiments(0,"test4",4,2,3,5,3,9));
        cartes.add(new CarteBatiments(0,"test5",7,4,2,2,3,9));
        ia.choisitBatiment(1,cartes);
        assertEquals("test1",j1.getMainBat().get(0).getNom());
        assertEquals(1,j1.getMainBat().size());
    }
    @Test
    public void TestChoisitOuvrier(){
        ArrayList<CarteOuvriers> cartes = new ArrayList<>();
        ia.choisitOuvrier(2,cartes);
        assertEquals(0,j1.getMainOuv().size());
        cartes.add(new CarteOuvriers(0,"ouv1",1,2,0,3,1));
        cartes.add(new CarteOuvriers(1,"ouv2",1,1,1,6,5));
        cartes.add(new CarteOuvriers(2,"ouv3",1,1,1,2,0));
        ia.choisitOuvrier(2,cartes);
        assertEquals("ouv1",j1.getMainOuv().get(0).getNom());
        assertEquals(2,j1.getMainOuv().size());
    }
    @Test
    public void TestPoserOuvrierSurChantier(){
        j1.getMainBat().add(new CarteBatiments(0,"test1",10,10,10,10,10,9));
        ia.poserOuvrierSurChantier();
        assertEquals(0,j1.getMainBat().get(0).getOuvriers().size());
        j1.getMainOuv().add(new CarteOuvriers(1,"ouv2",1,1,1,1,1));
        ia.poserOuvrierSurChantier();
        assertEquals(1,j1.getMainBat().get(0).getOuvriers().size());
    }
    @Test
    public void TestPasseTour(){
        ia.passeTour(1);
        assertEquals(11,j1.getBourse().getEcus());
    }
    @Test
    public void TestAjouteTour(){
        ia.ajouteTour(1);
        assertEquals(5,j1.getBourse().getEcus());
        assertEquals(4,ia.getCompteur().getNombreAction());
    }

    @Test
    public void TestActionsIA (){
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
        ia.actionIA(cartesOuv,cartesBat);
        assertEquals(0,ia.getCompteur().getNombreAction()); // effectue 3 actions
        /* Les actions effectué sont : */
        assertEquals(2,j1.getMainBat().size()); // le joueur selectionne 1 carte bat
        assertEquals(11, j1.getBourse().getEcus()); // le joueur passe un tour et gagne 1 écu
        /*––––––---–-––––*/
        c1.reset(); // on reste le compteur apres un tour
        ia.actionIA(cartesOuv,cartesBat);

        // effectue 3 actions et on verifie si il y a bien 2 ouvriers posées
        /* Les actions effectué sont : */
        assertEquals(12, j1.getBourse().getEcus()); // le joueur passe un tour et gagne 1 écu
        assertEquals(2, j1.getMainOuv().size()); // selctionne 2 carte ouv
        /*––––––---–-––––*/
        c1.reset(); // on reste le compteur apres un tour


        ia.actionIA(cartesOuv,cartesBat);
        assertEquals(1, j1.getMainBat().get(0).getOuvriers().size());
        assertEquals(14, j1.getBourse().getEcus()); // le joueur passe deux tours et gagne 3 écus

    }

}
