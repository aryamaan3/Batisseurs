package commun.joueur;

import commun.batiments.CarteBatiments;
import commun.ouvriers.CarteOuvriers;

/**
 * Classe qui regroupe toutes les informations et les méthodes liées au joueur
 */


import java.util.ArrayList;

public class Joueur {
    private int id;
    private int points;
    private ArrayList<CarteBatiments> MainBat = new ArrayList<>();
    private ArrayList<CarteBatiments> BuiltBat = new ArrayList<>();
    private ArrayList<CarteOuvriers> MainOuv = new ArrayList<>();
    private Bourse bourse;

    public Joueur(int id){
        this.id=id;
        this.points=0;
        bourse = new Bourse(id);

    }

    public Bourse getBourse() { return bourse;}
    public void setBourse(Bourse bourse){ this.bourse = bourse;}
    public int getId(){ return id;}
    public void setId(int id){ this.id=id;}
    public int getPoints(){ return points;}
    public void setPoints(int points){this.points = points;}
    public void addPoints(int points){this.points += points; }

    /**
     *  Méthode qui renvoit la main de cartes batiment du joueur
     */
    public ArrayList<CarteBatiments> getMainBat(){return MainBat;}
    /**
     *  Méthode qui renvoit la main de cartes ouvrier du joueur
     */
    public ArrayList<CarteOuvriers> getMainOuv(){return MainOuv;}
    /**
     *  Méthode qui prend une carte ouvrier sur le plateau pour la mettre dans la main du joueur
     *  @param carte la carte que le joueur souhaite piocher
     */
    public void ajouteOuvrier(CarteOuvriers carte){MainOuv.add(carte);}
    /**
     *  Méthode qui prend une carte batiment sur le plateau pour la mettre dans la main du joueur
     *  @param carte la carte que le joueur souhaite piocher
     */
    public void ajouteBatiment(CarteBatiments carte){MainBat.add(carte);}
    /**
     *  Méthode qui attribue un ouvrier à un batiment ( l'ouvrier est retiré de la main du joueur) en utilisant la methode attribuerOuvrier
     *  de la classe CarteBatiments
     *  Elle vérifie aussi que le joueur peut payer grâce à la méthode actionAutorisee et retire le cout de l'ouvrier
     *  de la bourse du joueur si c'est le cas
     *  @param ouvrier la carte ouvrier attribué au batiment
     *  @param batiment la carte batiment
     */
    public void attribuerOuvrierAChantier(CarteOuvriers ouvrier, CarteBatiments batiment){
        if(actionAutorisee(ouvrier)){
        batiment.attribuerOuvrier(ouvrier);
        MainOuv.remove(ouvrier);
        bourse.subEcus(ouvrier.getCout());
        }else{
            System.out.println("le joueur n'a pas assez d'écus pour payer l'ouvrier");
        }
    }
    /**
     *  Méthode qui trie la main de carte batiment du joueur pour "ranger" les cartes batiments "construites" dans la liste "BuiltBat"
     */
    public void trierBuiltBat(){
        for(int j=0;j<MainBat.size();j++){
            if(MainBat.get(j).isBuilt()){
                for(int i=0;i<MainBat.get(j).getOuvriers().size();i++){
                    MainBat.get(j).getOuvriers().get(i).setAssign(false);
                    MainOuv.add(MainBat.get(j).getOuvriers().get(i));
                    MainBat.get(j).getOuvriers().remove(MainBat.get(j).getOuvriers().get(i));
                }
                BuiltBat.add(MainBat.get(j));
                MainBat.remove(MainBat.get(j));
            }
        }
    }
    public ArrayList<CarteBatiments> getBuiltBat(){
        return BuiltBat;
    }
    /**
     *  Méthode qui vérifie que le joueur a assez d'écus pour payer un ouvrier
     * @param carteOuvriers la carte ouvrier que l'on veut payer avec les écus
     */
    public boolean actionAutorisee(CarteOuvriers carteOuvriers){
        return carteOuvriers.getCout() <= bourse.getEcus();
    }

}
