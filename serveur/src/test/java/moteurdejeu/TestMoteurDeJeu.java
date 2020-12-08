package moteurdejeu;

import IA.IA;
import IA.IASmart;
import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.batiments.DeckBatiments;
import commun.joueur.Compteur;
import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;
import commun.ouvriers.DeckOuvriers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMoteurDeJeu {
    MoteurDeJeu m1 = new MoteurDeJeu();
    Joueur j1 = new Joueur(1);
    Compteur c1 = new Compteur();
    IASmart iaTest = new IASmart(j1,c1);

    @Test
    public void testCarteOuvriersSurTable(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckOuv.size());
    }
    @Test
    public void testCarteBatimentsSurTable(){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteChantier> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        assertEquals(5,cartesSurTable.size());
        assertEquals(42-5,deckBat.size());
    }
    @Test
    public void testFillCartesOuvriers(){
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        ArrayList<CarteOuvriers> cartesSurTable = m1.carteOuvriersSurTable(deckOuv);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesOuvriers(deckOuv,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
    @Test
    public void testFillCartesBatiments(){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteChantier> cartesSurTable = m1.carteBatimentsSurTable(deckBat);
        cartesSurTable.remove(0);
        assertEquals(4,cartesSurTable.size());
        m1.fillCartesBatiments(deckBat,cartesSurTable);
        assertEquals(5,cartesSurTable.size());

    }
    @Test
    public void testIsBuild(){
        CarteBatiments carteBat = new CarteBatiments(0,"carteTest",1,2,5,4,6,9);
        carteBat.setConstruit(true);
        j1.getMainBat().add(carteBat);
        assertTrue(m1.isBuild(iaTest));
    }

    @Test
    public void Testapprenti(){
        ArrayList<CarteChantier> deckBat = new DeckBatiments().getDeck();
        ArrayList<CarteOuvriers> deckOuv = new DeckOuvriers().getDeck();
        Joueur j1 = new Joueur(1);
        Joueur j2 = new Joueur(2);
        Compteur c1 = new Compteur();
        Compteur c2 = new Compteur();
        ArrayList<IA> ia = new ArrayList<>();
        ia.add(new IASmart(j1,c1));
        ia.add(new IASmart(j2,c2));
        // On attribut automatiquement un apprenti par joueur
        // 6 apprentis dans le decks
        ArrayList<Integer> indiceApprentis = new ArrayList<>();
        // On boucle sur les indices du deck (qui a été shuffle)
        for(int i = 0; i < deckOuv.size() ; i++){
            if(deckOuv.get(i).getNom().equals("apprenti")){
                indiceApprentis.add(i);
            }
        }
        for(int i = 0; i < 2 ; i ++){
            // On prend à chaque fois le premier apprenti de la lite qui a été shuffle
            // Puis le deuxième joueur prendra le deuxième ...
            ia.get(i).getJoueur().ajouteOuvrier(deckOuv.get( indiceApprentis.get(i)) );
        }
        // On remove tous les apprentis qu'on a selectionné (les 4 premiers)
        deckOuv.remove( indiceApprentis.subList( 0, 4) );
        ia.get(0).choisitBatiment(1, deckBat);
        ia.get(0).choisitOuvrier(2, deckOuv);
        ia.get(0).poserOuvrierSurChantier();
        ia.get(0).poserOuvrierSurChantier();
        ia.get(0).poserOuvrierSurChantier();
        assertEquals(3,ia.get(0).getJoueur().getMainBat().get(0).getOuvriers().size());

    }

    @Test
    public void partieTest(){
        ArrayList<Joueur> joueur = new ArrayList<Joueur>();
        Joueur j2 = new Joueur(2);
        Joueur j3 = new Joueur(3);
        Joueur j4 = new Joueur(4);
        joueur.add(j1);
        joueur.add(j2);
        joueur.add(j3);
        joueur.add(j4);
        Joueur gagnant = m1.partie(joueur,false);
        assertEquals(true, gagnant instanceof Joueur);

        int idGagnant = gagnant.getId();
        boolean bonResultat = false;
        if (idGagnant == 1
                || idGagnant == 2
                || idGagnant == 3
                || idGagnant == 4){
            bonResultat = true;
        }
        assertEquals(true, bonResultat);

        // Un joueur doit au minimum avoir 17 points pour gagner
        int pointGagnant = gagnant.getPoints();
        boolean point = false;
        if(pointGagnant >= 17){
            point = true;
        }
        assertEquals(true, point);
    }

    @Test
    public void setDiplayIA(){
        ArrayList<IA> iaList = new ArrayList<IA>();
        iaList.add(iaTest);
        boolean displayBol;

        m1.setDisplayIA(false, iaList);
        displayBol = iaTest.getDisplay();
        assertEquals(false, displayBol);

        m1.setDisplayIA(true, iaList);
        displayBol = iaTest.getDisplay();
        assertEquals(true, displayBol);
    }
}
