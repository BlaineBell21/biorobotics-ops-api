# BioRobotics Ops API

A modern Spring Boot REST API for managing medical and robotic device operations, quality assurance workflows, and production data.

> **Status:** In Development 🚧

---

## Overview

BioRobotics Ops API is a portfolio project designed to simulate a real-world backend system used within biomedical engineering, robotics, or regulated manufacturing environments.

The purpose of this application is for it to be able to manage devices, record measurements, enforce quality rules, and maintain complete audit trails, while following modern backend development practices.

This project is being built from the ground up to strengthen my understanding of enterprise Java development and industry-standard backend architecture.

---

## Goals

- Build a production-style REST API using Spring Boot
- Learn enterprise application architecture
- Gain experience working with PostgreSQL and database migrations
- Implement authentication and authorization with Spring Security & JWT
- Practice automated testing and API documentation
- Deploy and monitor a containerized application

---

## Planned Features

### Device Management
- Create, update, archive, and retrieve devices
- Track operational status
- Maintain device metadata

### Measurements
- Record measurements from devices
- Associate measurements with individual devices
- Track historical measurement data

### Quality Rules
- Define acceptable measurement ranges
- Validate incoming measurements
- Flag failed quality checks

### Audit Logging
- Record important system actions
- Track user activity
- Maintain change history

### Security
- JWT Authentication
- Role-based authorization
- Protected API endpoints

### Monitoring
- Spring Boot Actuator
- Prometheus metrics
- Grafana dashboards

---

## Tech Stack

### Backend

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Security (planned)

### Database

- PostgreSQL
- Flyway

### DevOps

- Docker
- Docker Compose

### Testing

- JUnit 5
- Testcontainers (planned)

### Documentation

- OpenAPI / Swagger (planned)

### Monitoring

- Spring Boot Actuator
- Prometheus (planned)
- Grafana (planned)

---

## Project Structure

```
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

---

## Current Progress

- [x] Project initialized
- [x] Maven configured
- [x] Spring Boot setup
- [x] Java 21 configured
- [x] Project architecture planned
- [x] Docker environment planned
- [ ] PostgreSQL container
- [ ] Flyway migrations
- [ ] Device API
- [ ] Measurement API
- [ ] Quality Rules
- [ ] Authentication
- [ ] Testing
- [ ] Monitoring
- [ ] Deployment

---

## Running the Project

### Prerequisites

- Java 21
- Docker Desktop
- Maven (or Maven Wrapper)

### Clone the repository

```bash
git clone https://github.com/BlaineBell21/biorobotics-ops-api.git
cd biorobotics-ops-api
```

### Start PostgreSQL

```bash
docker compose up -d
```

### Run the application

```bash
./mvnw spring-boot:run
```

---

## Learning Objectives

The main purpose of this project, is for me to gain a better understanding of what enterprise Java development in the biomedical industry is like, in addition to building skills in the types of applications, tools, and work environments I'd likely be working with day-to-day. 

This project is something far out of my comfort zone of anything I've ever built, and I am intentionally challenging myself with brand-new tools and systems I haven't used before in pursuit of that goal. It feels daunting so far, but I'm excited to learn, and if you read this far, I hope you're excited to see how this project evolves along with me!

Areas of focus include:

- Spring Boot
- REST API design
- Object-Oriented Programming
- Database design
- Docker
- Flyway
- Authentication & Authorization
- Testing
- Monitoring
- Production-ready application architecture

---

## Future Improvements

- Report generation
- Production workflow management
- Device maintenance scheduling
- API rate limiting
- CI/CD with GitHub Actions
- Cloud deployment

---

## License

This project is licensed under the MIT License.