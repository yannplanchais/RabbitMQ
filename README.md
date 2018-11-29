# Projet RABBITMQ

projet permettant de mettre en oeuvre de manière simple une l'utilisation d'une file RabbitMQ.

Ce projet se compose de 2 aspects :

- une classe qui sert d'emetteur de message, qui envoie un message à chaque execution vers la file qui est configurée.
- une classe qui sert de recepteur et qui tourne en continue pour dépiler la file au fur et à mesure.

A noter qu'il faut que RabbitMQ soit installé sur le poste en question et qu'il soit démarré
(sous windows, il est démarré en tant que Service tourne sur le port 5672).

