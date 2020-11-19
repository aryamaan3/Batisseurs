package commun.batiments;

import commun.Cartes;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Joueur;

import java.util.ArrayList;

/**
 *  Classe qui regroupe les informations et les méthodes des cartes batiments
 */

public class CarteBatiments extends Cartes {
    private boolean isConstruit;
    private ArrayList<CarteOuvriers> ouvriers = new ArrayList<>();
    private int ecu;
    private int points;

    public CarteBatiments(int id, String nom, int pierre, int bois, int savoir, int tuile, int ecu, int points) {
        super(id, nom, bois, tuile, savoir, pierre);
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
}
