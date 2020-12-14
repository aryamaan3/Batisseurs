package commun.joueur;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;

import java.util.ArrayList;

/**
 * Classe qui regroupe toutes les informations et les méthodes liées au joueur
 */
public class Joueur implements Comparable{
    private int id;
    private int points;
    private ArrayList<CarteChantier> MainBat = new ArrayList<>();
    private ArrayList<CarteChantier> BuiltBat = new ArrayList<>();
    private ArrayList<CarteOuvriers> MainOuv = new ArrayList<>();
    private Bourse bourse;


    /**
     * Constructeur de la classe Joueur, on crée un joueur avec son numéro et on lui assigne ses points, sa bourse et ses statistiques
     * @param id le numéro du joueur
     */
    public Joueur(int id){
        this.id=id;
        this.points=0;
        bourse = new Bourse(id);


    }

    /**
     * Méthode retournant la bourse du joueur
     * @return la bourse du joueur
     */
    public Bourse getBourse() { return bourse;}

    /**
     * Méthode permettant l'assignation de la bourse à un joueur
     * @param bourse l'Objet bourse
     */
    public void setBourse(Bourse bourse){ this.bourse = bourse;}

    /**
     * Méthode retournant le numéro du joueur
     * @return le numéro du joueur
     */
    public int getId(){ return id;}

    /**
     * Méthode permettant l'assignation d'un numéro à un joueur
     * @param id le numéro du joueur
     */
    public void setId(int id){ this.id=id;}

    /**
     * Méthode retournant le nombre de points du joueur
     * @return le nombre de points du joueur
     */
    public int getPoints(){ return points;}

    /**
     * Méthode permettant l'assignation de points à un joueur
     * @param points le nombre de points
     */
    public void setPoints(int points){this.points = points;}

    /**
     * Méthode permettant l'ajout de point à un joueur
     * @param points le nombre de points à ajouter
     */
    public void addPoints(int points){this.points += points; }

    /**
     *  Méthode qui renvoit la main de cartes batiment du joueur
     * @return une ArrayList contenant les cartes batiment dans la main du joueur
     */
    public ArrayList<CarteChantier> getMainBat(){return MainBat;}
    /**
     *  Méthode qui renvoit la main de cartes ouvrier du joueur
     * @return une ArrayList contenant les cartes ouvrier dans la main du joueur
     */
    public ArrayList<CarteOuvriers> getMainOuv(){return MainOuv;}
    /**
     *  Méthode qui prend une carte ouvrier sur le plateau pour la mettre dans la main du joueur
     *  @param carte la carte que le joueur souhaite piocher
     */
    public void ajouteOuvrier(CarteOuvriers carte){
        MainOuv.add(carte);
        //stats.addActionsRecrutement(1);
        }
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
     * @return 1 si fait, 0 si impossible
     */
    public int attribuerOuvrierAChantier(CarteOuvriers ouvrier, CarteChantier batiment){
        if(actionAutorisee(ouvrier)){
            batiment.attribuerOuvrier(ouvrier);
            MainOuv.remove(ouvrier);
            bourse.subEcus(ouvrier.getCout());
            //stats.addEcusDépensésOuv(ouvrier.getCout());
            //stats.addActionsTravailler(1);
            return 1;
        }else{
            return 0;
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

    /**
     * Méthode permettant de savoir les bâtiments construits par le joueur
     * @return ArrayList contenant les bâtiments construits par le joueur
     */
    public ArrayList<CarteChantier> getBuiltBat(){
        return BuiltBat;
    }
    /**
     *  Méthode qui vérifie que le joueur a assez d'écus pour payer un ouvrier
     * @param carteOuvriers la carte ouvrier que l'on veut payer avec les écus
     * @return true si le joueur a assez d'écus pour réaliser son action, false sinon
     */
    public boolean actionAutorisee(CarteOuvriers carteOuvriers){
        return carteOuvriers.getCout() <= bourse.getEcus();
    }

    /**
     * En fin de partie, on converti tous les écus en points : 10 écus = 1 points
     */
    public void conversionEcuPoint(){
        // On récupère les écus
        int ecu = bourse.getEcus();
        int pointSupp = ecu / 10;
        int reste = ecu % 10;
        points += pointSupp;
        // on enlève 10 * le nombre de point qu'on a rajouté
        // puisque 1 point = 10 écus
        bourse.subEcus(pointSupp * 10);
    }


    /**
     * methode permettant de modifer le comparateur utilisé dans collections.sort
     * @param o objet dans ce cas Joueur
     * @return le plus grand
     */
    @Override
    public int compareTo(Object o) {
        int pointsCompare = ((Joueur)o).getPoints();
        return pointsCompare - this.points;
    }
}
