# Practica3Envios – Sistema de Cálculo de Tarifas  
![Java CI – Practica3Envios](https://github.com/Serroyel12/Practica3Envios/actions/workflows/ci.yml/badge.svg)

Proyecto desarrollado en Java como parte de la asignatura **CALIDAD**, cuyo objetivo es implementar un sistema básico de cálculo de tarifas de envío, acompañado de pruebas unitarias en JUnit 5 y de un pipeline automático de integración continua mediante **GitHub Actions**.

---

## Estructura del Proyecto

Practica3Envios/
│
├── src/
│   ├── main/java/
│   │   ├── app/                # Lógica principal (Main, gestor)
│   │   └── modelo/             # Clase CalculadoraTarifas y modelos
│   └── test/java/
│       └── test/               # Test unitarios JUnit 5
│
├── casos_predefinidos.txt      # Archivo adicional para pruebas
├── pom.xml                      # Configuración Maven
└── .github/workflows/ci.yml     # Pipeline CI/CD


---

## Ejecución del proyecto

### **1. Compilar**
```bash
mvn compile
---
Pruebas unitarias (JUnit 5)

El proyecto incluye un conjunto de tests diseñados para comprobar:

Cálculo correcto de tarifas según peso, distancia y urgencia

Control de errores (pesos inválidos, distancias fuera de rango)

Casos límite (mínimos, máximos y extremos)

Particiones equivalentes y categorías

La ejecución muestra también un sistema de logging interno C_LOG que indica qué nodo lógico ha sido evaluado.

---
CI/CD con GitHub Actions

Se ha configurado un workflow automático en .github/workflows/ci.yml que ejecuta Maven cada vez que se sube código al repositorio.

¿Qué hace exactamente el pipeline?

Detecta cambios en el código (push a main)

Descarga JDK 21 en el runner

Hace checkout del repositorio

Compila el proyecto con Maven

Ejecuta los tests unitarios

Marca el estado del repositorio

 passing si todo va bien

 failing si algún test falla

Esto garantiza que el código subido siempre es estable y compila correctamente.

---
          ┌──────────────┐
          │   Developer   │
          └──────┬───────┘
                 │  Push / Commit
                 ▼
        ┌──────────────────────┐
        │   GitHub Actions     │
        └─────────┬────────────┘
                  │
      ┌───────────▼─────────────┐
      │  1. Checkout del código  │
      └───────────┬─────────────┘
                  │
      ┌───────────▼─────────────┐
      │  2. Configurar Java 21   │
      └───────────┬─────────────┘
                  │
      ┌───────────▼─────────────┐
      │  3. Compilar con Maven   │
      └───────────┬─────────────┘
                  │
      ┌───────────▼─────────────┐
      │  4. Ejecutar tests       │
      └───────────┬─────────────┘
                  │
      ┌───────────▼─────────────┐
      │  Resultado: PASS / FAIL  │
      └──────────────────────────┘


