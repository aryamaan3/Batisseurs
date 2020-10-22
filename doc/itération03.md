# bat20-B

Fonctionnalités livrées et issues réalisées : 
- Fonctionnalités livrées :
    - Deuxieme Joueur
    - Construction d'un chantier
    - Plusieurs ouvriers sur un chantier
    - création des apprentis, et attribution au hasard 

- Issue réalisée :
    - Ajout deuxieme joueur
    - Shuffle des decks
    - Refactoring du main
    - Attribution des apprentis
    - Construction des chantiers, Methode IsBuilt
    - Placer plusiers ouvriers sur un chantier
    - Creation (presque) toutes les cartes

- Tests :
    - Test shuffle
    - Test GetApprenti
    - Test isBuilt
    - Ajout cas de Test dans Test Placer

- Organisation du code :
    - nous avons ajouté une nouvelle classe findInDeck qui permet de trouver un ouvrier dans le deck grace a son id
    - nous avons ajouté une classe shufffle qui permet de distibuer 5 cartes aléatoires 
    - nous avons modifié le moteur de jeux en créant une nouvelle methode de jeux : déroulementJeux afin d'alléger le main
    - nous utilisons maintenant les classes DeckBatiments et DeckOuvriers afin de d'attribuer des crates aux joueurs
    
