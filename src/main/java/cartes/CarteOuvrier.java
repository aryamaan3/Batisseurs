package cartes;



public class CarteOuvrier {
    String type;

    public CarteOuvrier(String type){
        this.type = type;
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
