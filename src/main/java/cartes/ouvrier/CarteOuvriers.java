package cartes.ouvrier;

import cartes.Cartes;
import cartes.batiments.CarteBatiments;
import display.Couleur.*;


import java.util.ArrayList;
import java.util.Random;

import static display.Couleur.*;

/**
 * CarteOuvriers contient des méthodes pour la gestion des cartes ouvriers
 */

public class CarteOuvriers extends Cartes { //Implemente les cartes ouvriers heritant cartes
    private int cout;
    private int idJoueur;
    private int assign = -1; // Constiendra l'id du chantier qu'il est en train de construire et -1 si il est libre
    
    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile, int assign,int idjoueur) {
        super(id, nom , bois, tuile, savoir, pierre);
        this.cout = cout;
        this.idJoueur = idjoueur;
    }


    /**
     * Méthode qui permet de changer le champ idJoueur d'un objet CarteOuvrier (initialisé à -1)
     * @param idJoueur id du joueur
     */
    public void AffectationOuvrier(int idJoueur){
        this.idJoueur = idJoueur;
    }

    /**
     *
     * @return L'id d'un joueur
     */
    public int getIdJoueur(){
        return this.idJoueur;
    }

    /**
     *
     * @return L'id d'une carte ouvrier
     */
    public int getId(){
        return super.id;
    }

    /**
     * getCout retourne le cout de l'ouvrier
     * @return le cout de l'ouvrier
     */
    public int getCout(){return this.cout;}

    /**
     *
     * @return Retourne l'id du chantier sur lequel il travaille ou -1 si il est libre
     */
    public int getAssign(){
        return this.assign;
    }

    /**
     * Est appelé dans isBuilt() quand un batiment est fini pour libérer l'ouvrier
     */
    public void resetAssign(){
        this.assign = -1;
        System.out.println(ANSI_RED + "L'ouvrier "+ id + " a été libéré" +ANSI_RESET);
    }

    /**
     *
     * @return Le chantier auquel est assigné l'ouvrier
     */
    public int getChantier(){
        return this.assign;
    }

    /**
     * On va remplacer le champs "assign" avec l'id de la carte chantier dont l'ouvrier s'occupe
     * @param chantier Chantier qui va etre choisi
     */
    public void AffectationOuvrierAChantier(int chantier){
        this.assign = chantier;
    }


    /**
     *
     * @return Une phrase informant le joueur sur les ouvriers qu'il possède
     */
    public String toString(){
        return "Carte ouvrier "+nom
                +", appartient au joueur "+(idJoueur)+"(-1 si il appartient à personne)"
                +" travaille sur le batiment "+ assign+"(-1 si pas assigné)";
    }
    /**
     *
     * Cette méthode prend aléatoirement un apprenti dans les apprentis possibles et l'assigne au joueur désiré
     * @param idJoueur le numéro du joueur auquel on assigne l'ouvrier.
     * @param c le tableau contenant les cartes apprenti.
     */
    public static void getApprenti(int idJoueur,  ArrayList<CarteOuvriers> c) {
        Random gen = new Random();
        int rand = gen.nextInt(6);
        c.get(36+rand).AffectationOuvrier(idJoueur);
    }
    
    /**
     *
     * @return Le nom de l'ouvrier
     */
    public String getName(){
        return super.nom;
    }


    //A Commenter
    public static  ArrayList<CarteOuvriers> carteSurTable(ArrayList<CarteOuvriers> c){
        ArrayList<CarteOuvriers> cst = new  ArrayList<>();
        int i =0;
        int j =0;
        while(i< 7){                        // Il y a 7 cartes pour le moment, car la 6ème carte du deck est nécessaire
            if(c.get(j).getIdJoueur()==-1){     // pour valider la condition de victoire.
                cst.add(c.get(j));
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cst;
    }

    /**
     *
     * @param idJoueur le numéro du joueur
     * @param DeckOuvrier le deck contenant les cartes ouvriers
     * @return Retourne un ArrayList d'int des id de toute les cartes que le joueur possède
     */
    public static ArrayList<Integer> obtenirDeckJoueur(int idJoueur, ArrayList<CarteOuvriers> DeckOuvrier){
        ArrayList<Integer> carteDuJoueur = new  ArrayList<>();
        for(int i = 0; i< DeckOuvrier.size(); i ++){
            if(DeckOuvrier.get(i).getIdJoueur() == idJoueur){
                carteDuJoueur.add(DeckOuvrier.get(i).getId());
            }
        }
        return carteDuJoueur;
    }

    /**
     *
     * @param idCarte le numéro de la carte
     * @param deck le deck contenant les cartes ouvriers
     * @return carte qui a l'id donnée en param
     */
    public static CarteOuvriers getCarteOuvById (int idCarte, ArrayList<CarteOuvriers> deck){
        CarteOuvriers Carte = null;
        for (int i = 0; i < deck.size(); i++){
            if (deck.get(i).getId() == idCarte){
                Carte = deck.get(i);
            }
        }
        return Carte;}
}
