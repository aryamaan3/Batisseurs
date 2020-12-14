package commun.display;

import commun.batiments.CarteChantier;
import commun.ouvriers.CarteOuvriers;
import commun.joueur.Compteur;
import commun.joueur.Joueur;

import java.util.ArrayList;
import java.util.Collections;

import static commun.display.Couleur.*;

/**
 * Classe permettant la gestion de l'affichage dans le jeu
 */
public class Display {
    private static boolean afficher;

    /**
     * Constructeur pour la classe Display
     * @param afficher true si on souhaite afficher les actions, false sinon
     */
    public Display(boolean afficher){
        Display.afficher = afficher;
    }

    /**
     * Méthode permettant de savoir si on a choisi d'afficher les actions des joueurs
     * @return true si on a choisi d'afficher les actions, false sinon
     */
    public boolean isAfficher(){
        return afficher;
    }

    /**
     * Méthode permettant de choisir l'affichage ou non des actions
     * @param afficher true si on veut afficher les actions, false sinon
     */
    public void setAfficher(boolean afficher){
        Display.afficher = afficher;
    }


    /**
     * Méthode permettant l'affichage de diverses informations sur le déroulement de la partie
     * @param s la chaîne de caractères à afficher
     */
    public void displayString(String s){
        if(afficher){System.out.println(s);}
    }

    /**
     * Méthode permettant d'afficher le bâtiment choisi par le joueur
     * @param idJoueur le numéro du joueur
     * @param batiment la carte bâtiment que le joueur choisi
     */
    public void displayBatimentChoisi(int idJoueur, CarteChantier batiment){
        if(afficher){
            System.out.println("Le "+ANSI_CYAN+"joueur "+ idJoueur+ANSI_RESET+" a pioché la carte bâtiment "+batiment.getNom());
        }
    }

    /**
     * Méthode permettant d'afficher l'ouvrier choisi par le joueur
     * @param ouvrier la carte ouvrier que le joueur choisi
     */
    public void displayOuvrierChoisi(CarteOuvriers ouvrier){
        if(afficher){
            System.out.println("l'ouvrier "+ouvrier.getNom()+" ("+ouvrier.getIdCarte()+")");
        }
    }

    /**
     *  Méthode qui imprime les ouvriers d'un joueur
     * @param joueur un objet Joueur
     */
    public void displayOuvriersDuJoueur(Joueur joueur){
        if(afficher && joueur.getMainOuv().size()>0){// On itère sur le DeckOuvrier du moteur de jeu
        // si on trouve un ouvrier qui à un assign == idJoueur donné en paramètre : on l'imprime
            System.out.print("\nLe "+ANSI_CYAN+"joueur " + (joueur.getId())+ANSI_RESET +" possède ce(s) ouvrier(s) :");
            for(int i = 0; i < joueur.getMainOuv().size(); i ++){
            System.out.print(" " + joueur.getMainOuv().get(i).getNom()
                    + " (id = " + joueur.getMainOuv().get(i).getIdCarte() + ")");

            }
            System.out.println();
        }
    }

    /**
     *  Méthode qui imprime les chantiers d'un joueur
     * @param joueur un objet Joueur
     */
    public void displayChantierDuJoueur(Joueur joueur){
        // On itère sur le DeckBatiment du moteur de jeu
        // si on trouve un batiment qui à un assign == idJoueur donné en paramètre : on l'imprime
        if(afficher && joueur.getMainBat().size()>0) {
            System.out.print("\nLe "+ANSI_CYAN+"joueur " + (joueur.getId()) + ANSI_RESET+" construit ce(s) "+ANSI_PURPLE+"chantier(s)"+ANSI_RESET+" :");
            for (int i = 0; i < joueur.getMainBat().size(); i++) {
                System.out.print(" " + ANSI_PURPLE +joueur.getMainBat().get(i).getNom()
                        + ANSI_RESET+" (id = " + joueur.getMainBat().get(i).getIdCarte() + ")");
            }
            System.out.println();
        }
    }

    /**
     * Méthode qui affiche l'etat des chantiers d'un joueur
     * @param joueur un objet Joueur
     */
    public void displayEtatChantiersDuJoueur(Joueur joueur){
        if(afficher) {
            for (int i = 0; i < joueur.getMainBat().size(); i++) {
                System.out.println(joueur.getMainBat().get(i).toString(joueur)+"\n");
            }
        }
    }

    /**
     * Imprime les Bâtiments (chantiers terminés) d'un joueur
     * @param joueur un Objet joueur
     */
    public void displayChantierFini(Joueur joueur){
        if(afficher && joueur.getBuiltBat().size()>0) {
            System.out.print(ANSI_CYAN+"Joueur " + (joueur.getId()) +ANSI_RESET+ " a ce(s) bâtiment(s) de construit(s): "+ANSI_GREEN);
            for (int i = 0; i < joueur.getBuiltBat().size(); i++) {
                System.out.print(joueur.getBuiltBat().get(i).getNom() + ", ");
            }
            System.out.println(ANSI_RESET+"\n"); // juste pour le retour à la ligne
        }
    }

    /**
     * Imprime dans l'invite de commande l'état des cartes à piocher (toutes les cartes disponibles, ouvrier ou chantier)
     * @param carteOuvSurTable Ouvriers Disponibles
     * @param carteBatSurTable  Chantiers disponibles
     */
    public void displayCarteDispo(ArrayList<CarteOuvriers> carteOuvSurTable, ArrayList<CarteChantier> carteBatSurTable){
        if(afficher) {
            if(carteOuvSurTable.size()>0) {
                System.out.print(ANSI_GREEN + "Cartes ouvriers disponibles :" + ANSI_RESET);
                for (CarteOuvriers carteOuvriers : carteOuvSurTable) {
                    System.out.println(" - " + carteOuvriers.toString());
                }
            } else {
                System.out.println(ANSI_GREEN +"Il n'y a plus de cartes ouvriers disponibles dans le deck "+ ANSI_RESET);
            }
            System.out.print(ANSI_GREEN + "\nCartes chantiers disponibles :\n" + ANSI_RESET);
            for (CarteChantier carteBatiments : carteBatSurTable) {
                System.out.println(" - " + carteBatiments.toString());
            }
            System.out.println("\n"); // Juste pour un retour à la ligne
        }
    }

    /**
     * Méthode permettant l'affichage des points d'un joueur
     * @param joueur l'Objet joueur
     */
    public void displayPoint(Joueur joueur){
        if(afficher) {
            System.out.println("Le "+ANSI_CYAN+"joueur n°" + (joueur.getId()) + ANSI_RESET+" a "
                    + ANSI_GREEN + joueur.getPoints() + " point(s)" + ANSI_RESET);
        }
    }

    /**
     * Méthode permettant l'affichage du compteur d'action d'un joueur
     * @param c le compteur d'action
     */
    public void displayActions(Compteur c){
        if(afficher) {
            if (c.getNombreAction() < 2) {
                System.out.println("Il reste " + ANSI_RED+ c.getNombreAction() + " action"+ ANSI_RESET);
            }
            else {
                System.out.println("Il reste " + ANSI_RED+ c.getNombreAction() + " actions"+ANSI_RESET);
            }
        }
        }


    /**
     * Méthode permettant l'affichage de la bourse d'un joueur
     * @param joueur l'Objet joueur
     */
    public void displayBourse(Joueur joueur){
        if(afficher) {System.out.println("Le "+ANSI_CYAN+"joueur "+ (joueur.getId()) + ANSI_RESET+" possede "+ANSI_YELLOW +joueur.getBourse().getEcus()+" écu(s)"+ANSI_RESET);}

    }

    /**
     * print les ouvriers posées sur un chantier par le joueur
     * @param ouvrier la carte ouvrier qu'on pose sur la carte batiment
     * @param batiment la carte batiment sur laquelle on pose l'ouvrier
     * @param idJoueur l'id du joueur auquel appartient les ouvriers
     */
    public void displayOuvPoseeSurChantier(CarteOuvriers ouvrier,CarteChantier batiment, int idJoueur){
        if(afficher){ System.out.println("le "+ANSI_CYAN+"joueur "+ idJoueur + ANSI_RESET+" pose l'ouvrier "
                            + ouvrier.getNom() + " ("+ouvrier.getIdCarte()+") sur le batiment "
                            + ANSI_PURPLE+batiment.getNom() + ANSI_RESET+" cela lui coûte "
                            + ANSI_YELLOW + ouvrier.getCout() + " écus"+ANSI_RESET);
        }
    }

    /**
     * Affiche un message quand un joueur passe son tour
     * @param idJoueur id du joueur
     * @param nbActions nb d'actions à passer
     * @param nbEcus nb d'écus gagné en vendant les actions
     */
    public void displayPasseTour(int idJoueur,int nbActions,int nbEcus){
        if(afficher && nbActions >1){
            System.out.println("Le "+ANSI_CYAN+"joueur "+ idJoueur+ ANSI_RESET+" passe son tour et vend "
                    +ANSI_RED+nbActions+ " actions "+ANSI_RESET+"restantes pour "
                    +ANSI_YELLOW+nbEcus+" écus"+ANSI_RESET);
        }
        else if(afficher){
            System.out.println("Le "+ANSI_CYAN+"joueur "+ idJoueur+ ANSI_RESET+" passe son tour et vend "
                    +ANSI_RED+ " une action "+ANSI_RESET+"restante pour "
                    +ANSI_YELLOW+nbEcus+" écus"+ANSI_RESET);
        }
    }

    /**
     * affiche un message quand un joueur achete un tour supplémentaire
     * @param idJoueur id du joueur
     * @param nbActions nb d'actions acheté par le joueur
     * @param nbEcus nb d'écus utilisé
     */
    public void displayAjouteTour(int idJoueur,int nbActions, int nbEcus){
        if(afficher) {
            System.out.println("Le "+ANSI_CYAN+"joueur " + idJoueur + ANSI_RESET+" achète " + nbActions + " action(s) pour " + ANSI_YELLOW +nbEcus + " écu(s)"+ANSI_RESET);
        }
    }

    /**
     * Affiche le nombre d'action que le joueur a utilisé
     * @param nbAction nombre d'action utilisé par le joueur
     */
    public void displayUtiliseAction(int nbAction){
        if (nbAction > 1 && afficher) {
            System.out.println("=> "+ANSI_RED + nbAction + " actions ont été utilisées"+ ANSI_RESET);
        }
        else if (afficher){
            System.out.println("=> "+ANSI_RED + nbAction + " action a été utilisée"+ ANSI_RESET);
        }
    }

    /**
     * Affiche la conversion d'écus en points
     * @param joueurID id du joueur
     * @param ecus ecus qui ont été convertis
     */
    public void displayConversionEcuPoint(int joueurID, int ecus){
        if (afficher) {
            System.out.println("Le " + ANSI_CYAN + "joueur " + joueurID + ANSI_RESET + " utilise "
                    + ANSI_YELLOW + (ecus) + " écus" + ANSI_RESET
                    + " pour gagner " + ANSI_GREEN + (ecus / 10) + " points" + ANSI_RESET);
        }
    }

    /**
     * affiche le joueur gagnant
     * @param idJoueur id du joueur
     */
    public void displayGagnant(int idJoueur){
        if (afficher){
            System.out.println(ANSI_WHITE_BACKGROUND+ANSI_BLACK+"Le Joueur "+idJoueur
                    +" a gagné !"+ANSI_RESET);
        }
    }


    /**
     * affiche le nb d'ecus du joueur
     * @param idJoueur id dujoueur
     * @param nbEcus les écus du joueur
     */
    public void displayEcus(int idJoueur,int nbEcus){
        if(afficher){System.out.println(ANSI_YELLOW+"la bourse actuelle du "+ANSI_CYAN+"joueur "+idJoueur+ANSI_YELLOW
                + " est de "+nbEcus+ " écu(s)\n"+ANSI_RESET);}
    }

    /**
     * affiche le classement de fin de partie
     * @param joueurs liste de tous les joueurs
     */
    public void displayClassement (ArrayList<Joueur> joueurs){
        if (afficher){
            Collections.sort(joueurs); //on tri les joueurs par les points
            System.out.println("\n"+ANSI_YELLOW+"Voici le classement :"+ANSI_RESET + "\n");
            for (int i = 0; i < joueurs.size(); i++){
                System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLACK+ (i+1)+". Joueur " +
                    ANSI_RESET+ANSI_WHITE_BACKGROUND+ANSI_YELLOW+joueurs.get(i).getId()+ANSI_RESET+
                        ANSI_WHITE_BACKGROUND+ANSI_BLACK+ " avec "+ joueurs.get(i).getPoints() +
                        " points." + ANSI_RESET);
                if (joueurs.get(i).getId() < 3){
                    System.out.println("Possedant comme IA, l'IA intelligent\n");
                }
                else {
                    System.out.println("Possedant comme IA, l'IA bête\n");
                }
            }
        }
    }

    /**
     * affiche le recapitulatif des parties lancés en mode stat
     * @param joueursGagnants liste des joueurs gagnants de chaque partie
     */
    public static void plusieursParties(ArrayList<Joueur> joueursGagnants){
        if (!afficher) {
            ArrayList<Integer> gagnants = new ArrayList<>();
            for (Joueur joueursGagnant : joueursGagnants) { //itere sur la taille de joueursGagnants
                if (joueursGagnant != null) { // si il y a bine un gagnant
                    gagnants.add(joueursGagnant.getId());
                } else { // car parfois on a pas de gagnant, à resoudre
                    gagnants.add(0);
                }
            }
            System.out.println("Voici le recapitulatif de(s) " + gagnants.size() + " parties lancés :\n");
            System.out.println("Le Joueur 1 avec l'IA intelligent a gagné : " + Collections.frequency(gagnants, 1)
                    + " fois");
            System.out.println("Le Joueur 2 avec l'IA intelligent a gagné : " + Collections.frequency(gagnants, 2)
                    + " fois");
            System.out.println("Le Joueur 3 avec l'IA bête a gagné        : " + Collections.frequency(gagnants, 3)
                    + " fois");
            System.out.println("Le Joueur 4 avec l'IA bête a gagné        : " + Collections.frequency(gagnants, 4)
                    + " fois");

            //System.out.println("\nIl y a eu " + Collections.frequency(gagnants, 0) + " parties interminés");

            System.out.println("\nUn joueur avec un IA intelligent a gagné " +
                    (Collections.frequency(gagnants, 1) + Collections.frequency(gagnants, 2)) + " fois");
            System.out.println("Un joueur avec un IA bête a gagné " +
                    (Collections.frequency(gagnants, 3) + Collections.frequency(gagnants, 4)) + " fois");
        }
    }
}
