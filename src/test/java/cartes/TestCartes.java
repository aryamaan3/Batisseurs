package cartes;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import org.junit.jupiter.api.Test;
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
        //assertEquals("test", test);
    }

    @Test
    public void TestCartesBatiments(){ //verifie création des Cartes Batiments
        int cond = 0;
        CarteBatiments b1 = new CarteBatiments(8,"foo",0,0,0,0,0,0,0,-1, -1);

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
}
