package decks;

import cartes.cartesouvrier.CarteOuvriers;

import java.util.Random;

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
            {19, 2, 4, 2, 1, 1, 0, -1, -1}, {20, 2, 4, 1, 2, 0, 1, -1, -1}, {21, 2, 4, 1, 0, 2, 1, -1, -1},
            {22, 2, 4, 1, 1, 1, 1, -1, -1}, {23, 2, 4, 1, 1, 1, 1, -1, -1}, {24, 3, 3, 0, 0, 2, 1, -1, -1},
            {25, 3, 3, 1, 0, 2, 0, -1, -1}, {26, 3, 3, 0, 1, 2, 0, -1, -1}, {27, 3, 3, 1, 2, 0, 0, -1, -1},
            {28, 3, 3, 0, 2, 0, 1, -1, -1}, {29, 3, 3, 0, 2, 1, 0, -1, -1}, {30, 3, 3, 1, 0, 0, 2, -1, -1},
            {31, 3, 3, 1, 0, 0, 2, -1, -1}, {32, 3, 3, 0, 0, 1, 2, -1, -1}, {33, 3, 3, 2, 0, 0, 1, -1, -1},
            {34, 3, 3, 2, 0, 1, 1, -1, -1}, {35, 3, 3, 2, 1, 0, 0, -1, -1}, {36, 4, 2, 0, 0, 1, 1, -1, -1},
            {37, 4, 2, 0, 1, 1, 0, -1, -1}, {38, 4, 2, 0, 1, 0, 1, -1, -1}, {39, 4, 2, 1, 0, 1, 0, -1, -1},
            {40, 4, 2, 1, 1, 0, 0, -1, -1}, {41, 4, 2, 1, 0, 0, 1, -1, -1}};

    /**
     * Pemet de créer un dec ouvrier
     */
    public DeckOuvriers() {
        DeckOuvriers = new CarteOuvriers[carteOuv.length];
        for (int i = 0; i < carteOuv.length; i++) {
            String nom = null;
            if (carteOuv[i][1] == 1) {
                nom = "maitre";
            }
            if (carteOuv[i][1] == 2) {
                nom = "compagnon";
            }
            if (carteOuv[i][1] == 3) {
                nom = "manoeuvre";
            }
            if (carteOuv[i][1] == 4) {
                nom = "apprenti";
            }
            DeckOuvriers[i] = new CarteOuvriers(carteOuv[i][0], nom, carteOuv[i][2], carteOuv[i][3], carteOuv[i][4], carteOuv[i][5], carteOuv[i][6], carteOuv[i][7], carteOuv[i][8]);
        }
    }

    public void getApprenti(int idJoueur) {
        int a = DeckOuvriers[3].getIdjoueur();
        a = idJoueur;
    }

    /**
     * @return Le deck ouvrier
     */
    public CarteOuvriers[] getDeck() {
        return DeckOuvriers;
    }


    public void shuffle() {
        Random gen = new Random();
        for (int i = DeckOuvriers.length - 1; i > 0; i--) {
            int indice = gen.nextInt(i + 1);
            // je swap
            CarteOuvriers a = DeckOuvriers[indice];
            DeckOuvriers[indice] = DeckOuvriers[i];
            DeckOuvriers[i] = a;
        }
    }
}
