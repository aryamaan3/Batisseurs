package cartes.cartesouvrier;

import cartes.Cartes;

import java.util.Random;

public class CarteOuvriers extends Cartes { //Implemente les cartes ouvriers heritant cartes
    private int cout;
    private int idjoueur, id;
    private int assign = -1; // Constiendra l'id du chantier qu'il est en train de construire et -1 si il est libre
    
    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile, int assign,int idjoueur) {
        super(id, nom , bois, tuile, savoir, pierre);
        this.cout = cout;
        this.id= id;
        this.idjoueur = idjoueur;
    }


    /**
     * Méthode qui permet de changer le champ idJoueur d'un objet CarteOuvrier (initialisé à -1)
     * @param idJoueur
     */
    public void AffectationOuvrier(int idJoueur){
        this.idjoueur = idJoueur;
    }

    /**
     *
     * @return L'id d'un joueur
     */
    public int getIdjoueur(){
        return this.idjoueur;
    }

    /**
     *
     * @return L'id d'une carte ouvrier
     */
    public int getId(){
        return this.id;
    }

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
     * @param chantier
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
                +", appartient au joueur "+idjoueur+"(-1 si il appartient à personne)"
                +" travaille sur le batiment "+ assign+"(-1 si pas assigné)";
    }

    public static void shuffle(CarteOuvriers[] c){
        Random gen = new Random();
        for (int i = c.length - 1; i > 0; i--){
            int indice = gen.nextInt(i + 1);
            // je swap
            CarteOuvriers a = c[indice];
            c[indice] = c[i];
            c[i] = a;
        }
    }

    /**
     *
     * @return Le nom de l'ouvrier
     */
    public String getName(){
        return this.nom;
    }
}
