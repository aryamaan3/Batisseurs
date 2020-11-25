package commun.joueur;

/**
 * Classe qui compte les actions des joueurs
 */

public class Compteur {
    private int id;
    private int nb;

    public Compteur(int id){
        this.id = id;
        this.nb = 3;
    }

    public void actionsFait (int n){
        this.nb = nb - n;
    }

    public int getNombreAction(){
        return nb;
    }

    /**
     *  Méthode qui permet aux joueurs d'acheter une action
     * @param n le nombre d'action que l'on souhaite acheter
     *
     */

    public void buyActions (int n){
        this.nb = nb + n;
        System.out.println("Le joueur "+(id)+" a acheté "+n+" action(s)");
        System.out.println("Il lui reste "+nb+" actions à faire");
    }

    /**
     *  Méthode qui permet aux joueurs de vendre une action
     * @param n le nombre d'action que l'on souhaite vendre
     *
     */

    public void sellActions (int n){
        if (n <= 3) {
            System.out.println("Le joueur a vendu ses " + nb + " action(s) restant");
            this.nb = nb - n;
        }
        else{
            System.out.println("on ne peut vendre seulement 3 actions");
        }
    }

    public void reset (){
        this.nb = 3;
    }
}
