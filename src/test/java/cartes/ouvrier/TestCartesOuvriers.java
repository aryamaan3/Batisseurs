package cartes.ouvrier;

import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import joueurs.Joueurs;
import org.junit.jupiter.api.Test;

import java.time.temporal.JulianFields;
import java.util.ArrayList;

import static cartes.ouvrier.CarteOuvriers.getApprenti;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCartesOuvriers {
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
    public void testAffectaionOuvrier(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
        DeckOuvrier.get(0).AffectationOuvrier(1);
        assertEquals(DeckOuvrier.get(0).getIdJoueur(),1);
    }

    @Test
    public void testGetIdJoueur(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvrier.get(0).getIdJoueur(), -1);
    }

    @Test
    public void testGetId(){
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvriers.get(0).getId(), 0);
    }

    @Test
    public void testGetCout(){
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvriers.get(0).getCout(),5);
    }

    @Test
    public void testGetAssign(){
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvriers.get(0).getAssign(), -1);
    }

    @Test
    public void testResetAssign(){
        ArrayList<CarteBatiments> DeckBatiments = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        DeckBatiments.get(0).AffectationOuvrierAChantier(DeckOuvriers.get(0).getId());
        DeckOuvriers.get(0).resetAssign();
        assertEquals(DeckOuvriers.get(0).getAssign(), -1);
    }

    @Test
    public void testGetChantier(){
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvriers.get(0).getChantier(),-1);
    }

    @Test
    public void testAffectationOuvrierAChantier(){
        ArrayList<CarteBatiments> DeckBatiments = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        DeckOuvriers.get(0).AffectationOuvrierAChantier(DeckBatiments.get(2).getId());
        assertEquals(DeckOuvriers.get(0).getChantier(),2);
    }

    @Test
    public void testGetApprenti(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        CarteOuvriers.getApprenti(1, deck);
        int cond = 0;

        for(int i = 36; i < 42; i++){
            if(deck.get(i).getIdJoueur() == 1){

                cond++;
            }
        }
        assertEquals(1, cond);
    }

    @Test
    public void testGetName(){
        ArrayList<CarteOuvriers> DeckOuvriers = new DeckOuvriers().getDeck();
        assertEquals(DeckOuvriers.get(0).getName(),"maitre");
    }

    @Test
    public void testCarteSurTable(){
        ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> CartesOuvrierSurTable = CarteOuvriers.carteSurTable(deck);
        for(int i=0;i<CartesOuvrierSurTable.size();i++){
            assertEquals(i,CartesOuvrierSurTable.get(i).getId());
        }
    }
}
