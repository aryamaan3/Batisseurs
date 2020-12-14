package commun.batiments;

import commun.joueur.Joueur;
import commun.ouvriers.CarteOuvriers;

import java.util.ArrayList;

/**
 * Interface nous permettant d'utiliser les méthodes de CartesBatiment et CarteChantier
 * sans etre obligé de connaitre le type spécifique dans le moteur de jeu.
 */
public interface CarteChantier {
    /**
     * Méthode retournant le nombre d'écus que le bâtiment rapporte au joueur une fois fini
     * @return le nombre d'écus que le bâtiment rapporte
     */
    int getEcu();

    /**
     * Méthode retournant le nombre de points que le bâtiment rapporte au joueur une fois fini
     * @return le nombre de points que le bâtiment rapporte
     */
    int getPoints();

    /**
     * Méthode permettant de choisir le nombre d'écus qu'un bâtiment peut rapporter une fois fini
     * @param ecu le nombre désiré
     */
    void setEcu(int ecu);

    /**
     * Méthode permettant de choisir le nombre de points qu'un bâtiment peut rapporter une fois fini
     * @param points le nombre de points désiré
     */
    void setPoints(int points);

    /**
     * Permet de vérifier l'état d'un chantier SANS recalculer les sommes comme
     * dans isBuilt()
     * @return true si le bâtiment est construit, false sinon
     */
    boolean isContruit();

    /**
     * Méthode permettant de choisir si le bâtiment est construit ou non
     * @param bool true si le bâtiment est construit, false sinon
     */
    void setConstruit(boolean bool);

    /**
     * Méthode retournant les ouvriers travaillant sur le bâtiment
     * @return une ArrayList contenant les ouvriers sur le bâtiment
     */
    ArrayList<CarteOuvriers> getOuvriers();

    /**
     * Méthode qui attribue un ouvrier à un batiment
     * @param carte la carte ouvrier attribuée au batiment
     */
    void attribuerOuvrier(CarteOuvriers carte);

    /**
     *  Méthode qui libère les ouvriers assignés à un chantier
     */
    void libererOuvrier();

    /**
     * Méthode retournant la somme des ressources que les ouvriers ont apporté sur le bâtiment
     * @return la somme des ressources que les ouvriers ont apporté
     */
    int getSumRessources();

    /**
     *  Méthode qui additionne le bois des ouvriers assignés au batiment
     * @return la somme de bois que les ouvriers apportent sur le batiment
     */
    int getSumBoisOuv();

    /**
     *  Méthode qui additionne la pierre des ouvriers assignés au batiment
     * @return la somme de pierre que les ouvriers apportent sur le batiment
     */
    int getSumPierreOuv();

    /**
     *  Méthode qui additionne le savoir des ouvriers assignés au batiment
     * @return la somme de savoir que les ouvriers apportent sur le batiment
     */
    int getSumSavoirOuv();

    /**
     * Méthode qui additionne la tuile des ouvriers assignés au batiment
     * @return la somme de tuile que les ouvriers apportent sur le batiment
     */
    int getSumTuileOuv();

    /**
     * Méthode pour organiser l'affichage d'une carte batiment
     * @param joueur le joueur associé à la carte bâtiment
     * @return l'affichage de la carte batiment avec le joueur associé et les ressources que ses ouvriers apportent
     */
    String toString(Joueur joueur);

    /**
     *  Méthode qui vérifie si la somme des matériaux des ouvriers est suffisant pour construire le batiment
     * @return true si les ouvriers apportent suffisamment de ressources pour construire le batiment, sinon false
     */
    boolean isBuilt();

    /**
     * Permet de savoir si un batiment est une machine ou non
     * @return Retourne true si c'est une machine, false sinon
     */
    boolean isMachine();

    // Méthode de la classe Carte

    /**
     * Méthode retournant le nom de la carte
     * @return Le nom d'une carte
     */
    String getNom();

    /**
     * Méthode retournant le nombre de bois associé à la carte
     * @return La valeur en bois de la carte
     */
    int getBois();

    /**
     * Méthode retournant le nombre de pierre associé à la carte
     * @return La valeur en pierre de la carte
     */
    int getPierre();

    /**
     * Méthode retournant le nombre de savoir associé à la carte
     * @return La valeur en savoir de la carte
     */
    int getSavoir();

    /**
     * Méthode retournant le nombre de tuile associé à la carte
     * @return La valeur en tuile de la carte
     */
    int getTuile();

    /**
     * Méthode retournant le numéro de la carte
     * @return Le numéro d'une carte
     */
    int getIdCarte();
}
