# Projet2a

## Vue d'ensemble
Ce projet est une application web basée en Java utilisant l'architecture Modèle-Vue-Contrôleur (MVC). Il comprend diverses classes Java pour la gestion de la logique métier, des pages JSP pour l'interface utilisateur et une intégration avec une base de données (MySQL).

## Structure du projet
- **src/** : Contient les classes Java pour les modèles, contrôleurs et objets d'accès aux données (DAOs) de l'application.
  - `Appareil`, `Branche`, `Disponibilite`, et `Utilisateur` : Principaux composants gérés dans l'application.
  - Classes `Controleur` : Gèrent la logique de l'application pour divers composants.
  - Classes `DAOModele` : Gèrent les interactions avec la base de données.
- **WebContent/** : Contient les vues JSP pour l'interface utilisateur de l'application.
  - Les vues telles que `AppareilVue.jsp`, `BrancheVue.jsp`, etc., correspondent à différents modules de l'application.
  - **WEB-INF/** : Fichiers de configuration et bibliothèques, y compris `web.xml` pour la configuration de l'application.

## Instructions d'installation
### Prérequis
- **Java** (version 8 ou supérieure recommandée)
- **Apache Tomcat** (pour le déploiement)
- **Base de données MySQL** (avec le connecteur `mysql-connector-java-5.1.49`)

### Étapes
1. **Importer le projet** : Ouvrez le projet dans un IDE (comme Eclipse) qui supporte Maven ou la gestion manuelle des bibliothèques.
2. **Configurer la base de données** : Mettez à jour les identifiants de connexion MySQL dans `ConnexionBDDModele.java`.
3. **Déployer** : Déployez le projet sur Apache Tomcat et accédez-y via `http://localhost:8080/Projet2a`.

## Utilisation
- Accédez aux différents modules via les vues correspondantes.
- Exemples de chemins :
  - `/AppareilVue.jsp` - Gérer les appareils.
  - `/BrancheVue.jsp` - Gérer les branches et les données associées.

## Bibliothèques
- **JSTL** : Pour le support des JSP et du langage d'expression.
- **MySQL Connector** : Gère les connexions à la base de données MySQL.
