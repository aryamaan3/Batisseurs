package cartes;

public class Cartes {
    private int idCart;
    private String type;

    public Cartes(int id, String type){ //constructeur
        this.idCart = id;
        this.type = type;
    }

    public String getIdCarte(){ //return le type de carte
        return type;
    }

    @Override
    public String toString() {      //méthode pour visualiser
        return "Cartes{ " +
                "id=" + idCart +
                " type='" + type +'\'' +
                " }";
    }
}
