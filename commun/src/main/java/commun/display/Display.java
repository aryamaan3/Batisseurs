package commun.display;

import commun.batiments.CarteBatiments;
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
    boolean afficher;


    public Display(boolean afficher){
        this.afficher = afficher;
    }


    public boolean isAfficher(){
        return afficher;
    }
    public void setAfficher(boolean afficher){
        this.afficher = afficher;
    }



    public void displayString(String s){
        if(afficher){System.out.println(s);}
    }

    public void displayBatimentChoisi(int idJoueur, CarteChantier batiment){
        if(afficher){
            System.out.println("Le joueur "+ idJoueur+" a pioché la carte bâtiment "+batiment.getNom());
        }
    }
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
            System.out.println("\nLe joueur " + (joueur.getId())+ " possède ce(s) ouvrier(s) :");
            for(int i = 0; i < joueur.getMainOuv().size(); i ++){
            System.out.println(" - " + joueur.getMainOuv().get(i).getNom()
                    + " (id = " + joueur.getMainOuv().get(i).getIdCarte() + ")");

            }
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
            System.out.println("\nLe joueur " + (joueur.getId()) + " construit ce(s) chantier(s) :");
            for (int i = 0; i < joueur.getMainBat().size(); i++) {
                System.out.println(" - " + joueur.getMainBat().get(i).getNom()
                        + " (id = " + joueur.getMainBat().get(i).getIdCarte() + ")");
            }
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
            System.out.print("Joueur " + (joueur.getId()) + " a ce(s) bâtiment(s) de construit(s): ");
            for (int i = 0; i < joueur.getBuiltBat().size(); i++) {
                System.out.print(joueur.getBuiltBat().get(i).getNom() + ", ");
            }
            System.out.println("\n"); // juste pour le retour à la ligne
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
                    System.out.print(" " + carteOuvriers.getNom() + "(id=" + carteOuvriers.getIdCarte() + ")" + " |");
                }
            } else {
                System.out.println(ANSI_GREEN +"Il n'y a plus de cartes ouvriers disponibles dans le deck "+ ANSI_RESET);
            }
            System.out.print(ANSI_GREEN + "\nCartes chantiers disponibles :" + ANSI_RESET);
            for (CarteChantier carteBatiments : carteBatSurTable) {
                System.out.print(" " + ((CarteBatiments) carteBatiments).getNom() + " |");
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
            System.out.println("Le joueur n°" + (joueur.getId()) + " a "
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
                System.out.println("Il reste " + c.getNombreAction() + " action");
            }
            else {
                System.out.println("Il reste " + c.getNombreAction() + " actions");
            }
        }
        }


    /**
     * Méthode permettant l'affichage de la bourse d'un joueur
     * @param joueur l'Objet joueur
     */
    public void displayBourse(Joueur joueur){
        if(afficher) {System.out.println("Le joueur "+ (joueur.getId()) + " possede "+ joueur.getBourse().getEcus()+" écu(s)");}

    }

    /**
     * Affichage des stats
     * @param joueur Objet Joueur
     */
    public void displayStats(Joueur joueur){
        System.out.println(ANSI_CYAN +"\nJoueur"+ (joueur.getId()) +ANSI_RESET);
        System.out.println("Points : "+joueur.getPoints());
        System.out.println("Ecus : "+joueur.getBourse().getEcus());
        System.out.println("Actions travailler (ouvriers attribués) : "+joueur.getStats().getNbActionsTravailler());
        System.out.println("Actions recrutement (ouvriers recrutés) :"+joueur.getStats().getNbActionsRecrutement());
        System.out.println("Ecus dépensés pour les ouvriers :"+joueur.getStats().getNbEcusDépensésOuv());
        System.out.println("Revenus des Bâtiments :"+joueur.getStats().getNbRevenusBat());
    }

    /**
     * print les ouvriers posées sur un chantier par le joueur
     * @param ouvrier la carte ouvrier qu'on pose sur la carte batiment
     * @param batiment la carte batiment sur laquelle on pose l'ouvrier
     * @param idJoueur l'id du joueur auquel appartient les ouvriers
     */
    public void displayOuvPoseeSurChantier(CarteOuvriers ouvrier,CarteChantier batiment, int idJoueur){
        if(afficher){ System.out.println("le joueur "+ idJoueur + " pose l'ouvrier "
                            + ouvrier.getNom() + " ( "+ouvrier.getIdCarte()+" ) sur le batiment "
                            + batiment.getNom() + " cela lui coûte "
                            + ouvrier.getCout() + " écus");
        }
    }

    /**
     * Affiche un message quand un joueur passe son tour
     * @param idJoueur id du joueur
     * @param nbActions nb d'actions à passer
     * @param nbEcus nb d'écus gagné en vendant les actions
     */
    public void displayPasseTour(int idJoueur,int nbActions,int nbEcus){
        if(afficher){System.out.println("Le joueur "+ idJoueur+ " passe son tour et vend "+nbActions+ " action(s) restante(s) pour "+nbEcus+" écu(s)");}
    }

    /**
     * affiche un message quand un joueur achete un tour supplémentaire
     * @param idJoueur id du joueur
     * @param nbActions nb d'actions acheté par le joueur
     * @param nbEcus nb d'écus utilisé
     */
    public void displayAjouteTour(int idJoueur,int nbActions, int nbEcus){
        if(afficher) {
            System.out.println("Le joueur " + idJoueur + " achète " + nbActions + " action(s) pour " + nbEcus + " écu(s)");
        }
    }

    /**
     * affiche le joueur gagnant
     * @param idJoueur id du joueur
     */
    public void displayGagnant(int idJoueur){
        if(!afficher) {
            System.out.println(ANSI_RED+"\nLe joueur "+idJoueur+ " a gagné la partie !"+ANSI_RESET);
        }
    }


    /**
     * affiche le nb d'ecus du joueur
     * @param idJoueur id dujoueur
     * @param nbEcus les écus du joueur
     */
    public void displayEcus(int idJoueur,int nbEcus){
        if(afficher){System.out.println(ANSI_RED+"la bourse actuelle du joueur "+idJoueur+ " est de "+nbEcus+ " écu(s)\n"+ANSI_RESET);}
    }

    /**
     * affiche le classement de fin de partie
     * @param joueurs liste de tous les joueurs
     */
    public void displayClassement (ArrayList<Joueur> joueurs){
        if (afficher){
            Collections.sort(joueurs);
            System.out.println("\n"+ANSI_BLACK_BACKGROUND+ANSI_YELLOW+"Voici le classement :"+ANSI_RESET);
            for (int i = 0; i < joueurs.size(); i++){
                System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLACK+ (i+1)+". Joueur " + joueurs.get(i).getId()+
                        " avec "+ joueurs.get(i).getPoints() + " points." + ANSI_RESET);
            }
        }
    }
}
