package commun.batiments;

import commun.ouvriers.CarteOuvriers;

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
        CarteOuvriers newMachineAsOuvrier = new CarteOuvriers(id+100, nom,0,
                apportPierre, apportBois, apportSavoir, apportTuile);

        /* A supprimer si tout marche bien
        CarteOuvriers newMachineAsOuvrier = new CarteOuvriers(carteMachine.getIdCarte()+100, carteMachine.getNom(),0,
                carteMachine.getApportPierre(), carteMachine.getApportBois(), carteMachine.getApportSavoir(),carteMachine.getApportTuile());*/

        return newMachineAsOuvrier;
    }
}
