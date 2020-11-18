package joueurs;

import cartes.ouvrier.CarteOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static cartes.ouvrier.CarteOuvriers.getCarteOuvById;
import static cartes.ouvrier.CarteOuvriers.obtenirDeckJoueur;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestBourse {
    Bourse BourseTest = new Bourse(1);
    ArrayList<CarteOuvriers> deck = new ArrayList<>();
    int idJoueur = 0;
    int idCarte = 0;

    @Test
    public void testGetEcus(){
        int bourse = BourseTest.getEcus();
        assertEquals(10,bourse);
    }

    @Test
    public void testActionAutorisee(){
        deck.add(new CarteOuvriers(0, "maitre", 5, 0, 0, 2, 3, -1, 0));
        ArrayList<Integer> idCarteOuvrierDuJoueur = obtenirDeckJoueur(idJoueur, deck);
        assertTrue(getCarteOuvById(idCarteOuvrierDuJoueur.get(idCarte),deck).getCout() <= BourseTest.getEcus());
    }

    @Test
    public void testAddEcus(){
        BourseTest.addEcus(5);
        assertEquals(15,BourseTest.getEcus());
    }

}
