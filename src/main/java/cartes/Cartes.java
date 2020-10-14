package cartes;

public class Cartes {

    protected int idCart,bois,tuile,savoir,pierre;
    protected String nom;
    // le deuxième indice sert le type d'ouvrier pour l'instant 1 = maitre et 2 = compagnon
    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    public static int[][] carteOuv = {{0,1,5,0,0,2,3,0,-1},{1,1,5,2,0,0,3,0,-1},{2,1,5,3,0,0,2,0,-1},
            {3,1,5,3,2,0,0,0,-1},{4,1,5,0,3,2,0,0,-1},{5,1,5,2,3,0,0,0,-1},{6,1,5,0,2,3,0,0,-1},
            {7,1,5,0,0,3,2,0,-1},{8,2,4,3,1,0,0,0,-1},{9,2,4,0,0,1,3,0,-1},
            {10,2,4,1,0,3,0,0,-1},{11,2,4,0,3,0,1,0,-1},{12,2,4,2,0,0,2,0,-1},
            {13,2,4,2,2,0,0,0,-1},{14,2,4,2,0,2,0,0,-1},{15,2,4,0,2,0,2,0,-1},
            {16,2,4,0,2,2,0,0,-1},{17,2,4,0,0,2,2,0,-1},{18,2,4,0,1,1,2,0,-1},
            {19,2,4,2,0,0,2,0,-1}};

    public static String[] carteOuvName = {"maitre", "compagnon"};


    public Cartes(int id, String nom, int bois,int tuile,int savoir,int pierre){
        this.idCart = id;
        this.bois = bois;
        this.tuile = tuile;
        this.savoir = savoir;
        this.pierre = pierre;
        this.nom = nom;


    }




    public String getIdCarte(){
        return nom;
    }


    @Override
    public String toString() {      //méthode pour visualiser
        return "Cartes{ " +
                "id=" + idCart +"}";
    }
}
