package cartes.batiments;

import cartes.*;
import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;
import joueurs.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static cartes.batiments.CarteBatiments.getCarteBatById;
import static cartes.batiments.CarteBatiments.obtenirDeckJoueur;
import static moteurdejeu.MoteurDeJeu.placerOuvrierSurChantier;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCarteBatiments {
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
    public void testAffectationChantier(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        DeckBatiment.get(0).AffectationChantier(1);
        assertEquals(DeckBatiment.get(0).getIdJoueur(),1);

    }

    @Test
    public void testGetIdJoueur(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(DeckBatiment.get(0).getIdJoueur(), -1);
    }

    @Test
    public void testGetId(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(DeckBatiment.get(0).getId(), 0);
    }

    @Test
    public void testGetIdOuvrier(){
        ArrayList<Integer> ouvriers = new ArrayList<>();
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(DeckBatiment.get(0).getIdOuvrier(), ouvriers);

    }

    /*@Test
    public void testAffectationOuvrierAChantier(){
        ArrayList<Integer> ouvriers = new ArrayList<>();
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        DeckBatiment.get(0).AffectationOuvrierAChantier(ouvriers.get(0));
        assertEquals(DeckBatiment.get(0).getIdOuvrier(),1);
    }*/

    @Test
    public void testGetName(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(DeckBatiment.get(0).getName(),"la cabane");
    }

    @Test
    public void testSumRessources(){
        //A faire
    }

    @Test
    public void testIsBuilt(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
        placerOuvrierSurChantier(DeckBatiment.get(0),DeckOuvrier.get(0));
        assertEquals(false, DeckBatiment.get(0).isBuiltShort());
    }

    @Test
    public void testIsBuildShort(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
        placerOuvrierSurChantier(DeckBatiment.get(0),DeckOuvrier.get(0));
        assertEquals(false, DeckBatiment.get(0).isBuiltShort());
    }

    @Test
    public void testCarteSurTable(){
        ArrayList<CarteBatiments> deck = new  DeckBatiments().getDeck();
        ArrayList<CarteBatiments> CartesBatimentSurTable =  CarteBatiments.carteSurTable(deck);
        for(int i=0;i<CartesBatimentSurTable.size();i++){
            assertEquals(i,CartesBatimentSurTable.get(i).getId());
        }
    }

    @Test
    public void testObtenirDeckJoueur(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        ArrayList<InternalError> a = new ArrayList<>();
        assertEquals(obtenirDeckJoueur(1,DeckBatiment),a);// Mis 1 pour essayer mais le est ne passe pas : java: illegal start of type
    }

    @Test
    public void testObtenirChantierEncours(){
        Joueurs test = new Joueurs(1);
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        ArrayList<InternalError> a = new ArrayList<>();
        assertEquals(obtenirDeckJoueur(1,DeckBatiment),a);
    }

    @Test
    public void testGetCarteBatById(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(getCarteBatById(1,DeckBatiment),DeckBatiment.get(1));
    }

    @Test
    public void testGetPoint(){
        ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();
        assertEquals(DeckBatiment.get(0).getPoint(),0);
    }
}
