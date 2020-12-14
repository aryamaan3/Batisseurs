package commun.batiments;

import commun.Cartes;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Joueur;

import java.util.ArrayList;

import static commun.display.Couleur.ANSI_PURPLE;
import static commun.display.Couleur.ANSI_RESET;

/**
 *  Classe qui regroupe les informations et les méthodes des cartes batiments
 */

public class CarteBatiments extends Cartes implements CarteChantier{
    protected boolean isConstruit;
    protected ArrayList<CarteOuvriers> ouvriers = new ArrayList<>();
    protected int ecu;
    protected int points;

    /**
     * Constructeur pour la classe CarteBâtiments, on crée les cartes en y associant leurs caractéristiques
     * @param id le numéro de la carte
     * @param nom le nom de la carte
     * @param pierre le nombre de pierre que la carte bâtiment a besoin pour sa construction
     * @param bois le nombre de bois que la carte bâtiment a besoin pour sa construction
     * @param savoir le nombre de savoir que la carte bâtiment a besoin pour sa construction
     * @param tuile le nombre de tuile que la carte bâtiment a besoin pour sa construction
     * @param ecu le nombre d'écus que le bâtiment rapporte une fois fini
     * @param points le nombre de points que le bâtiment rapporte une fois fini
     */
    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, pierre, bois, savoir, tuile);
        this.ecu = ecu;
        this.points = points;
        this.isConstruit = false; // 0 si pas encore construit et 1 si construit

    }

    /**
     * Méthode retournant le nombre d'écus que le bâtiment rapporte au joueur une fois fini
     * @return le nombre d'écus que le bâtiment rapporte
     */
    public int getEcu() {
        return ecu;
    }

    /**
     * Méthode retournant le nombre de points que le bâtiment rapporte au joueur une fois fini
     * @return le nombre de points que le bâtiment rapporte
     */
    public int getPoints() {
        return points;
    }

    /**
     * Méthode permettant de choisir le nombre d'écus qu'un bâtiment peut rapporter une fois fini
     * @param ecu le nombre d'écus désiré
     */
    public void setEcu(int ecu) {
        this.ecu = ecu;
    }

    /**
     * Méthode permettant de choisir le nombre de points qu'un bâtiment peut rapporter une fois fini
     * @param points le nombre de points désiré
     */
    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Permet de vérifier l'état d'un chantier SANS recalculer les sommes comme
     * dans isBuilt()
     * @return true si le bâtiment a été construit, false sinon
     */
    public boolean isContruit(){
        return isConstruit;
    }

    /**
     * Méthode permettant de choisir si le bâtiment est construit ou non
     * @param bool true si le bâtiment est construit, false sinon
     */
    public void setConstruit(boolean bool){
        this.isConstruit = bool;
    }

    /**
     * Méthode retournant les ouvriers travaillant sur le bâtiment
     * @return une ArrayList contenant les ouvriers sur le bâtiment
     */
    public ArrayList<CarteOuvriers> getOuvriers(){
        return ouvriers;
    }

    /**
     * Méthode retournant la somme des ressources que les ouvriers ont apporté sur le bâtiment
     * @return la somme des ressources que les ouvriers ont apporté
     */
    public int getSumRessources(){ // on additionne toutes les ressources pour donner une valeur globale
        return getBois() + getPierre() + getSavoir() + getTuile();
    }

    /**
     * Méthode qui attribue un ouvrier à un batiment
     * @param carte la carte ouvrier attribuée au batiment
     */

    public void attribuerOuvrier(CarteOuvriers carte){
        ouvriers.add(carte);
        carte.setAssign(true);
    }

    /**
     *  Méthode qui libère les ouvriers assignés à un chantier
     */
    public void libererOuvrier(){
        if(ouvriers.size()!=0){
            for(int i=0;i< ouvriers.size()+1;i++){
                ouvriers.get(i).setAssign(false);
                ouvriers.remove(i);
            }
        }
    }
    /**
     *  Méthode qui additionne le bois des ouvriers assignés au batiment
     * @return la somme de bois que les ouvriers apportent sur le batiment
     */
    public int getSumBoisOuv(){
        int sumBois =0;
        for (CarteOuvriers ouvrier : ouvriers) {
            sumBois += ouvrier.getBois();
        }
        return sumBois;
    }
    /**
     *  Méthode qui additionne la pierre des ouvriers assignés au batiment
     * @return la somme de pierre que les ouvriers apportent sur le batiment
     */
    public int getSumPierreOuv(){
        int sumPierre =0;
        for (CarteOuvriers ouvrier : ouvriers) {
            sumPierre += ouvrier.getPierre();
        }
        return sumPierre;
    }
    /**
     *  Méthode qui additionne le savoir des ouvriers assignés au batiment
     * @return la somme de savoir que les ouvriers apportent sur le batiment
     */
    public int getSumSavoirOuv(){
        int sumSavoir =0;
        for (CarteOuvriers ouvrier : ouvriers) {
            sumSavoir += ouvrier.getSavoir();
        }
        return sumSavoir;
    }
    /**
     * Méthode qui additionne la tuile des ouvriers assignés au batiment
     * @return la somme de tuile que les ouvriers apportent sur le batiment
     */
    public int getSumTuileOuv(){
        int sumTuile =0;
        for (CarteOuvriers ouvrier : ouvriers) {
            sumTuile += ouvrier.getTuile();
        }
        return sumTuile;
    }
    /**
     * Méthode pour organiser l'affichage d'une carte batiment
     * @return l'affichage de la carte batiment avec le joueur associé et les ressources que ses ouvriers apportent
     */
    public String toString(Joueur joueur){
        return "\nCarte Batiment "+ANSI_PURPLE + nom+ ANSI_RESET+", appartient au joueur "+(joueur.getId())+", ressources présentes : "
                + "\nbois : " + getSumBoisOuv() + "  (besoin : "+ this.bois +") ; "
                + "pierre : " + getSumPierreOuv() + "  (besoin : "+ this.pierre +") ; "
                + "tuile : " + getSumTuileOuv() + "    (besoin : "+ this.tuile +") ; "
                + "savoir : " + getSumSavoirOuv() + "  (besoin : "+ this.savoir +")";
    }
    /**
     *  Méthode qui vérifie si la somme des matériaux des ouvriers est suffisant pour construire le batiment
     * @return true si les ouvriers apportent suffisamment de ressources pour construire le batiment, sinon false
     */
    public boolean isBuilt(){
        if(this.bois <= getSumBoisOuv()
                && this.pierre <= getSumPierreOuv()
                && this.savoir <= getSumSavoirOuv()
                && this.tuile <= getSumTuileOuv()){
            isConstruit = true;
        }
        return isConstruit;
    }

    /**
     * Permet de savoir si un batiment est une machine ou non
     * @return Retourne true si c'est une machine, false sinon
     */
    public boolean isMachine(){
        // Les machines ont pour seule difference avec les batiments qu'elles ne rapportent pas d'écus
        return ecu == 0;
    }
}

