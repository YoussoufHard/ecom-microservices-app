# 🏪 Système de Gestion de Facturation - Architecture Microservices

## 📋 Description du Projet
Application de gestion de facturation basée sur une architecture microservices, développée avec Spring Boot et Spring Cloud. Le système permet de gérer des clients, des produits et des factures de manière distribuée et évolutive.

## 🏗️ Architecture du Projet

### Microservices
1. **customer-service** : Gestion des clients
   - CRUD des clients
   - API REST pour les opérations client

2. **inventory-service** : Gestion des produits
   - CRUD des produits
   - Gestion du stock

3. **billing-service** : Gestion des factures
   - Création et gestion des factures
   - Intégration avec customer-service et inventory-service via OpenFeign

4. **api-gateway** : Spring Cloud Gateway
   - Routage dynamique des requêtes
   - Gestion des CORS
   - Load balancing

5. **eureka-discovery-service** : Service d'annuaire
   - Découverte des services
   - Gestion des instances

6. **config-service** : Service de configuration centralisée
   - Configuration externe des microservices
   - Gestion des profils

## 🛠️ Technologies Utilisées

- **Backend**:
  - Java 17
  - Spring Boot 3.x
  - Spring Cloud (Gateway, Eureka, Config)
  - OpenFeign
  - Spring Data JPA
  - H2 Database (développement)
  - PostgreSQL (production)

- **Outils**:
  - Maven
  - Git
  - Docker (optionnel)

## 🚀 Installation et Démarrage

### Prérequis
- JDK 17
- Maven 3.6+
- PostgreSQL (pour la production)
- Docker (optionnel)

### Configuration
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/YoussoufHard/ecom-microservices-app.git
   cd ecom-microservices-app
   ```

2. Démarrer les services dans l'ordre :
   ```bash
   # 1. Service de configuration
   cd config-service
   mvn spring-boot:run

   # 2. Service Eureka
   cd ../eureka-discovery-service
   mvn spring-boot:run

   # 3. Autres services (dans l'ordre) :
   # customer-service
   # inventory-service
   # billing-service
   # api-gateway
   ```

## 📚 Documentation des API

### Customer Service
- `GET /api/customers` - Lister tous les clients
- `GET /api/customers/{id}` - Obtenir un client par ID
- `POST /api/customers` - Créer un nouveau client
- `PUT /api/customers/{id}` - Mettre à jour un client
- `DELETE /api/customers/{id}` - Supprimer un client

### Inventory Service
- `GET /api/products` - Lister tous les produits
- `GET /api/products/{id}` - Obtenir un produit par ID
- `POST /api/products` - Créer un nouveau produit
- `PUT /api/products/{id}` - Mettre à jour un produit
- `DELETE /api/products/{id}` - Supprimer un produit

### Billing Service
- `GET /api/invoices` - Lister toutes les factures
- `GET /api/invoices/{id}` - Obtenir une facture par ID
- `POST /api/invoices` - Créer une nouvelle facture
- `GET /api/invoices/customer/{customerId}` - Obtenir les factures d'un client

## 🧪 Tests
Pour exécuter les tests :
```bash
mvn test
```

## 📊 Schéma de la Base de Données
Le schéma de la base de données sera disponible dans le dossier `docs/`.

## 🤝 Contribution
1. Forkez le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Pushez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

## 📝 Licence
Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

## 📞 Contact
Tangara Youssouf - [ytangara2003@gmail.com](mailto:ytangara2003@gmail.com)  
Lien du projet : [https://github.com/YoussoufHard/ecom-microservices-app](https://github.com/YoussoufHard/ecom-microservices-app)

---
Développé avec ❤️ par [Youssouf Tangara](https://github.com/YoussoufHard)
