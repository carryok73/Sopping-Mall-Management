# Shopping Mall Management System

A full-stack Spring Boot web application for managing customers, shop owners, and shops in a shopping mall ecosystem.

## Features

- Dashboard with customer, owner, and shop counts
- CRUD operations for customers
- CRUD operations for shop owners
- CRUD operations for shops
- Shop-to-owner relationship
- MySQL database integration
- Environment-variable based deployment configuration
- Docker and Render deployment support

## Tech Stack

- Java 17
- Spring Boot 3
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Docker

## Local Setup

1. Import the included database file:

```bash
mysql -u root -p < database.sql
```

This creates:

- `shopping_mall_db`
- `customers` table
- `owners` table
- `shops` table
- sample customer, owner, and shop records

2. Set database environment variables if your MySQL username or password is different:

```bash
DATABASE_URL=jdbc:mysql://localhost:3306/shopping_mall_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
DATABASE_USERNAME=root
DATABASE_PASSWORD=your_mysql_password
```

3. Run the app:

```bash
mvn spring-boot:run
```

4. Open:

```text
http://localhost:8080
```

## Database File

The project includes `database.sql` in the root folder. Use it when you want to manually create the database before running the project.

If you do not import the SQL file, Spring Boot can still create the tables automatically because `spring.jpa.hibernate.ddl-auto` defaults to `update`. However, importing `database.sql` is useful because it also adds sample records for testing.

## Online Deployment Notes

This project does not store uploaded files or database data on the app server disk. That avoids the common persistent disk issue on platforms where the web service filesystem is temporary.

Use a hosted MySQL database and import `database.sql` into that hosted database if you want the same starter data online. Then set these environment variables in your deployment platform:

- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `JPA_DDL_AUTO=update`

For Render, connect the repository and use the included `Dockerfile` or `render.yaml`. If your MySQL provider gives a full JDBC URL, use it directly as `DATABASE_URL`.

Example JDBC URL:

```text
jdbc:mysql://hostname:3306/database_name?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=UTC
```
