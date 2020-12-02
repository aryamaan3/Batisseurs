package commun.ouvriers;

import commun.Cartes;

/**
 * Classe qui regroupe les informations et les méthodes des cartes ouvriers
 */
public class CarteOuvriers extends Cartes {
    private int cout;
    private boolean isBusy;

    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile){
        super(id, nom , pierre, bois, savoir, tuile);
        this.cout = cout;
        this.isBusy = false;

    }

    /**
     * @return le coût de l'ouvrier
     */
    public int getCout() {
        return cout;
    }

    /**
     * Assigne le coût d'un ouvrier
     * @param cout le coût de l'ouvrier
     */
    public void setCout(int cout) {
        this.cout = cout;
    }

    /**
     * @return true si l'ouvrier est assigné à un batiment, false sinon
     */
    public boolean isBusy() { return isBusy;
    }

    /**
     * Méthode permettant de changer le statut de l'ouvrier (si il est occupé ou pas)
     * @param isBusy true ou false
     */
    public void setAssign(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public String toString(){
        return ("\nCarte Ouvrier "+nom+", ressources présentes : \n" +
                "                \n - bois : "+ this.bois +"\n" +
                "                \n - pierre : " + this.pierre +"\n" +
                "                \n - tuile : " + this.tuile +"\n" +
                "                \n - savoir : " + this.savoir +"" );
    }

}
