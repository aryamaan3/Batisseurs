package commun.batiments;

import commun.Cartes;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Joueur;

import java.util.ArrayList;

/**
 *  Classe qui regroupe les informations et les méthodes des cartes batiments
 */

public class CarteBatiments extends Cartes implements CarteChantier{
    protected boolean isConstruit;
    protected ArrayList<CarteOuvriers> ouvriers = new ArrayList<>();
    protected int ecu;
    protected int points;

    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, pierre, bois, savoir, tuile);
        this.ecu = ecu;
        this.points = points;
        this.isConstruit = false; // 0 si pas encore construit et 1 si construit

    }

    public int getEcu() {
        return ecu;
    }
    public int getPoints() {
        return points;
    }
    public void setEcu(int ecu) {
        this.ecu = ecu;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public boolean isContruit(){
        return isConstruit;
    }
    public void setConstruit(boolean bool){
        this.isConstruit = bool;
    }
    public ArrayList<CarteOuvriers> getOuvriers(){
        return ouvriers;
    }

    /**
     *  Méthode qui attribue un ouvrier à un batiment
     * @param carte la carte ouvrier attribué au batiment
     */

    public void attribuerOuvrier(CarteOuvriers carte){
        ouvriers.add(carte);
    }

    /**
     *  Méthode qui libère les ouvriers assignés à un chantier
     */
    public void libererOuvrier(){
        if(ouvriers.size()!=0){
            for(int i=0;i< ouvriers.size()+1;i++){
                ouvriers.remove(0);
            }
        }else{
            System.out.println("\nIl n'y aucun ouvrier assigné à ce chantier\n");
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
     *  Méthode qui additionne la tuile des ouvriers assignés au batiment
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
     *  Méthode pour organiser l'affichage d'une carte batiment
     * @return l'affichage de la carte batiment avec le joueur associé et les ressources que ses ouvriers apportent
     */
    public String toString(Joueur joueur){
        return "\nCarte Batiment "+nom+", appartient au joueur "+(joueur.getId())+", ressources présentes : "
                + "\n - bois : " + getSumBoisOuv() + "  (besoin : "+ this.bois +")"
                + "\n - pierre : " + getSumPierreOuv() + "  (besoin : "+ this.pierre +")"
                + "\n - tuile : " + getSumTuileOuv() + "    (besoin : "+ this.tuile +")"
                + "\n - savoir : " + getSumSavoirOuv() + "  (besoin : "+ this.savoir +")";
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
        if(ecu == 0){ // Les machines ont pour seule difference avec les batiments qu'elles ne rapportent pas d'écus
            return true;
        }
        return false;
    }
}

