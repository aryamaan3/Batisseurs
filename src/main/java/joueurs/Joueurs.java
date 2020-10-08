package joueurs;

public class Joueurs {
    int id;
    public Joueurs (int id){
        this.id = id;
    }

    @Override
    public String toString() {  // Méthode pour visualiser les variable de l'objet joueur
        return "Joueurs{" +
                "id=" + id +
                '}';
    }
}
