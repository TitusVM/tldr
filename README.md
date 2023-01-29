# TLDR

## Utilisation

Pour utiliser l'application, il faut se munir de l'application [SpringToolSuite4](https://spring.io/tools). Pour les meilleurs résultats il est important d'importer le git dans le workspace. Pour cela, il suffit de suivre pas à pas les étapes suivantes:

* Ouvrir SpringToolSuite4
* `File` -> `Import` -> `Git` -> `Projects from Git (with smart import)` -> `Clone URI`
* Rentrer l'URI du git: `git@gitlab-etu.ing.he-arc.ch:isc/2022-23/niveau-3/3281.1-projet-p3-sa-il/201/p3evernym.git`
* Choisir la branche `main`
* Poursuivre l'importation


## Connexion

Une fois le projet importé dans Eclipse avec les packages Spring, il suffit de soit lancer avec la commande `Run As -> Springboot App`, ou alors avec la commande `Maven build... -> Goals: install clean` si on n'a pas encore les packages installés.

On peut se connecter avec un compte administrateur avec les informations suivantes:

- Username: `admin@tldr.com`
- Password: `admin`

La page `/users` n'est accesible qu'avec ce compte administrateur. D'ailleurs, il faut être loggé pour accéder aux fonctionnalités CRUD de l'application.

Pour se créer un compte, il suffit de naviguer sur `/login` en appuyant sur le bouton Login dans la barre de navigation.

## Seeder

En début d'exécution, l'application reçoit une vingtaine de TLDRs par un Seeder. Ce Seeder crée aussi l'utilisateur Administrateur, il est donc nécessaire de le lancer avec chaque exécution. Si l'on souhaite lancer l'application sans le Seeder, il suffit de commenter les appels de méthodes dans la fonction `run()` du [DBSeeder.java](https://github.com/TitusVM/tldr/blob/main/tldr/src/main/java/ch/hearc/jee/tldr/seed/DBSeeder.java).
