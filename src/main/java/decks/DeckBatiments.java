package decks;


import cartes.cartesbatiments.CarteBatiments;

import java.util.ArrayList;


public class DeckBatiments {
     private ArrayList<CarteBatiments> deck = new ArrayList<>();
    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    //public CarteBatiments(int id, String nom, int gainEcu, int  gainPoints, int bois, int tuile, int savoir, int pierre)
    private static int[][] carteBat = {{0, 0, 1, 1, 0, 8, 0}, {1, 1, 0, 0, 1, 8, 0}, {2, 0, 2, 1, 0, 6, 1}, {3, 1, 0, 0, 2, 6, 1 },
            {4, 0, 1, 0, 2, 6, 1}, {5, 2, 0, 1, 0, 6, 1 }, {6,	0, 1, 2, 0, 6, 1}, {7, 2, 0, 2,	1, 10, 2},
            {8, 2, 1, 0, 2,	10,	2}, {9, 1, 2, 1, 1, 10, 2}, {10, 0, 2, 1, 2, 10, 2}, {11, 3, 0, 3, 1, 14, 3},
            {12, 0,	2, 2, 2, 12, 3}, {13, 0, 3, 1, 2, 12, 3}, {14, 0, 3, 1, 3, 14, 3}, {15, 0, 2, 3, 1, 12, 3},
            {16, 0,	3, 1, 2, 12, 3}, {17, 0, 3, 1, 3, 14, 3}, {18, 0, 2, 3, 1, 12, 3}, {19, 2, 2, 0, 3, 14, 3},
    };
    private static String[] carteBatName = {"la cabane", "la tonelle", "la cabane perchée", "la hutte de paille", "le lavoir", "le pont en pierre", "la maisonnette",
            "la maison rurale", "la chaumière", "le moulin à vent", "la porcherie", "le relais rural", "l'écurie", "le silo à grains", "la forge", "le moulin à eau", "l'étable", "l'auberge",
            "le relais postal", "la ferme", "l'hôtel", "la taverne", "les halles", "la maison bourgeoise", "la chapelle", "la tour de guet", "l'abbaye", "l'église",
            "le cloître", "l'aqueduc", "le château-fort", "la cathédrale", "un instrument de mesure", "un four à tuiles", "une grue", "une scie circulaire", "un instrument de mesure", "un four à tuiles",
            "une grue", "une scie circulaire", "le pont couvert"};

    public DeckBatiments(){

        for(int i=0;i<carteBat.length;i++){
            deck.add(new CarteBatiments(i, carteBatName[i], carteBat[i][1], carteBat[i][2], carteBat[i][3], carteBat[i][4], carteBat[i][5], carteBat[i][6]));
        }
        }

    /**
     *
     * @return Le deck batiment
     */
    public ArrayList<CarteBatiments> getDeck(){
        return deck;
    }

    public int len(){
        return deck.size();
    }

}
