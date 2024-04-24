# Authentication API Documentation

## Overview

This document provides information on the authentication API endpoints for the Spring Boot application. The API supports registration and login operations.

## Prerequisites

- Java 11 or higher
- Spring Boot 2.3.x or higher
- Maven 3.x or higher

Ensure that the application is running on localhost (default port 8080) or adjust the base URL in the examples accordingly.

## API Endpoints

### 1. Register

- **URL:** `/api/v1/auth/register`
- **Method:** `POST`
- **Status Code:** `200 OK` upon success
- **Request Body:**

```json
{
  "username": "user",
  "password": "password"
}

Response Body:


{
  "accessToken": "eyJhb...",
  "refreshToken": "dGhpcy..."
}
