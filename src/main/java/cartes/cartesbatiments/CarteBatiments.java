package cartes.cartesbatiments;

import cartes.Cartes;
import cartes.findInDeck;

public class CarteBatiments extends Cartes { //Implemente les carte Batiments heritant Cartes


    int id,gainEcu,gainPoints,construit,idjoueur;
    int ouvrier;
    int nbOuvrier; // Compteur d'ouvriers posés sur le batiment : permet d'avoir l'indice du tableau "ouvriers[]"

    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    public static int[][] carteBat = {{0,0,1,1,0,8,0,0,0,0,0,0,-1},
            {1,1,0,0,1,8,0,0,0,0,0,0,-1}, {2,0,2,1,0,6,1,0,0,0,0,0,-1},
            {3,1,0,0,2,6,1,0,0,0,0,0,-1}, {4,0,1,0,2,8,0,0,0,0,0,0,-1},
            {5,2,0,1,0,6,1,0,0,0,0,0,-1}, {6,0,1,2,0,6,1,0,0,0,0,0,-1},
            {7,2,0,2,1,10,2,0,0,0,0,0,-1}, {8,2,1,0,2,10,2,0,0,0,0,0,-1}};

    public static String[] carteBatName = {"la cabane", "la tonnelle", "la cabane perchee", "la hutte de paille", "le lavoir", "le pont en pierre",
        "le pont couvert", "la maison urbaine", "la maisonnette"};

    public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre) {
        super(id, nom, bois, tuile, savoir, pierre);

        this.gainEcu = gainEcu;
        this.gainPoints = gainPoints;
        this.id = id;
    }

    /**
     * Méthode qui permet de changer le champ idJoueur d'un objet CarteBatiment (initialisé à -1)
     * @param idJoueur
     */
    public void AffectationChantier(int idJoueur){
        // this represente la carte qu'on passe : batiment1.AffectationChantier(id);
        this.idjoueur = idJoueur;
    }

    /**
     *
     * @return L'id du joueur
     */
    public int getIdjoueur(){
        return this.idjoueur;
    }

    /**
     *
     * @return L'id de la carte
     */
    public int getId(){
        return this.id;
    }

    /**
     *
     * @return L'id de l'ouvrier
     */
    public int getIdOuvrier(){
        return this.ouvrier;
    }

    /**
     * Affectation du champ ouvrier avec l'id; plus tard il nous faudra un tableau d'ouvrier à la place d'un int
     * @param ouvrier
     */
    public void AffectationOuvrierAChantier(int ouvrier){
        this.ouvrier = ouvrier;
    }

    /**
     *
     * @return Une phrase informant le joueur sur les batiments qu'il possède
     */
    public String toString(){
        return "\nCarte Batiment "+nom+", appartient au joueur "+(idjoueur+1);
    }

    /**
     *
     * @return Le nom du batiment
     */
    public String getName(){
        return this.nom;
    }


    /**
     * Méthode qui va constamment comparer les ressources du bâtiment et les ressources
     *         apportaient par les ouvriers qui travaillent sur ce bâtiment.
     * @return return 1 signifiant true
     */
    public int isBuilt(){
        // Compare le bois de l'objet ici (bâtiment) et le le bois de l'ouvrier qu'on trouve
        // on recupere l'id ouvrier avec "this.ouvrier", on trouve l'ouvrier à la position voulu
        // (qui pour le moment correspond à son id => à changer) dans le deckOuvrier "findInDeck.findOuvrierInDeck"
        // maintenant qu'on a l'objet ouvrier, on peut recuperer son bois avec "getBois()"
        if( this.getBois() <= findInDeck.findOuvrierInDeck(this.ouvrier).getBois()
            &&  this.getTuile() <= findInDeck.findOuvrierInDeck(this.ouvrier).getTuile()
            &&  this.getPierre() <= findInDeck.findOuvrierInDeck(this.ouvrier).getPierre()
            &&  this.getSavoir() <= findInDeck.findOuvrierInDeck(this.ouvrier).getSavoir()
        ){
            System.out.println("Le joueur "+ (this.idjoueur + 1) + " a terminé "+ this.getName());
            return 1;
        }
        return 0;
    }
}