package cartes;

public class Cartes {
    int idCart;
    String type;

    public Cartes(int id, String type){
        this.idCart = id;
        this.type = type;
    }

    public String getIdCarte(){
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
