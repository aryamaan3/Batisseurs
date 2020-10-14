package cartes.cartesbatiments;

import cartes.Cartes;

public class CarteBatiments extends Cartes {

    int gainEcu,gainPoints;
    public static Object[][] carteBat = {{0,"la cabane",0,1,1,0,8,0,0,0,0,0,false,-1},
            {1,"la tonnelle",1,0,0,1,8,0,0,0,0,0,false,-1}, {2,"la cabane perchee",0,2,1,0,6,1,0,0,0,0,false,-1},
            {3,"la hutte de paille",1,0,0,2,6,1,0,0,0,0,false,-1}, {4,"le lavoir",0,1,0,2,8,0,0,0,0,0,false,-1},
            {5,"le pont en pierre",2,0,1,0,6,1,0,0,0,0,false,-1}, {6,"le pont couvert",0,1,2,0,6,1,0,0,0,0,false,-1},
            {7,"la maison urbaine",2,0,2,1,10,2,0,0,0,0,false,-1}, {8,"la maisonnette",2,1,0,2,10,2,0,0,0,0,false,-1}};


    public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre, boolean construit, int idjoueur ) {
        super(id, nom, bois, tuile, savoir, pierre);

        this.gainEcu = gainEcu;
        this.gainPoints = gainPoints;
    }
}