package joueurs;

import cartes.batiments.CarteBatiments;
import cartes.batiments.DeckBatiments;
import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssets {

    private static ArrayList<CarteOuvriers> DeckOuvrier = new DeckOuvriers().getDeck();
    private static ArrayList<CarteBatiments> DeckBatiment = new DeckBatiments().getDeck();

    @Test
    public void testGetOuvriersDisponibles(){
        for(int i = 0; i<3;i++) {
            DeckOuvrier.get(i).resetAssign();
            MoteurDeJeu.choisirOuvrier(1, DeckOuvrier.get(i));
        }
        MoteurDeJeu.placerOuvrierSurChantier(DeckBatiment.get(0),DeckOuvrier.get(0));
        assertEquals(2,Assets.getOuvriersDisponibles(1,DeckOuvrier).size());
    }

    @Test
    public void testGetOuvriersOccupes(){
        for(int i = 0; i<3;i++) {
            DeckOuvrier.get(i).resetAssign();
            MoteurDeJeu.choisirOuvrier(1, DeckOuvrier.get(i));
        }
        MoteurDeJeu.placerOuvrierSurChantier(DeckBatiment.get(0),DeckOuvrier.get(0));
        MoteurDeJeu.placerOuvrierSurChantier(DeckBatiment.get(0),DeckOuvrier.get(1));
        assertEquals(2,Assets.getOuvriersOccupes(1,DeckOuvrier).size());
    }

    @Test
    public void testGetChantier(){
        for(int i = 0; i<3;i++) {
            MoteurDeJeu.choisirChantier(1, DeckBatiment.get(i));
        }
        assertEquals(3,Assets.getChantiers(1,DeckBatiment).size());
    }


}
