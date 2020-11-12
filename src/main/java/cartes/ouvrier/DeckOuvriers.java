package cartes.ouvrier;


import cartes.ouvrier.CarteOuvriers;

import java.util.ArrayList;

/**
 * Classe qui permet de créer le deck contenant les cartes ouvriers
 */

public class DeckOuvriers {
    private ArrayList<CarteOuvriers> deck = new ArrayList<>();
    // l'avant dernier indice indique si l'ouvrier est assigné ou pas à un batiment => -1 pas assigné,
    // sinon l'id du batiment auquel il est assigné
        /**
     * Pemet de créer un dec ouvrier
     */
    public DeckOuvriers() {
            deck.add(new CarteOuvriers(0, "maitre", 5, 0, 0, 2, 3, -1, -1));
            deck.add(new CarteOuvriers(1, "maitre", 5, 2, 0, 0, 3, -1, -1));
            deck.add(new CarteOuvriers(2, "maitre", 5, 3, 0, 0, 2, -1, -1));
            deck.add(new CarteOuvriers(3, "maitre", 5, 3, 2, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(4, "maitre", 5, 0, 3, 2, 0, -1, -1));
            deck.add(new CarteOuvriers(5, "maitre", 5, 2, 3, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(6, "maitre", 5, 0, 2, 3, 0, -1, -1));
            deck.add(new CarteOuvriers(7, "maitre", 5, 0, 0, 3, 2, -1, -1));
            deck.add(new CarteOuvriers(8, "compagnon", 4, 3, 1, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(9, "compagnon", 4, 0, 0, 1, 3, -1, -1));
            deck.add(new CarteOuvriers(10, "compagnon", 4, 1, 0, 3, 0, -1, -1));
            deck.add(new CarteOuvriers(11, "compagnon", 4, 0, 3, 0, 1, -1, -1));
            deck.add(new CarteOuvriers(12, "compagnon", 4, 2, 0, 0, 2, -1, -1));
            deck.add(new CarteOuvriers(13, "compagnon", 4, 2, 2, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(14, "compagnon", 4, 2, 0, 2, 0, -1, -1));
            deck.add(new CarteOuvriers(15, "compagnon", 4, 0, 2, 0, 2, -1, -1));
            deck.add(new CarteOuvriers(16, "compagnon", 4, 0, 2, 2, 0, -1, -1));
            deck.add(new CarteOuvriers(17, "compagnon", 4, 0, 0, 2, 2, -1, -1));
            deck.add(new CarteOuvriers(18, "compagnon", 4, 0, 1, 1, 2, -1, -1));
            deck.add(new CarteOuvriers(19, "compagnon", 4, 2, 1, 1, 0, -1, -1));
            deck.add(new CarteOuvriers(20, "compagnon", 4, 1, 2, 0, 1, -1, -1));
            deck.add(new CarteOuvriers(21, "compagnon", 4, 1, 0, 2, 1, -1, -1));
            deck.add(new CarteOuvriers(22, "compagnon", 4, 1, 1, 1, 1, -1, -1));
            deck.add(new CarteOuvriers(23, "compagnon", 4, 1, 1, 1, 1, -1, -1));
            deck.add(new CarteOuvriers(24, "manœuvre", 3, 0, 0, 2, 1, -1, -1));
            deck.add(new CarteOuvriers(25, "manœuvre", 3, 1, 0, 2, 0, -1, -1));
            deck.add(new CarteOuvriers(26, "manœuvre", 3, 0, 1, 2, 0, -1, -1));
            deck.add(new CarteOuvriers(27, "manœuvre", 3, 1, 2, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(28, "manœuvre", 3, 0, 2, 0, 1, -1, -1));
            deck.add(new CarteOuvriers(29, "manœuvre", 3, 0, 2, 1, 0, -1, -1));
            deck.add(new CarteOuvriers(30, "manœuvre", 3, 1, 0, 0, 2, -1, -1));
            deck.add(new CarteOuvriers(31, "manœuvre", 3, 1, 0, 0, 2, -1, -1));
            deck.add(new CarteOuvriers(32, "manœuvre", 3, 0, 0, 1, 2, -1, -1));
            deck.add(new CarteOuvriers(33, "manœuvre", 3, 2, 0, 0, 1, -1, -1));
            deck.add(new CarteOuvriers(34, "manœuvre", 3, 2, 0, 1, 1, -1, -1));
            deck.add(new CarteOuvriers(35, "manœuvre", 3, 2, 1, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(36, "manœuvre", 2, 0, 0, 1, 1, -1, -1));
            deck.add(new CarteOuvriers(37, "manœuvre", 2, 0, 1, 1, 0, -1, -1));
            deck.add(new CarteOuvriers(38, "manœuvre", 2, 0, 1, 0, 1, -1, -1));
            deck.add(new CarteOuvriers(39, "manœuvre", 2, 1, 0, 1, 0, -1, -1));
            deck.add(new CarteOuvriers(40, "manœuvre", 2, 1, 1, 0, 0, -1, -1));
            deck.add(new CarteOuvriers(41, "manœuvre", 2, 1, 0, 0, 1, -1, -1));
    }



    /**
     * @return Le deck ouvrier
     */
    public ArrayList<CarteOuvriers> getDeck() {
        return deck;
    }
}
