package cartes;
import cartes.cartesbatiments.CarteBatiments;
import cartes.cartesouvrier.CarteOuvriers;
import decks.DeckOuvriers;
import moteurdejeu.MoteurDeJeu;

public class findInDeck {
    // Classe qui permet de récupérer les objets contenus dans les decks
    // On ne demandera pas d'objet pour utiliser les méthodes de cette class

    public static CarteOuvriers findOuvrierInDeck(int id){
        return MoteurDeJeu.DeckOuvrier[id];
        // A modifier dans l'avenir car la carte à la position 0 ne sera pas forcement celle
        // dont l'indice = 0 !
    }

}
