package commun.ouvriers;

import java.util.ArrayList;

/**
 * Classe qui crée le deck des cartes ouvriers
 */

public class DeckOuvriers {
        private ArrayList<CarteOuvriers> deckMoyenAge = new ArrayList<>();
        private ArrayList<CarteOuvriers> deckAntiquites = new ArrayList<>();
        // l'avant dernier indice indique si l'ouvrier est assigné ou pas à un batiment => -1 pas assigné,
        // sinon l'id du batiment auquel il est assigné

        public DeckOuvriers() {
                deckMoyenAge.add(new CarteOuvriers(0, "maitre", 5, 0, 0, 2, 3));
                deckMoyenAge.add(new CarteOuvriers(1, "maitre", 5, 2, 0, 0, 3));
                deckMoyenAge.add(new CarteOuvriers(2, "maitre", 5, 3, 0, 0, 2));
                deckMoyenAge.add(new CarteOuvriers(3, "maitre", 5, 3, 2, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(4, "maitre", 5, 0, 3, 2, 0));
                deckMoyenAge.add(new CarteOuvriers(5, "maitre", 5, 2, 3, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(6, "maitre", 5, 0, 2, 3, 0));
                deckMoyenAge.add(new CarteOuvriers(7, "maitre", 5, 0, 0, 3, 2));
                deckMoyenAge.add(new CarteOuvriers(8, "compagnon", 4, 3, 1, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(9, "compagnon", 4, 0, 0, 1, 3));
                deckMoyenAge.add(new CarteOuvriers(10, "compagnon", 4, 1, 0, 3, 0));
                deckMoyenAge.add(new CarteOuvriers(11, "compagnon", 4, 0, 3, 0, 1));
                deckMoyenAge.add(new CarteOuvriers(12, "compagnon", 4, 2, 0, 0, 2));
                deckMoyenAge.add(new CarteOuvriers(13, "compagnon", 4, 2, 2, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(14, "compagnon", 4, 2, 0, 2, 0));
                deckMoyenAge.add(new CarteOuvriers(15, "compagnon", 4, 0, 2, 0, 2));
                deckMoyenAge.add(new CarteOuvriers(16, "compagnon", 4, 0, 2, 2, 0));
                deckMoyenAge.add(new CarteOuvriers(17, "compagnon", 4, 0, 0, 2, 2));
                deckMoyenAge.add(new CarteOuvriers(18, "compagnon", 4, 0, 1, 1, 2));
                deckMoyenAge.add(new CarteOuvriers(19, "compagnon", 4, 2, 1, 1, 0));
                deckMoyenAge.add(new CarteOuvriers(20, "compagnon", 4, 1, 2, 0, 1));
                deckMoyenAge.add(new CarteOuvriers(21, "compagnon", 4, 1, 0, 2, 1));
                deckMoyenAge.add(new CarteOuvriers(22, "compagnon", 4, 1, 1, 1, 1));
                deckMoyenAge.add(new CarteOuvriers(23, "compagnon", 4, 1, 1, 1, 1));
                deckMoyenAge.add(new CarteOuvriers(24, "manœuvre", 3, 0, 0, 2, 1));
                deckMoyenAge.add(new CarteOuvriers(25, "manœuvre", 3, 1, 0, 2, 0));
                deckMoyenAge.add(new CarteOuvriers(26, "manœuvre", 3, 0, 1, 2, 0));
                deckMoyenAge.add(new CarteOuvriers(27, "manœuvre", 3, 1, 2, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(28, "manœuvre", 3, 0, 2, 0, 1));
                deckMoyenAge.add(new CarteOuvriers(29, "manœuvre", 3, 0, 2, 1, 0));
                deckMoyenAge.add(new CarteOuvriers(30, "manœuvre", 3, 1, 0, 0, 2));
                deckMoyenAge.add(new CarteOuvriers(31, "manœuvre", 3, 1, 0, 0, 2));
                deckMoyenAge.add(new CarteOuvriers(32, "manœuvre", 3, 0, 0, 1, 2));
                deckMoyenAge.add(new CarteOuvriers(33, "manœuvre", 3, 2, 0, 0, 1));
                deckMoyenAge.add(new CarteOuvriers(34, "manœuvre", 3, 2, 0, 1, 1));
                deckMoyenAge.add(new CarteOuvriers(35, "manœuvre", 3, 2, 1, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(36, "apprenti", 2, 0, 0, 1, 1));
                deckMoyenAge.add(new CarteOuvriers(37, "apprenti", 2, 0, 1, 1, 0));
                deckMoyenAge.add(new CarteOuvriers(38, "apprenti", 2, 0, 1, 0, 1));
                deckMoyenAge.add(new CarteOuvriers(39, "apprenti", 2, 1, 0, 1, 0));
                deckMoyenAge.add(new CarteOuvriers(40, "apprenti", 2, 1, 1, 0, 0));
                deckMoyenAge.add(new CarteOuvriers(41, "apprenti", 2, 1, 0, 0, 1));

        }



        /**
         * @return Le deck ouvrier
         */
        public ArrayList<CarteOuvriers> getDeck(int whichDeck) {
                if (whichDeck == 1) {
                        return deckMoyenAge;
                }
                else {
                        return deckAntiquites;
                }
        }

        /*/**
         *
         * @return Retourne une liste des indices des apprentis dans le deck qui a été shuffle
         */
        /*static public int[] getIdApprentis(){
                // 6 apprentis dans le decks
                int[] idApprentis = new int[6];
                int count = 0;
                // On boucle sur les indices du deck (qui a été shuffle)
                for(int i = 0; i < deck.size() ; i++){
                        if(deck.get(i).getNom() == "apprenti"){
                                idApprentis[count] = i;
                                count ++;
                        }
                }
                return idApprentis;
        }*/
}
