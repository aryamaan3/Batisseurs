package deck;

import cartes.Cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
public class Deck {
    String type;
    Cartes[] deck;


     public Deck (String type) throws Exception {
         this.type = type;

         if(type.equals("ouvrier")){
             deck = new CarteOuvriers[CarteOuvriers.carteOuv.length];
             for(int i=0;i<CarteOuvriers.carteOuv.length;i++){
                 String nom;
                 if(CarteOuvriers.carteOuv[i][1] == 1){
                     nom = "maitre";
                 } else {
                     nom = "compagnon";
                 }
                 deck[i] = new CarteOuvriers(CarteOuvriers.carteOuv[i][0],nom,
                         CarteOuvriers.carteOuv[i][2],
                         CarteOuvriers.carteOuv[i][3],
                         CarteOuvriers.carteOuv[i][4],
                         CarteOuvriers.carteOuv[i][5],
                         CarteOuvriers.carteOuv[i][6],
                         CarteOuvriers.carteOuv[i][7],
                         CarteOuvriers.carteOuv[i][8]);
             }
         } // On crée le deck si le type du deck est "batiment"
         else if(type.equals("batiment")){
             deck = new CarteBatiments[CarteBatiments.carteBat.length];
             for(int i=0;i<CarteBatiments.carteBat.length;i++){
                 deck[i] = new CarteBatiments(i,CarteBatiments.carteBatName[i],
                         CarteBatiments.carteBat[i][1],
                         CarteBatiments.carteBat[i][2],
                         CarteBatiments.carteBat[i][3],
                         CarteBatiments.carteBat[i][4],
                         CarteBatiments.carteBat[i][5],
                         CarteBatiments.carteBat[i][6],
                         CarteBatiments.carteBat[i][7],
                         CarteBatiments.carteBat[i][8]);
             }
         } else {
             throw new Exception("deck doit être ouvrier ou batiment");
         }

     }

    public Cartes[] getDeck() {
        return deck;
    }


}
