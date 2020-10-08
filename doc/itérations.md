# bat20-B
bat20-bat20-b created by GitHub Classroom

ITERATION 1 
- Création d'une carte (sans propriétés type coûts, ...)
- Création d'un joueur unique
- Définition de l'action "Piocher"
- Joueur pioche une carte
- Définir une condition de fin de partie : le joueur a choisit la carte

ITERATION 2
- Création du deck
- Ajout d'un deuxième joueur
- Définition de l'action "Placer une carte"
- Création du compteur d'action (3)
- Fin du jeu quand on a placé un ouvrier sur un batiment

ITERATION 3
- Attribution des propriétés des cartes batiments et ouvrier (numéro unique : a débatre)
- Distinction types de carte
- Attribution automatique d'un apprentis en début de partie
- L'action "placer un ouvrier" bloque l'ouvrier en question
- Faire la somme des ressources des ouvriers placés sur un batiment
- Fin de partie : finir un batiment (la somme des ressources des ouvriers depasse celles du batiment)

ITERATION 4
- Génération des statistiques de fin de parties
- Génération de l'étalage des (5) cartes batiments et ouvrier, remplacer les cartes piochées
- Génération du portefeuille/bourse + attribution des 100 premiers écus (pour ne pas bloquer l'IA qui est encore basique)
- Vérification du portefeuille/bourse pour savoir si l'action est autorisée
- Gestion de la fin d'un batiment => Libération de l'ouvrier, on déplace la carte et donne les points et/ou des écus
- Condition de fin de partie : Finir un batiment

ITERATION 5
-Rapport de stage intermédiaire


ITERATION 6
- Gestion des tours : fin d'un tour après avoir utilisé toutes les actions
  - Création de l'action "Prendre de l'argent"/Skiper
- Création du compteur "Point de Victoire"
- Fin de partie : atteindre un certain nombre point

ITERATION 7
- Modification de la fin d'un tour : tout le monde a utilisé ses actions ? Ordre : d'abord le joueur 1 utilise toutes ses actions, puis le joueur 2
- Améliorer l'IA (stratégie simple)
- Désignation du premier joueur avec le totem
- Gestion des machines, batiments => ouvriers
- Fin de partie : on fait 2-3 tour, celui qui a le plus de point gagne (égalité non gérée)

ITERATION 8
- Vraie condition de fin de partie + les conditions supplémentaires en cas d'égalité
- Création du classement en fonction des conditions de fin de partie
- Mise en place de 4 joueurs

ITERATION 9
- Amélioration de l'IA


