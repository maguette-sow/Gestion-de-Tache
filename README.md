# Gestion-de-Tache
# Application ToDo - Spring Boot

## Description

Ce projet est une application web de gestion de tâches (ToDoList) développée avec **Spring Boot**.  
Elle permet aux utilisateurs de créer, afficher, modifier, supprimer et marquer des tâches comme terminées.

L'application respecte les **bonnes pratiques de développement** notamment :
- séparation des couches
- principes SOLID
- validation des données
- gestion des exceptions

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap

## Architecture du projet

Le projet suit une **architecture en couches (Layered Architecture)** afin de séparer les responsabilités.

Controller → Service → Repository → Database
↓
DTO
↓
Mapper
↓
Entity


Structure du projet :

com.unchk.todo
│
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
└── templates


Chaque couche possède une responsabilité spécifique.

---

# 1. Séparation des couches

L'application est organisée en plusieurs couches afin de respecter la séparation des responsabilités.

### Controller
La couche **Controller** gère les requêtes HTTP et les interactions avec les pages web.

Exemple :
TaskController

### Service
La couche **Service** contient la logique métier de l'application.

Exemple :
TaskService
TaskServiceImpl


### Repository
La couche **Repository** permet l'accès à la base de données via Spring Data JPA.

Exemple :
TaskRepository


### Entity
Les **Entities** représentent les tables de la base de données.

Exemple :
Task


### Mapper
Le **Mapper** convertit les données entre les DTO et les Entities.

Exemple :
TaskMapper


---

# 2. Application des principes SOLID

Le projet applique plusieurs principes SOLID.

## Single Responsibility Principle (SRP)

Chaque classe possède une seule responsabilité.

Exemples :

- `TaskController` gère uniquement les requêtes web
- `TaskServiceImpl` contient la logique métier
- `TaskRepository` gère l'accès à la base de données

## Open/Closed Principle (OCP)

Les classes sont **ouvertes à l'extension mais fermées à la modification**.

Par exemple, l'interface :
TaskService


peut être implémentée par différentes classes sans modifier le reste du système.

## Dependency Inversion Principle (DIP)

L'application utilise l'injection de dépendances fournie par Spring.

Exemple :
private final TaskService service;

public TaskController(TaskService service) {
this.service = service;
}



Le contrôleur dépend d'une **interface** et non d'une implémentation concrète.

---

# 3. Utilisation d'un DTO

Le projet utilise un **DTO (TaskDTO)** pour transporter les données entre les couches.

Cela permet :
- de ne pas exposer directement les entités
- de mieux contrôler les données reçues du formulaire

Flux de données :
Formulaire HTML
↓
TaskDTO
↓
TaskMapper
↓
Task Entity
↓
Database



---

# 4. Mapper

Le **TaskMapper** permet de convertir les données entre :
TaskDTO → Task
Task → TaskDTO



Cela permet de séparer :
- la logique de présentation
- la logique métier
- la logique de persistance

---

# 5. Gestion des exceptions

Les exceptions sont gérées de manière centralisée grâce à :
GlobalExceptionHandler


et une exception personnalisée :
TaskNotFoundException


L'utilisation de `@ControllerAdvice` permet de gérer les erreurs dans un seul endroit de l'application.

---

# 6. Validation des données

La validation est réalisée avec **Jakarta Validation**.

Exemple :
@NotBlank(message = "Le titre est obligatoire")


La validation est activée dans le contrôleur avec :
@Valid
BindingResult


Cela empêche l'enregistrement de données invalides dans la base de données.

---

# Fonctionnalités de l'application

L'application propose un CRUD complet :

- Ajouter une tâche
- Afficher les tâches
- Modifier une tâche
- Supprimer une tâche
- Marquer une tâche comme terminée

---

# Base de données

L'application utilise **MySQL** pour stocker les tâches.

Table principale :
tasks


Champs :

- id
- title
- description
- status

---

# Lancer l'application

1. Cloner le projet depuis GitHub
2. Configurer la base de données MySQL
3. Modifier le fichier :
application.properties


4. Lancer l'application :
TodoApplication.java



5. Ouvrir dans le navigateur :
http://localhost:8080/tasks



---

# Auteur

Projet réalisé par :

**Maguette Sow**

Master 1 Ingénierie Logicielle  
Université Numérique Cheikh Hamidou Kane
