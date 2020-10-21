package decks;


import cartes.cartesbatiments.CarteBatiments;


public class DeckBatiments {
    private CarteBatiments[] DeckBatiments;
    // l'avant dernier indice qui était avec false devient un int avec 0 = false, 1 = true
    private static int[][] carteBat = {{0,0,1,1,0,8,0}/*,
            {1,1,0,0,1,8,0}, {2,0,2,1,0,6,1},
            {3,1,0,0,2,6,1,0,0,0}, {4,0,1,0,2,8,0,0,0,0},
            {5,2,0,1,0,6,1,0,0,0}, {6,0,1,2,0,6,1,0,0,0},
            {7,2,0,2,1,10,2,0,0,0}, {8,2,1,0,2,10,2,0,0,0}*/};
    private static String[] carteBatName = {"la cabane"/*, "la tonnelle", "la cabane perchee", "la hutte de paille", "le lavoir", "le pont en pierre",
            "le pont couvert", "la maison urbaine", "la maisonnette"*/};

    public DeckBatiments(){
        DeckBatiments = new CarteBatiments[carteBat.length];
        for(int i=0;i<carteBat.length;i++){
            DeckBatiments[i] = new CarteBatiments(i,carteBatName[i],
                    carteBat[i][1],
                    carteBat[i][2],
                    carteBat[i][3],
                    carteBat[i][4],
                    carteBat[i][5],
                    carteBat[i][6]);
    }}

    /**
     *
     * @return Le deck batiment
     */
    public CarteBatiments[] getDeck(){
        return DeckBatiments;
    }
}
