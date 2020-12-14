package plateau;

import commun.batiments.CarteChantier;
import commun.batiments.DeckBatiments;
import commun.ouvriers.CarteOuvriers;
import commun.ouvriers.DeckOuvriers;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  c'est la classe du plateau, c'est celui ci qui va gérer les decks et les cartes posées sur la table.
 */

public class Plateau {
    private ArrayList<CarteChantier> deckBatiment = new DeckBatiments().getDeck();
    private ArrayList<CarteOuvriers> deckOuvrier = new DeckOuvriers().getDeck();
    private ArrayList<CarteChantier> cartesBatSurTable = new ArrayList<>();
    private ArrayList<CarteOuvriers> cartesOuvSurTable = new ArrayList<>();

    public Plateau(){
        Collections.shuffle(deckBatiment);
        Collections.shuffle(deckOuvrier);
    }

    public ArrayList<CarteOuvriers> getDeckOuvrier() {
        return deckOuvrier;
    }

    public ArrayList<CarteChantier> getCartesBatSurTable() {
        return cartesBatSurTable;
    }

    public ArrayList<CarteChantier> getDeckBatiment() {
        return deckBatiment;
    }

    public ArrayList<CarteOuvriers> getCartesOuvSurTable() {
        return cartesOuvSurTable;
    }

    public void setDeckOuvrier(ArrayList<CarteOuvriers> deckOuvrier) {
        this.deckOuvrier = deckOuvrier;
    }

    public void setCartesBatSurTable(ArrayList<CarteChantier> cartesBatSurTable) {
        this.cartesBatSurTable = cartesBatSurTable;
    }

    public void setCartesOuvSurTable(ArrayList<CarteOuvriers> cartesOuvSurTable) {
        this.cartesOuvSurTable = cartesOuvSurTable;
    }

    public void setDeckBatiment(ArrayList<CarteChantier> deckBatiment) {
        this.deckBatiment = deckBatiment;
    }

    /**
     *  Méthode qui pioche les 5 cartes ouvrier à poser sur le plateau et qui vont être pioché par les joueurs
     */

    public void carteOuvriersSurTable(){
        for(int i=0;i<5;i++){
            cartesOuvSurTable.add(deckOuvrier.get(i));
            deckOuvrier.remove(i);
        }

    }

    /**
     *  Méthode qui pioche les 5 cartes batiment à poser sur le plateau et qui vont être pioché par les joueurs
     */

    public void carteBatimentsSurTable() {
        for (int i = 0; i < 5; i++) {
            cartesBatSurTable.add(deckBatiment.get(i));
            deckBatiment.remove(i);
        }

    }
    /**
     *  Méthode qui vérifie le nombre de cartes ouvrier disponibles sur le plateau, et qui pioche le nombre de cartes nécessaire
     *  dans le deck principal ouvrier pour toujours avoir 5 cartes ouvrier sur le plateau
     */

    public void fillCartesOuvriers(){
        int nbCartes;
        if(cartesOuvSurTable.size()<5){
            nbCartes = 5 - cartesOuvSurTable.size();
            if (deckOuvrier.size() > nbCartes + 1) {
                for (int i = 0; i < nbCartes; i++) {
                    cartesOuvSurTable.add(deckOuvrier.get(i));
                    deckOuvrier.remove(i);
                }
            }

        }
    }
    /**
     *  Méthode qui vérifie le nombre de cartes batiment disponibles sur le plateau, et qui pioche le nombre de cartes nécessaire
     *  dans le deck principal batiment pour toujours avoir 5 cartes ouvrier sur le plateau
     */

    public void fillCartesBatiments(){
        int nbCartes;
        if(cartesBatSurTable.size()<5){
            nbCartes = 5 - cartesBatSurTable.size();
            for(int i=0;i<nbCartes;i++){
                cartesBatSurTable.add(deckBatiment.get(i));
                deckBatiment.remove(i);
            }
        }
    }
}
