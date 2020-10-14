package cartes.cartesbatiments;

import cartes.Cartes;

public class CarteBatiments extends Cartes {


    int gainEcu,gainPoints,construit,idjoueur;
    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    public static int[][] carteBat = {{0,0,1,1,0,8,0,0,0,0,0,0,-1},
            {1,1,0,0,1,8,0,0,0,0,0,0,-1}, {2,0,2,1,0,6,1,0,0,0,0,0,-1},
            {3,1,0,0,2,6,1,0,0,0,0,0,-1}, {4,0,1,0,2,8,0,0,0,0,0,0,-1},
            {5,2,0,1,0,6,1,0,0,0,0,0,-1}, {6,0,1,2,0,6,1,0,0,0,0,0,-1},
            {7,2,0,2,1,10,2,0,0,0,0,0,-1}, {8,2,1,0,2,10,2,0,0,0,0,0,-1}};

    public static String[] carteBatName = {"la cabane", "la tonnelle", "la cabane perchee", "la hutte de paille", "le lavoir", "le pont en pierre",
        "le pont couvert", "la maison urbaine", "la maisonnette"};

    public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre, int construit, int idjoueur ) {
        super(id, nom, bois, tuile, savoir, pierre);

        this.gainEcu = gainEcu;
        this.gainPoints = gainPoints;
        this.construit = construit;
        this.idjoueur = idjoueur;
    }

    // Méthode qui permet de changer le champ idJoueur d'un objet CarteBatiment (initialisé à -1)
    public void Affectation(int idJoueur){
        // this represente la carte qu'on passe : batiment1.Affectation(id);
        this.idjoueur = idJoueur;
    }

    public int getIdjoueur(){
        return this.idjoueur;
    }

    public String toString(){
        return "Carte Batiment "+nom+", appartient au joueur "+(idjoueur+1);
    }
}