package cartes;

import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.DeckOuvriers;
import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static moteurdejeu.MoteurDeJeu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCartes { //test le constructeur de cartes
    @Test
    public void testcartes(){
        int cond = 0;
        Cartes test = new Cartes(1,"test",1,2,3,4 );
        if (test.getIdCarte() == 1){ //verifie si l'id de carte est bien 1
            cond++;
        }

        if (test.getBois() == 1){ //verifie si parametre bois est bien implementé
            cond++;
        }

        if (test.getTuile() == 2){ //verifie si parametre tuile est bien implementé
            cond++;
        }

        if (test.getSavoir() == 3){ //verifie si parametre savoir est bien implementé
            cond++;
        }

        if (test.getPierre() == 4){ //verifie si parametre pierre est bien implementé
            cond++;
        }

        if (test.getNom().equals("test")){ //verifie si le nom est bien implementé
            cond++;
        }
        assertEquals(6, cond);

    }

    @Test
    public void TestCartesBatiments(){ //verifie création des Cartes Batiments
        int cond = 0;
        CarteBatiments b1 = new CarteBatiments(8,"foo",0,0,0,0,0,0);

        if (b1.getId() == 8){
            cond ++;
        }

        if (b1.getName().equals("foo")){
            cond++;
        }
        assertEquals(2, cond);
    }

    @Test
    public void TestCarteOuvrier(){
        int cond = 0;
        CarteOuvriers c1 = new CarteOuvriers(3,"toto",2,1,3,4,1,0,-1);

        if (c1.getId() == 3){
            cond++;
        }

        if (c1.getName().equals("toto")){
            cond++;
        }

        assertEquals(2, cond);
    }

    @Test
    public void TestIsBuilt(){
        MoteurDeJeu test= new MoteurDeJeu();
        test.creationDesJoueurs(1);
        CarteOuvriers c1 = new CarteOuvriers(3,"toto",2,1,3,4,1,0,-1);
        CarteBatiments b1 = new CarteBatiments(8,"foo",0,0,0,0,0,0);
        placerOuvrierSurChantier(b1,c1);
        assertEquals(true, b1.isBuilt());
    }

    @Test
    public void testGetCarteBatiment(){
        ArrayList<CarteBatiments> deck = new DeckBatiments().getDeck();
        assertEquals(5,CarteBatiments.getCarteBatById(5,deck).getIdCarte());
    }
    @Test

    public void testGetCarteOuvrier(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        assertEquals(7,CarteOuvriers.getCarteOuvById(7,deck).getIdCarte());
    }

    @Test
    public void testCarteSurTable(){
        ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
    }
}
