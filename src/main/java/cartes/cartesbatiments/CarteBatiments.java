package cartes.cartesbatiments;

import cartes.Cartes;

public class CarteBatiments extends Cartes {

    int gainEcu,gainPoints;


    public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre) {
        super(id, nom, bois, tuile, savoir, pierre);

        this.gainEcu = gainEcu;
        this.gainPoints = gainPoints;
    }
}