package joueurs;

/**
 * La classe Joueurs nous permet de créer les joueurs et d'avoir son numéro.
 */
public class Joueurs { // classe pour creer un joueur
    private static  int id;


    /**
     *
     * @param id id du joueur
     */
    public Joueurs (int id){
        this.id = id;
    }

    /**
     *
     * @return L'id du joueur
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return Renvoie une phrase permettant de visualiser l'objet joueur
     */
    @Override
    public String toString() {
        return "Joueurs{" +
                "id=" + id +
                '}';
    }

}
