package cartes.cartesouvrier;

import cartes.Cartes;

public class CarteOuvriers extends Cartes {
    int cout;

    // le deuxième indice sert le type d'ouvrier pour l'instant 1 = maitre et 2 = compagnon
    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    public static int[][] carteOuv = {{0,1,5,0,0,2,3,0,-1},{1,1,5,2,0,0,3,0,-1},{2,1,5,3,0,0,2,0,-1},
            {3,1,5,3,2,0,0,0,-1},{4,1,5,0,3,2,0,0,-1},{5,1,5,2,3,0,0,0,-1},{6,1,5,0,2,3,0,0,-1},
            {7,1,5,0,0,3,2,0,-1},{8,2,4,3,1,0,0,0,-1},{9,2,4,0,0,1,3,0,-1},
            {10,2,4,1,0,3,0,0,-1},{11,2,4,0,3,0,1,0,-1},{12,2,4,2,0,0,2,0,-1},
            {13,2,4,2,2,0,0,0,-1},{14,2,4,2,0,2,0,0,-1},{15,2,4,0,2,0,2,0,-1},
            {16,2,4,0,2,2,0,0,-1},{17,2,4,0,0,2,2,0,-1},{18,2,4,0,1,1,2,0,-1},
            {19,2,4,2,0,0,2,0,-1}};





    public CarteOuvriers(int id, String nom, int cout, int pierre, int bois, int savoir, int tuile, int assign,int idjoueur) {
        super(id, nom , bois, tuile, savoir, pierre);
        this.cout = cout;

    }



}
