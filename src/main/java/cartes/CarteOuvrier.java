package cartes;



public class CarteOuvrier {
    String type;
    int cout;
    int bois;
    int pierre;
    int savoir;
    int tuile;

    public CarteOuvrier(String type, int cout, int bois, int pierre, int savoir, int tuile){
        this.type = type;
        this.cout = cout;
        this.bois = bois;
        this.pierre = pierre;
        this.savoir = savoir;
        this.tuile = tuile;
    }

    @Override
    public String toString() {      //méthode pour visualiser
        return "CarteOuvrier{" +
                "type='" + type + '\'' +
                ", cout=" + cout +
                ", bois=" + bois +
                ", pierre=" + pierre +
                ", savoir=" + savoir +
                ", tuile=" + tuile +
                '}';
    }
}
