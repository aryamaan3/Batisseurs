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

    /**
     * Méthode permettant le calcul des actions réalisées
     * @param n le nombre d'actions réalisées
     */
    public void actionsFait (int n){
        this.nb = nb - n;
    }

    /**
     * @return le nombre d'actions restantes
     */
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
            if(n == 1){
            System.out.println("Le joueur a vendu sa seule action restante");
            this.nb = nb - n;}
            else{
                System.out.println("Le joueur a vendu ses "+ nb + "actions restantes");
                this.nb = nb - n;
            }
        }
        else{
            System.out.println("on ne peut vendre seulement 3 actions");
        }
    }

    /**
     * Remet à 3 (l'état originel) le compteur d'action
     */
    public void reset (){
        this.nb = 3;
    }
}
