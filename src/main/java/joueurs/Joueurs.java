package joueurs;

public class Joueurs {
    private int id;
    public Joueurs (int id){
        this.id = id;
    }

    public static int getId() {
        return id;
    }

    @Override
    public String toString() {  // Méthode pour visualiser les variable de l'objet joueur
        return "Joueurs{" +
                "id=" + id +
                '}';
    }

}
