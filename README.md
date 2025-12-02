# Practica3Envios – Sistema de Cálculo de Tarifas  
![Java CI – Practica3Envios](https://github.com/Serroyel12/Practica3Envios/actions/workflows/ci.yml/badge.svg)

Proyecto desarrollado en Java como parte de la asignatura **CALIDAD**, cuyo objetivo es implementar un sistema básico de cálculo de tarifas de envío, acompañado de pruebas unitarias en JUnit 5 y de un pipeline automático de integración continua mediante **GitHub Actions**.

---

## Estructura del Proyecto

Practica3Envios/
│
├── src/
│ ├── main/java/
│ │ ├── app/ # Lógica principal (Main, gestor)
│ │ └── modelo/ # Clase CalculadoraTarifas y modelos
│ └── test/java/
│ └── test/ # Test unitarios JUnit 5
│
├── casos_predefinidos.txt # Archivo adicional para pruebas
├── pom.xml # Configuración Maven
└── .github/workflows/ci.yml # Pipeline CI/CD

---

## Ejecución del proyecto

### **1. Compilar**
```bash
mvn compile
