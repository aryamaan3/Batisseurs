# bat20-B

Fonctionnalités livrées et issues réalisées : 
- Fonctionnalités livrées :
    - On peut affecter une carte chantier à un joueur
    - On peut mettre un ouvrier sur un chantier
    - On gagne quand un ouvrier est placé sur un chantier
    - Cependant nous n'avons pas le temps de créer un deuxième joueur et repoussant donc cette fonctionnalité à la prochaine itération 

- Issue réalisée :
    - Création Choisir Ouvrier
    - Création squelette pour tous les cartes
    - Creation affectation d'un joueur aux cartes
    - Creation de placerOuvrierSurChantier

- Tests :
    - Test Cartes
    - Test Piocher
    - Test ChoisirOuvrier

- Organisation du code :
    - Nous avons créé une classe mère Cartes et deux classes filles : CarteBatiments et CarteOuvriers.
    - Nous n'avons pas modifié la classe joueur, elle sert toujours à déclarer le joueur.
    - Nous avons modifié la classe MoteurDeJeux afin de répondre la user story. En effet nous avons créé trois nouvelles méthodes choisirOuvrier, choisirChantier et placeOuvrierSurChantier qui permettent d'assigner un ouvrier à un chantier
    - Nous avons aussi créé une classe deck que nous n'avons pas utilisé pour cette issue, mais elle pourrait être utile pour les issues suivantes. 
    