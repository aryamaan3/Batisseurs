package cartes;

import java.util.HashMap;

public class CarteOuvrier {
    String type;
    int cout;
    HashMap<String, Integer> ressources;

    public CarteOuvrier(String type, int cout, HashMap<String, Integer> ressources){
        this.type = type;
        this.cout = cout;
        this.ressources = ressources;
    }
}
