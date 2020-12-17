# Les Batissuers

![alt text](https://jeuxdis.files.wordpress.com/2016/06/lb41.png)

Version Java  du jeu Les Batisseurs avec deux IA

## Installation
telecharger [Maven](https://maven.apache.org/download.cgi) 

## Terminal
dans le fichier du projet
```
mvn install
```

```
cd serveur
```
une seule partie avec l'affichage du déroulement
```
mvn exec:java@normal
```
500 parties sans l'affichage du déroulement
```
mvn exec:java@stats
```