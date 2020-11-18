package cartes.batiments;

import cartes.Cartes;
import cartes.ouvrier.CarteOuvriers;
import cartes.ouvrier.DeckOuvriers;
import joueurs.Joueurs;

import java.util.ArrayList;

/**
 * CarteBatiments contient des méthodes permettant la gestion des cartes batiments
 */

public class CarteBatiments extends Cartes { //Implemente les carte Batiments heritant Cartes


    private int gainEcu,gainPoints,construit, idJoueur;
    private ArrayList<Integer> ouvriers = new ArrayList<>();
    private int sumBois = 0, sumPierre = 0, sumTuile=0, sumSavoir=0;
    private int ecu;
    private int points;
    private ArrayList<CarteOuvriers> deck = new DeckOuvriers().getDeck();

    /**
     * Constructeur de Cartes Batiment avec des valeurs par défaut (idjoueur, ouvrier et construit)
     * @param id id de la carte
     * @param nom nom du batiment
     * @param pierre cout en pierre
     * @param bois cout en bois
     * @param savoir cout en savoir
     * @param tuile cout en savoir
     * @param ecu cout en ecu
     * @param points Points que rapporte la construction d'un batiment
     */
    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, bois, tuile, savoir, pierre);
        this.ecu = ecu;
        this.points = points;
        this.construit = 0; // 0 si pas encore construit et 1 si construit
        this.idJoueur = -1;
    }

    /**
     * Méthode qui permet de changer le champ idJoueur d'un objet CarteBatiment (initialisé à -1)
     * @param idJoueur i ddu joueur auquel on veu attribuer un chantier
     */
    public void AffectationChantier(int idJoueur){
        // this represente la carte qu'on passe : batiment1.AffectationChantier(id);
        this.idJoueur = idJoueur;
    }

    /**
     *
     * @return L'id du joueur
     */
    public int getIdJoueur(){
        return this.idJoueur;
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
        return "\nCarte Batiment "+nom+", appartient au joueur "+(idJoueur +1)+", ressources présentes : "
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
            this.sumBois += deck.get(this.ouvriers.get(i)).getBois();
            this.sumPierre += deck.get(this.ouvriers.get(i)).getPierre();
            this.sumTuile += deck.get(this.ouvriers.get(i)).getTuile();
            this.sumSavoir += deck.get(this.ouvriers.get(i)).getSavoir();
            // on recupere l'id ouvrier avec "this.ouvrier", on trouve l'ouvrier à la position voulu
            // (qui pour le moment correspond à son id => à changer) dans le deckOuvrier "findInDeck.findOuvrierInDeck"
            // maintenant qu'on a l'objet ouvrier, on peut recuperer son bois avec "getBois()"
        }
    }


    /**
     * Méthode qui va constamment comparer les ressources du bâtiment et les ressources
     *         apportaient par les ouvriers qui travaillent sur ce bâtiment.
     * @return return 1 signifiant true
     */
    public boolean isBuilt(){
        // Compare le bois de l'objet ici (bâtiment) et le le bois de l'ouvrier qu'on trouve
        sumRessources();
        if( this.getBois() <= this.sumBois
            &&  this.getTuile() <= this.sumTuile
            &&  this.getPierre() <= this.sumPierre
            &&  this.getSavoir() <= this.sumSavoir
        ){  //Notre batiment est contruit
            this.construit = 1;
            System.out.println("Le joueur "+ (this.idJoueur + 1) + " a terminé "+ this.getName());

            // On libère nos ouvriers quand le chantier est fini
            for (int i = 0; i < ouvriers.size(); i++) {
                deck.get(ouvriers.get(i)).resetAssign();
            }
            // On ajoute les points de la carte au points du joueur
            Joueurs.getJoueurById(idJoueur).addPoints(points);
            // On ajoute les ecus
            Joueurs.getJoueurById(idJoueur).getBourseJoueur().addEcus(ecu);
            return true;
        }
        return false;
    }

    /**
     * Permet juste de recupérer le boolean et non de recalculer comme isBuilt()
     * @return Boolean pour savoir si un chantier est fini ou non
     */
    public boolean isBuiltShort(){
        if(construit == 1){
            return true;
        }
        return false;
    }

    /**
     * Méthode retournant les 5 cartes se trouvant sur le plateau
     * @param c Collection de carte batiment
     * @return ArrayList des 5 cartes sur le plateau
     */
    public static ArrayList<CarteBatiments> carteSurTable(ArrayList<CarteBatiments> c){
        ArrayList<CarteBatiments> cst = new ArrayList<>();
        int i =0;
        int j =0;
        while(i< 5){
            if(c.get(j).idJoueur ==-1){
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
     * Permet d'obtenir une collection des cartes batiments qu'un joueur possède
     * @param idJoueur id joueur
     * @param DeckBatiment DeckBatiment du main
     * @return ArrayList contenant les batiments que le joueur possède
     */
    public static ArrayList<Integer> obtenirDeckJoueur(int idJoueur, ArrayList<CarteBatiments> DeckBatiment){
        ArrayList<Integer> carteDuJoueur = new ArrayList<>();
        for(int i = 0; i < DeckBatiment.size(); i ++){
            if(DeckBatiment.get(i).getIdJoueur() == idJoueur){
                carteDuJoueur.add(DeckBatiment.get(i).getId());
            }
        }
        return carteDuJoueur;
    }

    /**
     *
     * @param idJoueur id du joueur dont on veut récupérer le deck
     * @param DeckBatiment Deck du Moteur de jeu
     * @return Retourne la collection des chantiers en construction d'un joueur
     */
    public static ArrayList<CarteBatiments> obtenirChantierEnCours(int idJoueur, ArrayList<CarteBatiments> DeckBatiment){
        ArrayList<CarteBatiments> chantierEnCours = new ArrayList<>();
        for(int i = 0; i < DeckBatiment.size(); i ++){
            // Si une carte appartient au joueur et qu'elle n'est pas encore construite
            if( (DeckBatiment.get(i).getIdJoueur() == idJoueur) && !(DeckBatiment.get(i).isBuiltShort())){
                chantierEnCours.add(DeckBatiment.get(i));
            }
        }
        return chantierEnCours;
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

    /**
     *
     * @return Retourne le nombre de point que donne un chantier lorsqu'il est terminé
     */
    public int getPoint() {
        return points;
    }
}