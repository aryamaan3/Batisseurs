package commun.ouvriers;

import commun.Cartes;

public class CarteOuvriers extends Cartes {
    private int cout;
    private boolean isBusy;

    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile){
        super(id, nom , bois, tuile, savoir, pierre);
        this.cout = cout;
        this.isBusy = false;

    }

    public int getCout() {
        return cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public boolean isBusy() { return isBusy;
    }
    public void setAssign(boolean isBusy) {
        this.isBusy = isBusy;
    }


}
