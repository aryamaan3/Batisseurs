package decks;

import cartes.cartesouvrier.CarteOuvriers;
import java.util.Random;

public class Shuffle {

    public void shuffleBat(DeckBatiments[] d){
        Random gen = new Random();
        for (int i = d.length - 1; i > 0; i--){
            int indice = gen.nextInt(i + 1);
            // je swap
            DeckBatiments a = d[indice];
            d[indice] = d[i];
            d[i] = a;
        }
    }

    public static void shuffleOuvrier(CarteOuvriers[] d){
        Random gen = new Random();
        for (int i = d.length - 1; i > 0; i--){
            int indice = gen.nextInt(i + 1);
            // je swap
            CarteOuvriers a = d[indice];
            d[indice] = d[i];
            d[i] = a;
        }
        /*List<CarteOuvriers> newDeck = Arrays.asList(d);
        Collections.shuffle(newDeck);*/
    }
}
