package joueurs;

//import joueurs.Joueurs;
import moteurdejeu.MoteurDeJeu;
import org.junit.jupiter.api.Test;

import static joueurs.Joueurs.getJoueurById;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

public class TestJoueurs { //Test sur la création d'un joueur
    /*
    @Test
    public void testJoueur() {
        TestSignature test = new TestSignature(Joueurs.class);

        test.publicConstructors(1);
        test.publicConstructor(int.class);
    }
    */
    @Test
    public void testGetId() {
        int a = ThreadLocalRandom.current().nextInt(0, 99);
       // Joueurs test = new Joueurs(a);
        Joueurs test2 = new Joueurs(a + 1); //crée un joueur test2

        assertEquals(test2.getId(), a + 1); //verifie si l'id aleatoire du joueur test2 est bien implementé
    }

    @Test
    public void testToString(){
        Joueurs test = new Joueurs(1);
        assertEquals(test.toString(), "Joueurs{" +
                "id=" + test.getId() +
                '}');
    }

    @Test
    public void testAddPoints(){
        Joueurs test = new Joueurs(1);
        test.addPoints(2);
        assertEquals(test.getPoints(), 2);
    }

    @Test
    public void testGetPoint(){
        Joueurs test = new Joueurs(1);
        assertEquals(test.getPoints(),0);
    }

    @Test
    public void testGetJoueurByID(){
        MoteurDeJeu m1 = new MoteurDeJeu();
        m1.creationDesJoueurs(4);
        for(int i = 0; i < MoteurDeJeu.nombreDeJoueurActifs; i++){
            assertEquals(getJoueurById(i),MoteurDeJeu.listJoueurs.get(i));
        }
    }
}
