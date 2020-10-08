package cartes;



public class Cartes {
    String type;

    public Cartes(String type){
        this.type = type;
    }

    @Override
    public String toString() {      //méthode pour visualiser
        return "Cartes{" +
                "type='" + type + '\'' +
                '}';
    }
}
