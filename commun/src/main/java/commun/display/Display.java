package commun.display;

import commun.batiments.CarteBatiments;
import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.ArrayList;
import static commun.display.Couleur.ANSI_GREEN;
import static commun.display.Couleur.ANSI_RESET;
import static commun.display.Couleur.ANSI_BLUE;

/**
 * Classe permettant la gestion de l'affichage dans le jeu
 */
public class Display {

    /**
     *  Méthode qui imprime les ouvriers d'un joueur
     * @param joueur un objet Joueur
     */
    public static void displayOuvriersDuJoueur(Joueur joueur){
        // On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " + (joueur.getId())+ " possède ce(s) ouvrier(s) :");
        for(int i = 0; i < joueur.getMainOuv().size(); i ++){
            System.out.println(" - " + joueur.getMainOuv().get(i).getNom()
                    + " (id = " + joueur.getMainOuv().get(i).getIdCarte() + ")");

        }
    }

    /**
     *  Méthode qui imprime les chantiers d'un joueur
     * @param joueur un objet Joueur
     */
    public static void displayChantierDuJoueur(Joueur joueur){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        System.out.println("Le joueur " +  (joueur.getId()) + " construit ce(s) chantier(s) :");
        for(int i = 0; i < joueur.getMainBat().size(); i ++){
            System.out.println(" - " + joueur.getMainBat().get(i).getNom()
                    + " (id = " + joueur.getMainBat().get(i).getIdCarte() + ")");
        }
    }

    /**
     * Méthode qui affiche l'etat des chantiers d'un joueur
     * @param joueur un objet Joueur
     */
    public static void displayEtatChantiersDuJoueur(Joueur joueur){
        for(int i = 0; i < joueur.getMainBat().size(); i ++){
            System.out.println(joueur.getMainBat().get(i).toString(joueur));
        }
    }

    /**
     * Imprime les Bâtiments (chantiers terminés) d'un joueur
     * @param joueur un Objet joueur
     */
    public static void displayChantierFini(Joueur joueur){
        System.out.print("Joueur "+(joueur.getId()) + " a ce(s) bâtiment(s) de construit(s): ");
        for(int i = 0; i < joueur.getBuiltBat().size(); i ++){
            System.out.print(joueur.getBuiltBat().get(i).getNom()+" ");
        }
        System.out.println("\n"); // juste pour le retour à la ligne
    }

    /**
     * Imprime dans l'invite de commande l'état des cartes à piocher (toutes les cartes disponibles, ouvrier ou chantier)
     * @param carteOuvSurTable Ouvriers Disponibles
     * @param carteBatSurTable  Chantiers disponibles
     */
    public static void displayCarteDispo(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){
        System.out.print(ANSI_GREEN + "Cartes ouvriers disponibles :"+ ANSI_RESET);
        for (CarteOuvriers carteOuvriers : carteOuvSurTable) {
            System.out.print(" " + carteOuvriers.getNom() + "(id=" + carteOuvriers.getIdCarte() + ")" + " |");
        }
        System.out.print(ANSI_GREEN + "\nCartes chantiers disponibles :"+ ANSI_RESET);
        for (CarteChantier carteBatiments : carteBatSurTable) {
            System.out.print(" " + ((CarteBatiments) carteBatiments).getNom() + " |");
        }
        System.out.println(); // Juste pour un retour à la ligne
    }

    /**
     * Méthode permettant l'affichage des points d'un joueur
     * @param joueur l'Objet joueur
     */
    public static void displayPoint(Joueur joueur){
        System.out.println("Le joueur n°" + (joueur.getId()) + " a "
                + ANSI_GREEN + joueur.getPoints() + " point(s)" +ANSI_RESET);
    }

    /**
     * Méthode permettant l'affichage du compteur d'action d'un joueur
     * @param c le compteur d'action
     */
    public static void displayActions(Compteur c){
        if(c.getNombreAction() < 2)
        System.out.println("Il reste "+c.getNombreAction()+" action");
        else{
            System.out.println("Il reste "+c.getNombreAction()+" actions");
        }
    }

    /**
     * Méthode permettant l'affichage de la bourse d'un joueur
     * @param joueur l'Objet joueur
     */
    public static void displayBourse(Joueur joueur){
        System.out.println("Le joueur "+ (joueur.getId()) + " possede "+ joueur.getBourse().getEcus()+" écu(s)");

    }

    public static void displayStats(Joueur joueur){
        System.out.println(ANSI_BLUE +"\nJoueur"+ (joueur.getId()) +ANSI_RESET);
        System.out.println("Points : "+joueur.getPoints());
        System.out.println("Ecus : "+joueur.getBourse().getEcus());
        System.out.println("Actions travailler (ouvriers attribués) : "+joueur.getStats().getNbActionsTravailler());
        System.out.println("Actions recrutement (ouvriers recrutés) :"+joueur.getStats().getNbActionsRecrutement());
        System.out.println("Ecus dépensés pour les ouvriers :"+joueur.getStats().getNbEcusDépensésOuv());
        System.out.println("Revenus des Bâtiments :"+joueur.getStats().getNbRevenusBat());
    }

    /**
     * print le nb d'actions fait et le nb d'actions vendu ou achetée s'ils ont eu lieu
     * @param nb
     */
    public static void displayActionsFini(int nb){
        if (nb > 3){
            System.out.println("le joueur a du acheter "+ (nb - 3) + " actions");
        }
        else if (nb < 3){
            System.out.println("le joueur a vendu " + (3 - nb) + "action(s)");
        }
        System.out.println("le joueur a effectué "+nb+" actions au total");
    }

    /**
     * print les ouvriers posées sur un chantier par le joueur
     * @param check
     * @param joueur
     */
    public static void displayOuvPoseeSurChantier(int check, Joueur joueur){
        if (joueur.getMainBat().size() > 0) {
            int nbOuvrierSurChantier = joueur.getMainBat().get(0).getOuvriers().size();
            if (check != 0){
                for (int i = nbOuvrierSurChantier - check; i < nbOuvrierSurChantier; i++){
                    System.out.println("le joueur "+ joueur.getId() + " pose l'ouvrier "+
                            joueur.getMainBat().get(0).getOuvriers().get(i).getIdCarte() + " sur le batiment " +
                            joueur.getMainBat().get(0).getIdCarte() + " cela lui coûte "+
                            joueur.getMainBat().get(0).getOuvriers().get(i).getCout() + " écus");
                }
            }
        }

    }
}
