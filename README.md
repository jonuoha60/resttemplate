# REST Template API Integration

## Overview

This Spring Boot project demonstrates how to **consume external REST APIs** using `RestTemplate`. It integrates with multiple public APIs (e.g., JSONPlaceholder, CatFact, REST Countries) to perform:

-  GET, POST, PUT, DELETE operations
-  Mapping JSON responses to Java POJOs
-  Logging with SLF4J Logger
-  Exposing custom endpoints using `@RestController`

---

## Dependencies Used

- Java 17+
- Spring Boot
- Spring Web (RestTemplate)
- Lombok
- Maven
- Jackson (for JSON mapping)
- SLF4J (for logging)

---

## 🔗 External APIs Used

| API               | Purpose                | Sample Endpoint                              |
|------------------|------------------------|-----------------------------------------------|
| JSONPlaceholder  | Simulated CRUD         | `https://jsonplaceholder.typicode.com/posts` |
| Cat Fact         | Random cat facts       | `https://catfact.ninja/fact`                 |
| REST Countries   | Country list info      | `https://countriesnow.space/api/v0.1/countries` |
| Random User      | Fake user generator    | `https://randomuser.me/api/`                 |

---

## Custom API Endpoints

| Endpoint              | Method | Description                          |
|-----------------------|--------|--------------------------------------|
| `/country`            | GET    | Get list of countries                |
| `/cat`                | GET    | Get a random cat fact                |
| `/randomusers`        | GET    | Get a random user                    |
| `/posts`              | GET    | Fetch posts from JSONPlaceholder     |
| `/createpost`         | POST   | Create a post                        |
| `/updatepost?id=1`    | PUT    | Update post with given ID            |
| `/deletepost?id=1`    | DELETE | Delete post with given ID            |
| `/info`               | GET    | Sample param handler (`name`, `age`) |

---

##  Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/resttemplate.git
