package decks;

import cartes.cartesouvrier.CarteOuvriers;

public class DeckOuvriers {
    private CarteOuvriers[] DeckOuvriers;

    // le deuxième indice sert le type d'ouvrier pour l'instant 1 = maitre et 2 = compagnon
    // l'avant dernier indice indique si l'ouvrier est assigné ou pas à un batiment => -1 pas assigné,
    // sinon l'id du batiment auquel il est assigné
    private static int[][] carteOuv = {{0, 1, 5, 0, 0, 2, 3, -1, -1}, {1, 1, 5, 2, 0, 0, 3, -1, -1}, {2, 1, 5, 3, 0, 0, 2, -1, -1},
            {3, 1, 5, 3, 2, 0, 0, -1, -1}, {4, 1, 5, 0, 3, 2, 0, -1, -1}, {5, 1, 5, 2, 3, 0, 0, -1, -1}, {6, 1, 5, 0, 2, 3, 0, -1, -1},
            {7, 1, 5, 0, 0, 3, 2, -1, -1}, {8, 2, 4, 3, 1, 0, 0, -1, -1}, {9, 2, 4, 0, 0, 1, 3, -1, -1},
            {10, 2, 4, 1, 0, 3, 0, -1, -1}, {11, 2, 4, 0, 3, 0, 1, -1, -1}, {12, 2, 4, 2, 0, 0, 2, -1, -1},
            {13, 2, 4, 2, 2, 0, 0, -1, -1}, {14, 2, 4, 2, 0, 2, 0, -1, -1}, {15, 2, 4, 0, 2, 0, 2, -1, -1},
            {16, 2, 4, 0, 2, 2, 0, -1, -1}, {17, 2, 4, 0, 0, 2, 2, -1, -1}, {18, 2, 4, 0, 1, 1, 2, -1, -1},
            {19, 2, 4, 2, 0, 0, 2, -1, -1}};

    /**
     * Pemet de créer un dec ouvrier
     */
    public DeckOuvriers() {
        DeckOuvriers = new CarteOuvriers[carteOuv.length];
        for (int i = 0; i < carteOuv.length; i++) {
            String nom;
            if (carteOuv[i][1] == 1) {
                nom = "maitre";
            }
            if (carteOuv[i][1] == 2){
                nom = "compagnom";
            }
            if (carteOuv[i][1] == 3){
                nom = "manoeuvre";
            }else {
                nom = "apprenti";
            }
            DeckOuvriers[i] = new CarteOuvriers(carteOuv[i][0], nom,
                    carteOuv[i][2],
                    carteOuv[i][3],
                    carteOuv[i][4],
                    carteOuv[i][5],
                    carteOuv[i][6],
                    carteOuv[i][7],
                    carteOuv[i][8]);
        }
    }

    /**
     *
     * @return Le deck ouvrier
     */
    public CarteOuvriers[] getDeck(){
        return DeckOuvriers;
    }
}
