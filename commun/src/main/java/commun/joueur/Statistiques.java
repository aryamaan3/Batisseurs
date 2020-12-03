package commun.joueur;

public class Statistiques {
    int nbPoints,nbEcus,nbActionsRecrutement,nbEcusDépensésOuv,nbActionsTravailler,nbRevenusBat,idJoueur;

    public Statistiques(int idJoueur){
        this.idJoueur = idJoueur;
        nbPoints = 0;

    }

    public int getNbPoints(){
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public void addPoints(int points){
        nbPoints =+ points;
    }

    public int getNbEcus() {
        return nbEcus;
    }

    public void setNbEcus(int nbEcus) {
        this.nbEcus = nbEcus;
    }

    public void addEcus(int ecus){
        nbEcus =+ ecus;
    }

    public int getNbEcusDépensésOuv() {
        return nbEcusDépensésOuv;
    }

    public void setNbEcusDépensésOuv(int nbEcusDépensésOuv) {
        this.nbEcusDépensésOuv = nbEcusDépensésOuv;
    }

    public void addEcusDépensésOuv(int ecusDépensésOuv){
        nbEcusDépensésOuv += ecusDépensésOuv;
    }

    public int getNbActionsRecrutement() {
        return nbActionsRecrutement;
    }

    public void setNbActionsRecrutement(int nbActionsRecrutement) {
        this.nbActionsRecrutement = nbActionsRecrutement;
    }

    public void addActionsRecrutement(int actionsRecrutement){
        nbActionsRecrutement += actionsRecrutement;
    }

    public int getNbRevenusBat() {
        return nbRevenusBat;
    }

    public void setNbRevenusBat(int nbRevenusBat) {
        this.nbRevenusBat = nbRevenusBat;
    }

    public void addRevenusBat(int revenusBat){
        nbRevenusBat += revenusBat;
    }

    public int getNbActionsTravailler() {
        return nbActionsTravailler;
    }

    public void setNbActionsTravailler(int nbActionsTravailler) {
        this.nbActionsTravailler = nbActionsTravailler;
    }

    public void addActionsTravailler(int actionsTravailler){
        nbActionsTravailler += actionsTravailler;
    }
}
