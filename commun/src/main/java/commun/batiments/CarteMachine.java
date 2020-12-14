package commun.batiments;

import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;

import static commun.display.Couleur.ANSI_PURPLE;
import static commun.display.Couleur.ANSI_RESET;

/**
 * Classe fille de CarteBatiment :
 *  Une machine est un batiment avec quelques paramètres en plus (des ressources qui seront apportées à un chantier)
 */
public class CarteMachine extends CarteBatiments implements CarteChantier{
    // Ressources que la machine apportera à un chantier lorsqu'elle sera utilisée comme un ouvrier
    protected int apportPierre, apportBois, apportSavoir, apportTuile;

    /**
     * Constructeur pour la classe CarteMachine, on crée les cartes en y associant leurs caractéristiques
     * @param id le numéro de la carte
     * @param nom le nom de la carte
     * @param pierre le nombre de pierre que la carte bâtiment a besoin pour sa construction
     * @param bois le nombre de bois que la carte bâtiment a besoin pour sa construction
     * @param savoir le nombre de savoir que la carte bâtiment a besoin pour sa construction
     * @param tuile le nombre de tuile que la carte bâtiment a besoin pour sa construction
     * @param ecu le nombre d'écus que le bâtiment rapporte une fois fini
     * @param points le nombre de points que le bâtiment rapporte une fois fini
     * @param apportPierre le nombre de pierre que le bâtiment peut apporter une fois transformé en machine
     * @param apportBois le nombre de bois que le bâtiment peut apporter une fois transformé en machine
     * @param apportSavoir le nombre de savoir que le bâtiment peut apporter une fois transformé en machine
     * @param apportTuile le nombre de tuile que le bâtiment peut apporter une fois transformé en machine
     */
    public CarteMachine(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points, int apportPierre, int apportBois, int apportSavoir, int apportTuile) {
        super(id, nom, pierre, bois, savoir, tuile, ecu, points);
        this.apportBois = apportBois;
        this.apportPierre = apportPierre;
        this.apportSavoir = apportSavoir;
        this.apportTuile = apportTuile;
        this.isConstruit = false; // 0 si pas encore construit et 1 si construit

    }

    /**
     * Méthode retournant le nombre de bois que la machine va apporter une fois finie
     * @return apportBois
     */
    public int getApportBois() {
        return apportBois;
    }

    /**
     * Méthode retournant le nombre de pierre que la machine va apporter une fois finie
     * @return apportPierre
     */
    public int getApportPierre(){
        return apportPierre;
    }

    /**
     * Méthode retournant le nombre de savoir que la machine va apporter une fois finie
     * @return apportSavoir
     */
    public int getApportSavoir() {
        return apportSavoir;
    }

    /**
     * Méthode retournant le nombre de tuile que la machine va apporter une fois finie
     * @return apportTuile
     */
    public int getApportTuile() {
        return apportTuile;
    }

    /**
     * Permet de transformer une carteBatiment (CarteChantier) en ouvrier
     * @return Retourne une carte ouvrier que l'on pourra ajouter au deckOuvrier du joueur
     */
    public CarteOuvriers transformationEnOuvrier(){

        // L'id de ce nouvel ouvrier est fixé à son id de chantier +100 pour ne pas entrer en conflit avec un id ouvrier déjà existant
        // Le 0 dans le constucteur est expliqué par le fait qu'une machine ne coute rien à utiliser
        return new CarteOuvriers(id+100, nom,0,
                apportPierre, apportBois, apportSavoir, apportTuile);
    }
    /**
     * Méthode pour organiser l'affichage d'une carte batiment
     * @return l'affichage de la carte batiment avec le joueur associé et les ressources que ses ouvriers apportent
     */
    public String toString(Joueur joueur){
        return "\nCarte Machine "+ANSI_PURPLE + nom+ ANSI_RESET+", appartient au joueur "+(joueur.getId())+", ressources présentes : "
                + "\nbois : " + getSumBoisOuv() + "  (besoin : "+ this.bois +") ; "
                + "pierre : " + getSumPierreOuv() + "  (besoin : "+ this.pierre +") ; "
                + "tuile : " + getSumTuileOuv() + "    (besoin : "+ this.tuile +") ; "
                + "savoir : " + getSumSavoirOuv() + "  (besoin : "+ this.savoir +")";
    }
}
