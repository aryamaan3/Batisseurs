package joueurs;

import cartes.batiments.CarteBatiments;
import cartes.ouvrier.CarteOuvriers;

import java.util.ArrayList;

public class Assets {



    public static ArrayList<CarteOuvriers> getOuvriersDisponibles(int idJoueur, ArrayList<CarteOuvriers> deck){
        int i = 0;
        ArrayList<CarteOuvriers> OuvriersDisponibles = new ArrayList<>();
        while(i< deck.size()){
            if(deck.get(i).getIdJoueur()==idJoueur && deck.get(i).getChantier()==-1){
                OuvriersDisponibles.add(deck.get(i));
            }
        }
        return OuvriersDisponibles;
    }

    public ArrayList<CarteOuvriers> getOuvriersOccupes(int idJoueur, ArrayList<CarteOuvriers> deck){
        int i = 0;
        ArrayList<CarteOuvriers> OuvriersOccupes = new ArrayList<>();
        while(i< deck.size()){
            if(deck.get(i).getIdJoueur()==idJoueur && deck.get(i).getChantier()!=-1){
                OuvriersOccupes.add(deck.get(i));
            }
        }
        return OuvriersOccupes;
    }


    public ArrayList<CarteBatiments> getChantiers(int idJoueur, ArrayList<CarteBatiments> deck) {
        int i = 0;
        ArrayList<CarteBatiments> Chantiers = new ArrayList<>();
        while (i < deck.size()) {
            if (deck.get(i).getIdJoueur() == idJoueur) {
                Chantiers.add(deck.get(i));
            }
        }
        return Chantiers;
    }
}
