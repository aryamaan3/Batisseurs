package cartes.batiments;


import cartes.batiments.CarteBatiments;

import java.util.ArrayList;

/**
 * Classe qui permet la création du deck contenant les cartes bâtiments
 */

public class DeckBatiments {
     private ArrayList<CarteBatiments> deck = new ArrayList<>();

    public DeckBatiments(){
        deck.add(new CarteBatiments(0,"la cabane", 0, 1, 1, 0, 8, 0));
        deck.add(new CarteBatiments(1,"la tonnelle", 1, 0, 0, 1, 8, 0));
        deck.add(new CarteBatiments(2,"la cabane perchée", 0, 2, 1, 0, 6, 1));
        deck.add(new CarteBatiments(3,"la hutte de paille",1, 0, 0, 2, 6, 1));
        deck.add(new CarteBatiments(4,"le lavoir",0, 1, 0, 2, 6, 1));
        deck.add(new CarteBatiments(5,"le pont en pierre",2, 0, 1, 0, 6, 1));
        deck.add(new CarteBatiments(6,"la pont couvert",0, 1, 2, 0, 6, 1));
        deck.add(new CarteBatiments(7,"la maison urbaine",2, 0, 2,	1, 10, 2));
        deck.add(new CarteBatiments(8,"la maisonnette",2, 1, 0, 2,	10,2));
        deck.add(new CarteBatiments(9,"la maison rurale",1, 2, 1, 1, 10, 2));
        deck.add(new CarteBatiments(10,"la chaumière",0, 2, 1, 2, 10, 2));
        deck.add(new CarteBatiments(11,"le moulin à vent",3, 0, 3, 1, 14, 3));
        deck.add(new CarteBatiments(12,"la porcherie",0,2, 2, 2, 12, 3));
        deck.add(new CarteBatiments(13,"le relais rural",0, 3, 1, 2, 12, 3));
        deck.add(new CarteBatiments(14,"l'écurie",0, 3, 1, 3, 14, 3));
        deck.add(new CarteBatiments(15,"le silo à grains",0, 2, 3, 1, 12, 3));
        deck.add(new CarteBatiments(16,"la forge",2,2,0,3,14,3));
        deck.add(new CarteBatiments(17,"le moulin à eau",0,2,3,2,14,3));
        deck.add(new CarteBatiments(18,"l'étable'",0,1,2,3,12,3));
        deck.add(new CarteBatiments(19,"l'auberge",2,1,1,2,12,3));
        deck.add(new CarteBatiments(20,"le relais postal",3,1,2,2,16,4));
        deck.add(new CarteBatiments(21,"la ferme",4,2,0,2,16,4));
        deck.add(new CarteBatiments(22,"l'hôtel",1,3,3,1,16,4));
        deck.add(new CarteBatiments(23,"la taverne",1,3,1,3,16,4));
        deck.add(new CarteBatiments(24,"les halles",0,3,2,3,16,4));
        deck.add(new CarteBatiments(25,"la maison bourgeoise",2,2,2,2,16,4));
        deck.add(new CarteBatiments(26,"la chapelle",3,2,2,3,18,5));
        deck.add(new CarteBatiments(27,"la tour de guet",3,3,2,2,18,5));
        deck.add(new CarteBatiments(28,"l'abbaye",4,3,2,1,18,5));
        deck.add(new CarteBatiments(29,"l'eglise",4,0,2,4,18,5));
        deck.add(new CarteBatiments(30,"le cloître",4,2,4,0,18,5));
        deck.add(new CarteBatiments(31,"l'aqueduc",5,2,5,0,20,6));
        deck.add(new CarteBatiments(32,"le château-fort",5,3,5,3,20,7));
        deck.add(new CarteBatiments(33,"la cathédrale",5,4,4,4,20,8));
        deck.add(new CarteBatiments(34,"un instrument de mesure",1,0,0,2,0,2));
        deck.add(new CarteBatiments(35,"un four à tuiles",2,1,0,0,0,2));
        deck.add(new CarteBatiments(36,"une grue",0,2,1,0,0,2));
        deck.add(new CarteBatiments(37,"une scie circulaire",0,0,2,1,0,2));
        deck.add(new CarteBatiments(38,"un instrument de mesure",1,1,0,0,0,1));
        deck.add(new CarteBatiments(39,"un four à tuiles",0,1,1,0,0,1));
        deck.add(new CarteBatiments(40,"une grue",0,1,0,1,0,1));
        deck.add(new CarteBatiments(41,"une scie circulaire",1,0,0,1,0,1));
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
