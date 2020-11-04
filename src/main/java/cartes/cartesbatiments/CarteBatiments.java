package cartes.cartesbatiments;

import cartes.Cartes;
import moteurdejeu.MoteurDeJeu;
import java.util.ArrayList;
import java.util.Random;

public class CarteBatiments extends Cartes { //Implemente les carte Batiments heritant Cartes


    int gainEcu,gainPoints,construit,idjoueur;
    int []ouvrier = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};    // Tableau car on veut avoir plusieurs ouvriers sur un chantier, limite arbitraire de 10 ouvrier sur un chantier
    ArrayList<Integer> ouvriers = new ArrayList<>();
    int nbOuvrier = 0; // Compteur d'ouvriers posés sur le batiment : permet d'avoir l'indice du tableau "ouvriers[]"
    int sumBois = 0, sumPierre = 0, sumTuile=0, sumSavoir=0;
    int ecu;
    int points;

    /**
     * Constructeur de Cartes Batiment avec des valeurs par défaut (idjoueur, ouvrier et construit)
     * @param id id de la carte
     * @param nom nom du batiment
     * @param pierre cout en pierre
     * @param bois cout en bois
     * @param savoir cout en savoir
     * @param tuile cout en savoir
     * @param ecu cout en ecu
     * @param points cout en points
     */
    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, bois, tuile, savoir, pierre);
        this.ecu = ecu;
        this.points = points;
        this.construit = 0;
        this.idjoueur = -1;
    }

    /**
     * Méthode qui permet de changer le champ idJoueur d'un objet CarteBatiment (initialisé à -1)
     * @param idJoueur i ddu joueur auquel on veu attribuer un chantier
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
        return super.id;
    }

    /**
     *
     * @return L'id de l'ouvrier
     */
    public ArrayList<Integer> getIdOuvrier(){
        return this.ouvriers;
    }

    /**
     * Affectation du champ ouvrier avec l'id; plus tard il nous faudra un tableau d'ouvrier à la place d'un int
     * @param ouvrier ouvrier qu'on veut affecter au chantier
     */
    public void AffectationOuvrierAChantier(int ouvrier){
       ouvriers.add(ouvrier);
    }

    /**
     *
     * @return Une phrase informant le joueur sur les batiments qu'il possède
     */
    public String toString(){
        return "\nCarte Batiment "+nom+", appartient au joueur "+(idjoueur+1)+", ressources présentes : "
                + "\n - bois : " + this.sumBois + "  (besoin : "+ this.bois +")"
                + "\n - pierre : " + this.sumPierre + "  (besoin : "+ this.pierre +")"
                + "\n - tuile : " + this.sumTuile + "    (besoin : "+ this.tuile +")"
                + "\n - savoir : " + this.sumSavoir + "  (besoin : "+ this.savoir +")";
    }

    /**
     *
     * @return Le nom du batiment
     */
    public String getName(){
        return super.nom;
    }

    /**
     * Méthode qui va sommer les ressources de tous les ouvriers présent sur un chantier
     */
    public void sumRessources(){
        // On réinitialise les sum pour ne pas additionner les anciennes au nouvelles !
        this.sumBois = 0;
        this.sumPierre = 0;
        this.sumTuile = 0;
        this.sumSavoir = 0;
        for (int i = 0; i < ouvriers.size(); i++){
            this.sumBois += MoteurDeJeu.DeckOuvrier.get(this.ouvriers.get(i)).getBois();
            this.sumPierre += MoteurDeJeu.DeckOuvrier.get(this.ouvriers.get(i)).getPierre();
            this.sumTuile += MoteurDeJeu.DeckOuvrier.get(this.ouvriers.get(i)).getTuile();
            this.sumSavoir += MoteurDeJeu.DeckOuvrier.get(this.ouvriers.get(i)).getSavoir();
            // on recupere l'id ouvrier avec "this.ouvrier", on trouve l'ouvrier à la position voulu
            // (qui pour le moment correspond à son id => à changer) dans le deckOuvrier "findInDeck.findOuvrierInDeck"
            // maintenant qu'on a l'objet ouvrier, on peut recuperer son bois avec "getBois()"
        }
    }

    public int getSum(String type){
        return switch (type) {
            case "bois" -> (this.sumBois);
            case "pierre" -> (this.sumPierre);
            case "tuile" -> (this.sumTuile);
            case "savoir" -> (this.sumSavoir);
            default -> 0;
        };
    }

    /**
     * Méthode qui va constamment comparer les ressources du bâtiment et les ressources
     *         apportaient par les ouvriers qui travaillent sur ce bâtiment.
     * @return return 1 signifiant true
     */
    public int isBuilt(){
        // Compare le bois de l'objet ici (bâtiment) et le le bois de l'ouvrier qu'on trouve
        sumRessources();
        if( this.getBois() <= this.sumBois
            &&  this.getTuile() <= this.sumTuile
            &&  this.getPierre() <= this.sumPierre
            &&  this.getSavoir() <= this.sumSavoir
        ){
            System.out.println("Le joueur "+ (this.idjoueur + 1) + " a terminé "+ this.getName());

            // On libère nos ouvriers quand le chantier est fini
            for (int i = 0; i < nbOuvrier; i++) {
                MoteurDeJeu.DeckOuvrier.get(this.ouvrier[i]).resetAssign();
            }
            return 1;
        }
        return 0;
    }
    public static ArrayList<CarteBatiments> carteSurTable(ArrayList<CarteBatiments> c){
        ArrayList<CarteBatiments> cst = new ArrayList<>();
        int i =0;
        int j =0;
        while(i< 5){
            if(c.get(j).idjoueur==-1){
                cst.add(c.get(j));
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cst;
    }

    public static ArrayList<Integer> obtenirDeckJoueur(int idJoueur, ArrayList<CarteBatiments> DeckBatiment){
        ArrayList<Integer> carteDuJoueur = new ArrayList<>();
        for(int i = 0; i < DeckBatiment.size(); i ++){
            if(DeckBatiment.get(i).getIdjoueur() == idJoueur){
                carteDuJoueur.add(DeckBatiment.get(i).getId());
            }
        }
        return carteDuJoueur;
    }

    /**
     *
     * @param idCarte le numéro de la carte
     * @param deck le deck contenant les cartes batiments
     * @return carte qui a l'id donnée en param
     */
    public static CarteBatiments getCarteBatById (int idCarte, ArrayList<CarteBatiments> deck){
        CarteBatiments Carte = null;
        for (int i = 0; i < deck.size(); i++){
            if (deck.get(i).getId() == idCarte){
                Carte = deck.get(i);
            }
        }
        return Carte;}

}