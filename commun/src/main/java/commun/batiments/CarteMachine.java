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

    public CarteMachine(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points, int apportPierre, int apportBois, int apportSavoir, int apportTuile) {
        super(id, nom, pierre, bois, savoir, tuile, ecu, points);
        this.apportBois = apportBois;
        this.apportPierre = apportPierre;
        this.apportSavoir = apportSavoir;
        this.apportTuile = apportTuile;
        this.isConstruit = false; // 0 si pas encore construit et 1 si construit

    }

    /**
     *
     * @return apportBois
     */
    public int getApportBois() {
        return apportBois;
    }

    /**
     *
     * @return apportPierre
     */
    public int getApportPierre(){
        return apportPierre;
    }

    /**
     *
     * @return apportSavoir
     */
    public int getApportSavoir() {
        return apportSavoir;
    }

    /**
     *
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
     *  Méthode pour organiser l'affichage d'une carte batiment
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
