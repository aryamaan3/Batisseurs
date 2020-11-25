# bat20-B

Fonctionnalités livrées et issues réalisées : 
- Fonctionnalités livrées :
  - Le client peut lancer plusieurs parties
  - Le premier joueur est choisi aléatoirement
  - Statisiques de fin de partie
  - Possiblité d'avoir plus de deux joueurs
  
- Issues réalisées :
  - Méthode nbPartie() qui permet de lancer plusieurs parties
  - Création des joueurs à présent de le main 
  - Supression des méthodes qui étaient en statique 
  - Méthode qui permet la génération de statistiques
  - Correction du pom afin que maven fonctionne avec la nouvelle configuration en multi module 
  
- Tests : 
  - Ajout des tests des nouvelles méthodes 
  
- Organisation de code :
  - Amélioration de l'affichage 
  - Refactoring pour afin de permetttre que n'importe quelle joueur commence 
  - Refactoring pour organiser le code en plusieurs modules afin de préparer l'aspect client/serveur
  - Refactoring afin de réduire le nombre de println
