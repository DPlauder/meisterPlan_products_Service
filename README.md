# Products Service

Ein RESTful Microservice für die Verwaltung von Produkten, gebaut mit Spring Boot und PostgreSQL. Der Service ist als eigenständiger Baustein in einer Microservice-Architektur gedacht und liefert eine robuste, klar strukturierte CRUD-API für Produktdaten.

## 📖 Programmbeschreibung

Der Products Service stellt Endpunkte bereit, um Produktdaten anzulegen, abzurufen, zu aktualisieren und zu löschen. Er setzt auf eine klare Schichtenarchitektur, nutzt eine relationale Datenbank für Persistenz und ist vollständig containerisiert für einfache Inbetriebnahme in Entwicklung und Betrieb.

Anwendungsfälle:
- Verwaltung von Produktkatalogen in E‑Commerce‑Systemen
- Inventar- und Lagerverwaltung
- Backend-Dienst für Web- und Mobile-Frontends
- Referenzprojekt für saubere Spring-Boot-Microservice-Architektur

## ✨ Hauptfunktionen

- Vollständige CRUD-Operationen für Produkte
- Standardkonforme REST-API (JSON)
- Persistente Speicherung in PostgreSQL
- Automatisierte Datenbankmigrationen (Flyway)
- Containerisierte Ausführung mit Docker und Orchestrierung via Docker Compose
- Health-Check-gestützter Start (Service wartet bis DB bereit ist)

## 🏗️ Architektur

Das Projekt folgt einer mehrschichtigen Architektur (Layered Architecture) mit klarer Verantwortlichkeit je Schicht:
- API Layer: REST-Endpunkte, Request/Response-Mapping
- Application Layer: Geschäftslogik, Use-Case-Orchestrierung
- Domain Layer: Domänenmodelle, Regeln
- Persistence Layer: Datenzugriff, Repositories
- DTOs: Stabile API-Schemata und Schichtenentkopplung

Verzeichnisüberblick: