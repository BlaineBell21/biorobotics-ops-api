
# BioRobotics Ops API

A full-stack portfolio project simulating an operations management platform for biomedical and robotic devices. The application is designed around managing device information, measurements, quality assurance workflows, and audit data while following modern software development practices.

> **Status:** In Development 🚧

___

## Overview

BioRobotics Ops API is a portfolio project designed to simulate a real-world backend system used within biomedical engineering, robotics, or regulated manufacturing environments.

TThe project is being built from the ground up to strengthen my understanding of enterprise Java development, REST API design, database architecture, full-stack development, testing, and containerized applications.

The backend provides the core REST API and data management functionality, while a React frontend is being developed to provide a user-facing interface for interacting with the system.

---

## Project Goals

- Build a production-style REST API using Spring Boot
- Develop a React-based frontend to interact with the API
- Practice enterprise application architecture
- Gain experience working with PostgreSQL and database migrations
- Implement authentication and authorization with Spring Security & JWT
- Practice automated testing and API documentation
- Develop experience with Docker and containerized applications
- Build a portfolio project representative of software used in biomedical and robotics environments

---
## Tech Stack

### Backend

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Security *(planned)*
- Maven

### Frontend

* React
* Vite
* JavaScript
* React Router

### Database

- PostgreSQL
- Flyway

### DevOps

- Docker
- Docker Compose

### Testing

- JUnit 5
- Spring Boot Test
- Testcontainers *(planned)*

### Documentation

- OpenAPI / Swagger *(planned)*

### Monitoring

- Spring Boot Actuator
- Prometheus *(planned)*
- Grafana *(planned)*

[Back to Top](#biorobotics-ops-api)
___
## Features

- Light/dark mode toggle
- Live previews
- Fullscreen mode
- Cross platform

## Planned Features

### Device Management

- Create, update, archive, and retrieve devices
- Track device information and operational status
- Maintain device metadata
- Paginate device results

### Measurements

* Record measurements from devices
* Associate measurements with individual devices
* Track historical measurement data

### Quality Management

* Define acceptable measurement ranges
* Validate measurements against quality rules
* Identify failed quality checks

### Audit Logging

- Record important system actions
- Track user activity
- Maintain change history

### Security

- JWT Authentication
- Role-based authorization
- Protected API endpoints

### Monitoring

* Application health monitoring
* Application metrics
* Operational monitoring dashboards

[Back to Top](#biorobotics-ops-api)
___

## Frontend

The frontend is being developed with **React and Vite** and will provide a graphical interface for interacting with the BioRobotics Ops API.

Planned frontend functionality includes:

* Operations dashboard
* Device management
* Device search and pagination
* Device details and editing
* Measurement data
* Quality rule results
* Audit logs
* Authentication and role-based access
* Error handling and user feedback
* Data visualization

*The frontend and backend are being developed together so that API functionality can be tested and demonstrated through a practical user interface rather than exclusively through API testing tools.*

[Back to Top](#biorobotics-ops-api)

---
## Current Progress

*[Checkout my project board!](https://github.com/users/BlaineBell21/projects/10)*

### Completed

* [x] Project initialized
* [x] Maven configured
* [x] Spring Boot application configured
* [x] Java 21 configured
* [x] Initial application architecture established
* [x] PostgreSQL development environment
* [x] Docker Compose configuration
* [x] Flyway database migrations
* [x] Device API
* [x] Measurement API
* [x] Quality rule functionality
* [x] API search functionality
* [x] Initial automated testing

### In Progress

* [ ] API pagination
* [ ] API error handling
* [ ] React frontend foundation
* [ ] Frontend application layout
* [ ] Frontend API integration
* [ ] Device management interface

### Planned

* [ ] JWT authentication and authorization
* [ ] Role-based access control
* [ ] Audit logging
* [ ] Measurement visualization
* [ ] OpenAPI / Swagger documentation
* [ ] Testcontainers integration
* [ ] Prometheus metrics
* [ ] Grafana dashboards
* [ ] CI/CD with GitHub Actions
* [ ] Cloud deployment

## Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── dto
├── exception
├── config
└── security
```

*The frontend will be maintained within the same repository as the backend to keep the application organized as a single full-stack project.*

[Back to Top](#biorobotics-ops-api)
## Architecture

The application follows a full-stack architecture:

```text
┌──────────────────────────────┐
│        React Frontend        │
│         Vite + JS            │
└──────────────┬───────────────┘
               │
               │ HTTP / REST
               ▼
┌──────────────────────────────┐
│       Spring Boot API        │
│                              │
│ Controllers                  │
│ Services                     │
│ Repositories                 │
│ DTOs                         │
│ Validation                   │
│ Security                     │
└──────────────┬───────────────┘
               │
               │ JPA / SQL
               ▼
┌──────────────────────────────┐
│         PostgreSQL           │
│                              │
│      Flyway Migrations       │
└──────────────────────────────┘

          Docker Compose
        Development Environment
```

## Run Locally


### Prerequisites

* Java 21
* Docker Desktop
* Maven (or Maven Wrapper)


Clone the project

```bash
  git clone https://github.com/BlaineBell21/biorobotics-ops-api.git
```

Go to the project directory

```bash
  cd biorobotics-ops-api
```

Install dependencies

### Start PostgreSQL

```bash
docker compose up -d
```

### Run the Backend

```bash
./mvnw spring-boot:run
```

### Run the Frontend

* *Node.js and npm  (WIP)*

Once the React frontend is configured:

```bash
cd frontend
npm install
npm run dev
```
## Learning Objectives

The primary purpose of this project is to gain practical experience with the technologies, architecture, and development practices used in enterprise software development, particularly in biomedical and robotics-related environments.

This project intentionally uses technologies and systems that are outside of my previous experience. Rather than building something familiar, I am using the project to challenge myself to learn new tools and understand how the different pieces of a production-style application work together.

## Author

### Blaine Anthony Bell
- [My Github Profile](https://github.com/BlaineBell21)
- [My LinkedIn Profile](https://www.linkedin.com/in/blaine-bell21/?skipRedirect=true)


## License

[MIT](LICENSE)

[Back to Top](#biorobotics-ops-api)
