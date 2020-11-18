package joueurs;

import cartes.batiments.CarteBatiments;
import moteurdejeu.MoteurDeJeu;


import java.util.ArrayList;

import static display.Couleur.ANSI_RED;
import static display.Couleur.ANSI_RESET;

/**
 * La classe Joueurs nous permet de créer les joueurs et d'avoir son numéro.
 */
public class Joueurs { // classe pour creer un joueur
    int id;
    // Pour compter les points de victoire
    private int points;
    Bourse bourseJoueur;

    /**
     *
     * @param id id du joueur
     */
    public Joueurs (int id){
        this.id = id;
        this.points = 0;
        // On lie notre joueur à une bourse
        bourseJoueur = new Bourse(id);
    }

    /**
     *
     * @return L'id du joueur
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return Renvoie une phrase permettant de visualiser l'objet joueur
     */
    @Override
    public String toString() {
        return "Joueurs{" +
                "id=" + id +
                '}';
    }

    /**
     * Fonction qui permet d'attribuer des points à un joueur après avoir fini un batiment par exemple
     * @param nbPoints Nombre de points à ajouter au joueur
     */
    public void addPoints(int nbPoints){
        System.out.println(ANSI_RED+"Attribution de points"+ANSI_RESET);
        this.points += nbPoints;
    }

    /**
     * Fonction qui permet de connaitre le nombre de point qu'un joueur possède
     * @return Retourne le nombre de point du joueur
     */
    public int getPoints(){
        return points;
    }


    /**
     * Permet de retourner l'objet joueur qui correspond à l'id donné
     * @param idJoueur ID du joueur qu'on veut recuperer
     * @return Retourne l'objet joueur qui correspond à l'ID
    **/
    static public Joueurs getJoueurById (int idJoueur){
        for (int i =0; i < MoteurDeJeu.nombreDeJoueurActifs; i++){
            if (MoteurDeJeu.listJoueurs.get(i).getId() == idJoueur){
                return MoteurDeJeu.listJoueurs.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @return retourne la bourse du joueur en question
     */
    public Bourse getBourseJoueur(){
        return bourseJoueur;
    }

}
