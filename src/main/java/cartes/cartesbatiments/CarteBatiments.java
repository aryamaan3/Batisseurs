package cartes.cartesbatiments;

import cartes.Cartes;
import cartes.findInDeck;

public class CarteBatiments extends Cartes { //Implemente les carte Batiments heritant Cartes


    int id,gainEcu,gainPoints,construit,idjoueur;
    int []ouvrier;    // Tableau car on veut avoir plusieurs ouvriers sur un chantier
    int nbOuvrier = 0; // Compteur d'ouvriers posés sur le batiment : permet d'avoir l'indice du tableau "ouvriers[]"
    int sumBois = 0, sumPierre = 0, sumTuile=0, sumSavoir=0;

    public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre) {
        super(id, nom, bois, tuile, savoir, pierre);

        this.gainEcu = gainEcu;
        this.gainPoints = gainPoints;
        this.id = id;
        this.construit = 0;
        this.idjoueur = -1;
        this.ouvrier[0] = -1;
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
    public int[] getIdOuvrier(){
        return this.ouvrier;
    }

    /**
     * Affectation du champ ouvrier avec l'id; plus tard il nous faudra un tableau d'ouvrier à la place d'un int
     * @param ouvrier
     */
    public void AffectationOuvrierAChantier(int ouvrier){
        this.ouvrier[nbOuvrier] = ouvrier;
        this.nbOuvrier ++;  // On incrémente ce compteur pour que le prochain ouvrier soit affecté à la bonne position
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
     * Méthode qui va sommer les ressources de tous les ouvriers présent sur un chantier
     * @return return la somme des ressources apportaient par les ouvriers
     */
    public void sumRessources(){
        // On réinitialise les sum pour ne pass additionner les anciennes au nouvelles !
        this.sumBois = 0;
        this.sumPierre = 0;
        this.sumTuile = 0;
        this.sumSavoir = 0;
        for (int i = 0; i < nbOuvrier; i++){
            this.sumBois += findInDeck.findOuvrierInDeck(this.ouvrier[i]).getBois();
            this.sumPierre += findInDeck.findOuvrierInDeck(this.ouvrier[i]).getPierre();
            this.sumTuile += findInDeck.findOuvrierInDeck(this.ouvrier[i]).getTuile();
            this.sumSavoir += findInDeck.findOuvrierInDeck(this.ouvrier[i]).getSavoir();
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
    public int isBuilt(){
        // Compare le bois de l'objet ici (bâtiment) et le le bois de l'ouvrier qu'on trouve
        if( this.getBois() <= this.sumBois
            &&  this.getTuile() <= this.sumTuile
            &&  this.getPierre() <= this.sumPierre
            &&  this.getSavoir() <= this.sumSavoir
        ){
            System.out.println("Le joueur "+ (this.idjoueur + 1) + " a terminé "+ this.getName());
            return 1;
        }
        return 0;
    }
}