package cartes.cartesouvrier;

import cartes.Cartes;

public class CarteOuvriers extends Cartes { //Implemente les cartes ouvriers heritant cartes
    private int cout;
    private int idjoueur, id;
    private int assign; // Constiendra l'id du chantier qu'il est en train de construire

    // le deuxième indice sert le type d'ouvrier pour l'instant 1 = maitre et 2 = compagnon
    // l'avant dernier indice indique si l'ouvrier est assigné ou pas à un batiment => -1 pas assigné,
    // sinon l'id du batiment auquel il est assigné
    public static int[][] carteOuv = {{0,1,5,0,0,2,3,-1,-1},{1,1,5,2,0,0,3,-1,-1},{2,1,5,3,0,0,2,-1,-1},
            {3,1,5,3,2,0,0,-1,-1},{4,1,5,0,3,2,0,-1,-1},{5,1,5,2,3,0,0,-1,-1},{6,1,5,0,2,3,0,-1,-1},
            {7,1,5,0,0,3,2,-1,-1},{8,2,4,3,1,0,0,-1,-1},{9,2,4,0,0,1,3,-1,-1},
            {10,2,4,1,0,3,0,-1,-1},{11,2,4,0,3,0,1,-1,-1},{12,2,4,2,0,0,2,-1,-1},
            {13,2,4,2,2,0,0,-1,-1},{14,2,4,2,0,2,0,-1,-1},{15,2,4,0,2,0,2,-1,-1},
            {16,2,4,0,2,2,0,-1,-1},{17,2,4,0,0,2,2,-1,-1},{18,2,4,0,1,1,2,-1,-1},
            {19,2,4,2,0,0,2,-1,-1}};

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
        return "Carte ouvrier "+nom+", appartient au joueur "+idjoueur+"(-1 si il appartient à personne)";
    }

    /**
     *
     * @return Le nom de l'ouvrier
     */
    public String getName(){
        return this.nom;
    }
}
