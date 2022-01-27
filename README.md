LISEZ MOI :
Memento – Projet Application mobile Android Graine de Copeaux – Jeudi 27 janvier 2022

Intervenants du projet : CREMON Damien, DI PAOLO Hugo, DI TULLIO Louis et WOILLARD Éric 
Pour télécharger Android Studio : https://developer.android.com/studio
Activer la virtualisation, essentielle pour l’émulation du téléphone sous Android Studio : https://www.youtube.com/watch?v=pzrrxsdiIWU

Affichage de l’application lorsqu’elle démarre : 
Pour ouvrir le projet, faire « File – Open » et sélectionner le bon dossier. 
 

A gauche, les différents dossiers importants de l’application apparaissent, et à droite la programmation Interface Homme Machine 




Java - MainActivity -> Fichier .java du projet qui est l’activité principale du projet (liens entre les pages et connexion BdD MySQL)
Java - ConnectMySql -> Connexion de la BdD G2C à l’application, là aussi où il faut mettre toutes les requêtes SQL pour récupérer les données)
Res – drawable -> Toutes les images utilisées pour le projet en PNG ou XML
Dossier Font -> Les polices enregistrées de G2C au format .ttf et également le lancement 
Dossier Layout -> Les différentes pages de notre projet (fragment_dashboard = menu, fragment_home = page d’accueil…) 
Dossier Menu -> Les barres de menu utilisées sur chaque page en haut et en bas de l’application 
Dossier MipMap -> Les icônes repris d’Android Studio utilisés dans le projet (logos pour la plupart)
Dossier Navigation -> Les 3 écrans principaux pour naviguer dans l’application 
Dossier values -> colors.xml représentent les couleurs utilisées pour le projet (reprises de G2C), dimens.xml représentent les dimensions générales prises pour les pages du projet 
Values - Strings -> Toutes les variables utilisées dans le projet déclarées ici, 2 fichiers présents, un pour le mode jour et un pour le mode nuit 
Themes -> themes.xml pour tous les thèmes utilisés dans le projet, 2 fichiers présents, un pour le mode jour et un pour le mode nuit
Gradle Scripts – build.gradle -> Implémentations de scripts pour faire fonctionner l’appli 

Pour afficher les pages du projet, il faut double-cliquer sur les fragments.

A ce moment-là, vous pouvez sélectionner 3 modes en haut à droite de l’application qui sont « Code » où on voit uniquement le Code utilisé de la page, « Split » où on voit le code et l’interface réalisé grâce à celui-ci, et « design » où on voit l’interface et à gauche toutes les options possibles pour en IHM.  

Pour compiler et lancer le programme global il faut cliquer sur la flèche verte en haut de l’écran.

Amelioration possible de l'appli :

Amélioration possible de l'appli :-développement d'une base de données en MySQL ou Lite Sql
-Étude du projet afin d'effectuer un schéma E/A pour ensuite de la bdd-Continuer la partie Login
-Televerse les cours et QCM dans la BDD directement dans l'appli en les incrémentant dans un Scroll View
-Gestion des profils personnalise
-Respecter le RGPD
-Ajout de formulaire en mode prof pour rajouter des cours et des qcm dans l'appli
-Randomiser l'apparition des question et de l'ordre d'affichage des reponses
-Développer un PDF Viewer 
