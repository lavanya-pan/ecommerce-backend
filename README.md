# E-Commerce Backend

A REST API for an e-commerce platform built with Spring Boot, MySQL, and JWT Authentication.

## Features
- Product management (Add, Get, Update, Delete, Search)
- User registration and login
- JWT-based authentication
- Clean layered architecture (Controller → Service → Repository)

## Technologies
- Java
- Spring Boot
- MySQL
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- BCrypt password hashing
- Maven

## API Endpoints

### Auth
- POST /api/auth/register — Register a new user
- POST /api/auth/login — Login and get JWT token

### Products
- POST /api/products — Add a product
- GET /api/products — Get all products
- GET /api/products/{id} — Get product by ID
- GET /api/products/search?name= — Search products by name
- PUT /api/products/{id} — Update a product
- DELETE /api/products/{id} — Delete a product
