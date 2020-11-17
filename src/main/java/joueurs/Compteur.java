package joueurs;

public class Compteur {

    int id;
    public int nb;
    public Compteur(int id){
        this.id = id;
        this.nb = 3;
    }

    public void actionsFait (int n){
        this.nb = nb - n;
    }

    public void buyActions (int n){
        this.nb = nb + n;
        System.out.println("Le joueur "+(id + 1)+" a acheté "+n+" action(s)");
        System.out.println("Il lui reste "+nb+" actions à faire");
    }

    public void reset (){
        this.nb = 3;
    }
}
