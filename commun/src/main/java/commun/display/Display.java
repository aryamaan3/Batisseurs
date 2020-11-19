package commun.display;

import commun.batiments.CarteBatiments;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.ArrayList;
import static commun.display.Couleur.ANSI_GREEN;
import static commun.display.Couleur.ANSI_RESET;

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
        System.out.println(); // juste pour le retour à la ligne
    }

    /**
     * Imprime dans l'invite de commande l'état des cartes à piocher (toutes les cartes disponibles, ouvrier ou chantier)
     * @param carteOuvSurTable Ouvriers Disponibles
     * @param carteBatSurTable  Chantiers disponibles
     */
    public static void displayCarteDispo(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteBatiments> carteBatSurTable){
        System.out.print(ANSI_GREEN + "Cartes ouvriers disponibles :"+ ANSI_RESET);
        for (CarteOuvriers carteOuvriers : carteOuvSurTable) {
            System.out.print(" " + carteOuvriers.getNom() + "(id=" + carteOuvriers.getIdCarte() + ")");
        }
        System.out.print(ANSI_GREEN + "\nCartes chantiers disponibles :"+ ANSI_RESET);
        for (CarteBatiments carteBatiments : carteBatSurTable) {
            System.out.print(" " + carteBatiments.getNom());
        }
        System.out.println(); // Juste pour un retour à la ligne
    }

    /**
     *
     */
    public static void displayPoint(Joueur joueur){
        System.out.println("Le joueur n°" + (joueur.getId()) + " a "
                + ANSI_GREEN + joueur.getPoints() + " point(s)" +ANSI_RESET);
    }
    public static void displayActions(Compteur c){
        System.out.println("Il reste "+c.getNb()+" action(s)");
    }

    public static void displayBourse(Joueur joueur){
        System.out.println("Le joueur "+ (joueur.getId()) + " possede "+ joueur.getBourse().getEcus()+" écu(s)");

    }
}
