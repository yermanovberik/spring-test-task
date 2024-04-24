

# Authentication API Documentation

## Overview

This document provides information on the authentication API endpoints for the Spring Boot application. The API supports registration and login operations.

## Prerequisites

- Java 11 or higher
- Spring Boot 2.3.x or higher
- Maven 3.x or higher

Ensure that the application is running on localhost (default port 8080) or adjust the base URL in the examples accordingly.

## API Endpoints

## Link to postman - https://elements.getpostman.com/redirect?entityId=28284936-9420e4e7-b0ff-461e-a445-beb8c33057ed&entityType=collection

### 1. Register

- **URL:** `/api/v1/auth/register`
- **Method:** `POST`
- **Status Code:** `200 OK` upon success
- **Request Body:**

```json
{
    "username":"yermanov",
    "password":"35ipihef",
    "confirmPassword":"35ipihef",
    "fullName":"Berik Yerman",
    "avatarUrl": "2342324"
}

Response Body:


{
  "accessToken": "eyJhb...",
  "refreshToken": "dGhpcy..."
}


### 2.Login

- **URL:** `/api/v1/auth/login`
- **Method:** `POST`
- **Status Code:** `200 OK` upon success
- **Request Body:**

```json
{
    "username":"yermanov",
    "password":"35ipihef"
}

Response Body:


{
  "accessToken": "eyJhb...",
  "refreshToken": "dGhpcy..."
}


