package commun.batiments;

/**
 * Classe fille de CarteBatiment :
 *  Une machine est un batiment avec quelques paramètres en plus (des ressources qui seront apportées à un chantier)
 */
public class CarteMachine extends CarteBatiments {
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
}
