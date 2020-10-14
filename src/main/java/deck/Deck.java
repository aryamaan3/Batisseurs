package deck;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvrier;
public class Deck {
    String type;

     public Deck (String type){
         this.type = type;
     }

     public Cartes[] CreateDeck() throws Exception {
         Cartes []deck = new Cartes[42];

         if(type == "ouvrier"){
             for(int i=1;i<43;i++){
                 deck[i-1] = new CarteOuvrier(i,"ouvrier",2,1,3,4);
             }
             return deck;
         }
         else if(type == "batiment"){
             for(int i=1;i<43;i++){
                 deck[i-1] = new CarteBatiments(i,"batiments",2,1,3,4,4,6);
             }
             return deck;

         } else {
             throw new Exception("deck doit être ouvrier ou batiment");
         }
     }
}
